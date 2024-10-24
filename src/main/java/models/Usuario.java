/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package models;
import jakarta.persistence.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
/**
 *
 * @author BRENO
 */
@Entity
@Table(name = "tbusuario")
public class Usuario {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Integer id;

    @Column(name = "Nome")
    public String nome;

    @Column(name = "Usuariio")
    public String Usuariio;
    
    @Column(name = "Senha")
    public String Senha;
    
    @Column(name = "isAdmin")
    public Boolean isAdmin;

    // Getters e Setters
    public String getNome() {
        return nome;
    }
    public String getSenha() {
        return Senha;
    }
    public String getUsuario() {
        return Usuariio;
    }
     private Connection connect() {
        // Conectar ao banco de dados
        String url = "jdbc:sqlite:banco.db";  // Modifique de acordo com seu BD
        Connection conn = null;
        try {
            conn = DriverManager.getConnection(url);
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return conn;
    }
    public void saveUser(String nome, String senha, String usuario) {
        // Lógica para salvar o usuário no banco de dados.
        try {
            // Aqui você precisaria de um objeto de conexão com o banco de dados.
            Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/banco", "root", "root");

            String sql = "INSERT INTO tbusuario (Nome, Senha, Usuariio) VALUES (?, ?, ?)";
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setString(1, nome);
            statement.setString(2, senha);
            statement.setString(3, usuario);  // Adiciona o valor booleano

            int rowsInserted = statement.executeUpdate();
            if (rowsInserted > 0) {
                System.out.println("Um novo usuário foi inserido com sucesso!");
            }
        } catch (SQLException e) {
            e.printStackTrace();  // Exibir erro caso haja
        }
    }
}