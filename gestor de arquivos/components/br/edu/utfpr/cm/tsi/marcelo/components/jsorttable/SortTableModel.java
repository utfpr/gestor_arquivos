/*
 =====================================================================
 
 SortTableModel.java
 
 Created by Claude Duguay
 Copyright (c) 2002
 
 =====================================================================
 */
package br.edu.utfpr.cm.tsi.marcelo.components.jsorttable;

import javax.swing.table.TableModel;

public interface SortTableModel
        extends TableModel {

    public boolean isSortable(int col);

    public void sortColumn(int col, boolean ascending);
}
