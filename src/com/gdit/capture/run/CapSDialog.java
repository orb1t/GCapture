/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package com.gdit.capture.run;

/**
 *
 * @author bahy
 */
import SK.gnome.capabilities.Capabilities;
import SK.gnome.capabilities.Capability;
import SK.gnome.capabilities.MyBasicComboBoxUI;
import SK.gnome.capabilities.PreviewPanel;
import java.awt.Component;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.Frame;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusListener;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.util.ArrayList;
import java.util.EventObject;
import java.util.Vector;

import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.DefaultCellEditor;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JSplitPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;
import javax.swing.table.TableCellEditor;
import javax.swing.table.TableCellRenderer;
import javax.swing.table.TableColumn;
import javax.swing.table.TableModel;

import SK.gnome.capabilities.sane.SaneActivity;

public class CapSDialog extends JDialog implements ActionListener, PropertyChangeListener
{
  private ArrayList editors;
  private Frame frame;
  private String sourceName;
  private Vector rows, columns;
  private JTable selectedCapabilitiesTable;
  private final String[] headers = new String[] { "Name", "Default value", "Value" };
  private int returnValue = JOptionPane.CLOSED_OPTION;
  private Capabilities capabilities;

  public CapSDialog(Frame frame, Capabilities capabilities)
  {
    super(frame, capabilities.getSourceName(), true);
    this.frame = frame;
    this.sourceName = capabilities.getSourceName();
    this.capabilities= capabilities;

    Container contentPane = getContentPane();

    JPanel capabilitiesPanel = new JPanel();
    capabilitiesPanel.setLayout(new BoxLayout(capabilitiesPanel, BoxLayout.Y_AXIS));
    capabilitiesPanel.setAlignmentX(Component.LEFT_ALIGNMENT);

    for (Capability capability : capabilities.getCapabilities())
    {
      capability.addListener(this);
    }

    columns = new Vector();
    for (int i = 0; i < headers.length; i++)
      columns.addElement((String) headers[i]);

    DefaultTableModel tabModel = new DefaultTableModel();
    tabModel.setDataVector(rows, columns);
    selectedCapabilitiesTable = new JTable(tabModel)
    {
      public TableCellEditor getCellEditor(int row, int column)
      {
        int modelColumn = convertColumnIndexToModel(column);

        if ((modelColumn == 2) && (null != editors.get(row)))
          return (TableCellEditor) editors.get(row);
        else
          return super.getCellEditor(row, column);
      }

      public boolean isCellEditable(int row, int column)
      {
        int modelColumn = convertColumnIndexToModel(column);

        if ((modelColumn == 2) && (null != editors.get(row)))
          return true;
        else
          return false;
      }
    };
    selectedCapabilitiesTable.setAlignmentX(Component.LEFT_ALIGNMENT);

    updateCapabilitiesTable();
//    initColumnSizes(selectedCapabilitiesTable);

    JTableHeader th1 = selectedCapabilitiesTable.getTableHeader();
    th1.setAlignmentX(Component.LEFT_ALIGNMENT);

    capabilitiesPanel.add(th1);
    capabilitiesPanel.add(selectedCapabilitiesTable);

    capabilitiesPanel.add(Box.createRigidArea(new Dimension(0,5)));

    String buttonText;
    if(capabilities instanceof SaneActivity)
      buttonText="Select options";
    else
      buttonText="Select capabilities";

//    JButton button2 = new JButton(buttonText);
//    button2.addActionListener(capabilities);
//    button2.setActionCommand("selectCapabilitiesButton");
//    button2.setAlignmentX(Component.LEFT_ALIGNMENT);
//    capabilitiesPanel.add(button2);
    JScrollPane scrollPane = new JScrollPane(capabilitiesPanel);
    scrollPane.setBorder(BorderFactory.createTitledBorder(""));

   // PreviewPanel previewPanel=new PreviewPanel(capabilities);

    JSplitPane splitPane = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT,scrollPane, null);
    splitPane.setOneTouchExpandable(true);
    splitPane.setDividerLocation(360);
    contentPane.add(splitPane);


   // JPanel bottomPanel=new JPanel();

//    JButton button = new JButton("Scan");
//    button.setFont(new Font("Arial",Font.BOLD,24));
//    button.setActionCommand("scanButton");
//    button.addActionListener(this);
//    button.setAlignmentX(Component.LEFT_ALIGNMENT);
//    bottomPanel.add(button);
//    contentPane.add(bottomPanel, BorderLayout.PAGE_END);

    selectedCapabilitiesTable.setPreferredScrollableViewportSize(selectedCapabilitiesTable.getPreferredSize());
    selectedCapabilitiesTable.addNotify();

    setLocationByPlatform(true);
    pack();
  }


  public final Object[] longValues = { "Name", "Default value", "Value"};
  private void initColumnSizes(JTable table)
  {
    TableModel model = table.getModel();
    TableColumn column = null;
    Component comp = null;
    int headerWidth = 0;
    int cellWidth = 0;
    TableCellRenderer headerRenderer = table.getTableHeader().getDefaultRenderer();

    for (int i = 0; i < 2; i++)
    {
      column = table.getColumnModel().getColumn(i);
      comp = headerRenderer.getTableCellRendererComponent(null, column.getHeaderValue(),false, false, 0, 0);
      headerWidth = comp.getPreferredSize().width;
      comp = table.getDefaultRenderer(model.getColumnClass(i)).getTableCellRendererComponent(table, longValues[i],false, false, 0, i);
      cellWidth = comp.getPreferredSize().width;
      //System.out.println("Initializing width of column " + i + ". " + "headerWidth = " + headerWidth + "; cellWidth = " + cellWidth);
      column.setPreferredWidth(Math.max(headerWidth, cellWidth));
    }
  }


  public void updateCapabilitiesTable()
  {
//    System.out.println("CapabilityDialog.updateCapabilitiesTable() begin");
    rows = new Vector();
    Vector temp;
    editors = new ArrayList(capabilities.getCapabilities().size());
    JComboBox comboBox;
    DefaultCellEditor dce;
    for (Capability capability : capabilities.getCapabilities())
    {
      if (capability.isSelected())
      {
          temp = new Vector();
          temp.addElement(capability.getTitle());

          Object defaultValue=null;
          try
          {
            defaultValue = capability.getDefaultValue();
          } catch (Exception e)
          {
          }
          temp.addElement(defaultValue);
          Object value = null;
          value = capability.getValue();
          temp.addElement(value);
          rows.addElement(temp);

          Object[] supported = capability.getSupportedValues();
          if(capability.isSetMethodSupported())
          {
            if (null != supported)
            {
              comboBox = new JComboBox(supported);
              comboBox.setEditable(true);
              //Apple&Linux workaround
              if(!System.getProperty("os.name").toLowerCase().startsWith("windows"))
                comboBox.setUI(new MyBasicComboBoxUI());

              comboBox.setActionCommand("tableComboBox");
              comboBox.addActionListener((ActionListener) capability);
              dce = new DefaultCellEditor(comboBox)
              {
                public boolean shouldSelectCell(EventObject anEvent)
                {
                  return false;
                }
              };
            }
            else
            {
              JTextField textField=new JTextField();
              textField.setActionCommand("tableTextField");
              textField.addActionListener((ActionListener) capability);
              textField.addFocusListener((FocusListener) capability);
              dce = new DefaultCellEditor(textField);
//              System.out.println("CapabilityDialog.updateCapabilitiesTable()JTextField.getClickCountToStart()="+dce.getClickCountToStart());
//              dce.setClickCountToStart(1);
            }
          }
          else
            dce = null;
          editors.add(dce);
      }
    }
    ((DefaultTableModel) selectedCapabilitiesTable.getModel()).setDataVector(rows, columns);
    selectedCapabilitiesTable.setPreferredScrollableViewportSize(selectedCapabilitiesTable.getPreferredSize());
    selectedCapabilitiesTable.addNotify();
    validate();
//    System.out.println("CapabilityDialog.updateCapabilitiesTable() end");
  }

  public int getReturnValue()
  {
    return returnValue;
  }

  public void propertyChange(PropertyChangeEvent evt)
  {
//    System.out.println("CapabilityDialog.propertyChange()");
    updateCapabilitiesTable();
  }

    @Override
    public void actionPerformed(ActionEvent e) {
        throw new UnsupportedOperationException("Not supported yet.");
    }
}
