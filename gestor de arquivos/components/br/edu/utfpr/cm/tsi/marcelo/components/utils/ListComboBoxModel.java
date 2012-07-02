/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.utfpr.cm.tsi.marcelo.components.utils;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;
import javax.swing.ComboBoxModel;
import javax.swing.event.ListDataEvent;
import javax.swing.event.ListDataListener;

/**
 *
 * @author marcelo
 */
public class ListComboBoxModel implements ComboBoxModel, ActionListener {

    protected List data;
    protected ArrayList listeners;
    protected Object selected;

    public ListComboBoxModel() {
        this.listeners = new ArrayList();
        
    }

    public ListComboBoxModel(List list) {
        this.data = list;

        if (list.size() > 0) {
            selected = list.get(0);
        }
    }

    public void setSelectedItem(Object o) {
        this.selected = o;
    }

    public Object getSelectedItem() {
        return this.selected;
    }

    public int getSize() {
        return data.size();
    }

    public Object getElementAt(int i) {
        return data.get(i);
    }

    public void addListDataListener(ListDataListener ll) {
        listeners.add(ll);
    }

    public void removeListDataListener(ListDataListener ll) {
        this.listeners.remove(ll);
    }

    public void actionPerformed(ActionEvent ae) {
        if (ae.getActionCommand().equals("update")) {
            this.fireUpdate();
        }
    }

    public void fireUpdate() {
        ListDataEvent le = new ListDataEvent(this, ListDataEvent.CONTENTS_CHANGED, 0, data.size());

        for (int i = 0; i < listeners.size(); i++) {
            ListDataListener l = (ListDataListener) listeners.get(i);
            l.contentsChanged(le);
        }
    }
}