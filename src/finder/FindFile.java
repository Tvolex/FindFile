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
    public static Find findFile;
    
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
                
                if (listOfFiles != null)
                    findFile = new Find(phrase, inPath);
                
                else 
                    
                    System.err.println("Somethins wrong");
                
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

