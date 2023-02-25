package com.example.gerenciamentotarefas.core.model.embeddable;

import com.example.gerenciamentotarefas.core.model.constants.StatusTarefa;
import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import jakarta.persistence.Enumerated;

import java.time.LocalDate;
import java.util.Optional;

@Embeddable
public class DadosTarefa {
    public static final String DESCRICAOO_NAO_INFORMADA = "Descrição não informada";
    @Column(name = "TITULO")
    private String titulo;

    @Column(name = "DESCRICAO")
    private String descricao;

    @Column(name = "DATA_VENCIMENTO")
    private LocalDate dataVencimento;

    @Column(name = "STATUS_TAREFA")
    @Enumerated
    private StatusTarefa status;

    protected DadosTarefa() {
        this.status = StatusTarefa.ABERTO;
        setDataVencimento(null);
        setDescricao(null);
    }

    public DadosTarefa(String titulo) {
        this();
        this.setTitulo(titulo);
    }

    public DadosTarefa(String titulo, String descricao) {
        this(titulo);
        this.setDescricao(descricao);
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = Optional.ofNullable(titulo)
                .filter(e -> !e.isEmpty())
                .orElseThrow(() -> new RuntimeException("Título da atividade não pode ser nulo"));
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = Optional.ofNullable(descricao)
                .orElse(DESCRICAOO_NAO_INFORMADA);
    }

    public LocalDate getDataVencimento() {
        return dataVencimento;
    }

    public void setDataVencimento(LocalDate dataVencimento) {
        this.dataVencimento = Optional.ofNullable(dataVencimento)
                .orElseGet(LocalDate::now);
    }

    public StatusTarefa getStatus() {
        return status;
    }

    protected void setStatus(StatusTarefa status) {
        this.status = status;
    }
}
