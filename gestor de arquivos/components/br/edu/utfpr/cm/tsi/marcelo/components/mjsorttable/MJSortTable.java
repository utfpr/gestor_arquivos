/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.utfpr.cm.tsi.marcelo.components.mjsorttable;

import br.edu.utfpr.cm.tsi.marcelo.components.jsorttable.JSortTable;
import br.edu.utfpr.cm.tsi.marcelo.components.jsorttable.SortTableModel;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JTable;

/**
 *
 * @author tchulla
 */
public class MJSortTable extends JSortTable {

    private List<Coluna> colunas;

    public MJSortTable(SortTableModel model) {
        super(model);
        colunas = new ArrayList<Coluna>();
    }
    
    public MJSortTable() {
        super(null);
        colunas = new ArrayList<Coluna>();
    }

    
    private class Coluna {

        private String descricao;
        private int largura;

        public String getDescricao() {
            return descricao;
        }

        public void setDescricao(String descricao) {
            this.descricao = descricao;
        }

        public int getLargura() {
            return largura;
        }

        public void setLargura(int largura) {
            this.largura = largura;
        }
    }
}
