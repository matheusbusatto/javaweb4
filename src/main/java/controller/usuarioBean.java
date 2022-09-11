package controller;

import java.io.Serializable;
import java.util.List;
import java.util.Objects;
import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import javax.faces.application.FacesMessage;
import model.Usuario;
import model.UsuarioDao;
import org.primefaces.PrimeFaces;

@Named(value = "usuarioBean")
@SessionScoped
public class usuarioBean implements Serializable {

    private Usuario usuario = new Usuario();
    private UsuarioDao usuarioDao = new UsuarioDao();

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public UsuarioDao getUsuarioDao() {
        return usuarioDao;
    }

    public void setUsuarioDao(UsuarioDao usuarioDao) {
        this.usuarioDao = usuarioDao;
    }

    public usuarioBean() {
    }

    public String adicionarUsuario() {
        usuarioDao.create(usuario);
        addMessage(FacesMessage.SEVERITY_INFO, "Confirmação", "Dados Gravados.");
        return "index_pessoa.xhtml";

    }

    public String removerUsuario(int id) {

        usuario = usuarioDao.read(id);
        usuarioDao.delete(usuario);

        //pessoa.setEmail("");
        //pessoa.setNome("");
        //pessoa.setId(0);
        addMessage(FacesMessage.SEVERITY_INFO, "Confirmação", "Dados Excluídos.");

        return "index_usuario.xhtml";

    }
    
    public void addMessage(FacesMessage.Severity severity, String summary, String detail) {
        FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO, summary, detail);
        PrimeFaces.current().dialog().showMessageDynamic(message);

    }

    public List<Object> listarUsuarioFull() {
        List<Object> objetosGrid;
        return objetosGrid = usuarioDao.getListSQL();
    }

}
