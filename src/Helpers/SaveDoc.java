package Helpers;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.util.ArrayList;


import model.Doc;

public class SaveDoc {
	
	public static void saveDoc(File diretorio, ArrayList<Doc> listaDoc) {		
		ArrayList<String> listaString = new ArrayList<String>();
		for (Doc doc : listaDoc) {
			listaString.add(doc.getLinha());
		}
		diretorio.delete();
		try {
			BufferedWriter writer = new BufferedWriter(new FileWriter(diretorio, true));
			for (String linha : listaString) {
				writer.write(linha+"\n");
			}
			writer.flush();
			writer.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
