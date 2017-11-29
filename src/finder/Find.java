/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package finder;

import filework.Read;
import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;

/**
 *
 * @author tisya
 */
public final class Find {
    private static String[] allFiles = new String[999];
    private static String[] foundedFiles = new String[20];
    private static int i = 0;
    public Find (String phrase, String path) {
        
        if (path != null && phrase != null) {
            
            func(phrase, path);
            
        }
        
    }
    
    public void findRuntime(String phrase, String path) {
        System.out.println("Path: " + path);
        
        File f = new File(path);
        
        File[] listByPath = new Path(f).contains();
        
        String result;
        
        System.out.println(Arrays.toString(listByPath));
        
        int i = 0;
                
        for (File file : listByPath) {
        
            result = new Read(phrase, file.getAbsolutePath()).findInFile();
            
            if (result != null) {
                
                try {
                    
                    foundedFiles[i] = result;
                    
                } catch(Exception e) {
                    
                }
            }
            
            File tempFile = new File(path + "/" + file);
            
            if (tempFile.isDirectory()) {
                
                findRuntime(phrase, path);
                
            }
            
            
                
            i++;
        }
        
        System.out.println("Founded: " + Arrays.toString(foundedFiles));
    }
    
    
     static boolean flag;
    
    static void func(String find, String path) {
        File f = new File(path);
        
        String currentPath;
        
        String[] list = f.list();   
        
        
        
        for (String file : list) {      
            if (!path.endsWith("/")) {
                path = path + "/";
            }
            
            currentPath = path + file;
            
            if (new File(currentPath).isFile()) {
                 
                allFiles[i] = path + file; // insert all files to String[] AllFiles
                
                i++;
               
            }
            
            File tempfile = new File(path, file);
            
           
            
            if (tempfile.isDirectory()) {      
                    
                    func(find, path + file); 
                }
        }
        
        System.err.println(Arrays.toString(allFiles));
    }
}
