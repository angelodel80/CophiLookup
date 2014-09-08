/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package eu.cophi.util.lookup;
 
import java.util.logging.Level;
import java.util.logging.Logger;


/**
 *
 * @author angelodel80
 */
public class Lookup {
    private Lookup(){
        
    }
    
    public static Lookup getDefault(){
        return new Lookup();
    }
    
    public <T extends Object> T lookup(Class<T> c){
        Logger.getLogger(Lookup.class.getName()).log(Level.INFO, "in lookup con param " + c.getName());
        
        if(c.getName().equals("eu.cophi.api.variants.Diff")) {
            try {
                try {
                    return (T) Class.forName("eu.cophi.modules.variants.builtin.DefaultDiff").newInstance();
                } catch (InstantiationException ex) {
                    Logger.getLogger(Lookup.class.getName()).log(Level.SEVERE, null, ex);
                } catch (IllegalAccessException ex) {
                    Logger.getLogger(Lookup.class.getName()).log(Level.SEVERE, null, ex);
                }
            } catch (ClassNotFoundException ex) {
                Logger.getLogger(Lookup.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        
        else if(c.getName().equals("eu.cophi.spi.variants.DiffProvider")) {
            try {
                try {
                    return (T) Class.forName("eu.cophi.modules.variants.builtin.Provider").newInstance();
                } catch (InstantiationException ex) {
                    Logger.getLogger(Lookup.class.getName()).log(Level.SEVERE, null, ex);
                } catch (IllegalAccessException ex) {
                    Logger.getLogger(Lookup.class.getName()).log(Level.SEVERE, null, ex);
                }
            } catch (ClassNotFoundException ex) {
                Logger.getLogger(Lookup.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        
            return null;
        
    }
}
