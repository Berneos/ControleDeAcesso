/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.controledeacesso;

import views.Login;
import java.sql.Connection;
import java.sql.DriverManager;

/**
 *
 * @author BRENO
 */
public class ControleDeAcesso {
    public static void main(String[] args) {
        System.out.println("Sistema de Controle de Acesso iniciado.");
        Login login = new Login();
        login.setVisible(true);
         try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/controle_acesso?useSSL=false&serverTimezone=UTC", "root", "root");
            System.out.println("Conexão bem-sucedida!");
            connection.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}