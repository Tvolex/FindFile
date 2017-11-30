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
    
    private static ArrayList allFiles = new ArrayList();
    
    private static ArrayList foundedFiles = new ArrayList();
    
    private static ArrayList ff = new ArrayList();

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
    
    public ArrayList queue () {
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
                    
                    foundedFiles.add(result.toString());
                    
                } catch(Exception e) {
                    System.err.println("Some trouble: " + e.getMessage());
                }
            }
            
            File tempFile = new File(path + "/" + file);
            
            if (tempFile.isDirectory()) {
                
                findRuntime(phrase, path);
                
            }
            
            i++;
        }

    }
    
    private ArrayList findQueue (String find, String path) {
        
        File f = new File(path);
        
        if (!path.endsWith("/"))
                path = path + "/";
        
        String currentFile;
        
         
        
        String[] list = f.list();   
        
        
        
        for (String file : list) {  
            
            currentFile = path + file;
            
            File tempFile = new File(currentFile);
            
            /**
             * if tempFile is File and have related expansion that push to allFiles
             */
            if (tempFile.isFile() && tempFile.getName().endsWith(Expansion)) {
                 
                allFiles.add(currentFile); // insert all files with Expansion .txt to AllFiles
                
                //continue;
            }
            
            if (tempFile.isDirectory()) {      
                    
                findQueue(find, currentFile); 
            }
        }
        
        return findInEachFile(allFiles);
    }
    
    private ArrayList findInEachFile(ArrayList allFiles) {
        
        ArrayList Result = new ArrayList();
        
        try {
        
            for (Object file : allFiles) {
                
                if (file != null) {

                    String tempFile = new Read(Phrase, file.toString()).findInFile();

                    if (tempFile != null) {

                        Result.add(tempFile);
                    }
                        
                }
                
                
            }
        } catch (Exception e) {
            
            System.err.println("Some fuck*ng shit trouble: " + e);
            
        }
        
        
        return Result;
    }
    
}
 
