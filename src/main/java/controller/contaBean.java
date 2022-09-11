package controller;

import java.io.Serializable;
import java.util.Objects;
import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import model.Conta;
import model.ContaDao;



@Named(value = "contaBean")
@SessionScoped
public class contaBean implements Serializable {

    private Conta conta = new Conta();

    public Conta getConta() {
        return conta;
    }

    public void setConta(Conta conta) {
        this.conta = conta;
    }

    public ContaDao getContaDao() {
        return contaDao;
    }

    public void setContaDao(ContaDao contaDao) {
        this.contaDao = contaDao;
    }
    private ContaDao contaDao = new ContaDao();
  
    
  
    public contaBean() {
    }

    
    @Override
    public int hashCode() {
        int hash = 5;
        hash = 97 * hash + Objects.hashCode(this.conta);
        return hash;
    }

    
    
    

}
