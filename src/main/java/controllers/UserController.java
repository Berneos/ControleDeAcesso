/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controllers;
import models.Usuario;
import views.Home;

public class UserController {
    private Home view;
    private Usuario model;

    public UserController(Home view, Usuario model) {
        this.view = view;
        this.model = model;

        // Adiciona um listener para o botão de salvar
        this.view.getSaveButton().addActionListener(e -> saveUser());
    }

    private void saveUser() {
        // Obtém os dados da View
        String nome = view.getName();
        String senha = view.getPassword();
        String usuario = view.getUsuario();

        // Chama o método do Model para salvar os dados
        model.saveUser(nome, senha, usuario);

        // Exibe uma mensagem de confirmação na View
        view.showMessage("Usuário salvo com sucesso!");
    }
}