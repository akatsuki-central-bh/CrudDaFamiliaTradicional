package Control;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

import javax.swing.JOptionPane;

import model.Doc;

public class DocControler {
	public static int count = 0;
	public static void escrever(Doc doc) {
		try {
			BufferedWriter writer = new BufferedWriter(new FileWriter("legislacao-ambiental-brasileira.txt", true));
			String linha = doc.getAno() + ";" + doc.getDocumento() + ";" + doc.getAtoNormativo() + ";" + doc.getEmenta()
					+ ";" + doc.getLink() + ";" + doc.getStatus();
			writer.append("\n" + linha);
			writer.close();
			JOptionPane.showMessageDialog(null, "Documento gravado com sucesso!");
			System.out.println("Objeto gravado com sucesso!");
			//falta adicionar um ID antes de salvar o objeto no txt, se deixar do jeito q ta ele nao cooloca id
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static ArrayList<Doc> ler() { //le todas as linhas do txt e armazena num array(sem o numero de id), em seguida retorna esse array
		ArrayList<Doc> ArrayDocumentos = new ArrayList();
		Doc doc;
		try {
			FileReader arq = new FileReader("legislacao-ambiental-brasileira.txt");
			BufferedReader lerArq = new BufferedReader(arq);
			String linha = "";
			try {
				linha = lerArq.readLine();
				while (linha != null) {
					String[] colunas = linha.split(";");
					try {
						doc = new Doc(colunas[1], colunas[2], colunas[3], colunas[4], colunas[5], colunas[6]);
						ArrayDocumentos.add(doc);
					} catch (Exception e) {
						//e.printStackTrace(); 515 linhas com erro de tamanho(n tem os 5 campos preenchidos)
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
		return ArrayDocumentos;

	}
}
