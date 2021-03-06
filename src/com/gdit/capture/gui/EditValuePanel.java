/*
 * EditValuePanel.java
 *
 * Created on 01 يوليو, 2008, 09:58 ص
 */

package com.gdit.capture.gui;

import javax.swing.JOptionPane;
import javax.swing.JTextField;

/**
 * this panel will used for entering data for condition value1 or value 2, and
 * if user need support from database (see sample from database table to select
 * from it or just see the format of suitable data)
 * 
 * @author zanon
 */
public class EditValuePanel extends javax.swing.JPanel {
	/**
	 * the name that we use for search in the database by it
	 */
	private String tableName = "";
	/**
	 * the name of column that we need to see its sample ...
	 */
	private String columnName = "";

	/** Creates new form EditValuePanel */
	public EditValuePanel() {
		initComponents();
	}

	/**
	 * This method is called from within the constructor to initialize the form.
	 * WARNING: Do NOT modify this code. The content of this method is always
	 * regenerated by the Form Editor.
	 */
	@SuppressWarnings("unchecked")
	// <editor-fold defaultstate="collapsed"
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        txtValue = new javax.swing.JTextField();
        selectValueBtn = new javax.swing.JButton();

        setBackground(java.awt.SystemColor.inactiveCaptionText);
        setMinimumSize(new java.awt.Dimension(95, 23));
        setPreferredSize(new java.awt.Dimension(350, 23));
        setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.CENTER, 0, 5));

        txtValue.setText("value");
        txtValue.setMinimumSize(new java.awt.Dimension(50, 22));
        txtValue.setPreferredSize(new java.awt.Dimension(150, 22));
        add(txtValue);

        selectValueBtn.setText("...");
        selectValueBtn.setToolTipText("select samples from dataBase");
        selectValueBtn.setMaximumSize(new java.awt.Dimension(45, 20));
        selectValueBtn.setMinimumSize(new java.awt.Dimension(45, 20));
        selectValueBtn.setPreferredSize(new java.awt.Dimension(30, 20));
        selectValueBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                selectValueBtnActionPerformed(evt);
            }
        });
        add(selectValueBtn);
    }// </editor-fold>//GEN-END:initComponents

	/**
	 * open LOV dialog to see sample of data
	 * 
	 * @param evt
	 */
	private void selectValueBtnActionPerformed(java.awt.event.ActionEvent evt) {// GEN

		  JOptionPane.showMessageDialog(null, "Request Data From server");
//		LOVDialog lovDiag = (LOVDialog) YVGUIFactory.getScreen(YVQBScreenTypes.YVQB_SCREEN_TYPE_LOV_DIALOG);
//		lovDiag.initGUI(null, new Object[] { tableName, columnName });
//		YVGUIFactory.centerScreen(lovDiag);
//		lovDiag.fillData(tableName, columnName);
//		txtValue.setText(lovDiag.getSelectedValue());

	}// GEN-LAST:event_selectValueBtnActionPerformed

	/**
	 * return the componnet text that contain the value entered to be used later
	 * for filling the model of node query setup dialog
	 * 
	 * @return the text filed that contain the value ...
	 */
	public JTextField getJTextValue() {
		return txtValue;
	}

	/**
	 * enable design when editor for the cell that contain this panel is
	 * editable
	 */
	public void enableDesign() {
		txtValue.setText("");
		txtValue.setEnabled(true);
		selectValueBtn.setEnabled(true);
	}

	/**
	 * disable design when editor for the cell that contain this panel is not
	 * editable
	 */
	public void disableDesign() {
		txtValue.setText("");
		txtValue.setEnabled(false);
		selectValueBtn.setEnabled(false);
	}

	public void setTableColumnData(String _table, String _column) {
		tableName = _table;
		columnName = _column;
	}

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton selectValueBtn;
    private javax.swing.JTextField txtValue;
    // End of variables declaration//GEN-END:variables

}
