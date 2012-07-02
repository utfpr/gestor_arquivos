/*
 =====================================================================

 JSortTable.java
 
 Created by Claude Duguay
 Copyright (c) 2002
 
 
 Modified by Renato F. V. da Costa
 2005-2006
 
 =====================================================================
 */
package br.edu.utfpr.cm.tsi.marcelo.components.jsorttable;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.util.Vector;

import javax.swing.JPopupMenu;
import javax.swing.JTable;
import javax.swing.table.JTableHeader;
import javax.swing.table.TableColumnModel;
import javax.swing.table.TableModel;

public class JSortTable
        extends JTable
        implements MouseListener, MouseMotionListener {

    protected class HeaderMouseListener
            extends MouseAdapter {

        public void mousePressed(MouseEvent event) {
            if (sortColumn) {
                if (getTableHeader().getResizingColumn() != null) {
                    sortColumn = false;
                }
            }

            if (event.isPopupTrigger()) {
                processMouseClick(event);
                handled = true;
            }
        }

        public void mouseReleased(MouseEvent event) {
            if (sortColumn) {
                TableColumnModel colModel = getColumnModel();
                sortColumn(colModel.getColumnIndexAtX(event.getX()));
            } else {
                sortColumn = true;
            }
        }
    }
    private static final long serialVersionUID = 1L;
    protected boolean dragging, handled;
    private JPopupMenu popupMenu;
    protected boolean sortColumn, sortedColumnAscending;
    private int sortedColumnIndex;

    public JSortTable(SortTableModel model) {
        super(model);
        sortColumn = true;
        sortedColumnAscending = true;
        sortedColumnIndex = -1;

        initSortHeader();
        addMouseListener(this);
        addMouseMotionListener(this);
    }

    public JSortTable(Vector<?> data, Vector<?> names) {
        this(new DefaultSortTableModel(data, names));
    }

    public boolean getScrollableTracksViewportHeight() {
        return getPreferredSize().height < getParent().getHeight();
    }

    public int getSortedColumnIndex() {
        return sortedColumnIndex;
    }

    @Override
    public TableModel getModel() {
        return super.getModel();
    }
    
    protected void initSortHeader() {
        JTableHeader header = getTableHeader();
        header.setDefaultRenderer(new SortHeaderRenderer());
        header.addMouseListener(new HeaderMouseListener());
    }

    public boolean isSortedColumnAscending() {
        return sortedColumnAscending;
    }

    public void mouseClicked(MouseEvent event) {
    }

    public void mouseDragged(MouseEvent e) {
        dragging = true;
    }

    public void mouseEntered(MouseEvent event) {
    }

    public void mouseExited(MouseEvent event) {
    }

    public void mouseMoved(MouseEvent e) {
    }

    public void mousePressed(MouseEvent event) {
        if (event.isPopupTrigger()) {
            processMouseClick(event);
            handled = true;
        }
    }

    public void mouseReleased(MouseEvent event) {
        if (!handled) {
            processMouseClick(event);
        }

        dragging = false;
        handled = false;
    }

    protected void processMouseClick(MouseEvent event) {
        int row = rowAtPoint(event.getPoint());
        if (row != -1) {
            if (getSelectedRow() != -1) {
                if (!event.isPopupTrigger()) {
                    if (!dragging && !event.isControlDown() && !event.isShiftDown()) {
                        getSelectionModel().setSelectionInterval(row, row);
                    }
                } else {
                    boolean isRowSelected = false;
                    int rows[] = getSelectedRows();
                    for (int i = 0; i < rows.length; i++) {
                        if (rows[i] == row) {
                            isRowSelected = true;
                            break;
                        }
                    }

                    if (!isRowSelected) {
                        getSelectionModel().setSelectionInterval(row, row);
                    }
                }
            } else {
                if (!event.isControlDown() && !event.isShiftDown()) {
                    getSelectionModel().setSelectionInterval(row, row);
                }
            }
        } else {
            clearSelection();
        }

        if (event.isPopupTrigger() && popupMenu != null) {
            popupMenu.show(event.getComponent(), event.getX(), event.getY());
        }
    }

    public void resortTable() {
        if (sortedColumnIndex != -1) {
            SortTableModel model = (SortTableModel) getModel();
            model.sortColumn(sortedColumnIndex, sortedColumnAscending);
        }
    }

    public void setPopupMenu(JPopupMenu popupMenu) {
        this.popupMenu = popupMenu;
    }

    public void sortColumn(int index) {
        if (index != -1) {
            int modelIndex = getColumnModel().getColumn(index).getModelIndex();

            SortTableModel model = (SortTableModel) getModel();
            if (model.isSortable(modelIndex)) {
                if (sortedColumnIndex == index) {
                    sortedColumnAscending = !sortedColumnAscending;
                }

                sortedColumnIndex = index;

                model.sortColumn(modelIndex, sortedColumnAscending);
            }
        }
    }
}
