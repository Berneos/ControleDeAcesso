/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package views;

import controllers.UserController;
import javax.swing.JOptionPane;
import models.Usuario;
import views.Home;

/**
 *
 * @author Daniel
 */
public class CadastroUser extends javax.swing.JFrame {
    private UserController userController; // Declarar a variável do controlador

    public CadastroUser() {
        initComponents();

        // Cria uma nova instância do modelo Usuario
        Usuario model = new Usuario();
        
        // Inicializa o controlador
        userController = new UserController(this, model); // Este construtor deve existir em UserController
        
        
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jPanel3 = new javax.swing.JPanel();
        NomeLabel = new javax.swing.JLabel();
        SenhaLabel = new javax.swing.JLabel();
        UsuarioLabel = new javax.swing.JLabel();
        NomeTxt = new javax.swing.JTextField();
        SenhaTxt = new javax.swing.JTextField();
        UsuarioTxt = new javax.swing.JTextField();
        DropButton = new javax.swing.JButton();
        InputButton = new javax.swing.JButton();
        ÉadmBox = new javax.swing.JCheckBox();
        jPanel2 = new javax.swing.JPanel();
        HomeButton = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 380, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 288, Short.MAX_VALUE)
        );

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel3.setBackground(new java.awt.Color(255, 255, 255));
        jPanel3.setPreferredSize(new java.awt.Dimension(0, 282));
        jPanel3.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        NomeLabel.setForeground(new java.awt.Color(0, 0, 0));
        NomeLabel.setText("Nome:");
        jPanel3.add(NomeLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, -1, -1));

        SenhaLabel.setForeground(new java.awt.Color(0, 0, 0));
        SenhaLabel.setText("Senha:");
        jPanel3.add(SenhaLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 70, -1, -1));

        UsuarioLabel.setForeground(new java.awt.Color(0, 0, 0));
        UsuarioLabel.setText("Usuario:");
        jPanel3.add(UsuarioLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 130, -1, -1));

        NomeTxt.setBackground(new java.awt.Color(255, 0, 51));
        NomeTxt.setForeground(new java.awt.Color(255, 255, 255));
        jPanel3.add(NomeTxt, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 30, 220, -1));

        SenhaTxt.setBackground(new java.awt.Color(255, 0, 51));
        SenhaTxt.setForeground(new java.awt.Color(255, 255, 255));
        jPanel3.add(SenhaTxt, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 90, 220, -1));

        UsuarioTxt.setBackground(new java.awt.Color(255, 0, 51));
        UsuarioTxt.setForeground(new java.awt.Color(255, 255, 255));
        jPanel3.add(UsuarioTxt, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 150, 220, -1));

        DropButton.setBackground(new java.awt.Color(255, 0, 51));
        DropButton.setForeground(new java.awt.Color(255, 255, 255));
        DropButton.setText("Limpar");
        DropButton.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        DropButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                DropButtonActionPerformed(evt);
            }
        });
        jPanel3.add(DropButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 250, 90, 40));

        InputButton.setBackground(new java.awt.Color(255, 0, 51));
        InputButton.setForeground(new java.awt.Color(255, 255, 255));
        InputButton.setText("Cadastrar");
        InputButton.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        InputButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                InputButtonActionPerformed(evt);
            }
        });
        jPanel3.add(InputButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 250, 90, 40));

        ÉadmBox.setBackground(new java.awt.Color(255, 255, 255));
        ÉadmBox.setForeground(new java.awt.Color(0, 0, 0));
        ÉadmBox.setText("É admin?");
        jPanel3.add(ÉadmBox, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 200, -1, -1));

        jPanel2.setBackground(new java.awt.Color(255, 0, 51));
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

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
        jPanel2.add(HomeButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(375, 3, 120, 50));

        jLabel1.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Cadastro de Usuarios");
        jPanel2.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 220, 60));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, 500, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, 325, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void HomeButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_HomeButtonActionPerformed
            Home home = new Home();
            home.setVisible(true);
            this.dispose();
    }//GEN-LAST:event_HomeButtonActionPerformed

    private void InputButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_InputButtonActionPerformed
    String nome = NomeTxt.getText();
    String usuario = UsuarioTxt.getText();
    String senha = SenhaTxt.getText();
    boolean isAdmin = ÉadmBox.isSelected();

    // Verifica se os campos estão preenchidos
    if (nome.isEmpty() || usuario.isEmpty() || senha.isEmpty()) {
        JOptionPane.showMessageDialog(this, "Por favor, preencha todos os campos.", "Erro", JOptionPane.ERROR_MESSAGE);
        return;
    }

    // Cria uma nova instância do modelo Usuario
    Usuario usuarioModel = new Usuario();
    usuarioModel.setNome(nome);
    usuarioModel.setUsuario(usuario);
    usuarioModel.setSenha(senha);
    usuarioModel.setAdmin(isAdmin);

    // Chama o método do UserController para salvar o usuário
    userController.saveUser(usuarioModel);  // Certifique-se de que userController foi inicializado corretamente.
    
    // Limpa os campos após o cadastro
    NomeTxt.setText("");
    UsuarioTxt.setText("");
    SenhaTxt.setText("");
    ÉadmBox.setSelected(false);

    // Exibe uma mensagem de sucesso
    JOptionPane.showMessageDialog(this, "Usuário cadastrado com sucesso!", "Sucesso", JOptionPane.INFORMATION_MESSAGE);
    }//GEN-LAST:event_InputButtonActionPerformed

    private void DropButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_DropButtonActionPerformed
    NomeTxt.setText("");        // Substitua "NomeTxt" pelo nome correto do seu campo de texto para nome
    SenhaTxt.setText("");       // Substitua "SenhaTxt" pelo nome correto do seu campo de texto para senha
    UsuarioTxt.setText("");     // Substitua "UsuarioTxt" pelo nome correto do seu campo de texto para usuário
    
    // Desmarca o checkbox "É admin"
    ÉadmBox.setSelected(false);    // Substitua "Éadm" pelo nome correto do seu checkbox
    }//GEN-LAST:event_DropButtonActionPerformed

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
            java.util.logging.Logger.getLogger(CadastroUser.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(CadastroUser.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(CadastroUser.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(CadastroUser.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                new CadastroUser().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton DropButton;
    private javax.swing.JButton HomeButton;
    private javax.swing.JButton InputButton;
    private javax.swing.JLabel NomeLabel;
    private javax.swing.JTextField NomeTxt;
    private javax.swing.JLabel SenhaLabel;
    private javax.swing.JTextField SenhaTxt;
    private javax.swing.JLabel UsuarioLabel;
    private javax.swing.JTextField UsuarioTxt;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JCheckBox ÉadmBox;
    // End of variables declaration//GEN-END:variables
}