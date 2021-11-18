package Control;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

import javax.swing.JOptionPane;

import model.Doc;

public class DocControler {
    public static int count = 0;
    public static int nextId;
    public static File diretorio = new File("legislacao-ambiental-brasileira.txt");

    private static ArrayList<Doc> documentos = new ArrayList<Doc>();

    public static void escrever(Doc doc) { // escreve no final do txt
        documentos.add(doc);
        salvar();
        JOptionPane.showMessageDialog(null, "Documento gravado com sucesso!");
        System.out.println("Objeto gravado com sucesso!");
    }

    public static void deletar() { // passa as linhas para um arraylist, remove o primeiro, apaga o arquivo txt e
        documentos.remove(0);
        salvar();
    }

    public static ArrayList<Doc> getArrayDocs() { // retorna um array com todas as linhas do txt
        documentos.clear();
        try {
            FileReader arq = new FileReader(diretorio);
            BufferedReader lerArq = new BufferedReader(arq);
            String linha = "";
            try {
                linha = lerArq.readLine();
                while (linha != null) {
                    String[] colunas = linha.split(";");
                    try {
                        Doc doc = new Doc(Integer.parseInt(colunas[0]), colunas[1], colunas[2], colunas[3], colunas[4],
                                colunas[5], colunas[6]);
                        documentos.add(doc);
                    } catch (Exception e) {
                        // e.printStackTrace(); 515 linhas com erro de tamanho(n tem os 5 campos
                        // preenchidos)
                    }
                    linha = lerArq.readLine();
                }
                arq.close();
            } catch (IOException ex) {
                JOptionPane.showMessageDialog(null, "nao foi possivel ler o arquivo!");
            }
        } catch (FileNotFoundException ex) {
            JOptionPane.showMessageDialog(null, "Arquivo nao encontrado!");
        }

        return documentos;
    }

    public static int getNextId() throws FileNotFoundException {
        getArrayDocs();
        Doc lastDoc = documentos.get(documentos.size() - 1);
        return lastDoc.getId() + 1;
    }

    public static void alterarDoc(Doc d) {
        for (int i = 0; i < documentos.size(); i++) {
            if (documentos.get(i).getId() == d.getId()) {
                documentos.set(i, d);
                salvar();
                System.out.println("alterado com sucesso");
                JOptionPane.showMessageDialog(null, "Documento Alterado com sucesso!");
                break;
            }
        }
    }

    public static Doc getById(int id) {
        ArrayList<Doc> docs = getArrayDocs();
        for (Doc doc : docs) {
            if (doc.getId() == id) {
                return doc;
            }
        }
        return null;
    }

    public static void salvar() {
        diretorio.delete();
        try {
            BufferedWriter writer = new BufferedWriter(new FileWriter(diretorio, true));
            for (Doc doc : documentos) {
                writer.write(doc.getLinha() + "\n");
            }
            writer.flush();
            writer.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
