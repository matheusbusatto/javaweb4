package model;


import java.io.Serializable;
import java.util.List;
import javax.persistence.PersistenceException;
import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import util.HibernateUtil;

public class ContaDao implements Serializable {

    private Session session;//sessao hibernate
    private Transaction trans;
    private SessionFactory sessionFactory ;

    
    public void create(Conta conta) {

        try {

            sessionFactory = HibernateUtil.getSessionAnnotationFactory();
            session = sessionFactory.openSession();
            trans = session.beginTransaction();
            session.save(conta);//save método do hibernate
            trans.commit();  //grava no disco efetivamente
            
        } catch (PersistenceException e) {
            trans.rollback();
           
        } finally {

            
        }
    }

    public Conta read(int id) {
             sessionFactory = HibernateUtil.getSessionAnnotationFactory();
             session = sessionFactory.openSession();

        Conta pe = new Conta();
        //(Pessoa) type cast - força a conversao para Pessoa
        return pe = (Conta) session.get(Conta.class, id);
        
    }

    public void update(Conta conta) {

        try {
            sessionFactory = HibernateUtil.getSessionAnnotationFactory();
            session = sessionFactory.openSession();

            trans = session.beginTransaction();
            session.update(conta);
            trans.commit();
        } catch (PersistenceException e) {
             trans.rollback();
        } finally {
            if (session.isOpen()) {
            session.close();}
        }
    }

    public int delete(Conta conta) {
      int retorno =0;
        try {

            sessionFactory = HibernateUtil.getSessionAnnotationFactory();
            session = sessionFactory.openSession();
            
            trans = session.beginTransaction();
            session.delete(conta);
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
    
    
    
        public List<Object> getListSQL() {
        Session session = HibernateUtil.getSessionAnnotationFactory().openSession();
        SQLQuery qry = session.createSQLQuery("");
        return qry.list();
    }
    
    
    
    
    
    

}
