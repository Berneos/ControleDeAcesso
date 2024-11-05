/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package views;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import models.Usuario;
import views.CadastroUser;
import views.Login;
import controllers.UsuarioDAO;
import javax.swing.*;
import javax.swing.table.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;
import java.util.ArrayList;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
/**
 *
 * @author ADMIN
 */
public class GerenciarUser extends javax.swing.JFrame {

    /**
     * Creates new form Home
     */
    
    
    private DefaultTableModel model;
    private ArrayList<JButton> editButtons = new ArrayList<>();
    
    public GerenciarUser() {
    
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
        setTitle("Gerenciar Usuários");
        

        setLayout(null); // Usaremos layout nulo para posicionar os botões manualmente

        // Configuração da tabela
        model = new DefaultTableModel(new Object[]{"ID", "Nome", "Usuário", "Adm"}, 0);
        userTable.setModel(model); // Associa o modelo `model` à `userTable`
        configurarRenderizadorNomeComReticenciasETooltip();
        carregarDados();



        // Adiciona os botões "Editar" ao lado da tabela
        adicionarBotoesEditar();

        setVisible(true);
    }

    private void carregarDados() {
        // Configura o Hibernate e abre uma sessão
        SessionFactory sessionFactory = new Configuration().configure("hibernate.cfg.xml").buildSessionFactory();
        Session session = sessionFactory.openSession();

        Transaction transaction = null;
        try {
            transaction = session.beginTransaction();

            // Consulta para obter todos os usuários (ajustado para retornar objetos Usuario)
            List<Usuario> usuarios = session.createQuery("FROM Usuario", Usuario.class).getResultList();

            // Adiciona cada usuário como uma linha na tabela
            for (Usuario usuario : usuarios) {
                int id = usuario.getId();
                String nome = usuario.getNome();
                String usuariio = usuario.getUsuariio();
                String admText = usuario.isAdmin() ? "Sim" : "Não"; // Converte booleano para texto

                // Adiciona a linha à tabela
                model.addRow(new Object[]{id, nome, usuariio, admText});
            }

            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
        } finally {
            session.close();
            sessionFactory.close();
        }
    }
   public void configurarRenderizadorNomeComReticenciasETooltip() {
        DefaultTableCellRenderer renderizador = new DefaultTableCellRenderer() {
            @Override
            public void setValue(Object value) {
                if (value instanceof String) {
                    String textoCompleto = (String) value;

                    // Define o limite de caracteres (ajuste conforme o tamanho da coluna)
                    int limiteCaracteres = 15; 
                    if (textoCompleto.length() > limiteCaracteres) {
                        textoCompleto = textoCompleto.substring(0, limiteCaracteres - 3) + "...";
                    }

                    super.setValue(textoCompleto);
                } else {
                    super.setValue(value);
                }
            }
        };

        // Aplica o renderizador na coluna "Nome"
        TableColumn colunaNome = userTable.getColumnModel().getColumn(1); // Coluna de índice 1 para "Nome"
        colunaNome.setCellRenderer(renderizador);

        // Adiciona o MouseMotionListener para exibir o tooltip
        userTable.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            @Override
            public void mouseMoved(java.awt.event.MouseEvent e) {
                int row = userTable.rowAtPoint(e.getPoint());
                int col = userTable.columnAtPoint(e.getPoint());

                if (col == 1) { // Coluna "Nome"
                    Object value = userTable.getValueAt(row, col);
                    if (value != null) {
                        userTable.setToolTipText(value.toString()); // Mostra o nome completo como tooltip
                    }
                } else {
                    userTable.setToolTipText(null); // Remove o tooltip quando fora da coluna "Nome"
                }
            }
        });
    }
    private void adicionarBotoesEditar() {
        
        // Limpa os botões anteriores, caso existam
        for (JButton button : editButtons) {
            menuCadastroUser.remove(button); // Remove do painel correto
        }
        editButtons.clear();

        // Tamanho do painel que contém a tabela e os botões
        int panelWidth = menuCadastroUser.getWidth();
        int buttonWidth = (int) (panelWidth * 0.20); // 20% da largura do painel
        int tableWidth = panelWidth - buttonWidth - 10; // Ajusta a largura da tabela para 80%

        // Configura o tamanho da tabela para ocupar 80% do painel
        userTable.setSize(tableWidth, userTable.getHeight());
        JScrollPane scrollPane = (JScrollPane) userTable.getParent().getParent();
        scrollPane.setBounds(10, 20, tableWidth, scrollPane.getHeight()); // Ajusta a largura do scrollPane e adiciona um padding menor à esquerda

        // Posição inicial dos botões
        int yPosition = userTable.getY();

        // Adiciona os botões "Editar" ao lado de cada linha da tabela
        for (int i = 0; i < model.getRowCount(); i++) {
            int userId = (int) model.getValueAt(i, 0); // ID do usuário
            JButton editButton = new JButton("Editar");

            // Define a posição e o tamanho do botão
            int rowHeight = userTable.getRowHeight();
            int buttonYPosition = yPosition + (i * rowHeight) + userTable.getTableHeader().getHeight();
            int buttonXPosition = tableWidth + 15; // Margem reduzida entre a tabela e os botões

            editButton.setBounds(buttonXPosition, buttonYPosition, buttonWidth - 5, rowHeight); // Define largura e altura do botão para coincidir com a linha da tabela

            // Adiciona ação ao botão
            editButton.addActionListener(new EditButtonListener(userId));
            editButtons.add(editButton); // Guarda o botão na lista para referência futura

            menuCadastroUser.add(editButton); // Adiciona o botão ao painel correto
        }

        // Atualiza o layout para exibir os botões corretamente
        menuCadastroUser.revalidate();
        menuCadastroUser.repaint();

    }
    
       
    private class EditButtonListener implements ActionListener {
        private int userId;

        public EditButtonListener(int userId) {
            this.userId = userId;
        }

        @Override
        public void actionPerformed(ActionEvent e) {
            // Salva o ID do usuário em um arquivo .txt
            try (BufferedWriter writer = new BufferedWriter(new FileWriter("userToEdit.txt"))) {
                writer.write(String.valueOf(userId));
            } catch (IOException ex) {
                ex.printStackTrace();
            }

            // Abre a janela de edição do usuário
            abrirEdicao(userId);
        }
    }

    private void abrirEdicao(int userId) {
        // Aqui você pode abrir um novo JFrame ou JDialog para edição do usuário
        JOptionPane.showMessageDialog(this, "Abrindo edição para o usuário com ID: " + userId);
        EdicaoUser edicao = new EdicaoUser(this);
        edicao.setVisible(true);
    }
    public void atualizarTabela() {
    // Limpa a tabela atual
    model.setRowCount(0);
    
    // Recarrega os dados dos usuários
    carregarDados();
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
        btnGerenciarUsuarios = new javax.swing.JButton();
        btnGerenciarAcessos = new javax.swing.JButton();
        btnGerenciarPessoas = new javax.swing.JButton();
        menuPerfil = new javax.swing.JPanel();
        lblUsuarioLogado = new javax.swing.JLabel();
        sair = new javax.swing.JButton();
        menuCadastroUser = new javax.swing.JPanel();
        jScrollPane6 = new javax.swing.JScrollPane();
        userTable = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setName("Home"); // NOI18N
        setResizable(false);

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

        btnGerenciarUsuarios.setBackground(new java.awt.Color(255, 51, 51));
        btnGerenciarUsuarios.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btnGerenciarUsuarios.setForeground(new java.awt.Color(255, 255, 255));
        btnGerenciarUsuarios.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/user.png"))); // NOI18N
        btnGerenciarUsuarios.setText("Gerenciar Usuários");
        btnGerenciarUsuarios.setHorizontalAlignment(javax.swing.SwingConstants.LEADING);
        btnGerenciarUsuarios.setIconTextGap(20);
        btnGerenciarUsuarios.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGerenciarUsuariosActionPerformed(evt);
            }
        });

        btnGerenciarAcessos.setBackground(new java.awt.Color(255, 51, 51));
        btnGerenciarAcessos.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btnGerenciarAcessos.setForeground(new java.awt.Color(255, 255, 255));
        btnGerenciarAcessos.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/catracaico.png"))); // NOI18N
        btnGerenciarAcessos.setText("Gerenciar Acessos");
        btnGerenciarAcessos.setHorizontalAlignment(javax.swing.SwingConstants.LEADING);
        btnGerenciarAcessos.setIconTextGap(20);
        btnGerenciarAcessos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGerenciarAcessosActionPerformed(evt);
            }
        });

        btnGerenciarPessoas.setBackground(new java.awt.Color(255, 51, 51));
        btnGerenciarPessoas.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btnGerenciarPessoas.setForeground(new java.awt.Color(255, 255, 255));
        btnGerenciarPessoas.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/pessoa.png"))); // NOI18N
        btnGerenciarPessoas.setText("Gerenciar Pessoas");
        btnGerenciarPessoas.setHorizontalAlignment(javax.swing.SwingConstants.LEADING);
        btnGerenciarPessoas.setIconTextGap(20);
        btnGerenciarPessoas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGerenciarPessoasActionPerformed(evt);
            }
        });

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
            .addComponent(btnGerenciarUsuarios, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(btnGerenciarAcessos, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(btnGerenciarPessoas, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
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
                .addComponent(btnGerenciarUsuarios, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnGerenciarAcessos, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnGerenciarPessoas, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE)
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

        menuCadastroUser.setBackground(new java.awt.Color(255, 255, 255));
        menuCadastroUser.setForeground(new java.awt.Color(0, 0, 0));

        jScrollPane6.setBackground(new java.awt.Color(255, 255, 255));
        jScrollPane6.setForeground(new java.awt.Color(0, 0, 0));

        userTable.setBackground(new java.awt.Color(255, 255, 255));
        userTable.setForeground(new java.awt.Color(0, 0, 0));
        userTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4", "Title 5"
            }
        ));
        jScrollPane6.setViewportView(userTable);

        javax.swing.GroupLayout menuCadastroUserLayout = new javax.swing.GroupLayout(menuCadastroUser);
        menuCadastroUser.setLayout(menuCadastroUserLayout);
        menuCadastroUserLayout.setHorizontalGroup(
            menuCadastroUserLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane6, javax.swing.GroupLayout.PREFERRED_SIZE, 432, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        menuCadastroUserLayout.setVerticalGroup(
            menuCadastroUserLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane6, javax.swing.GroupLayout.PREFERRED_SIZE, 390, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        jPanel3.add(menuCadastroUser, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 60, 540, 390));

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

       
 
    private void btnCadastroUsersActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCadastroUsersActionPerformed
            
            String nomeUsuario = "";
            try (BufferedReader reader = new BufferedReader(new FileReader("usuarioLogado.txt"))) {
                nomeUsuario = reader.readLine();
            } catch (IOException e) {
                e.printStackTrace();
            }

            UsuarioDAO usuarioDAO = new UsuarioDAO();
            boolean isAdmin = usuarioDAO.isAdmin(nomeUsuario);

            if (isAdmin) {
                CadastroUser TelaCaUser = new CadastroUser();
                TelaCaUser.setVisible(true);
                this.dispose();
            } else {
                // Exibe alerta de área restrita
                JOptionPane.showMessageDialog(this, "Acesso restrito para administradores.");
            }
            
            
    }//GEN-LAST:event_btnCadastroUsersActionPerformed

    
    
    private void btnHomeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnHomeActionPerformed
       Home home = new Home();
       home.setVisible(true);
       this.dispose();
    }//GEN-LAST:event_btnHomeActionPerformed

    private void btnGerenciarPessoasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGerenciarPessoasActionPerformed
        String nomeUsuario = "";
            try (BufferedReader reader = new BufferedReader(new FileReader("usuarioLogado.txt"))) {
                nomeUsuario = reader.readLine();
            } catch (IOException e) {
                e.printStackTrace();
            }

            UsuarioDAO usuarioDAO = new UsuarioDAO();
            boolean isAdmin = usuarioDAO.isAdmin(nomeUsuario);

            if (isAdmin) {
                GerenciarPessoa Telape = new GerenciarPessoa();
                Telape.setVisible(true);
                this.dispose();
            } else {
                // Exibe alerta de área restrita
                JOptionPane.showMessageDialog(this, "Acesso restrito para administradores.");
            }
    }//GEN-LAST:event_btnGerenciarPessoasActionPerformed

    private void btnGerenciarUsuariosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGerenciarUsuariosActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnGerenciarUsuariosActionPerformed

    private void btnGerenciarAcessosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGerenciarAcessosActionPerformed
        String nomeUsuario = "";
            try (BufferedReader reader = new BufferedReader(new FileReader("usuarioLogado.txt"))) {
                nomeUsuario = reader.readLine();
            } catch (IOException e) {
                e.printStackTrace();
            }

            UsuarioDAO usuarioDAO = new UsuarioDAO();
            boolean isAdmin = usuarioDAO.isAdmin(nomeUsuario);

            if (isAdmin) {
                GerenciarAcesso geace = new GerenciarAcesso();
                geace.setVisible(true);
                this.dispose();
            } else {
                // Exibe alerta de área restrita
                JOptionPane.showMessageDialog(this, "Acesso restrito para administradores.");
            }
    }//GEN-LAST:event_btnGerenciarAcessosActionPerformed

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
        java.util.logging.Logger.getLogger(GerenciarUser.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

   
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCadastroAcessos;
    private javax.swing.JButton btnCadastroPessoas;
    private javax.swing.JButton btnCadastroUsers;
    private javax.swing.JButton btnGerenciarAcessos;
    private javax.swing.JButton btnGerenciarPessoas;
    private javax.swing.JButton btnGerenciarUsuarios;
    private javax.swing.JButton btnHome;
    private javax.swing.JButton btnHome1;
    private javax.swing.JLabel catracaImg;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JScrollPane jScrollPane6;
    private javax.swing.JLabel lblUsuarioLogado;
    private javax.swing.JPanel menuCadastroUser;
    private javax.swing.JPanel menuPerfil;
    private javax.swing.JButton sair;
    private javax.swing.JTable userTable;
    // End of variables declaration//GEN-END:variables
}