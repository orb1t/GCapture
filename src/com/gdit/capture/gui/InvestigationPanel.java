/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/*
 * InvestigationPanel.java
 *
 * Created on 14/12/2010, 07:18:49 م
 */
package com.gdit.capture.gui;

import com.gdit.capture.entity.Investigation;
import com.gdit.capture.entity.InvestigationHome;
import com.gdit.capture.model.ButtonEditor;
import com.gdit.capture.model.ButtonRenderer;
import com.gdit.capture.model.InvestigationTableModel;
import com.jidesoft.swing.JideSwingUtilities;
import java.awt.Component;
import java.awt.ComponentOrientation;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.util.List;
import java.util.Locale;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.SwingUtilities;
import javax.swing.UIManager;

/**
 *
 * @author Bahi
 */
public class InvestigationPanel extends javax.swing.JPanel {

    private static final Logger log = Logger.getAnonymousLogger();
    private InvestigationTableModel investigationsModel;
    private List<Investigation> investigations;
    private ResourceBundle bundle;
    private Locale locale;

    /** Creates new form InvestigationPanel */
    public InvestigationPanel() {
        try {
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        } catch (Exception e1) {
            e1.printStackTrace();
        }
        if (locale == null) {
            locale = new Locale("ar");
        }
        bundle = ResourceBundle.getBundle("com/gdit/bundle/capture", locale);
        initComponents();
        init();
        changeScreenDirection(this, locale);
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
        txtInvestigation = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        investigationsTable = new javax.swing.JTable();
        addBtn = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();

        java.util.ResourceBundle bundle = java.util.ResourceBundle.getBundle("com/gdit/bundle/capture"); // NOI18N
        jLabel1.setText(bundle.getString("investigation.name")); // NOI18N

        investigationsTable.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane1.setViewportView(investigationsTable);

        addBtn.setText(bundle.getString("add")); // NOI18N
        addBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addBtnActionPerformed(evt);
            }
        });

        jLabel2.setText(bundle.getString("investigations")); // NOI18N

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 400, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(addBtn)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 105, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(txtInvestigation, javax.swing.GroupLayout.PREFERRED_SIZE, 162, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, 81, Short.MAX_VALUE)
                        .addGap(299, 299, 299))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 375, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 388, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(txtInvestigation, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(addBtn)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 275, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void init() {
        try {
            InvestigationHome rolesDao = new InvestigationHome();
            investigations = rolesDao.getAllInvestigation();
            investigationsModel = new InvestigationTableModel(investigationsTable, investigations, bundle);
            investigationsTable.setModel(investigationsModel);
            investigationsTable.getColumn(bundle.getString("edit")).setCellRenderer(new ButtonRenderer());
            investigationsTable.getColumn(bundle.getString("delete")).setCellRenderer(new ButtonRenderer());
            investigationsTable.getColumn(bundle.getString("edit")).setCellEditor(new ButtonEditor(new JCheckBox(), bundle));
            investigationsTable.getColumn(bundle.getString("delete")).setCellEditor(new ButtonEditor(new JCheckBox(), bundle));
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        finally{
            InvestigationHome.close();
        }
    }

    public void clear() {
        txtInvestigation.setText("");
    }

    private void centerScreen() {
        Toolkit tk = Toolkit.getDefaultToolkit();
        Dimension screenSize = tk.getScreenSize();
        int screenHeight = screenSize.height / 2;
        int screenWidth = screenSize.width / 2;
        //setSize(screenWidth, screenHeight - 20);
        setLocation(screenWidth - this.getWidth() / 2, screenHeight - this.getHeight() / 2);
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
            log.log(Level.SEVERE, "", ex);
        }
    }

    public static void main(String[] args){
        JFrame frame = new JFrame();
        frame.add(new InvestigationPanel());
        frame.setSize(400, 400);
        frame.setVisible(true);
    }

    private void addBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addBtnActionPerformed
        // TODO add your handling code here:
        try {
            Investigation investigation = new Investigation();
            InvestigationHome dao = new InvestigationHome();
            investigation.setName(txtInvestigation.getText());
            dao.persist(investigation);
            dao.commit();
            InvestigationHome.close();
            investigationsModel.addRow(investigation);
            clear();
        } catch (Exception ex) {
            ex.printStackTrace();
        } finally {
            InvestigationHome.close();
        }
}//GEN-LAST:event_addBtnActionPerformed
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton addBtn;
    private javax.swing.JTable investigationsTable;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField txtInvestigation;
    // End of variables declaration//GEN-END:variables
}
