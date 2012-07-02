/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.utfpr.cm.tsi.marcelo.components.utils;

import java.awt.Rectangle;
import java.awt.Window;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.prefs.Preferences;
import javax.swing.JComponent;
import javax.swing.JDialog;
import javax.swing.KeyStroke;

/**
 *
 * @author Marcelo
 */
public class JDialogUtils {

   public static void addBoundListner(final Window janela){
      Preferences p = Preferences.systemRoot().node( janela.getClass().getName().replace('.', '/'));
      String bounds = p.get("bounds", null);

      if(bounds!=null){
         if(janela instanceof JDialog){
            if(((JDialog)janela).isResizable()){
               janela.setBounds(decodeRectangle(bounds));
            }else{
               janela.setLocation(decodeRectangle(bounds).getLocation());
            }
         }else{
            janela.setBounds(decodeRectangle(bounds));
         }
      }

      janela.addWindowListener(new WindowAdapter() {

         @Override
         public void windowClosing(WindowEvent e) {
            Preferences p = Preferences.systemRoot().node( janela.getClass().getName().replace('.', '/'));

            

            p.put("bounds", encodeRectangle(janela.getBounds()));

            janela.removeWindowListener(this);
         }

      });
      
      if(janela instanceof JDialog){
         addEscapeListener((JDialog) janela);
      }

   }
   
   public static void addEscapeListener(final JDialog dialog) {

      KeyStroke stroke = KeyStroke.getKeyStroke(KeyEvent.VK_ESCAPE, 0);

      dialog.getRootPane().registerKeyboardAction(new ActionListener() {

         /**
          * Invoked when an action occurs.
          */
         @Override
         public void actionPerformed(final ActionEvent e) {
            dialog.dispatchEvent(new WindowEvent(dialog, WindowEvent.WINDOW_CLOSING));
         }
      }, stroke, JComponent.WHEN_IN_FOCUSED_WINDOW);
   }

   public static Rectangle decodeRectangle(String bounds) {
        if (bounds == null) {
            return null;
        }

        Rectangle rect = null;
        String[] array = bounds.split(",");
        if (array.length == 4) {
            try {
                rect = new Rectangle();
                rect.x = Integer.parseInt(array[0]);
                rect.y = Integer.parseInt(array[1]);
                rect.width = Integer.parseInt(array[2]);
                rect.height = Integer.parseInt(array[3]);
            } catch (NumberFormatException nfe) {
                rect = null;
            }
        }
        return rect;
    }

    public static String encodeRectangle(Rectangle bounds) {
        StringBuilder buf = new StringBuilder();
        buf.append(bounds.x);
        buf.append(',');
        buf.append(bounds.y);
        buf.append(',');
        buf.append(bounds.width);
        buf.append(',');
        buf.append(bounds.height);
        return buf.toString();
    }

}
