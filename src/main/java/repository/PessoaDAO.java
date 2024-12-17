    /*
     * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
     * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
     */
    package repository;

    /**
     *
     * @author Daniel
     */

    import controllers.HibernateUtil;
    import java.util.List;
    import java.sql.Connection;
    import models.Pessoa;
    import org.hibernate.Session;
    import org.hibernate.Transaction;
    import org.hibernate.query.Query;

    public class PessoaDAO {
        private Session session; // Usar Session em vez de EntityManager

         // Construtor que inicializa uma sessão
        public PessoaDAO() {
            this.session = HibernateUtil.getSessionFactory().openSession();
        }

        // Construtor que aceita uma sessão externa
        public PessoaDAO(Session session) {
            this.session = session; 
        }

        public List<String> buscarTodosNomes() {
            List<String> nomes = null;
            Transaction transaction = null;
            try {
                transaction = session.beginTransaction();
                nomes = session.createQuery("SELECT p.nome FROM Pessoa p", String.class).getResultList();
                transaction.commit();
            } catch (Exception e) {
                if (transaction != null) {
                    transaction.rollback();
                }
                e.printStackTrace();
            }
            return nomes;
        }

        public Pessoa buscarPessoaPorNome(String nome) {
            Pessoa pessoa = null;
            Session session = HibernateUtil.getSessionFactory().openSession();

            try {
                String hql = "FROM Pessoa p WHERE p.nome = :nome";
                Query<Pessoa> query = session.createQuery(hql, Pessoa.class);
                query.setParameter("nome", nome);

                List<Pessoa> results = query.getResultList();
                if (!results.isEmpty()) {
                    pessoa = results.get(0); // Retorna o primeiro resultado
                }
            } catch (Exception e) {
                e.printStackTrace();
            } finally {
                session.close();
            }

            return pessoa;
        }

        // Método para salvar uma pessoa no banco de dados
        public boolean salvarPessoa(Pessoa pessoa) {
            Transaction transaction = null;
            try {
                transaction = session.beginTransaction();
                session.save(pessoa);
                transaction.commit();
                return true;
            } catch (Exception e) {
                if (transaction != null) {
                    transaction.rollback(); // Rollback em caso de erro
                }
                e.printStackTrace();
                return false;
            }
        }

        // Método para buscar uma pessoa pelo ID
        public Pessoa buscarPessoaPorId(Integer id) {
            return session.get(Pessoa.class, id); // Usar session.get em vez de entityManager.find
        }

        // Método para atualizar uma pessoa no banco de dados
        public boolean atualizarPessoa(Pessoa pessoa) {
            Transaction transaction = null;
            try {
                transaction = session.beginTransaction();
                session.update(pessoa); // Usa update para atualizar a pessoa
                transaction.commit();
                return true;
            } catch (Exception e) {
                e.printStackTrace();
                if (transaction != null) {
                    transaction.rollback(); // Rollback em caso de erro
                }
                return false;
            }
        }

        // Método para remover uma pessoa do banco de dados
        public boolean removerPessoa(Integer id) {
            Transaction transaction = null;
            try {
                transaction = session.beginTransaction();
                Pessoa pessoa = buscarPessoaPorId(id);
                if (pessoa != null) {
                    session.delete(pessoa); // Remove a pessoa
                    transaction.commit();
                    return true;
                }
                transaction.rollback(); // Rollback se a pessoa não for encontrada
            } catch (Exception e) {
                e.printStackTrace();
                if (transaction != null) {
                    transaction.rollback(); // Rollback em caso de erro
                }
            }
            return false; // Retorna falso se a operação falhou
        }

        // Método para fechar a sessão
        public void close() {
            if (session != null) {
                session.close(); // Fecha a sessão
            }
        }
    }