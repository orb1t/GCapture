/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.gdit.capture.model;

/**
 *
 * @author Bahi
 */
import com.gdit.capture.test.*;
import com.gdit.capture.entity.Capture;
import com.gdit.capture.entity.CaptureHome;
import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.concurrent.ExecutionException;

import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTree;
import javax.swing.SwingUtilities;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.DefaultTreeModel;
//import javax.swing.tree.IconNode;

import org.jdesktop.swingworker.SwingWorker;

public class SwingDemo implements Runnable {
	
	public static class VisualSwingWorkerFactory implements SwingWorkerFactory<IconNode[], Object> {

		private Component father;
		
		public VisualSwingWorkerFactory(Component father) {
			this.father = father;
		}
		
		public SwingWorker<IconNode[], Object> getInstance(
				final IWorker<IconNode[]> worker) {
			VisualSwingWorker<IconNode[], Object> vWorker = 
				new VisualSwingWorker<IconNode[], Object>(
						father, 
						"Tree Loading ...", 
						"Loading in Tree",
						false) {
				
					@Override
					protected IconNode[] lockedDoInBackground() throws Exception {
						return worker.doInBackground();
					}
				
					@Override
					protected void done() {
						try {
							worker.done(get());
						} catch (InterruptedException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						} catch (ExecutionException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
					}
				};
			return vWorker;
		}
		
	}
	
	
	
	public static void main(String[] args) {
		SwingUtilities.invokeLater(new SwingDemo());
	}
	
	public void run() {
		final JTree tree = new JTree();
		CaptureHome dao = new CaptureHome();
                Capture batch = dao.findById(2107472L);
                
                DefaultMutableTreeNode rootNode = new DefaultMutableTreeNode(batch, true);
		DefaultTreeModel model = new DefaultTreeModel(rootNode);
		
                for (Capture doc:batch.getCaptures()) {
			rootNode.add(new CaptureTreeNode(doc, model));
		}
		tree.setModel(model);
		final LazyLoadingTreeController controller = new LazyLoadingTreeController(model); 
		tree.addTreeWillExpandListener(controller);
		JFrame frame = new JFrame();
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setLayout(new BorderLayout());
		frame.add(new JScrollPane(tree), BorderLayout.CENTER);
		final JCheckBox useVisualSwingWorkerCheck = new JCheckBox("Can't expand 2 Nodes at a time");
		useVisualSwingWorkerCheck.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (useVisualSwingWorkerCheck.isSelected()) {
					controller.setWorkerFactory(new VisualSwingWorkerFactory(tree));
				} else {
					controller.setWorkerFactory(null);
				}
			}
		});
		JPanel northPanel = new JPanel();
		northPanel.add(useVisualSwingWorkerCheck);
		frame.add(northPanel, BorderLayout.NORTH);
		frame.pack();
		frame.setLocationRelativeTo(null);
		frame.setVisible(true);
	}

}