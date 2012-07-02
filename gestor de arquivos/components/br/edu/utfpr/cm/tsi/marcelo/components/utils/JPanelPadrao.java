/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package br.edu.utfpr.cm.tsi.marcelo.components.utils;

import java.awt.event.ActionListener;
import javax.swing.JPanel;

/**
 *
 * @author Marcelo
 */
public abstract class JPanelPadrao extends JPanel implements ActionListener{
    private JComponentsUtils jComponentsUtils;
    
    public JPanelPadrao() {
        this.jComponentsUtils = new JComponentsUtils();
    }
    
    
    

    public JComponentsUtils getComponentsUtils() {
        return jComponentsUtils;
    }

    

}
