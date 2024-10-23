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
@Table(name = "tbcatraca")
public class Catraca {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "Id")
    public Integer id;

    @Column(name = "CatracaNome")
    public String nome;
    // Getters e Setters
}