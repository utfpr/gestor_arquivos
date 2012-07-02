/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.utfpr.cm.tsi.marcelo.components.resource;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.text.MessageFormat;
import java.util.Properties;
import java.util.ResourceBundle;

/**
 *
 * @author tchulla
 */
public class B {

    private ResourceBundle bundle;
    private File file;
    private FileInputStream fis;
    
    public B() {
        bundle = ResourceBundle.getBundle("resource/Bundle");
    }

    public static String getPreferencia(EnumValues key, String sdefault) {
        return new B().getPropertiesInFile(key.name(), sdefault);
    }

    public static String getPreferencia(String key, String sdefault) {
        return new B().getPropertiesInFile(key, sdefault);
    }

    public static String getPreferenciaNaoSalvar(String key, String sdef) {
        return new B().getPreferenciaSemSalvar(key, sdef);
    }

    private String getPreferenciaSemSalvar(String key, String sdefault) {
        try {
            Properties props = new Properties();
            file = new File(Conf.FILE_PROPERTIES);
            fis = new FileInputStream(file);

            props.load(fis);
            fis.close();

            if (props.getProperty(key) == null) {
                return key;
            } else {
                return props.getProperty(key);
            }

        } catch (Exception e) {
            return key;
        }
    }

    private String getPropertiesInFile(String key, String sdefault) {
        synchronized (this) {

            try {
                Properties props = new Properties();
                file = new File(Conf.FILE_PROPERTIES);
                fis = new FileInputStream(file);

                props.load(fis);
                fis.close();

          
                if (props.getProperty(key) == null) {
                    props.put(key, sdefault);
                    store(props);
                }

                return props.getProperty(key);
            } catch (FileNotFoundException e) {
                store(new Properties());
                getPropertiesInFile(key, sdefault);
                return null;
            } catch (Exception e) {
                return key;
            }
        }

    }

    public void store(Properties p) {
        try {
            file = new File(Conf.FILE_PROPERTIES);
            p.store(new FileOutputStream(file), "");
          
        } catch (Exception e) {
        }
    }

    public static String getString(String key, Object... args) {
        return new B().get(key, args);
    }

    private String get(String key, Object... args) {
        try {
            return MessageFormat.format(bundle.getString(key), args);
        } catch (Exception e) {
            return key;
        }
    }
}
