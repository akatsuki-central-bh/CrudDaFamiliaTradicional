
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author leanddro
 */
public class test {

    public static void main(String[] args) {
        try {
            String str = "Hello";
            BufferedWriter writer = new BufferedWriter(new FileWriter("teste.txt", true));
            writer.append("\n" + str);

            writer.close();
        } catch (IOException ex) {
            Logger.getLogger(test.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
