/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/*
 * RepPanel.java
 *
 * Created on 04/01/2011, 01:35:06 م
 */
package com.gdit.capture.gui;

import com.gdit.capture.entity.Rep;
import com.gdit.capture.entity.RepHome;
import com.gdit.capture.model.rep.RepButtonEditor;
import com.gdit.capture.model.rep.RepButtonRenderer;
import com.gdit.capture.model.rep.RepTableModel;
//import com.gdit.capture.service.SyncFiles;
//import com.gdit.capture.service.SyncFilesService;
import com.jidesoft.swing.JideSwingUtilities;
import java.awt.Component;
import java.awt.ComponentOrientation;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.util.List;
import java.util.Locale;
import java.util.ResourceBundle;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.SwingUtilities;

/**
 *
 * @author Bahi
 */
public class RepPanel extends javax.swing.JPanel {

    private Rep rep;
    private RepTableModel repTableModel;
    private ResourceBundle bundle;
    private List<Rep> reps;
    private DefaultComboBoxModel repComboModel;
    private JFrame frame;
    private Locale locale;
    /** Creates new form RepPanel */
    public RepPanel(Locale locale,ResourceBundle bundle) {
        this.locale = locale;
        this.bundle = bundle;
        initComponents();
        init();
        changeScreenDirection(this, locale);
        centerScreen();
    }

    private void init() {
        try {
            bundle = java.util.ResourceBundle.getBundle("com/gdit/bundle/capture");
            RepHome repDao = new RepHome();
            reps = repDao.getAllRep();
            repTableModel = new RepTableModel(repsTable, reps, bundle);
            repsTable.setModel(repTableModel);
            repsTable.getColumn(bundle.getString("edit")).setCellRenderer(new RepButtonRenderer());
            repsTable.getColumn(bundle.getString("delete")).setCellRenderer(new RepButtonRenderer());
            repsTable.getColumn(bundle.getString("edit")).setCellEditor(new RepButtonEditor(this, new JCheckBox(), bundle));
            repsTable.getColumn(bundle.getString("delete")).setCellEditor(new RepButtonEditor(this, new JCheckBox(), bundle));
            // txtComputerName.setText(System.getProperty("user.name"));
            repComboModel = new DefaultComboBoxModel();
            repComboModel.addElement("");
            for (Rep rep : reps) {
                repComboModel.addElement(rep);
            }
            repsCombo.setModel(repComboModel);
            editBtn.setEnabled(false);
            changeScreenDirection(this, locale);
            centerScreen();
        } catch (Exception ex) {
            ex.printStackTrace();
        } finally {
            RepHome.close();
        }
    }

    public void edit(Rep rep) {
        this.rep = rep;
        txtRepName.setText(rep.getName());
        txtPath.setText(rep.getPath());
        txtProtocolPath.setText(txtProtocolPath.getText());
        if (rep.getRep() != null) {
            repsCombo.setSelectedItem(rep.getRep());
        }
        editBtn.setEnabled(true);
        saveBtn.setEnabled(false);
    }

    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        txtRepName = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        repsCombo = new javax.swing.JComboBox();
        saveBtn = new javax.swing.JButton();
        editBtn = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        repsTable = new javax.swing.JTable();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        txtProtocolPath = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        txtPath = new javax.swing.JTextField();

        java.util.ResourceBundle bundle = java.util.ResourceBundle.getBundle("com/gdit/bundle/capture"); // NOI18N
        jLabel1.setText(bundle.getString("rep.name")); // NOI18N

        jLabel2.setText(bundle.getString("rep.parent")); // NOI18N

        saveBtn.setText(bundle.getString("add")); // NOI18N
        saveBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                saveBtnActionPerformed(evt);
            }
        });

        editBtn.setText(bundle.getString("save")); // NOI18N
        editBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                editBtnActionPerformed(evt);
            }
        });

        repsTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane1.setViewportView(repsTable);

        jLabel3.setText(bundle.getString("reps")); // NOI18N

        jLabel4.setText(bundle.getString("protocol.path")); // NOI18N

        jLabel5.setText(bundle.getString("path")); // NOI18N

        org.jdesktop.layout.GroupLayout layout = new org.jdesktop.layout.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(layout.createSequentialGroup()
                .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                    .add(layout.createSequentialGroup()
                        .addContainerGap()
                        .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                            .add(jScrollPane1, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 375, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                            .add(layout.createSequentialGroup()
                                .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                                    .add(jLabel1, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 77, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                                    .add(jLabel2, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 90, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))
                                .add(65, 65, 65)
                                .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING, false)
                                    .add(repsCombo, 0, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .add(layout.createSequentialGroup()
                                        .add(saveBtn, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 72, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                                        .add(18, 18, 18)
                                        .add(editBtn, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 74, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))
                                    .add(txtProtocolPath, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, 180, Short.MAX_VALUE)
                                    .add(txtRepName)
                                    .add(txtPath)))
                            .add(jLabel3, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 70, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)))
                    .add(layout.createSequentialGroup()
                        .addContainerGap()
                        .add(jLabel4, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 109, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(15, Short.MAX_VALUE))
            .add(layout.createSequentialGroup()
                .addContainerGap()
                .add(jLabel5, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 99, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(291, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(layout.createSequentialGroup()
                .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                    .add(layout.createSequentialGroup()
                        .addContainerGap()
                        .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.BASELINE)
                            .add(jLabel1)
                            .add(txtRepName, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))
                        .add(14, 14, 14)
                        .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.BASELINE)
                            .add(jLabel5)
                            .add(txtPath, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(org.jdesktop.layout.LayoutStyle.UNRELATED)
                        .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.BASELINE)
                            .add(jLabel4)
                            .add(txtProtocolPath, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)))
                    .add(layout.createSequentialGroup()
                        .add(114, 114, 114)
                        .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.BASELINE)
                            .add(repsCombo, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                            .add(jLabel2))))
                .add(18, 18, 18)
                .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                    .add(saveBtn)
                    .add(layout.createSequentialGroup()
                        .add(jLabel3)
                        .add(4, 4, 4))
                    .add(editBtn))
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                .add(jScrollPane1, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 313, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                .add(40, 40, 40))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void saveBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_saveBtnActionPerformed
        // TODO add your handling code here:
        try {
            if(txtRepName.getText().trim().equals("")){
                JOptionPane.showMessageDialog(this, bundle.getString("error.rep.name.required"));
                return;
            }
            rep = new Rep();
            RepHome dao = new RepHome();
            rep.setName(txtRepName.getText());
            rep.setPath(txtPath.getText());
            rep.setProtocolPath(txtProtocolPath.getText());
            if (!txtPath.getText().equals("")) {
//                SyncFilesService service = new SyncFilesService();
  //              SyncFiles port = service.getSyncFilesPort();
   //             port.createSharedFile(txtPath.getText());
            }
            if (!repsCombo.getSelectedItem().equals("")) {
                rep.setRep((Rep) repsCombo.getSelectedItem());
            }
            dao.persist(rep);
            repTableModel.addRow(rep);
            clear();
        } catch (Exception ex) {
            ex.printStackTrace();
        } finally {
            RepHome.close();
        }
    }//GEN-LAST:event_saveBtnActionPerformed

    private void editBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_editBtnActionPerformed
        // TODO add your handling code here:
        try {
            //  rep = new Rep();
            if(txtRepName.getText().trim().equals("")){
                JOptionPane.showMessageDialog(this, bundle.getString("error.rep.name.required"));
                return;
            }
            RepHome dao = new RepHome();
            rep.setName(txtRepName.getText());
            rep.setPath(txtPath.getText());
            rep.setProtocolPath(txtProtocolPath.getText());
            if (!repsCombo.getSelectedItem().equals("")) {
                rep.setRep((Rep) repsCombo.getSelectedItem());

            }
            if (!txtPath.getText().equals("")) {
//                SyncFilesService service = new SyncFilesService();
 //               SyncFiles port = service.getSyncFilesPort();
 //               port.createSharedFile(txtPath.getText());
            }
            dao.attachDirty(rep);
            dao.commit();
            reps.set(reps.indexOf(rep), rep);
            repTableModel.setReps(reps);
            clear();
            editBtn.setEnabled(false);
            saveBtn.setEnabled(true);
        } catch (Exception ex) {
            ex.printStackTrace();
            JOptionPane.showConfirmDialog(null, bundle.getString("error"));
        } finally {
            RepHome.close();
        }
    }//GEN-LAST:event_editBtnActionPerformed

    public void clear() {
        txtRepName.setText("");
        repsCombo.setSelectedItem("");
        txtPath.setText("");
        txtProtocolPath.setText("");
    }

    public static void changeScreenDirection(Component screen, Locale locale) {
        try {
            if (locale == null) {
                locale = new Locale("ar");
            }
            if (ComponentOrientation.getOrientation(locale).equals(ComponentOrientation.RIGHT_TO_LEFT)) {
                JideSwingUtilities.toggleRTLnLTR(screen);
                JideSwingUtilities.invalidateRecursively(screen);
                SwingUtilities.updateComponentTreeUI(screen);
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

     private void centerScreen() {
        Toolkit tk = Toolkit.getDefaultToolkit();
        Dimension screenSize = tk.getScreenSize();
        int screenHeight = screenSize.height / 2;
        int screenWidth = screenSize.width / 2;
        //setSize(screenWidth, screenHeight - 20);
        setLocation(screenWidth - this.getWidth() / 2, screenHeight - this.getHeight() / 2);
    }

    public JFrame getFrame() {
        return frame;
    }

    public void setFrame(JFrame frame) {
        this.frame = frame;
    }

    

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton editBtn;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JComboBox repsCombo;
    private javax.swing.JTable repsTable;
    private javax.swing.JButton saveBtn;
    private javax.swing.JTextField txtPath;
    private javax.swing.JTextField txtProtocolPath;
    private javax.swing.JTextField txtRepName;
    // End of variables declaration//GEN-END:variables

    public static void main(String[] args) {
//        JFrame frame = new JFrame();
//        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//        frame.setSize(500, 500);
//        frame.add(new RepPanel());
//        frame.setVisible(true);
    }
}
