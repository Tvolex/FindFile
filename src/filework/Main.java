/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package filework;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 *
 * @author DX
 */
public class Main {

    /**
     * @param args the command line arguments
     * @throws java.io.IOException
     */
    public static void main(String[] args) throws IOException {
        // TODO code application logic here
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in,"Cp1251"));
        writeFile w = new writeFile();//містить метод для збереження тексту в файлі
        Read r = new Read("TEST");//містить метод для виводу вмісту файлу
        
        System.out.println("Введіть текст для збереження");
        String data;
        
        data=in.readLine();

        while(!data.equals("0")){
            //для коректної кросплатформеності додаємо той кінець рядка який використовується в ОС
            w.addToFile(data+System.getProperty("line.separator"));
            r.findInFile();
            System.out.println("Введіть текст для збереження, або 0 для виходу.");
            data=in.readLine();
        }
    }    
}
