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
public class Main {
    
    private static ArrayList TOTAL_RESULT;
    private static String confirm;
    private static String phrase;
    private static Find findFile;
    private static String inPath;
    private static int procces;
    private static Path path;
    
    /**
     * 
     * @param args main method 
     */
    public static void main (String args[]) throws IOException {
        
        procces = 1;
        
        startProcess();
    }
    
    public static void startProcess () {
        
        while (procces == 1) {
            
            System.err.print("Enter your phrase: ");
            
            phrase = Input.get();
            
            System.err.print("Enter your path: ");
                
            inPath = Input.get();
            
            path = new Path(inPath);
            
            if (path.validate()) {
                
                findFile = new Find(phrase, inPath, ".txt");
                
                TOTAL_RESULT = findFile.queue();
                    
                System.err.println("TOTAL RESULT: " + TOTAL_RESULT);
                
                //   D:/Programs/JavasProjects/FindFile/src/
                
                
            } else {
                
                System.err.println("No such file/directory or no permission for read");
                
            }
            
            System.out.println("Repeat? (y/n)");
            
            confirm = Input.get();
            
            
            if (confirm.equals("y")) 
                updateVariables();
            else 
                procces = 0;
            
        }
    }
    
    private static void updateVariables() {
        
        Main.TOTAL_RESULT = null;
        Main.findFile = null;
        Main.confirm = null;
        Main.inPath = null;
        Main.phrase = null;
        Main.path = null;
        
        
    }
}

