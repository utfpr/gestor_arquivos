/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.utfpr.cm.tsi.marcelo.components.resource;

import java.util.prefs.Preferences;

/**
 *
 * @author tchulla
 */
public class Pref {
    private Class clazz ;
    private Preferences prefs;
    
    private Pref(Class clazz){
        this.clazz = clazz;
    }
    
    public static Pref getInstanceForUser(Object o){
        return new Pref(o.getClass());
    }
    public static Pref getInstanceForSystem(Object o){
        return new Pref(o.getClass());
    }
    
    public String getSystemPref(String key, String sDefault){
        this.prefs = Preferences.systemNodeForPackage(clazz);
        return prefs.get(key, sDefault);
    }
    public String getUserPref(String key, String sDefault){
        this.prefs = Preferences.userNodeForPackage(clazz);
        return prefs.get(key, sDefault);
    }
    
    public void putSystemPref(String key, String value){
        this.prefs = Preferences.systemNodeForPackage(clazz);
        this.prefs.put(key, value);
    }
    
    public void putUserPref(String key, String value){
        this.prefs = Preferences.userNodeForPackage(clazz);
        this.prefs.put(key, value);
    }
    
}
