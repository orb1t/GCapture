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
import java.util.concurrent.ExecutionException;

import javax.swing.event.TreeExpansionEvent;
import javax.swing.event.TreeWillExpandListener;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.DefaultTreeModel;
import javax.swing.tree.ExpandVetoException;
//import javax.swing.tree.IconNode;
import javax.swing.tree.TreePath;

import org.jdesktop.swingworker.SwingWorker;

public class LazyLoadingTreeController implements TreeWillExpandListener {
	
	public static class DefaultWorkerFactory implements SwingWorkerFactory<IconNode[], Object> {
		
		public SwingWorker<IconNode[], Object> getInstance(final IWorker<IconNode[]> worker) {
			final SwingWorker<IconNode[], Object> myWorker = 
				new SwingWorker<IconNode[], Object>() {
			
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
				@Override
				protected IconNode[] doInBackground() throws Exception {
					return worker.doInBackground();
				}
			};
			return myWorker;
		}
		
	}
	
	private SwingWorkerFactory<IconNode[], ?> workerFactory = new DefaultWorkerFactory();
	/** Tree Model */
	private DefaultTreeModel model;
	/**
	 * Default constructor
	 * @param model Tree model
	 */
	public LazyLoadingTreeController(DefaultTreeModel model) {
		this.model = model;
	}

	public void treeWillCollapse(TreeExpansionEvent event)
			throws ExpandVetoException {
		//Do nothing on collapse.
	}
	/**
     * Invoked whenever a node in the tree is about to be expanded.
     * If the Node is a LazyLoadingTreeNode load it's children in a SwingWorker
     */
	public void treeWillExpand(TreeExpansionEvent event)
			throws ExpandVetoException {
		TreePath path = event.getPath();
		Object lastPathComponent = path.getLastPathComponent();
		if (lastPathComponent instanceof LazyLoadingTreeNode) {
			LazyLoadingTreeNode lazyNode = (LazyLoadingTreeNode) lastPathComponent;
			expandNode(lazyNode, model);
		}
	}

	/**
	 * If the Node is not already loaded 
	 * @param node
	 * @param model
	 */
	public void expandNode(final LazyLoadingTreeNode node, 
			final DefaultTreeModel model) {
		if (node.areChildrenLoaded()) {
			return;
		}
//		node.setChildren(createLoadingNode());
		SwingWorker<IconNode[], ?> worker = createSwingWorker(node);
		worker.execute();
	}
	
	/**
	 * 
	 * @return a new Loading please wait node 
	 */
	protected IconNode createLoadingNode() {
		return new IconNode("Loading ...");
	}
	
	protected IWorker<IconNode[]> getWorkerInterface(final LazyLoadingTreeNode node) {
		return new IWorker<IconNode[]>() {
		
			public void done(IconNode[] nodes) {
//                            System.out.println("NODES "+nodes.length);
//				node.setAllowsChildren(nodes != null && nodes.length > 0);
				node.setChildren(nodes);
			}
		
			public IconNode[] doInBackground() {
				return node.loadChildren(model);
			}
		};
	}
	
	/**
	 * Create worker that will load the nodes 
	 * @param tree the tree
	 * @return the newly created SwingWorker
	 */
	protected SwingWorker<IconNode[], ?> createSwingWorker(
			final LazyLoadingTreeNode node) {
		return getWorkerFactory().getInstance(getWorkerInterface(node));
	}
	/**
	 * 
	 * @return
	 */
	public SwingWorkerFactory<IconNode[], ?> getWorkerFactory() {
		if (workerFactory == null) {
			workerFactory = new DefaultWorkerFactory();
		}
		return workerFactory;
	}

	public void setWorkerFactory(
			SwingWorkerFactory<IconNode[], ?> workerFactory) {
		this.workerFactory = workerFactory;
	}
}