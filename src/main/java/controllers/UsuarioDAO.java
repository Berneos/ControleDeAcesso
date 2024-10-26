/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controllers;

/**
 *
 * @author BRENO
 */
import models.Usuario;
import controllers.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

public class UsuarioDAO {

    public Usuario getUsuarioByUsernameAndPassword(String Usuariio, String Senha) {
        Transaction transaction = null;
        Usuario usuario = null;

        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            transaction = session.beginTransaction();

            // Consulta ajustada para refletir o nome das colunas da tabela tbusuario
            usuario = (Usuario) session.createQuery("FROM Usuario WHERE Usuariio = :Usuariio AND Senha = :Senha")
                    .setParameter("Usuariio", Usuariio)
                    .setParameter("Senha", Senha)
                    .uniqueResult();

            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
        }
        return usuario;
    }
    public boolean isAdmin(String nomeUsuario) {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            // Consulta o usuário no banco
            Query<Boolean> query = session.createQuery(
                "SELECT u.isAdmin FROM Usuario u WHERE u.nome = :nomeUsuario", Boolean.class);
            query.setParameter("nomeUsuario", nomeUsuario);
            Boolean isAdmin = query.uniqueResult();
            return isAdmin != null && isAdmin;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }
}
