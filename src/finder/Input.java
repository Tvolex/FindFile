/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package finder;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author tisya
 */
public class Input {
    
    public static String get() {
        
        try {
            
            BufferedReader reader = new BufferedReader( new InputStreamReader (System.in));
            
            String path = reader.readLine();
            
            return path;
        } catch (IOException ex) {
            
            Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
        
        }
        
        return null;
    }
}
