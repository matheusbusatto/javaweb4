package model;


import java.io.Serializable;
import java.util.List;
import javax.persistence.PersistenceException;
import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import util.HibernateUtil;

public class RendaMensalDao implements Serializable {

    private Session session;//sessao hibernate
    private Transaction trans;
    private SessionFactory sessionFactory ;

    
    public void create(RendaMensal rendaMensal) {

        try {

            sessionFactory = HibernateUtil.getSessionAnnotationFactory();
            session = sessionFactory.openSession();
            trans = session.beginTransaction();
            session.save(rendaMensal);//save método do hibernate
            trans.commit();  //grava no disco efetivamente
            
        } catch (PersistenceException e) {
            trans.rollback();
           
        } finally {

            
        }
    }

    public RendaMensal read(int id) {
             sessionFactory = HibernateUtil.getSessionAnnotationFactory();
             session = sessionFactory.openSession();

        RendaMensal pe = new RendaMensal();
        //(Pessoa) type cast - força a conversao para Pessoa
        return pe = (RendaMensal) session.get(RendaMensal.class, id);
        
    }

    public void update(RendaMensal rendaMensal) {

        try {
            sessionFactory = HibernateUtil.getSessionAnnotationFactory();
            session = sessionFactory.openSession();

            trans = session.beginTransaction();
            session.update(rendaMensal);
            trans.commit();
        } catch (PersistenceException e) {
             trans.rollback();
        } finally {
            if (session.isOpen()) {
            session.close();}
        }
    }

    public int delete(RendaMensal rendaMensal) {
      int retorno =0;
        try {

            sessionFactory = HibernateUtil.getSessionAnnotationFactory();
            session = sessionFactory.openSession();
            
            trans = session.beginTransaction();
            session.delete(rendaMensal);
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
