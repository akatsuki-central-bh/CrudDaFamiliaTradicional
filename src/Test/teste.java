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
			Doc doc = new Doc(8000, 2055, "DocTeste", "AtoNormativo Teste", "EmentaTest", "Teste", "Teste");
			BufferedWriter writer = new BufferedWriter(new FileWriter(DocControler.diretorio, true));
			String linha = doc.getLinha();
			writer.append("\n" + linha);
			writer.close();
			JOptionPane.showMessageDialog(null, "Documento gravado com sucesso!");
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	public static void gerarId() { //NAO USEM ESSE METODO, SO SE NAO TIVER ID NO TXT DE VCS BLZ?
		try {              //GERA ID PARA TODAS AS LINHAS, POREM JA ATIVEI ELE UMA VEZ, SE ATIVAR DENOVO VAI DUPLICAR
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
		ArrayList<Doc> Docs = DocControler.getArrayDocs();
		for (Doc doc : Docs) {
			System.out.println(doc.toString());
		}
	}

	public static void main(String[] args) {
		//ESCREVE AQUI OS METODOS Q VC QUER TESTAR E EXECUTA A CLASSE, COMO FIZ ACIMA LISTANDO OS DOCUMENTOS.
		//SE QUISER CRIAR UM METODO DE TESTE FICA A VONTS. SÓ NAO ESQUECE DE DESFAZER A OPERAÇÃO DPS Q FOR FEITA
	}
}
