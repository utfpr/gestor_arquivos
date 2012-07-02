/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.utfpr.cm.tsi.marcelo.components.utils;

import java.awt.HeadlessException;
import java.awt.Window;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import javax.swing.JDialog;
import javax.swing.JOptionPane;
import net.miginfocom.swing.MigLayout;

/**
 *
 * @author Marcelo
 */
public abstract class JDialogPadrao extends JDialog {

    protected JComponentsUtils ju;
    private JDialogUtils jDialogUtils;
    protected final String sThis = this.getClass().getSimpleName();

    public JDialogPadrao() throws HeadlessException {
        init();
        setModal(true);
//        setLocationRelativeTo(null);
        setLayout(new MigLayout("inset 2"));
        addWindowListener(new WindowAdapter() {

            @Override
            public void windowClosing(WindowEvent we) {
                if (fecharWindow()) {
                    dispose();
                } else {
                    dispatchEvent(new WindowEvent(JDialogPadrao.this, WindowEvent.WINDOW_CLOSED));
                    return;
                }
            }

            @Override
            public void windowOpened(WindowEvent we) {
            }
        });



    }

    public JDialogPadrao(String title) {
        this();
        setTitle(title);
    }

    private void init() {
        dispose();

        ju = new JComponentsUtils();
        jDialogUtils = new JDialogUtils();
        setDefaultCloseOperation(JDialog.DO_NOTHING_ON_CLOSE);
    }

    protected boolean fecharWindow() {
        return true;
    }

    public void showWindow() {
            java.awt.EventQueue.invokeLater(new Runnable() {

            @Override
            public void run() {
                setVisible(true);
            }
        });
    }

    public void closeWindow() {
        dispatchEvent(new WindowEvent(this, WindowEvent.WINDOW_CLOSING));
    }

    public void dialog(String msg, int tipo) {
        JOptionPane.showMessageDialog(this, msg, getName(), tipo);
    }

    protected void setBoundWindow() {
        setBoundWindow(this);
    }
    protected void setBoundWindow(Window window) {
        JDialogUtils.addBoundListner(window);
    }

    protected void setCloseOnEsc() {
        setCloseOnEsc(this);
    }
    protected void setCloseOnEsc(JDialog dialog) {
        JDialogUtils.addEscapeListener(dialog);
    }

    protected JComponentsUtils getJComponentsUtils() {
        return ju;
    }

    protected JDialogUtils getjDialogUtils() {
        return jDialogUtils;
    }
}
