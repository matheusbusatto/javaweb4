package model;


import java.io.Serializable;
import java.util.List;
import javax.persistence.PersistenceException;
import org.hibernate.Criteria;
import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import util.HibernateUtil;

public class UsuarioDao implements Serializable {

    private Session session;//sessao hibernate
    private Transaction trans;
    private SessionFactory sessionFactory ;
    private List list;

    
    public void create(Usuario usuario) {

        try {

            sessionFactory = HibernateUtil.getSessionAnnotationFactory();
            session = sessionFactory.openSession();
            trans = session.beginTransaction();
            session.save(usuario);//save método do hibernate
            trans.commit();  //grava no disco efetivamente
            
        } catch (PersistenceException e) {
            trans.rollback();
           
        } finally {

            
        }
    }

    public Usuario read(int id) {
             sessionFactory = HibernateUtil.getSessionAnnotationFactory();
             session = sessionFactory.openSession();

        Usuario pe = new Usuario();
        //(Pessoa) type cast - força a conversao para Pessoa
        return pe = (Usuario) session.get(Usuario.class, id);
        
    }

    public void update(Usuario usuario) {

        try {
            sessionFactory = HibernateUtil.getSessionAnnotationFactory();
            session = sessionFactory.openSession();

            trans = session.beginTransaction();
            session.update(usuario);
            trans.commit();
        } catch (PersistenceException e) {
             trans.rollback();
        } finally {
            if (session.isOpen()) {
            session.close();}
        }
    }

    public int delete(Usuario usuario) {
      int retorno =0;
        try {

            sessionFactory = HibernateUtil.getSessionAnnotationFactory();
            session = sessionFactory.openSession();
            
            trans = session.beginTransaction();
            session.delete(usuario);
            trans.commit();
            retorno = 1;
        } catch (PersistenceException e) {
             trans.rollback();
             retorno = 0;
        } finally {
            if (session.isOpen()) {
            session.close();}
        }
        
        return retorno;
    }
    
    
    /*
        public List<Object> getListSQL() {
        Session session = HibernateUtil.getSessionAnnotationFactory().openSession();
        SQLQuery qry = session.createSQLQuery("");
        return qry.list();
    }
    
    
    */
    
    public List<Usuario> getList() {
        sessionFactory = HibernateUtil.getSessionAnnotationFactory();
        session = sessionFactory.openSession();
        Criteria cri = session.createCriteria(Usuario.class);
        list = cri.list();
        return list;
    }

    public List<Object> getListSQL() {
        Session session = HibernateUtil.getSessionAnnotationFactory().openSession();
        SQLQuery qry = session.createSQLQuery("SELECT * FROM usuario ORDER BY idUsuario DESC");
        return qry.list();
    }
    
    

}
