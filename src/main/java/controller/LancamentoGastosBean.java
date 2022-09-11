package controller;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import javax.annotation.PostConstruct;
import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import javax.faces.application.FacesMessage;
import javax.faces.model.SelectItem;
import model.LancamentoGastos;
import model.LancamentoGastosDao;



@Named(value = "lancamentoGastosBean")
@SessionScoped
public class LancamentoGastosBean implements Serializable {

    private  LancamentoGastos lancamentoGastos = new LancamentoGastos();
    private  LancamentoGastosDao lancamentoGastosDao = new LancamentoGastosDao();
    private List<SelectItem> LancamentoGastos;
    private List<LancamentoGastos> listaLancamentoGastos;
    
   
    private Object usuario;

    public LancamentoGastos getLancamentoGastos() {
        return lancamentoGastos;
    }

    public void setLancamentoGastos(LancamentoGastos lancamentoGastos) {
        this.lancamentoGastos = lancamentoGastos;
    }

    public LancamentoGastosDao getLancamentoGastosDao() {
        return lancamentoGastosDao;
    }

    public void setLancamentoGastosDao(LancamentoGastosDao lancamentoGastosDao) {
        this.lancamentoGastosDao = lancamentoGastosDao;
    }

    public Object getUsuario() {
        return usuario;
    }

    public void setUsuario(Object usuario) {
        this.usuario = usuario;
    }
  
    
    public String LancarGasto() {
        lancamentoGastosDao.create(lancamentoGastos);
        addMessage(FacesMessage.SEVERITY_INFO, "Confirmação", "Dados Gravados.");
        return "index_cliente.xhtml";

    }
    
    
   
    
    /**
     *
     * @return
     */
    public List<Object> listarGastosFull() {
        List<Object> objetosGrid;
        return objetosGrid = lancamentoGastos.getListSQL();
    }
  
    public LancamentoGastosBean() {
    }

    
    @Override
    public int hashCode() {
        int hash = 5;
        hash = 97 * hash + Objects.hashCode(this.usuario);
        return hash;
    }

    
    
    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final LancamentoGastosBean other = (LancamentoGastosBean) obj;
        if (!Objects.equals(this.usuario, other.usuario)) {
            return false;
        }
        return true;

    }

    private void addMessage(FacesMessage.Severity SEVERITY_INFO, String confirmação, String dados_Gravados) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
