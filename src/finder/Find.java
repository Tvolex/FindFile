/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package finder;

import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;

/**
 *
 * @author tvolex
 */
public final class Find {
    
    private static String[] allFiles = new String[999];
    
    private static String[] foundedFiles = new String[20];

    private static String Expansion = ".txt";
    
    private static String Phrase;
    
    private static String Path;
    
    private static int i = 0;
    
    private static boolean flag;
    
    
    /**
     * This is a class in which to search
     * @param phrase The phrase for which the search will
     * @param path The parent path which the search will
     * @param expansion The expansion which the search will. Like a '.txt'
     */
    public Find (String phrase, String path) {
        
        if (path != null && phrase != null) {
            
            this.Phrase = phrase;
            
            this.Path = path;
            
        }
    }
    
    /**
     * This is a class in which to search
     * @param phrase The phrase for which the search will
     * @param path The parent path which the search will
     * @param expansion The expansion which the search will. Like a '.txt'
     */
    public Find (String phrase, String path, String expansion) {
        
        if (path != null && phrase != null) {
            
            this.Phrase = phrase;
            
            this.Path = path;
            
            this.Expansion = expansion;
            
        }
    }
    
    public void runtime () { 
        findRuntime(Phrase, Path); 
    };
    
    public String[] queue () {
        return findQueue(Phrase, Path);
    }
    
    
    private void findRuntime (String phrase, String path) {
        
        System.out.println("Path: " + path);
        
        File f = new File(path);
        
        File[] listByPath = new Path(f).contains();
        
        String result;
        
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

    }
    
    private String[] findQueue (String find, String path) {
        File f = new File(path);
        
        String currentPath;
        
        String[] list = f.list();   
        
        
        
        for (String file : list) {      
            if (!path.endsWith("/")) {
                path = path + "/";
            }
            
            currentPath = path + file;
            
            File tempFile = new File(currentPath);
            
            if (tempFile.isFile() && tempFile.getName().endsWith(Expansion)) {
                 
                allFiles[i] = path + file; // insert all files with Expansion .txt to String[] AllFiles
                
                i++;
               
            }
            
            File tempfile = new File(path, file);
            
            if (tempfile.isDirectory()) {      
                    
                    findQueue(find, path + file); 
                }
        }
        
        return findByEachFile(allFiles);
    }
    
    private String[] findByEachFile(String[] allFiles) {
        
        String[] Result = new String[100];
        
        int j = 0;
        
        for (String file : allFiles) {
            
                if (file != null) {

                    Read tempFile = new Read(Phrase, file);

                    if (!tempFile.toString().equals(null)) {

                        Result[j] = tempFile.findInFile();

                        j++;
                }
            }
            
        }
        
        return Result;
    }
}
