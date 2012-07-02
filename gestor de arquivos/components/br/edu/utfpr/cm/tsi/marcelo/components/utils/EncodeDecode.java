/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.utfpr.cm.tsi.marcelo.components.utils;
import java.awt.Rectangle;

/**
 *
 * @author Marcelo
 */
public class EncodeDecode {

    public static Rectangle encodeRectangle(String get) {
        Rectangle ret = new Rectangle();

        String[] array = get.split(",");

        ret.x = Integer.parseInt(array[0].replace(".0", ""));
        ret.y = Integer.parseInt(array[1].replace(".0", ""));
        ret.width = Integer.parseInt(array[2].replace(".0", ""));
        ret.height = Integer.parseInt(array[3].replace(".0", ""));

        return ret;
    }

    public static String decodeRectangle(Rectangle bounds) {
        final char CARACTER_SEPARADOR = ',';

        StringBuilder builder = new StringBuilder();

        builder.append(bounds.getX());
        builder.append(CARACTER_SEPARADOR);
        builder.append(bounds.getY());
        builder.append(CARACTER_SEPARADOR);
        builder.append(bounds.getWidth());
        builder.append(CARACTER_SEPARADOR);
        builder.append(bounds.getHeight());

        return builder.toString();
    }
}
