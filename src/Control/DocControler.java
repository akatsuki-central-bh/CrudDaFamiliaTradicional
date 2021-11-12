package Control;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;

import model.Doc;

public class DocControler {
	public static int count = 0;
	public static int nextId;
	public static File diretorio = new File("legislacao-ambiental-brasileira.txt");

	public static void escrever(Doc doc) { // escreve no final do txt
		try {
			BufferedWriter writer = new BufferedWriter(new FileWriter(diretorio, true));
			String linha = Integer.toString(doc.getId()) + ";" + doc.getAno() + ";" + doc.getDocumento() + ";"
					+ doc.getAtoNormativo() + ";" + doc.getEmenta() + ";" + doc.getLink() + ";" + doc.getStatus();
			writer.append("\n" + linha);
			writer.close();
			JOptionPane.showMessageDialog(null, "Documento gravado com sucesso!");
			System.out.println("Objeto gravado com sucesso!");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static void deletar() { // passa as linhas para um arraylist, remove o primeiro, apaga o arquivo txt e
		try { // cria um novo com os arquivos do arraylist
			BufferedReader lerArq = new BufferedReader(new FileReader(diretorio));
			ArrayList<String> salvar = new ArrayList<String>();
			String linha = lerArq.readLine();
			while (linha != null) {
				salvar.add(linha);
				linha = lerArq.readLine();
			}
			lerArq.close();
			salvar.remove(0);
			diretorio.delete();
			BufferedWriter writer = new BufferedWriter(new FileWriter(diretorio, true));
			for (String string : salvar) {
				writer.write(string + "\n");
			}
			writer.flush();
			writer.close();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	public static ArrayList<Doc> getArrayDocs() { // retorna um array com todas as linhas do txt
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
						doc = new Doc(Integer.parseInt(colunas[0]), colunas[1], colunas[2], colunas[3], colunas[4],
								colunas[5], colunas[6]);
						ArrayDocumentos.add(doc);
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
		return ArrayDocumentos;

	}

	public static int getNextId() throws FileNotFoundException {
		FileReader arq = new FileReader("legislacao-ambiental-brasileira.txt");
		BufferedReader lerArq = new BufferedReader(arq);
		String linha = "";
		try {
			linha = lerArq.readLine();
			while (linha != null) {
				nextId++;
				linha = lerArq.readLine();
			}
			arq.close();
		} catch (IOException ex) {
			JOptionPane.showMessageDialog(null, "nao foi possivel ler o arquivo!");
		}

		return nextId;
	}

	public static void alterarDoc(Doc d) {
		ArrayList<Doc> docs = getArrayDocs();
		for (int i = 0; i < docs.size(); i++) {
			if (docs.get(i).getId() == d.getId()) {
				docs.set(i, d);
				salvar(docs);
				System.out.println("alterado com sucesso");
				break;
			}
		}
	}

	public static void salvar(ArrayList<Doc> listaDoc) {
		ArrayList<String> listaString = new ArrayList<String>();
		for (Doc doc : listaDoc) {
			listaString.add(doc.getLinha());
		}
		diretorio.delete();
		try {
			BufferedWriter writer = new BufferedWriter(new FileWriter(diretorio, true));
			for (String linha : listaString) {
				writer.write(linha + "\n");
			}
			writer.flush();
			writer.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static ArrayList<String> getListaString(ArrayList<Doc> docs) {
		ArrayList<String> listaString = new ArrayList<String>();
		for (Doc doc : docs) {
			listaString.add(doc.getLinha());
		}
		return listaString;

	}

}
