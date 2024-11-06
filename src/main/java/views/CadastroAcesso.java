/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package views;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;
import javax.swing.*;
import models.Acesso;
import repository.AcessoDAO;
import repository.PessoaDAO;
import java.time.*;


/**
 *
 * @author Daniel
 */
public class CadastroAcesso extends javax.swing.JFrame {
    private PessoaDAO pessoaDAO;
        private AcessoDAO acessoDAO;

    public CadastroAcesso() {
        this.pessoaDAO = new PessoaDAO(); 
        this.acessoDAO = new AcessoDAO(); 
        initComponents();
        preencherComboBoxPessoas(); 
        definirDataAtual();
    }
    
    private void definirDataAtual() {
    DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
    LocalDateTime dataAcesso = LocalDateTime.now(); // Obtém a data e hora atuais
    String dataFormatada = dateFormat.format(Date.from(dataAcesso.atZone(ZoneId.systemDefault()).toInstant()));
    DateTxt.setText(dataFormatada);
    }
    
     private void preencherComboBoxPessoas() {
        PessoaDAO pessoaDAO = new PessoaDAO();
        List<String> nomesPessoas = pessoaDAO.buscarTodosNomes(); // Busca os nomes

        DefaultComboBoxModel<String> model = new DefaultComboBoxModel<>();
        for (String nome : nomesPessoas) {
            model.addElement(nome); // Adiciona os nomes ao modelo
        }

        PessoaCB.setModel(model); // Define o modelo no JComboBox
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        PessoaCB = new javax.swing.JComboBox<>();
        PessoaLabel = new javax.swing.JLabel();
        DateLabel = new javax.swing.JLabel();
        DateTxt = new javax.swing.JTextField();
        Inputtbutton = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        HomeButton = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setForeground(new java.awt.Color(255, 255, 255));

        PessoaCB.setBackground(new java.awt.Color(255, 0, 51));
        PessoaCB.setForeground(new java.awt.Color(255, 255, 255));
        PessoaCB.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        PessoaCB.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                PessoaCBActionPerformed(evt);
            }
        });

        PessoaLabel.setForeground(new java.awt.Color(0, 0, 0));
        PessoaLabel.setText("Pessoa:");

        DateLabel.setForeground(new java.awt.Color(0, 0, 0));
        DateLabel.setText("Data e hora:");

        DateTxt.setEditable(false);
        DateTxt.setBackground(new java.awt.Color(255, 0, 51));
        DateTxt.setForeground(new java.awt.Color(255, 255, 255));
        DateTxt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                DateTxtActionPerformed(evt);
            }
        });

        Inputtbutton.setBackground(new java.awt.Color(255, 0, 51));
        Inputtbutton.setForeground(new java.awt.Color(255, 255, 255));
        Inputtbutton.setText("Cadastrar");
        Inputtbutton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                InputtbuttonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(26, 26, 26)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(PessoaLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 96, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(PessoaCB, javax.swing.GroupLayout.PREFERRED_SIZE, 132, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(121, 121, 121)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(DateLabel)
                    .addComponent(DateTxt)
                    .addComponent(Inputtbutton, javax.swing.GroupLayout.DEFAULT_SIZE, 100, Short.MAX_VALUE))
                .addContainerGap(116, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(26, 26, 26)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(PessoaLabel)
                    .addComponent(DateLabel))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(PessoaCB, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(DateTxt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 151, Short.MAX_VALUE)
                .addComponent(Inputtbutton, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(83, 83, 83))
        );

        jPanel2.setBackground(new java.awt.Color(255, 0, 51));

        HomeButton.setBackground(new java.awt.Color(255, 0, 51));
        HomeButton.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        HomeButton.setForeground(new java.awt.Color(255, 255, 255));
        HomeButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/home.png"))); // NOI18N
        HomeButton.setText("Home");
        HomeButton.setBorder(null);
        HomeButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                HomeButtonActionPerformed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Cadastro de acesso");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 202, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(HomeButton, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(HomeButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(8, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void HomeButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_HomeButtonActionPerformed
        Home home = new Home();
        home.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_HomeButtonActionPerformed

    private void PessoaCBActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_PessoaCBActionPerformed
          
    }//GEN-LAST:event_PessoaCBActionPerformed

    private void InputtbuttonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_InputtbuttonActionPerformed
    // Captura o nome selecionado no JComboBox
    String nomeSelecionado = (String) PessoaCB.getSelectedItem();
    
    // Busca o ID da pessoa correspondente ao nome selecionado
    Integer idPessoa = pessoaDAO.buscarIdPorNome(nomeSelecionado); // Chama o método que você implementou
    
    String dataAcessoStr = DateTxt.getText(); // Certifique-se de que a data esteja no formato adequado
    Date dataAcesso;
    try {
        dataAcesso = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss").parse(dataAcessoStr); // Formato de data

        // Cria um novo objeto Acesso
        Acesso acesso = new Acesso();
        acesso.setId(idPessoa);

         // Salva o acesso no banco de dados
        if (acessoDAO.salvarAcesso(acesso)) {
            JOptionPane.showMessageDialog(this, "Acesso cadastrado com sucesso!");
        } else {
            JOptionPane.showMessageDialog(this, "Erro ao cadastrar acesso.");
        }
    } catch (ParseException e) {
        JOptionPane.showMessageDialog(this, "Data inválida. Por favor, use o formato dd/MM/yyyy HH:mm:ss.");
        e.printStackTrace();
    }
    }//GEN-LAST:event_InputtbuttonActionPerformed

    private void DateTxtActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_DateTxtActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_DateTxtActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        
        //</editor-fold>

        /* Create and display the form */
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel DateLabel;
    private javax.swing.JTextField DateTxt;
    private javax.swing.JButton HomeButton;
    private javax.swing.JButton Inputtbutton;
    private javax.swing.JComboBox<String> PessoaCB;
    private javax.swing.JLabel PessoaLabel;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    // End of variables declaration//GEN-END:variables
}
