package Test;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.ArrayList;

import javax.swing.JOptionPane;

import Control.DocControler;
import model.Doc;

public class teste {
	public static void escrever() {
		try {
			Doc doc = new Doc("2014", "DocTeste", "AtoNormativo Teste", "EmentaTest", "Teste", "Teste");
			BufferedWriter writer = new BufferedWriter(new FileWriter("legislacao-ambiental-brasileira.txt", true));
			String linha = doc.getAno() + ";" + doc.getDocumento() + ";" + doc.getAtoNormativo() + ";" + doc.getEmenta()
					+ ";" + doc.getLink() + ";" + doc.getStatus();
			writer.append("\n" + linha);
			writer.close();
			JOptionPane.showMessageDialog(null, "Documento gravado com sucesso!");
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	public static void gerarId() {
		try {
			BufferedWriter writer = new BufferedWriter(new FileWriter("entrada.txt", true));
			FileReader arq = new FileReader("legislacao-ambiental-brasileira.txt");
			BufferedReader lerArq = new BufferedReader(arq);
			String linha = lerArq.readLine();
			int id = 0;
			String novaLinha;
			while (linha != null) {
				novaLinha = Integer.toString(id) + ";" + linha + "\n";
				writer.write(novaLinha);
				id++;
				linha = lerArq.readLine();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static void listarDocumentos() {
		ArrayList<Doc> Docs = DocControler.ler();
		for (Doc doc : Docs) {
			System.out.println(doc.toString());
		}
	}

	public static void main(String[] args) {
		listarDocumentos();
	}
}
