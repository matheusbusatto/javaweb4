package model;


import java.io.Serializable;
import java.util.List;
import javax.faces.model.SelectItem;
import javax.persistence.PersistenceException;
import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import util.HibernateUtil;

public class LancamentoGastosDao implements Serializable {

    public static List<SelectItem> getList() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    private Session session;//sessao hibernate
    private Transaction trans;
    private SessionFactory sessionFactory ;

    
    public void create(LancamentoGastos lancamentoGastos) {

        try {

            sessionFactory = HibernateUtil.getSessionAnnotationFactory();
            session = sessionFactory.openSession();
            trans = session.beginTransaction();
            session.save(lancamentoGastos);//save método do hibernate
            trans.commit();  //grava no disco efetivamente
            
        } catch (PersistenceException e) {
            trans.rollback();
           
        } finally {

            
        }
    }

    public LancamentoGastos read(int id) {
             sessionFactory = HibernateUtil.getSessionAnnotationFactory();
             session = sessionFactory.openSession();

        LancamentoGastos pe = new LancamentoGastos();
        //(Pessoa) type cast - força a conversao para Pessoa
        return pe = (LancamentoGastos) session.get(LancamentoGastos.class, id);
        
    }

    public void update(LancamentoGastos lancamentoGastos) {

        try {
            sessionFactory = HibernateUtil.getSessionAnnotationFactory();
            session = sessionFactory.openSession();

            trans = session.beginTransaction();
            session.update(lancamentoGastos);
            trans.commit();
        } catch (PersistenceException e) {
             trans.rollback();
        } finally {
            if (session.isOpen()) {
            session.close();}
        }
    }

    public int delete(LancamentoGastos lancamentoGastos) {
      int retorno =0;
        try {

            sessionFactory = HibernateUtil.getSessionAnnotationFactory();
            session = sessionFactory.openSession();
            
            trans = session.beginTransaction();
            session.delete(lancamentoGastos);
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
        SQLQuery qry = session.createSQLQuery("SELECT * FROM lancamentosgastos WHERE 1 ORDER BY lancamentosgastos.idLancamentosGastos DESC");
        return qry.list();
    }
    
    
    
    
    
    

}
