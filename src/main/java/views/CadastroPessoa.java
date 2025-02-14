/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package views;

import controllers.PessoaController;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import models.CPFValidator;
import repository.PessoaDAO;

/**
 *
 * @author Daniel
 */
public class CadastroPessoa extends javax.swing.JFrame {

    /**
     * Creates new form CadastroPessoa
     */
    public CadastroPessoa() {
        initComponents();
        
         // Adiciona o KeyListener para formatar o CPF dinamicamente e limitar a 11 dígitos
        CpfTxt.addKeyListener(new KeyAdapter() {
            @Override
        public void keyReleased(KeyEvent e) {
            String input = CpfTxt.getText();
            
            // Remove caracteres não numéricos
            input = input.replaceAll("[^\\d]", "");
            
            // Limita o input a 11 caracteres
            if (input.length() > 11) {
                input = input.substring(0, 11);
            }
            
            // Aplica a formatação ao CPF
            if (!input.isEmpty()) {
                input = CPFValidator.format(input);
            }
            
            // Define o texto formatado no campo
            CpfTxt.setText(input);
            
            // Coloca o cursor no final do texto
            CpfTxt.setCaretPosition(input.length());
        }
    });
         // Listener para formatar o telefone
        TelTxt.addKeyListener(new KeyAdapter() {
            @Override
        public void keyReleased(KeyEvent e) {
            String input = TelTxt.getText();
            input = input.replaceAll("[^\\d]", ""); // Remove caracteres não numéricos

            // Limita o input a 11 caracteres
            if (input.length() > 11) {
                input = input.substring(0, 11);
            }

            // Aplica a formatação ao telefone
            if (input.length() > 2) {
                input = input.replaceFirst("(\\d{2})(\\d)", "($1) $2");
            }
            if (input.length() > 7) {
                input = input.replaceFirst("(\\(\\d{2}\\) \\d{4})(\\d)", "$1-$2");
            }

            // Define o texto formatado no campo
            TelTxt.setText(input);
            TelTxt.setCaretPosition(input.length());
        }
    });
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
        jButton3 = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        NomeLabel = new javax.swing.JLabel();
        CpfLabel = new javax.swing.JLabel();
        telLabel = new javax.swing.JLabel();
        NomeTxt = new javax.swing.JTextField();
        CpfTxt = new javax.swing.JTextField();
        TelTxt = new javax.swing.JTextField();
        InputButton = new javax.swing.JButton();
        DropButton = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setPreferredSize(new java.awt.Dimension(500, 380));
        setResizable(false);

        jPanel1.setBackground(new java.awt.Color(255, 0, 51));
        jPanel1.setMinimumSize(new java.awt.Dimension(495, 60));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jButton3.setBackground(new java.awt.Color(255, 0, 51));
        jButton3.setForeground(new java.awt.Color(255, 255, 255));
        jButton3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/home.png"))); // NOI18N
        jButton3.setText("Home");
        jButton3.setBorder(null);
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton3, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 0, 130, 50));

        jLabel4.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("Cadastro de Pessoa");
        jPanel1.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 200, 50));

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));
        jPanel2.setForeground(new java.awt.Color(255, 255, 255));
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        NomeLabel.setText("Nome:");
        jPanel2.add(NomeLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 20, -1, -1));

        CpfLabel.setText("CPF:");
        jPanel2.add(CpfLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 70, -1, -1));

        telLabel.setText("Telefone:");
        jPanel2.add(telLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 120, -1, -1));

        NomeTxt.setBackground(new java.awt.Color(255, 0, 51));
        NomeTxt.setForeground(new java.awt.Color(255, 255, 255));
        jPanel2.add(NomeTxt, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 40, 200, -1));

        CpfTxt.setBackground(new java.awt.Color(255, 0, 51));
        CpfTxt.setForeground(new java.awt.Color(255, 255, 255));
        CpfTxt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CpfTxtActionPerformed(evt);
            }
        });
        jPanel2.add(CpfTxt, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 90, 200, -1));

        TelTxt.setBackground(new java.awt.Color(255, 0, 51));
        TelTxt.setForeground(new java.awt.Color(255, 255, 255));
        jPanel2.add(TelTxt, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 140, 200, -1));

        InputButton.setBackground(new java.awt.Color(255, 0, 51));
        InputButton.setForeground(new java.awt.Color(255, 255, 255));
        InputButton.setText("Cadastrar");
        InputButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                InputButtonActionPerformed(evt);
            }
        });
        jPanel2.add(InputButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 220, 100, 40));

        DropButton.setBackground(new java.awt.Color(255, 0, 51));
        DropButton.setForeground(new java.awt.Color(255, 255, 255));
        DropButton.setText("Limpar");
        DropButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                DropButtonActionPerformed(evt);
            }
        });
        jPanel2.add(DropButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 220, 100, 40));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 54, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, 326, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
            Home home = new Home();
            home.setVisible(true);
            this.dispose();
    }//GEN-LAST:event_jButton3ActionPerformed

    private void InputButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_InputButtonActionPerformed
        String nome = NomeTxt.getText();
        String cpf = CpfTxt.getText();
        String telefone = TelTxt.getText();

    // Validação do CPF
    if (!CPFValidator.isValid(cpf)) {
        JOptionPane.showMessageDialog(this, "CPF inválido. Por favor, digite um CPF válido.");
        return;
    }

    cpf = CPFValidator.format(cpf);

    // Conexão com o banco de dados
    try {
        Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/controle_acesso", "root", "Bkdeilt17");

        // Criação das instâncias DAO e Controller
        PessoaDAO pessoaDAO = new PessoaDAO();
        PessoaController pessoaController = new PessoaController(pessoaDAO);
        
        // Cadastro da pessoa
        boolean sucesso = pessoaController.cadastrarPessoa(nome, cpf, telefone);

        if (sucesso) {
            JOptionPane.showMessageDialog(this, "Pessoa cadastrada com sucesso!");
        } else {
            JOptionPane.showMessageDialog(this, "Erro ao cadastrar pessoa.");
        }

        connection.close();
    } catch (SQLException e) {
        e.printStackTrace();
        JOptionPane.showMessageDialog(this, "Erro de conexão com o banco de dados.");
    }
    }//GEN-LAST:event_InputButtonActionPerformed

    private void DropButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_DropButtonActionPerformed
        NomeTxt.setText("");
        CpfTxt.setText("");
        TelTxt.setText("");
    }//GEN-LAST:event_DropButtonActionPerformed

    private void CpfTxtActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CpfTxtActionPerformed
       
    }//GEN-LAST:event_CpfTxtActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(CadastroPessoa.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(CadastroPessoa.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(CadastroPessoa.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(CadastroPessoa.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                new CadastroPessoa().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel CpfLabel;
    private javax.swing.JTextField CpfTxt;
    private javax.swing.JButton DropButton;
    private javax.swing.JButton InputButton;
    private javax.swing.JLabel NomeLabel;
    private javax.swing.JTextField NomeTxt;
    private javax.swing.JTextField TelTxt;
    private javax.swing.JButton jButton3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JLabel telLabel;
    // End of variables declaration//GEN-END:variables
}
