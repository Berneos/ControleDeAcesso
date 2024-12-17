/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controllers;

/**
 *
 * @author Daniel
 */
import repository.PessoaDAO;
import models.Pessoa;


public class PessoaController {
    private PessoaDAO pessoaDAO;

    public PessoaController(PessoaDAO pessoaDAO) {
        this.pessoaDAO = pessoaDAO;
    }

    // Método para cadastrar uma nova pessoa
    public boolean cadastrarPessoa(String nome, String cpf, String telefone) {
        Pessoa pessoa = new Pessoa();
        pessoa.setNome(nome);
        pessoa.setCpf(cpf);
        pessoa.setTelefone(telefone);

        return pessoaDAO.salvarPessoa(pessoa);
    }

    // Método para buscar uma pessoa pelo ID
    public Pessoa obterPessoaPorId(Integer id) {
        return pessoaDAO.buscarPessoaPorId(id);
    }

    // Método para atualizar os dados de uma pessoa
    public boolean atualizarPessoa(Integer id, String nome, String cpf, String telefone) {
        Pessoa pessoa = pessoaDAO.buscarPessoaPorId(id);
        if (pessoa != null) {
            pessoa.setNome(nome);
            pessoa.setCpf(cpf);
            pessoa.setTelefone(telefone);
            return pessoaDAO.atualizarPessoa(pessoa);
        }
        return false; // Retorna falso se a pessoa não for encontrada
    }

    // Método para remover uma pessoa pelo ID
    public boolean removerPessoa(Integer id) {
        return pessoaDAO.removerPessoa(id);
    }
}