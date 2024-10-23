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
@Table(name = "tbpessoa")
public class Pessoa {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "Id")
    public Integer id;

    @Column(name = "PessoaNome")
    public String nome;

    @Column(name = "PessoaCPF")
    public String cpf;
    
    @Column(name = "PessoaTelefone")
    public String telefone;

    // Getters e Setters
}