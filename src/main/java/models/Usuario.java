/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package models;
import controllers.HibernateUtil;
import jakarta.persistence.*;
import org.hibernate.Session;
import org.hibernate.Transaction;
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
    public Integer getId() { return id; }
    public void setId(Integer id) { this.id = id; }
    public String getNome() { return nome; }
    public void setNome(String nome) { this.nome = nome; }
    public String getUsuariio() { return Usuariio; }
    public void setUsuario(String usuario) { this.Usuariio = usuario; }
    public String getSenha() { return Senha; }
    public void setSenha(String senha) { this.Senha = senha; }
    public boolean isAdmin() { return isAdmin; }
    public void setAdmin(boolean isAdmin) { this.isAdmin = isAdmin; }
}