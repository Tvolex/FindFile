/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package finder;


import java.io.*;
import java.util.Arrays;
import java.util.logging.Level;
import java.util.logging.Logger;
import filework.*;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Map;
import java.util.Set;
import sun.rmi.runtime.Log;

/**
 *
 * @author tvolex
 */
public class FindFile {
    private static int procces = 1;
    private static String phrase;
    
    private Map collection;
    /**
     * 
     * @param args main method 
     */
    public static void main (String args[]) throws IOException {
        start();
    }
    
    public static void start () {
        
        while (procces == 1) {
            
            System.err.print("Enter your phrase: ");
            
            phrase = Input.get();
            
            System.err.print("Enter your path: ");
                
            String inPath = Input.get();
            
            Path path = new Path(inPath);
            
            if (path.validate()) {
                
                File[] listOfFiles = path.contains();
                
                //   D:/Programs/JavasProjects/FindFile/src/
                
                for (File file : listOfFiles) {
                    
                    if (file.isFile()) {
                        
                        Read readedFile = new Read(phrase, file.toString());
                        
                        readedFile.readFile();
                        
                    } else if (file.isDirectory()) {
                        
                        try {
                            
                            Read readedFile = new Read(phrase, file.toString());
                            
                            readedFile.readFile();
                            
                        } catch (Exception e) {
                            
                            System.err.println(e);
                            
                        }
                        
                    }
                    
                    
                }
                
                System.out.println(listOfFiles.length);
                
            } else {
                
                System.err.println("No such file/directory or no permission for read");
                
            }
            
            System.out.println("Repeat? (y/n)");
            
            String confirm = Input.get();
            
            
            if (confirm.equals("y")) 
                procces = 1;
            else 
                procces = 0;
            
        }
         
    }
}
