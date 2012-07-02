/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.utfpr.cm.tsi.marcelo.components.utils;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.KeyListener;
import java.text.ParseException;
import javax.swing.BorderFactory;
import javax.swing.ComboBoxModel;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JComponent;
import javax.swing.JFormattedTextField;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import javax.swing.text.JTextComponent;
import javax.swing.text.MaskFormatter;
import br.edu.utfpr.cm.tsi.marcelo.components.jsorttable.JSortTable;
import br.edu.utfpr.cm.tsi.marcelo.components.resource.B;

/**
 *
 * @author Marcelo
 */
public class JComponentsUtils {
    
//    private final String DEFAULT_MINMONIC_CHAR = r.getString("CharForMnemonics");
    private Font fontDefault;

    public void validarCampo(JTextComponent jtc, boolean condicao, String naoValido) {
        if (!condicao) {
            JOptionPane.showMessageDialog(jtc, naoValido, "Campo invalido!", JOptionPane.ERROR_MESSAGE);
            jtc.grabFocus();
        }
    }

    public void carregarValor(JTextComponent jtc, String text) {
        jtc.setText(text);
        
    }

    public JCheckBox getJCheckBox(String s) {
        JCheckBox ret = new JCheckBox(s);
        return ret;
    }

    public void setFont(Font font) {
        this.fontDefault = font;
    }

    public Boolean checkJText(JTextComponent jtc, String regix, String noMsg) {
        if (!jtc.getText().matches(regix.trim())) {

            JOptionPane.showMessageDialog(null, noMsg, "Campo invalido!", JOptionPane.ERROR_MESSAGE);

            return false;
        }
        return true;
    }

    public JLabel getLabel(String text) {
        return getLabel(text, fontDefault, Color.DARK_GRAY, null);
    }

    public JLabel getLabel(String text, Font font) {
        return getLabel(text, font, Color.DARK_GRAY, null);
    }
    public JLabel getLabel(String text, Font font , Color color) {
        return getLabel(text, font, color, null);
    }

    public JLabel getLabel(String text, JComponent componentForLabel) {
        return getLabel(text, fontDefault, Color.DARK_GRAY, componentForLabel);
    }

    public JLabel getLabel(String text, Font fonte, Color cor, JComponent componentForLabel) {
        JLabel ret = new JLabel();
        ret.setLabelFor(componentForLabel);
        ret.setText(B.getString(text));
        ret.setFont(fonte);
        ret.setForeground(cor);

        setMnemonic(ret);

        return ret;
    }

    public JButton getJButton(String texto) {
        return getJButton(texto, null);
    }
    
    public void textoParaComponenteTexto(String text, JTextComponent component){
        component.setText(text);
    }
    
    public void abilitarComponents(JComponent ... components){
        for (JComponent jc : components) {
            jc.setEnabled(true);
        }
    }
    public void desbilitarComponents(JComponent ... components){
        for (JComponent jc : components) {
            jc.setEnabled(false);
        }
    }

    public JButton getJButton(String texto, Font font, ActionListener al) {
        JButton ret = new JButton(B.getString(texto));
        ret.setMnemonic(getMnemonic(texto));
        ret.setFont(font);
        ret.setText(texto.replace("_", ""));
        ret.addActionListener(al);
        setMnemonic(ret);
        return ret;
    }
    public JButton getJButton(String texto, ActionListener al) {
        return getJButton(texto,null,al);
    }

    public JPanel getJPanel(String label) {
        JPanel ret = new JPanel();

        if (label != null) {
            ret.setBorder(BorderFactory.createTitledBorder(B.getString(label)));
        }
        return ret;
    }

    public JRadioButton getJRadioButton(String value) {
        String val = B.getString(value);
        JRadioButton ret = new JRadioButton();
        ret.setMnemonic(getMnemonic(val));
        ret.setText(val.replace("_", ""));
        return ret;
    }

    public JComboBox getJComboBox(ComboBoxModel comboBoxModel) {
        JComboBox ret = new JComboBox();
        if (comboBoxModel != null) {
            ret.setModel(comboBoxModel);
        }
        return ret;
    }

    private char getMnemonic(String text) {
        if (text.contains("_")) {
            char c = text.charAt(text.indexOf("_") + 1);
//            text = text.replaceAll("_", "");
            return c;
        }
        
        return ' ';

    }

    private void setMnemonic(JComponent component) {
        if (component instanceof JButton) {
            JButton button = (JButton) component;

            String text = button.getText();

            if (text.contains("_")) {
                char c = text.charAt(text.indexOf("_") + 1);
                text = text.replaceAll("_", "");
                button.setText(text);
                button.setMnemonic(c);
            }
        }

        if (component instanceof JLabel) {
            JLabel label = (JLabel) component;
            String text = label.getText();
            
            if(text == null) return;


            if (text.contains("_")) {

                if (label.getLabelFor() != null) {
                    char c = text.charAt(text.indexOf("_") + 1);
                    text = text.replace("_", "");
                    label.setText(text);
                    label.setDisplayedMnemonic(c);
                }
            }

        }



    }

    private void setMnemocs(JTextComponent component) {
        String text = component.getText();

        if (text.contains("_")) {
            int index = text.lastIndexOf("_");
            System.out.println(index);

        }

    }
    
    public MJTextField getMJTextField(String label, KeyListener mjtl) {
        return getMJTextField(label, "", 10, mjtl);
    }
    public MJTextField getMJTextField(String label) {
        return getMJTextField(label, null, 10);
    }

    public MJTextField getMJTextField(String label, int with) {
        return getMJTextField(label, null, with);
    }

    public MJTextField getMJTextField(String label, String value, int with) {
        return getMJTextField(label, value, with, null);
    }
    public MJTextField getMJTextField(String label, String value, int with, final KeyListener mjtl) {
        MJTextField ret = new MJTextField();
        
        final String txt = value;

        ret.setFontComponent(fontDefault);

        if(mjtl!=null){
            System.out.println("...");
            ret.addKeyListener(mjtl);
        }
        
        ret.getjLabel().setText(B.getString(label));
        ret.getjTextField().setColumns(with);
        ret.getjTextField().setText(value);
        return ret;
    }

    
    
    
    public JTextField getTextField(int i) {
        return getTextField(i, null);
    }
    public JTextField getTextField(int i, KeyListener keyListener) {
        JTextField ret = new JTextField(i);
        ret.addKeyListener(keyListener);
        return ret;
    }

    public JPasswordField getJPasswordField(int i) {
        return new JPasswordField(i);
    }

    private ComboBoxModel getComboBoxModel() {
        DefaultComboBoxModel dcbm = new DefaultComboBoxModel();
        dcbm.addElement("Marcelo");
        dcbm.addElement("Lopes");
        dcbm.addElement("Silva");

        return dcbm;
    }

    public JFormattedTextField getJFormattedTextField(String mask) {
        return getJFormattedTextField(mask, 10);
    }

    public JSortTable getJSortTable(){
        return new JSortTable(null);
    }
    
    
    public JFormattedTextField getJFormattedTextField(String string, int i) {
        try {
            JFormattedTextField ret = new JFormattedTextField(new MaskFormatter(string));
            ret.setColumns(i);
            return ret;
        } catch (ParseException ex) {
            return new JFormattedTextField();
        }
    }
}
