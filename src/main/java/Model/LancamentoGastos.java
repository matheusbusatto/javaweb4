package model;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "lancamentosGastos")
public class LancamentoGastos implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    private Integer idLancamentosGastos;
    private Float valorGasto;
    private Date dataGasto;
    private String qtdConsumo;

    public Integer getIdLancamentosGastos() {
        return idLancamentosGastos;
    }

    public void setIdLancamentosGastos(Integer idLancamentosGastos) {
        this.idLancamentosGastos = idLancamentosGastos;
    }

    public Float getValorGasto() {
        return valorGasto;
    }

    public void setValorGasto(Float valorGasto) {
        this.valorGasto = valorGasto;
    }

    public Date getDataGasto() {
        return dataGasto;
    }

    public void setDataGasto(Date dataGasto) {
        this.dataGasto = dataGasto;
    }

    public String getQtdConsumo() {
        return qtdConsumo;
    }

    public void setQtdConsumo(String qtdConsumo) {
        this.qtdConsumo = qtdConsumo;
    }
    
    
    

    

public LancamentoGastos() {
	}

	public LancamentoGastos(Integer idLancamentosGastos, Float valorGasto, Date dataGasto, String qtdConsumo ) {
		super();
		this.idLancamentosGastos= idLancamentosGastos;
		this.valorGasto = valorGasto;
                this.dataGasto = dataGasto;
                this.qtdConsumo = qtdConsumo;
		
	}

    //public List<Object> getListSQL() {
      //  throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
  //  }

    public List<Object> getListSQL() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}

