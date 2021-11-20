package View;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.util.ArrayList;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.LayoutStyle.ComponentPlacement;

import Control.DocControler;
import Control.HeapSort;
import Control.MergeSort;
import Control.RelatorioController;
import Helpers.SaveDoc;
import model.Doc;

public class Principal extends JFrame {

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Principal window = new Principal();
					window.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public Principal() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		this.setBounds(100, 100, 450, 300);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JButton Btn_Tabela = new JButton("Tabela");
		Btn_Tabela.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				TabelaDados tab = new TabelaDados();
				tab.setVisible(true);
				dispose();
			}
		});
		
		JButton BtnRelatorio = new JButton("Relatorio");
		BtnRelatorio.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Relatorio relatorio = new Relatorio();
				relatorio.setVisible(true);
				dispose();
			}
			
		});
		
		JButton btnHeap = new JButton("HeapSort");
		btnHeap.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		ArrayList<Doc> docs = DocControler.getEntrada();
        		HeapSort heap = new HeapSort(docs);
        		heap.heapSort();
        		File diretorio = new File("HeapSort.txt");
        		SaveDoc.saveDoc(diretorio, heap.getLista());
        		JOptionPane.showMessageDialog(null, "HeapSort.txt Salvo com sucesso!");
        	}
        });
		JButton btnMerge = new JButton("MergeSort");
		btnMerge.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		ArrayList<Doc> docs = DocControler.getEntrada();
        		MergeSort merge = new MergeSort();
        		merge.mergeSort(docs);
        		File diretorio = new File("MergeSort.txt");
        		SaveDoc.saveDoc(diretorio, docs);
        		JOptionPane.showMessageDialog(null, "MergeSort.txt Salvo com sucesso!");
        	}
        });;
		GroupLayout groupLayout = new GroupLayout(getContentPane());
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.TRAILING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(153)
					.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING)
						.addComponent(btnMerge, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 109, Short.MAX_VALUE)
						.addComponent(btnHeap, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 109, Short.MAX_VALUE)
						.addComponent(BtnRelatorio, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 109, Short.MAX_VALUE)
						.addComponent(Btn_Tabela, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 109, Short.MAX_VALUE))
					.addGap(172))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(47)
					.addComponent(Btn_Tabela, GroupLayout.PREFERRED_SIZE, 39, GroupLayout.PREFERRED_SIZE)
					.addGap(18)
					.addComponent(BtnRelatorio, GroupLayout.PREFERRED_SIZE, 35, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addComponent(btnHeap, GroupLayout.PREFERRED_SIZE, 38, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(btnMerge, GroupLayout.DEFAULT_SIZE, 37, Short.MAX_VALUE)
					.addGap(30))
		);
		getContentPane().setLayout(groupLayout);
	}
}
