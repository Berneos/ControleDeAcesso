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
import java.util.List;

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
    public Usuario buscarUsuarioPorNome(String nome) {
            Usuario usuario = null;
            Session session = HibernateUtil.getSessionFactory().openSession();

            try {
                String hql = "FROM Usuario u WHERE u.nome = :nome";
                Query<Usuario> query = session.createQuery(hql, Usuario.class);
                query.setParameter("nome", nome);

                List<Usuario> results = query.getResultList();
                if (!results.isEmpty()) {
                    usuario = results.get(0); // Retorna o primeiro resultado
                }
            } catch (Exception e) {
                e.printStackTrace();
            } finally {
                session.close();
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
    public static List<Usuario> buscarTodos() {
        // Lista onde armazenaremos os usuários recuperados
        List<Usuario> usuarios = null;

        // Obtendo a sessão do Hibernate
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            // Iniciando uma transação
            Transaction transaction = session.beginTransaction();
            
            // Criando a query para buscar todos os usuários
            Query<Usuario> query = session.createQuery("FROM Usuario", Usuario.class);
            
            // Executando a query e armazenando o resultado na lista
            usuarios = query.getResultList();
            
            // Confirmando a transação
            transaction.commit();
        } catch (Exception e) {
            e.printStackTrace();
        }
        
        // Retornando a lista de usuários
        return usuarios;
    }
}
