/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package repository;
import controllers.HibernateUtil;
import java.util.List;
import java.sql.Connection;
import models.Catraca;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
/**
 *
 * @author Breno
 */
public class CatracaDAO {
    private Session session; // Usar Session em vez de EntityManager

    // Construtor que inicializa uma sessão
    public CatracaDAO() {
        this.session = HibernateUtil.getSessionFactory().openSession();
    }

    // Construtor que aceita uma sessão externa
    public CatracaDAO(Session session) {
            this.session = session; 
    }
    public List<String> buscarTodosNomes() {
            List<String> nomes = null;
            Transaction transaction = null;
            try {
                transaction = session.beginTransaction();
                nomes = session.createQuery("SELECT c.nome FROM Catraca c", String.class).getResultList();
                transaction.commit();
            } catch (Exception e) {
                if (transaction != null) {
                    transaction.rollback();
                }
                e.printStackTrace();
            }
            return nomes;
    }
    
    public Catraca buscarCatracaPorNome(String nome) {
            Catraca catraca = null;
            Session session = HibernateUtil.getSessionFactory().openSession();

            try {
                String hql = "FROM Catraca c WHERE c.nome = :nome";
                Query<Catraca> query = session.createQuery(hql, Catraca.class);
                query.setParameter("nome", nome);

                List<Catraca> results = query.getResultList();
                if (!results.isEmpty()) {
                    catraca = results.get(0); // Retorna o primeiro resultado
                }
            } catch (Exception e) {
                e.printStackTrace();
            } finally {
                session.close();
            }

            return catraca;
        }
    
}
