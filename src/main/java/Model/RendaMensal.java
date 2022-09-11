package model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "rendaMensal")
public class RendaMensal implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    
    private Integer idRendaMensal;
    private Float valorRenda;
    private Date dataConta;
    private String descricaoRenda;

    public Integer getIdRendaMensal() {
        return idRendaMensal;
    }

    public void setIdRendaMensal(Integer idRendaMensal) {
        this.idRendaMensal = idRendaMensal;
    }

    public Float getValorRenda() {
        return valorRenda;
    }

    public void setValorRenda(Float valorRenda) {
        this.valorRenda = valorRenda;
    }

    public Date getDataConta() {
        return dataConta;
    }

    public void setDataConta(Date dataConta) {
        this.dataConta = dataConta;
    }

    public String getDescricaoRenda() {
        return descricaoRenda;
    }

    public void setDescricaoRenda(String descricaoRenda) {
        this.descricaoRenda = descricaoRenda;
    }

    

    
    

    public RendaMensal() {
    }

    public RendaMensal(Integer idRendaMensal, Float valorRenda, Date dataConta, String descricaoRenda) {
        super();
        this.idRendaMensal = idRendaMensal;
        this.valorRenda = valorRenda;
        this.dataConta = dataConta;
        this.descricaoRenda = descricaoRenda;
    }
    
    

}
