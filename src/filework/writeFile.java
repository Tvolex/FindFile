/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package filework;
import java.io.BufferedWriter;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
/**
 *
 * @author DX
 */
public class writeFile {
    private BufferedWriter out;
    /**
     * метод дописує у кінець файлу переданий текст, якщо файл не існує його буде створено
     * @param x містить текст який треба дописати
     */
    public void addToFile(String x){
        try {
            out = new BufferedWriter(new OutputStreamWriter(new FileOutputStream("d:\\text.txt", true),"Cp1251"));
            out.write(x);
            //out.newLine();
            out.close();
        }catch (IOException e){
            System.out.println(e.getMessage());
        }
    }
    /**
     * метод перезаписує файл, якщо файл не існує його буде створено
     * @param X текст яким буде перезаписано файл
     */
    public void rewriteFile(String X) {
        try{
            out = new BufferedWriter(new OutputStreamWriter(new FileOutputStream("d:\\text.txt"),"Cp1251"));           
            out.write(X);
            out.newLine();
            out.close();
            
        }catch (IOException e){
            System.out.println(e.getMessage());
        }
    }      
}
