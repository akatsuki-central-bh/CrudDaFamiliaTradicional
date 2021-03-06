/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package View;

import Control.DocControler;
import model.Doc;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.GroupLayout.Alignment;
import javax.swing.LayoutStyle.ComponentPlacement;

/**
 *
 * @author cauaa7
 */
public class TelaEdicao extends javax.swing.JFrame {

	private int idDoc;

	/**
	 * Creates new form Nova_Tela
	 */

	public TelaEdicao() {
		initComponents();
	}

	public TelaEdicao(Doc d) {
		initComponents();
		this.idDoc = d.getId();
		tfAno.setText(String.valueOf(d.getAno()));
		tfDocumento.setText(d.getDocumento());
		tfAtoNormativo.setText(d.getAtoNormativo());
		txEmenta.setText(d.getEmenta());
		tfLink.setText(d.getLink());
		tfStatus.setText(d.getStatus());
	}

	private void alterarDoc(Doc novo){
		novo.setId(this.idDoc);
		DocControler.alterarDoc(novo);
	}
	/**
	 * This method is called from within the constructor to initialize the form.
	 * WARNING: Do NOT modify this code. The content of this method is always
	 * regenerated by the Form Editor.
	 */
	@SuppressWarnings("unchecked")
	// <editor-fold defaultstate="collapsed" desc="Generated
	// Code">//GEN-BEGIN:initComponents
	private void initComponents() {

		pnTopo = new javax.swing.JPanel();
		lbTopo = new javax.swing.JLabel();
		pnPrincipal = new javax.swing.JPanel();
		lbAno = new javax.swing.JLabel();
		lbDocumento = new javax.swing.JLabel();
		lbAtoNormativo = new javax.swing.JLabel();
		lbEmenta = new javax.swing.JLabel();
		lbLink = new javax.swing.JLabel();
		lbStatus = new javax.swing.JLabel();
		tfAtoNormativo = new javax.swing.JTextField();
		tfAno = new javax.swing.JTextField();
		tfDocumento = new javax.swing.JTextField();
		tfLink = new javax.swing.JTextField();
		tfStatus = new javax.swing.JTextField();
		jScrollPane1 = new javax.swing.JScrollPane();
		txEmenta = new javax.swing.JTextArea();
		pnBotoes = new javax.swing.JPanel();
		btnCriar = new javax.swing.JButton();
		btnCriar.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				try {
					int id = DocControler.getNextId();
					Doc newDoc = 	new Doc(id, Integer.parseInt(tfAno.getText()), tfDocumento.getText(), tfAtoNormativo.getText(), txEmenta.getText(), tfLink.getText(), tfStatus.getText());
					DocControler.escrever( newDoc );
				} catch (Exception error) {
					System.err.println(error.getMessage());
				}
			}
		});
		btnEditar = new javax.swing.JButton();
		btnEditar.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
					Doc docAlterado = new Doc(
					0,
					Integer.parseInt(tfAno.getText()),
					tfDocumento.getText(),
					tfAtoNormativo.getText(),
					txEmenta.getText(),
					tfLink.getText(),
					tfStatus.getText()
				);

				alterarDoc(docAlterado);

				new TabelaDados().setVisible(true);;
				dispose();


			}
		});
		btnAbrirTabela = new javax.swing.JButton();
		btnAbrirTabela.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				new TabelaDados().setVisible(true);
				dispose();
			}
		});

		addWindowListener(new java.awt.event.WindowAdapter() {
			public void windowClosing(java.awt.event.WindowEvent evt) {
				formWindowClosing(evt);
			}
		});
		
		
		lbTopo.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
		lbTopo.setText("APS CRUD");

		javax.swing.GroupLayout pnTopoLayout = new javax.swing.GroupLayout(pnTopo);
		pnTopo.setLayout(pnTopoLayout);
		pnTopoLayout.setHorizontalGroup(pnTopoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
				.addGroup(pnTopoLayout.createSequentialGroup().addGap(285, 285, 285).addComponent(lbTopo)
						.addContainerGap(301, Short.MAX_VALUE)));
		pnTopoLayout.setVerticalGroup(pnTopoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
				.addGroup(pnTopoLayout.createSequentialGroup().addGap(19, 19, 19).addComponent(lbTopo)
						.addContainerGap(28, Short.MAX_VALUE)));

		lbAno.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
		lbAno.setText("Ano:");

		lbDocumento.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
		lbDocumento.setText("Documento:");

		lbAtoNormativo.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
		lbAtoNormativo.setText("Ato Normativo:");

		lbEmenta.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
		lbEmenta.setText("Ementa:");

		lbLink.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
		lbLink.setText("Link:");

		lbStatus.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
		lbStatus.setText("Status:");

		tfAtoNormativo.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N

		tfAno.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N

		tfDocumento.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N

		tfLink.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
		tfLink.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				tfLinkActionPerformed(evt);
			}
		});

		tfStatus.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N

		txEmenta.setColumns(20);
		txEmenta.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
		txEmenta.setLineWrap(true);
		txEmenta.setRows(5);
		jScrollPane1.setViewportView(txEmenta);

		javax.swing.GroupLayout pnPrincipalLayout = new javax.swing.GroupLayout(pnPrincipal);
		pnPrincipal.setLayout(pnPrincipalLayout);
		pnPrincipalLayout.setHorizontalGroup(pnPrincipalLayout
				.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
				.addGroup(pnPrincipalLayout.createSequentialGroup().addGap(25, 25, 25)
						.addGroup(pnPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
								.addComponent(lbAtoNormativo).addComponent(lbAno).addComponent(lbDocumento)
								.addComponent(lbLink).addComponent(lbStatus).addComponent(lbEmenta))
						.addGap(18, 18, 18)
						.addGroup(pnPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
								.addComponent(jScrollPane1).addComponent(tfAno).addComponent(tfDocumento)
								.addComponent(tfAtoNormativo).addComponent(tfLink).addComponent(tfStatus))
						.addContainerGap()));
		pnPrincipalLayout.setVerticalGroup(pnPrincipalLayout
				.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
				.addGroup(pnPrincipalLayout.createSequentialGroup().addGap(26, 26, 26)
						.addGroup(pnPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
								.addComponent(lbAno).addComponent(tfAno, javax.swing.GroupLayout.PREFERRED_SIZE,
										javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
						.addGap(18, 18, 18)
						.addGroup(pnPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
								.addComponent(lbDocumento)
								.addComponent(tfDocumento, javax.swing.GroupLayout.PREFERRED_SIZE,
										javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
						.addGap(18, 18, 18)
						.addGroup(pnPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
								.addComponent(lbAtoNormativo)
								.addComponent(tfAtoNormativo, javax.swing.GroupLayout.PREFERRED_SIZE,
										javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
						.addGap(18, 18, 18)
						.addGroup(pnPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
								.addGroup(pnPrincipalLayout.createSequentialGroup().addComponent(lbEmenta).addGap(0, 0,
										Short.MAX_VALUE))
								.addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 137, Short.MAX_VALUE))
						.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
						.addGroup(pnPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
								.addComponent(lbLink).addComponent(tfLink, javax.swing.GroupLayout.PREFERRED_SIZE,
										javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
						.addGap(18, 18, 18)
						.addGroup(pnPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
								.addComponent(tfStatus, javax.swing.GroupLayout.PREFERRED_SIZE,
										javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
								.addComponent(lbStatus))
						.addGap(38, 38, 38)));

		btnCriar.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
		btnCriar.setText("Criar");
		btnCriar.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				btnCriarActionPerformed(evt);
			}
		});

		btnEditar.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
		btnEditar.setText("Editar");
		btnEditar.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				btnEditarActionPerformed(evt);
			}
		});

		btnAbrirTabela.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
		btnAbrirTabela.setText("Tabela");

		javax.swing.GroupLayout pnBotoesLayout = new javax.swing.GroupLayout(pnBotoes);
		pnBotoesLayout.setHorizontalGroup(
			pnBotoesLayout.createParallelGroup(Alignment.TRAILING)
				.addGroup(pnBotoesLayout.createSequentialGroup()
					.addContainerGap()
					.addComponent(btnAbrirTabela)
					.addPreferredGap(ComponentPlacement.RELATED, 434, Short.MAX_VALUE)
					.addComponent(btnEditar)
					.addGap(18)
					.addComponent(btnCriar)
					.addGap(20))
		);
		pnBotoesLayout.setVerticalGroup(
			pnBotoesLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(pnBotoesLayout.createSequentialGroup()
					.addGap(15)
					.addGroup(pnBotoesLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(btnCriar)
						.addComponent(btnEditar)
						.addComponent(btnAbrirTabela))
					.addContainerGap(15, Short.MAX_VALUE))
		);
		pnBotoes.setLayout(pnBotoesLayout);

		javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
		getContentPane().setLayout(layout);
		layout.setHorizontalGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
				.addGroup(layout.createSequentialGroup().addContainerGap()
						.addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
								.addComponent(pnPrincipal, javax.swing.GroupLayout.Alignment.TRAILING,
										javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE,
										Short.MAX_VALUE)
								.addComponent(pnTopo, javax.swing.GroupLayout.Alignment.TRAILING,
										javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE,
										Short.MAX_VALUE)
								.addComponent(pnBotoes, javax.swing.GroupLayout.DEFAULT_SIZE,
										javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
						.addContainerGap()));
		layout.setVerticalGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
				.addGroup(layout.createSequentialGroup().addContainerGap()
						.addComponent(pnTopo, javax.swing.GroupLayout.PREFERRED_SIZE,
								javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
						.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
						.addComponent(pnPrincipal, javax.swing.GroupLayout.DEFAULT_SIZE,
								javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
						.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
						.addComponent(pnBotoes, javax.swing.GroupLayout.PREFERRED_SIZE,
								javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
						.addContainerGap()));

		pack();
		setLocationRelativeTo(null);
	}// </editor-fold>//GEN-END:initComponents

	private void btnEditarActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_btnEditarActionPerformed
		
	}

	private void btnCriarActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_btnCriarActionPerformed
		try {
			Doc doc = new Doc(
				DocControler.getNextId(),
				Integer.parseInt(tfAno.getText()),
				tfDocumento.getText(),
				tfAtoNormativo.getText(), 
				txEmenta.getText(),
				tfLink.getText(),
				tfStatus.getText()
			);
			DocControler.escrever(doc);
			tfAno.setText("");
			tfDocumento.setText("");
			tfAtoNormativo.setText("");
			txEmenta.setText("");
			tfLink.setText("");
			tfStatus.setText("");
			tfAno.requestFocus();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}// GEN-LAST:event_btnCriarActionPerformed

	private void tfLinkActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_tfLinkActionPerformed
		// TODO add your handling code here:
	}// GEN-LAST:event_tfLinkActionPerformed

	private void formWindowClosing(java.awt.event.WindowEvent evt) {// GEN-FIRST:event_formWindowClosing
		dispose();
	}// GEN-LAST:event_formWindowClosing

	/**
	 * @param args the command line arguments
	 */
	public static void main(String args[]) {
		/* Set the Nimbus look and feel */
		// <editor-fold defaultstate="collapsed" desc=" Look and feel setting code
		// (optional) ">
		/*
		 * If Nimbus (introduced in Java SE 6) is not available, stay with the default
		 * look and feel. For details see
		 * http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html
		 */
		try {
			for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
				if ("Nimbus".equals(info.getName())) {
					javax.swing.UIManager.setLookAndFeel(info.getClassName());
					break;
				}
			}
		} catch (ClassNotFoundException ex) {
			java.util.logging.Logger.getLogger(TelaEdicao.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
		} catch (InstantiationException ex) {
			java.util.logging.Logger.getLogger(TelaEdicao.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
		} catch (IllegalAccessException ex) {
			java.util.logging.Logger.getLogger(TelaEdicao.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
		} catch (javax.swing.UnsupportedLookAndFeelException ex) {
			java.util.logging.Logger.getLogger(TelaEdicao.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
		}
		// </editor-fold>

		/* Create and display the form */
		java.awt.EventQueue.invokeLater(new Runnable() {
			public void run() {
				new TelaEdicao().setVisible(true);
			}
		});
	}

	// Variables declaration - do not modify//GEN-BEGIN:variables
	private javax.swing.JButton btnCriar;
	private javax.swing.JButton btnAbrirTabela;
	private javax.swing.JButton btnEditar;
	private javax.swing.JScrollPane jScrollPane1;
	private javax.swing.JLabel lbAno;
	private javax.swing.JLabel lbAtoNormativo;
	private javax.swing.JLabel lbDocumento;
	private javax.swing.JLabel lbEmenta;
	private javax.swing.JLabel lbLink;
	private javax.swing.JLabel lbStatus;
	private javax.swing.JLabel lbTopo;
	private javax.swing.JPanel pnBotoes;
	private javax.swing.JPanel pnPrincipal;
	private javax.swing.JPanel pnTopo;
	private javax.swing.JTextField tfAno;
	private javax.swing.JTextField tfAtoNormativo;
	private javax.swing.JTextField tfDocumento;
	private javax.swing.JTextField tfLink;
	private javax.swing.JTextField tfStatus;
	private javax.swing.JTextArea txEmenta;
	// End of variables declaration//GEN-END:variables
}
