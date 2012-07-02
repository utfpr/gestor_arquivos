/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package br.edu.utfpr.cm.tsi.marcelo.components.utils;

import java.awt.event.ActionEvent;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 *
 * @author marcelo
 */
public class MapComboBoxModel extends ListComboBoxModel{
    
    protected Map mapData;
    protected List index;
    
    
    public MapComboBoxModel(Map map) {
        this.mapData = map;
        index = new ArrayList();
        
        buildIndex();
        if(index.size() > 0 ){
            selected = index.get(0);
        }
    }

    private void buildIndex() {
        index = new ArrayList(mapData.keySet());
    }

    @Override
    public Object getElementAt(int i) {
        return index.get(i);
    }

    @Override
    public int getSize() {
        return mapData.size();
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        if(ae.getActionCommand().equals("update")){
            buildIndex();
            fireUpdate();
        }
    }
    
    public Object getValue(Object selectedItem){
        return mapData.get(selectedItem);
    }
    public Object getValue(int selectedItem){
        return getValue(index.get(selectedItem));
    }
    
    
    
    
}
