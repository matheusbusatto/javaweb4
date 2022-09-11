package controller;

import java.io.Serializable;
import java.util.Objects;
import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import model.RendaMensal;



@Named(value = "rendaMensalBean")
@SessionScoped
public class RendaMensalBean implements Serializable {

    private  RendaMensal rendaMensal = new RendaMensal();
    private  RendaMensal rendaMensalDao = new RendaMensal();

    public RendaMensal getRendaMensal() {
        return rendaMensal;
    }

    public void setRendaMensal(RendaMensal rendaMensal) {
        this.rendaMensal = rendaMensal;
    }

    public RendaMensal getRendaMensalDao() {
        return rendaMensalDao;
    }

    public void setRendaMensalDao(RendaMensal rendaMensalDao) {
        this.rendaMensalDao = rendaMensalDao;
    }
  
    
  
    public RendaMensalBean() {
    }

    
    @Override
    public int hashCode() {
        int hash = 5;
        hash = 97 * hash + Objects.hashCode(this.rendaMensal);
        return hash;
    }

    
    
    

}
