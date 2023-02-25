package com.example.gerenciamentotarefas.core.model.embeddable;

import com.example.gerenciamentotarefas.core.model.Usuario;
import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Embeddable
public class DadosAtribuicao {
    @Column(name = "USUARIO_ID")
    private String idUsuario;

    @Column(name = "USUARIO_ATRIBUIDOR_ID")
    private String idAtribuidor;

    @ManyToOne
    @JoinColumn(name = "USUARIO_ATRIBUIDOR_ID", referencedColumnName = "USUARIO_ID", insertable = false, updatable = false)
    private Usuario usuarioAtribuidor;

    @ManyToOne
    @JoinColumn(name = "USUARIO_ID", referencedColumnName = "USUARIO_ID", insertable = false, updatable = false)
    private Usuario usuarioResponsavel;

    public String getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(String idUsuario) {
        this.idUsuario = idUsuario;
    }

    public String getIdAtribuidor() {
        return idAtribuidor;
    }

    public void setIdAtribuidor(String idAtribuidor) {
        this.idAtribuidor = idAtribuidor;
    }

    public Usuario getUsuarioAtribuidor() {
        return usuarioAtribuidor;
    }

    public void setUsuarioAtribuidor(Usuario usuarioAtribuidor) {
        this.usuarioAtribuidor = usuarioAtribuidor;
    }

    public Usuario getUsuarioResponsavel() {
        return usuarioResponsavel;
    }

    public void setUsuarioResponsavel(Usuario usuarioResponsavel) {
        this.usuarioResponsavel = usuarioResponsavel;
    }
}
