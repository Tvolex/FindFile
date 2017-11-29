/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package finder;

import java.io.File;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;

/**
 *
 * @author tisya
 */
public class Path {
    private String currentPath;
    
    private boolean exist;
    
    private boolean readable;
    
    private boolean result;
    
    
    public Path(String path) {
        
        this.currentPath = path;
        
    }

    public Path(File path) {
       this.currentPath = path.getAbsolutePath();
    }

    public boolean validate() {
        
        char[] chars = currentPath.toCharArray();
        
        exist = new File(currentPath).exists();
        
        if (!exist) return false;
        
        boolean ended = String.valueOf(chars[chars.length - 1]).equals("/");
        
        if (!ended) 
            currentPath += "/";
        
        readable = new File(currentPath).canRead();
        
        result = exist && readable;
        
        System.out.println("path is valid: " + result);
           
       //asds
        return result;
    }
    
    public File[] contains() {
        
        return new File(currentPath).listFiles();
        
    }

    
}
