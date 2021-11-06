package Test;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

import model.Doc;

public class Test {

	public static void escrever() {
		Doc doc = new Doc("2015", "Documento3", "Ato Norm. 6", "Ementa", "Link", "Status");
		try {
			BufferedWriter writer = new BufferedWriter(new FileWriter("legislacao-ambiental-brasileira.txt", true));
			String linha = doc.getAno() + ";" + doc.getDocumento() + ";" + doc.getAtoNormativo() + ";" + doc.getEmenta()
			+ ";" + doc.getLink() + ";" + doc.getStatus();
			
			writer.append("\n" + linha);
			writer.close();
			// ObjectOutputStream objGravar = new ObjectOutputStream(arquivoGrav);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public static void main(String[] args) {
		escrever();
	}
}
