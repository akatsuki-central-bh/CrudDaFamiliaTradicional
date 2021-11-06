package Control;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

import model.Doc;

public class DocControler {
	public static void escrever(Doc doc) {
		try {
			FileOutputStream arquivoGrav = new FileOutputStream("Docs.dat");
	        ObjectOutputStream objGravar = new ObjectOutputStream(arquivoGrav);
	        objGravar.writeObject(doc);
	        objGravar.flush();
	        objGravar.close();
	        System.out.println("Objeto gravado com sucesso!");;
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public static ArrayList<Doc> ler() { //preciso consertar essa parte aqui
		FileInputStream arquivo = null;
		ArrayList<Doc> Docs = new ArrayList<Doc>();
		Doc Doc = null;
		ObjectInputStream obj = null;
		try {
			arquivo = new FileInputStream("./Docs.obj");
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
