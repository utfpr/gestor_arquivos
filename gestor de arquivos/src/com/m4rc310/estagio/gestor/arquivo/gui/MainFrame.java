/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package com.m4rc310.estagio.gestor.arquivo.gui;

import br.edu.utfpr.cm.tsi.marcelo.components.utils.JComponentsUtils;
import br.edu.utfpr.cm.tsi.marcelo.components.utils.JFramePadrao;
import java.awt.Color;
import java.awt.Component;
import java.awt.HeadlessException;
import java.awt.event.ActionEvent;
import javax.swing.*;
import javax.swing.table.AbstractTableModel;
import javax.swing.table.TableCellRenderer;
import javax.swing.table.TableColumn;
import net.miginfocom.swing.MigLayout;

/**
 *
 * @author tchulla
 */
public class MainFrame extends JFramePadrao {
    
    private JPanel panelControls;

    @Override
    protected boolean fecharWindow() {
        return true;
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        throw new UnsupportedOperationException("Not supported yet.");
    }
    

    private ImageIcon icon = new ImageIcon(getClass().getResource("/icones/engrenagem.png"));

    public MainFrame(String string) throws HeadlessException {
        super(string);
        initLayout();
    }
    
    
    
    
    private void initLayout(){
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new MigLayout("inset -1"));
        setBackground(new Color(120, 120, 120));
        JComponentsUtils ju = getJComponentsUtils();
        
        panelControls = ju.getJPanel(null);
        panelControls.setLayout(new MigLayout("inset -1"));
        panelControls.setBackground(new Color(237,237,237));
        
        JButton jbPreferences = ju.getJButton("_Preferencias");
        jbPreferences.setIcon(icon);
       // jbPreferences.setBorder(BorderFactory.createTitledBorder(""));
        jbPreferences.setHorizontalTextPosition(SwingConstants.CENTER);
        jbPreferences.setVerticalTextPosition(SwingConstants.BOTTOM);
        
//        jbPreferences.setHorizontalTextPosition(JButton.BOTTOM_ALIGNMENT);
        
        
        JTable table = new JTable(new MyTableModel());
        table.setDefaultRenderer(JPanel.class, new ColorRenderer());
        table.setShowHorizontalLines(true);
        table.setShowVerticalLines(true);
        table.setAutoResizeMode(JTable.AUTO_RESIZE_ALL_COLUMNS);
        table.setGridColor(Color.GRAY);
//        table.setUI(null);
        
        JButton button = new JButton("teste");
        
        TableColumn column = table.getColumnModel().getColumn(3);
        
        column.setCellEditor(new DefaultCellEditor(new JTextField(15)));
        
        JScrollPane panel = new JScrollPane(table);
        
        panelControls.add(jbPreferences);
        
        add(panelControls, "wrap, split, growx, w 100%");
        add(panel);
    }
    
    private class MyTableModel extends AbstractTableModel{
        
        private String[] columns = {"ID", "NAME", "AGE", "A STUDENT?", "BD"};
        private Object[][] data = {
                {1, "Alice", 20, Boolean.FALSE, new JPanel()},
                {2, "Bob", 10, Boolean.TRUE, icon},
                {3, "Carol", 15, Boolean.TRUE, icon},
                {4, "Mallory", 25, Boolean.FALSE, icon}
        };
        
        

        @Override
        public int getRowCount() {
            return data.length;
        }

        @Override
        public int getColumnCount() {
            return columns.length;
        }

        @Override
        public Object getValueAt(int i, int i1) {
            return data[i][i1];
        }

        @Override
        public String getColumnName(int i) {
            return columns[i];
        }

        @Override
        public Class<?> getColumnClass(int i) {
            return data[0][i].getClass();
        }
        
        
    }
    
    private class ColorRenderer extends JButton implements TableCellRenderer{
        
        @Override
        public Component getTableCellRendererComponent(JTable jtable, Object color, boolean isSelected, boolean hasFocus, int row, int column) {
            
            
            return this;
        }
    }

    


    /**
     * TODO apagar    
     * Os metodos abaixo foram gerados automáticamente com intuito de testar as funcionalidades 
     * desta classe quando necessario.
     */
    
    public static void main(String[] args) {
        new MainFrame("").teste();
    }

    private void teste(){
        // Implementação de testes das funcionalidades.
        new MainFrame("").setVisible(true);
    }

}
