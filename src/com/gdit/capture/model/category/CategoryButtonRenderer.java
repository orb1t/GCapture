/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package com.gdit.capture.model.category;

import java.awt.Component;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JTable;
import javax.swing.UIManager;
import javax.swing.table.TableCellRenderer;
/**
 *
 * @author Bahi
 */
public class CategoryButtonRenderer extends JButton implements TableCellRenderer {

  public CategoryButtonRenderer() {
    setOpaque(true);
  }

  public CategoryButtonRenderer(ImageIcon icon){
      setOpaque(true);
      this.setIcon(icon);
  }

  public Component getTableCellRendererComponent(JTable table, Object value,
      boolean isSelected, boolean hasFocus, int row, int column) {
    if (isSelected) {
      setForeground(table.getSelectionForeground());
      setBackground(table.getSelectionBackground());
    } else {
      setForeground(table.getForeground());
      setBackground(UIManager.getColor("Button.background"));
    }
    setText((value == null) ? "" : value.toString());
    return this;
  }
}