package Control;

import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.ArrayList;

import javax.swing.JOptionPane;

import model.Doc;

public class DocControler {
	public static void escrever(Doc doc) {
		try {
			BufferedWriter writer = new BufferedWriter(new FileWriter("legislacao-ambiental-brasileira.txt", true));
			String linha = doc.getAno() + ";" + doc.getDocumento() + ";" + doc.getAtoNormativo() + ";" + doc.getEmenta()
			+ ";" + doc.getLink() + ";" + doc.getStatus();
			writer.append("\n" + linha);
			writer.close();
			JOptionPane.showMessageDialog(null, "Documento gravado com sucesso!");
	        System.out.println("Objeto gravado com sucesso!");;
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static ArrayList<Doc> ler() { //preciso consertar essa parte aqui
		FileInputStream arquivo = null;
		ArrayList<Doc> Docs = new ArrayList<Doc>();
		Doc Doc = null;
		ObjectInputStream obj = null;
		try {
			arquivo = new FileInputStream("./Docs.dat");
			obj = new ObjectInputStream(arquivo);
			do {
				Doc = (Doc) obj.readObject();
				if (Doc != null)
					Docs.add(Doc);
			} while (Doc != null);
			arquivo.close();
			obj.close();
		} catch (IOException | ClassNotFoundException e) {
			e.printStackTrace();
		}
		return Docs;
	}
}
