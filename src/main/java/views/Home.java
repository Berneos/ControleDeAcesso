/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package views;
import controllers.UserController;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import models.Usuario;
import views.CadastroUser;
import views.Login;
/**
 *
 * @author ADMIN
 */
public class Home extends javax.swing.JFrame {

    /**
     * Creates new form Home
     */
    
   
    public Home() {
    
        initComponents();
        
        // Lê o nome do usuário a partir do arquivo de texto
        try (BufferedReader reader = new BufferedReader(new FileReader("usuarioLogado.txt"))) {
            String nomeUsuario = reader.readLine();
            // Exibe o nome do usuário na tela Home
            lblUsuarioLogado.setText("Bem-vindo, " + nomeUsuario + "!");
        } catch (IOException e) {
            e.printStackTrace();
        }
        
        menuPerfil.setVisible(false);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel3 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        btnHome1 = new javax.swing.JButton();
        jPanel4 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        catracaImg = new javax.swing.JLabel();
        btnHome = new javax.swing.JButton();
        btnCadastroUsers = new javax.swing.JButton();
        btnCadastroAcessos = new javax.swing.JButton();
        btnCadastroPessoas = new javax.swing.JButton();
        btnGerenciarPessoas = new javax.swing.JButton();
        btnGerenciarAcessos = new javax.swing.JButton();
        btnGerenciarAcessos1 = new javax.swing.JButton();
        menuPerfil = new javax.swing.JPanel();
        lblUsuarioLogado = new javax.swing.JLabel();
        sair = new javax.swing.JButton();
        painelHome = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel3.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel2.setBackground(new java.awt.Color(255, 0, 51));
        jPanel2.setForeground(new java.awt.Color(255, 255, 255));
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        btnHome1.setBackground(new java.awt.Color(255, 51, 51));
        btnHome1.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        btnHome1.setForeground(new java.awt.Color(255, 255, 255));
        btnHome1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/user.png"))); // NOI18N
        btnHome1.setHorizontalAlignment(javax.swing.SwingConstants.LEADING);
        btnHome1.setIconTextGap(20);
        btnHome1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnHome1ActionPerformed(evt);
            }
        });
        jPanel2.add(btnHome1, new org.netbeans.lib.awtextra.AbsoluteConstraints(440, 10, -1, 49));

        jPanel3.add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 0, 540, 60));

        jPanel4.setBackground(new java.awt.Color(255, 0, 51));
        jPanel4.setForeground(new java.awt.Color(255, 255, 255));

        jLabel1.setFont(new java.awt.Font("Tw Cen MT Condensed Extra Bold", 1, 24)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Tela Inicial");

        catracaImg.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/computer.png"))); // NOI18N

        btnHome.setBackground(new java.awt.Color(255, 51, 51));
        btnHome.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        btnHome.setForeground(new java.awt.Color(255, 255, 255));
        btnHome.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/home.png"))); // NOI18N
        btnHome.setText("Home");
        btnHome.setHorizontalAlignment(javax.swing.SwingConstants.LEADING);
        btnHome.setIconTextGap(20);
        btnHome.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnHomeActionPerformed(evt);
            }
        });

        btnCadastroUsers.setBackground(new java.awt.Color(255, 51, 51));
        btnCadastroUsers.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btnCadastroUsers.setForeground(new java.awt.Color(255, 255, 255));
        btnCadastroUsers.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/user.png"))); // NOI18N
        btnCadastroUsers.setText("Cadastro de Usuários");
        btnCadastroUsers.setHorizontalAlignment(javax.swing.SwingConstants.LEADING);
        btnCadastroUsers.setIconTextGap(20);
        btnCadastroUsers.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCadastroUsersActionPerformed(evt);
            }
        });

        btnCadastroAcessos.setBackground(new java.awt.Color(255, 51, 51));
        btnCadastroAcessos.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btnCadastroAcessos.setForeground(new java.awt.Color(255, 255, 255));
        btnCadastroAcessos.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/catracaico.png"))); // NOI18N
        btnCadastroAcessos.setText("Cadastro de Acessos");
        btnCadastroAcessos.setHorizontalAlignment(javax.swing.SwingConstants.LEADING);
        btnCadastroAcessos.setIconTextGap(20);

        btnCadastroPessoas.setBackground(new java.awt.Color(255, 51, 51));
        btnCadastroPessoas.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btnCadastroPessoas.setForeground(new java.awt.Color(255, 255, 255));
        btnCadastroPessoas.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/pessoa.png"))); // NOI18N
        btnCadastroPessoas.setText("Cadastro de Pessoas");
        btnCadastroPessoas.setHorizontalAlignment(javax.swing.SwingConstants.LEADING);
        btnCadastroPessoas.setIconTextGap(20);

        btnGerenciarPessoas.setBackground(new java.awt.Color(255, 51, 51));
        btnGerenciarPessoas.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btnGerenciarPessoas.setForeground(new java.awt.Color(255, 255, 255));
        btnGerenciarPessoas.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/user.png"))); // NOI18N
        btnGerenciarPessoas.setText("Gerenciar Usuários");
        btnGerenciarPessoas.setHorizontalAlignment(javax.swing.SwingConstants.LEADING);
        btnGerenciarPessoas.setIconTextGap(20);

        btnGerenciarAcessos.setBackground(new java.awt.Color(255, 51, 51));
        btnGerenciarAcessos.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btnGerenciarAcessos.setForeground(new java.awt.Color(255, 255, 255));
        btnGerenciarAcessos.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/catracaico.png"))); // NOI18N
        btnGerenciarAcessos.setText("Gerenciar Acessos");
        btnGerenciarAcessos.setHorizontalAlignment(javax.swing.SwingConstants.LEADING);
        btnGerenciarAcessos.setIconTextGap(20);

        btnGerenciarAcessos1.setBackground(new java.awt.Color(255, 51, 51));
        btnGerenciarAcessos1.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btnGerenciarAcessos1.setForeground(new java.awt.Color(255, 255, 255));
        btnGerenciarAcessos1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/pessoa.png"))); // NOI18N
        btnGerenciarAcessos1.setText("Gerenciar Pessoas");
        btnGerenciarAcessos1.setHorizontalAlignment(javax.swing.SwingConstants.LEADING);
        btnGerenciarAcessos1.setIconTextGap(20);

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                .addGap(12, 12, 12)
                .addComponent(catracaImg, javax.swing.GroupLayout.PREFERRED_SIZE, 58, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel1)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addComponent(btnHome, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(btnCadastroUsers, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(btnCadastroAcessos, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(btnCadastroPessoas, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(btnGerenciarPessoas, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(btnGerenciarAcessos, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(btnGerenciarAcessos1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(catracaImg, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGap(15, 15, 15)
                        .addComponent(jLabel1)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnHome, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnCadastroUsers, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnCadastroAcessos, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnCadastroPessoas, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnGerenciarPessoas, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnGerenciarAcessos, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnGerenciarAcessos1, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel3.add(jPanel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 250, 450));

        menuPerfil.setBackground(new java.awt.Color(255, 51, 51));

        lblUsuarioLogado.setBackground(new java.awt.Color(255, 51, 51));
        lblUsuarioLogado.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        lblUsuarioLogado.setForeground(new java.awt.Color(255, 255, 255));

        sair.setBackground(new java.awt.Color(255, 0, 51));
        sair.setForeground(new java.awt.Color(255, 255, 255));
        sair.setText("Sair");
        sair.setBorder(null);
        sair.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                sairActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout menuPerfilLayout = new javax.swing.GroupLayout(menuPerfil);
        menuPerfil.setLayout(menuPerfilLayout);
        menuPerfilLayout.setHorizontalGroup(
            menuPerfilLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(menuPerfilLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(menuPerfilLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblUsuarioLogado, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(menuPerfilLayout.createSequentialGroup()
                        .addComponent(sair, javax.swing.GroupLayout.PREFERRED_SIZE, 79, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 109, Short.MAX_VALUE)))
                .addContainerGap())
        );
        menuPerfilLayout.setVerticalGroup(
            menuPerfilLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(menuPerfilLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblUsuarioLogado, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(sair, javax.swing.GroupLayout.DEFAULT_SIZE, 21, Short.MAX_VALUE)
                .addContainerGap())
        );

        jPanel3.add(menuPerfil, new org.netbeans.lib.awtextra.AbsoluteConstraints(570, 60, -1, -1));

        painelHome.setBackground(new java.awt.Color(255, 255, 255));
        painelHome.setForeground(new java.awt.Color(0, 0, 0));
        painelHome.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/homered.png"))); // NOI18N
        painelHome.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 60, 540, 320));

        jLabel3.setFont(new java.awt.Font("Segoe UI", 1, 36)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 0, 51));
        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel3.setText("HOME");
        painelHome.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 320, 540, 90));

        jPanel3.add(painelHome, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 0, 540, 450));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, 450, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void sairActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_sairActionPerformed
        Login login = new Login();
        login.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_sairActionPerformed

    private void btnHome1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnHome1ActionPerformed
        if(!menuPerfil.isVisible()) 
        {
        
            menuPerfil.setVisible(true);
            
            
        }
        else if(menuPerfil.isVisible())
        {
        
            menuPerfil.setVisible(false);
            
        }
    }//GEN-LAST:event_btnHome1ActionPerformed
 public Home(Usuario model) {
}
       
 
    private void btnCadastroUsersActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCadastroUsersActionPerformed
            CadastroUser TelaCaUser = new CadastroUser();
            TelaCaUser.setVisible(true);
            this.dispose();
    }//GEN-LAST:event_btnCadastroUsersActionPerformed

    private void btnHomeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnHomeActionPerformed
       
    }//GEN-LAST:event_btnHomeActionPerformed

    /**
     * @param args the command line arguments
     */
   public static void main(String args[]) {
    // Configuração do Look and Feel
    try {
        for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
            if ("Nimbus".equals(info.getName())) {
                javax.swing.UIManager.setLookAndFeel(info.getClassName());
                break;
            }
        }
    }catch (ClassNotFoundException | InstantiationException | IllegalAccessException | javax.swing.UnsupportedLookAndFeelException ex) {
        java.util.logging.Logger.getLogger(Home.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

    // Criação da View e do Model
    Home view = new Home();
    Usuario model = new Usuario();

    // Exibe a View
    view.setVisible(true);
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCadastroAcessos;
    private javax.swing.JButton btnCadastroPessoas;
    private javax.swing.JButton btnCadastroUsers;
    private javax.swing.JButton btnGerenciarAcessos;
    private javax.swing.JButton btnGerenciarAcessos1;
    private javax.swing.JButton btnGerenciarPessoas;
    private javax.swing.JButton btnHome;
    private javax.swing.JButton btnHome1;
    private javax.swing.JLabel catracaImg;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JLabel lblUsuarioLogado;
    private javax.swing.JPanel menuPerfil;
    private javax.swing.JPanel painelHome;
    private javax.swing.JButton sair;
    // End of variables declaration//GEN-END:variables
}