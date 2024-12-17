/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package repository;

import controllers.HibernateUtil;
import models.Acesso;
import org.hibernate.*;

/**
 *
 * @author Daniel
 */
public class AcessoDAO {
    private Session session;
    
    public AcessoDAO() {
        this.session = HibernateUtil.getSessionFactory().openSession(); // Inicializa a session
    }
    
    public boolean salvarAcesso(Acesso acesso) {
    Session session = HibernateUtil.getSessionFactory().openSession();
    Transaction transaction = null;
    boolean isSuccess = false;

    try {
        transaction = session.beginTransaction();
        session.save(acesso); // Salva o objeto Acesso
        transaction.commit();
        isSuccess = true; // Indica que a operação foi bem-sucedida
    } catch (Exception e) {
        if (transaction != null) {
            transaction.rollback(); // Desfaz a transação em caso de erro
        }
        e.printStackTrace();
    } finally {
        session.close(); // Fecha a sessão
    }
        return isSuccess; // Retorna o resultado da operação
    }
}