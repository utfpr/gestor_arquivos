/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package br.edu.utfpr.cm.tsi.marcelo.components.utils;

import java.awt.EventQueue;
import java.awt.HeadlessException;
import java.awt.Window;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import javax.swing.JFrame;

/**
 *
 * @author Marcelo
 */
public abstract class JFramePadrao extends JFrame implements ActionListener {

    private JComponentsUtils jComponentsUtils;
    private JDialogUtils jDialogUtils;
    
    public JFramePadrao(String string) throws HeadlessException {
        super(string);
        init();
        addWindowListener(new WindowAdapter() {

            @Override
            public void windowClosing(WindowEvent we) {
                if(fecharWindow()){
                    System.exit(0);
                }else{
                    return ;
                }
            }
        });
        
    }

    private void init(){
        jComponentsUtils = new JComponentsUtils();
        jDialogUtils = new JDialogUtils();

        setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
        
        pack();
    }
    
    
    
    protected abstract boolean fecharWindow();


    public void showWindow(){
        EventQueue.invokeLater(new Runnable() {

            @Override
            public void run() {
                setVisible(true);
            }
        });
    }

    public void closeWindow(){
        if (fecharWindow()) {
            dispatchEvent(new WindowEvent(this, WindowEvent.WINDOW_CLOSING));
        }else{
            dispatchEvent(new WindowEvent(this, WindowEvent.WINDOW_STATE_CHANGED));
        }
    }

    protected void addBoundListener(Window window){
        //JDialogUtils.addBoundListner(window);
    }

    protected JComponentsUtils getJComponentsUtils(){
        return jComponentsUtils;
    }

    protected JDialogUtils getjDialogUtils() {
        return jDialogUtils;
    }

}
