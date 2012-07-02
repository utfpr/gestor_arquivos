/*
 =====================================================================
 
 DefaultSortTableModel.java
 
 Created by Claude Duguay
 Copyright (c) 2002
 
 
 Modified by Renato F. V. da Costa
 2005
 
 =====================================================================
 */
package br.edu.utfpr.cm.tsi.marcelo.components.jsorttable;

import java.util.Comparator;
import java.util.Vector;

public class ColumnComparator
        implements Comparator {

    protected boolean ascending;
    protected int index;

    public ColumnComparator(int index, boolean ascending) {
        this.index = index;
        this.ascending = ascending;
    }

    public int compare(Object one, Object two) {
        if (one instanceof Vector && two instanceof Vector) {
            Vector vOne = (Vector) one;
            Vector vTwo = (Vector) two;
            Object oOne = vOne.elementAt(index);
            Object oTwo = vTwo.elementAt(index);

            if (oOne instanceof Comparable && oTwo instanceof Comparable) {
                Comparable cOne = (Comparable) oOne;
                Comparable cTwo = (Comparable) oTwo;

                //Added by jSMS
                try {
                    if (index == 0) {
                        boolean found = false;
                        String o[] = oOne.toString().substring(0, 10).split("/");
                        String t[] = oTwo.toString().substring(0, 10).split("/");

                        for (int i = o.length - 1; i >= 0; i--) {
                            if (!o[i].equals(t[i])) {
                                cOne = o[i];
                                cTwo = t[i];

                                found = true;
                                break;
                            }
                        }


                        if (!found) {
                            o = oOne.toString().substring(13, 21).split(":");
                            t = oTwo.toString().substring(13, 21).split(":");

                            for (int i = 0; i < o.length; i++) {
                                if (!o[i].equals(t[i])) {
                                    cOne = o[i];
                                    cTwo = t[i];

                                    break;
                                }
                            }
                        }
                    }
                } catch (Exception e) {
                    //e.printStackTrace();

                    cOne = oOne.toString().toLowerCase();
                    cTwo = oTwo.toString().toLowerCase();
                }

                if (ascending) {
                    return cOne.compareTo(cTwo);
                } else {
                    return cTwo.compareTo(cOne);
                }
            }
        }

        return 1;
    }
}
