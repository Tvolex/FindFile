/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package finder;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

/**
 *
 * @author DX
 */
public class Read {
    
    private String path = "C:/";
    
    private String phrase;

    public Read (String phrase) {
        
        this.phrase = phrase;
        
    }
    
    public Read (String phrase, String path) {
        
        this.phrase = phrase;
        
        this.path = path;
        
    }
    
    public String findInFile (){
        
        if (path != null) {
            try {

                FileInputStream fis = new FileInputStream(new File(path)); 

                byte[] content = new byte[fis.available()];

                fis.read(content);

                fis.close();

                String[] lines = new String(content, "Cp1251").split("\n"); 

                for (String line : lines) {

                    String[] words = line.split(" ");

                    for (String word : words) {

                        if (word.equalsIgnoreCase(phrase)) {

                            System.out.println("Found in: " + path);

                            return path;

                        }
                    }
                }

            } catch (IOException e) {

                System.err.println(e);

                return null;
            } 
        }
        
        return null;
    }    
}