/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.utfpr.cm.tsi.marcelo.components.mjsorttable;

import java.util.ArrayList;
import java.util.List;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author tchulla
 */
public class MJSortTableModel extends AbstractTableModel {

    private static final long serialVersionUID = 1L;
    
    private List<Coluna> colunas;

    public MJSortTableModel() {
        colunas = new ArrayList<Coluna>();
    }

    public void addColumn(String descricao, int largura) {
        colunas.add(new Coluna(descricao, largura));
    }

    @Override
    public int getRowCount() {
        return 0;
    }

    @Override
    public int getColumnCount() {
        return colunas.size();
    }

    @Override
    public Object getValueAt(int i, int i1) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public String getColumnName(int i) {
        return colunas.get(i).getDescricao();
    }
    
    
    
    

    private class Coluna {

        private String descricao;
        private int largura;

        public Coluna() {
        }

        public Coluna(String descricao, int largura) {
            this.descricao = descricao;
            this.largura = largura;
        }

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
