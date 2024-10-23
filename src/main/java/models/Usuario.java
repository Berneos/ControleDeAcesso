/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package models;
import jakarta.persistence.*;
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
}

