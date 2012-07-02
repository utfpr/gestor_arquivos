/*
 =====================================================================
 
 DefaultSortTableModel.java
 
 Created by Claude Duguay
 Copyright (c) 2002
 
 
 Modified by Renato F. V. da Costa
 2005
 
 =====================================================================
 */
package br.edu.utfpr.cm.tsi.marcelo.components.jsorttable;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Vector;

import javax.swing.table.DefaultTableModel;

public class DefaultSortTableModel
        extends DefaultTableModel
        implements SortTableModel {
    
    private static final long serialVersionUID = -3540101867215160717L;

    private List<Integer> larguras;
    
    public DefaultSortTableModel() {
        larguras = new ArrayList<Integer>();
    }

    public DefaultSortTableModel(Vector<?> data, Vector<?> names) {
        
        super(data, names);
    }

    public void addColumn(Object o, int largura) {
        larguras.add(largura);
        super.addColumn(o);
    }

    
    
    @Override
    public void addRow(Object ... os) {
        super.addRow(os);
    }

    public List<Integer> getLarguras() {
        return larguras;
    }
    
    //Added by jSMS
    @Override
    public boolean isCellEditable(int row, int column) {
        return false;
    }

    @Override
    public boolean isSortable(int col) {
        return true;
    }

    @Override
    public void sortColumn(int col, boolean ascending) {
        //Added by jSMS
        if (isSortable(col)) {
            Collections.sort(getDataVector(), new ColumnComparator(col, ascending));
        }
    }
}
