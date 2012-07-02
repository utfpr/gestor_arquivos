
/*
 * Copyright 2011 marcelo.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.

 */
/*
 * UTFPR - Universidade Tecnol�gica Federal do Paran�
 * Campo Mour�o 20/07/2011
 * Tecnologia em Sistemas para Internet
 * Aluno: Marcelo Lopes da Silva
 * Professor orientador: Ivanilton Polato 
 */
package br.edu.utfpr.cm.tsi.marcelo.components.utils;

import java.awt.Font;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

/**
 * Classe: "MJTextField.java" criada em 20/07/2011, 23:51:56
 * @author marcelo
 */
public class MJTextField extends JPanel{
    private JLabel jLabel;
    private JTextField jTextField;
    
    private JComponentsUtils jcu;

    public MJTextField() {
        jcu = new JComponentsUtils();
        
        jLabel = jcu.getLabel("");
        jTextField = jcu.getTextField(10);
        initLayout();
    }

    public void setFontComponent(Font font){
        jLabel.setFont(font);
        jTextField.setFont(font);
    }
    
    private void initLayout() {
        add(jLabel);
        add(jTextField);
    }

    public JLabel getjLabel() {
        return jLabel;
    }

    public void setjLabel(JLabel jLabel) {
        this.jLabel = jLabel;
    }

    public JTextField getjTextField() {
        return jTextField;
    }

    public void setjTextField(JTextField jTextField) {
        this.jTextField = jTextField;
    }
}
