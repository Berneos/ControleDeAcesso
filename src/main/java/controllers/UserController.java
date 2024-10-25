/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controllers;

import models.Usuario; // Import necessário, se não estiver
import repository.UserRepository;
import views.CadastroUser;

public class UserController {
    private final CadastroUser view; // Instância da tela
    private final Usuario model; // Instância do modelo

    // Construtor com dois parâmetros
    public UserController(CadastroUser view, Usuario model) {
        this.view = view;
        this.model = model;
    }

    public void saveUser(Usuario user) {
        UserRepository userRepository = new UserRepository();
        userRepository.save(user); // Chama o método save no repositório
    }


    public void saveUser(String nome, String usuario, String senha, boolean isAdmin) {
        Usuario user = new Usuario();
        user.setNome(nome);
        user.setUsuario(usuario);
        user.setSenha(senha);
        user.setAdmin(isAdmin);

        UserRepository userRepository = new UserRepository();
        userRepository.save(user);
    }
}