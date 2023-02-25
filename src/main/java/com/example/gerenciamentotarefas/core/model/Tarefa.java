package com.example.gerenciamentotarefas.core.model;

import com.example.gerenciamentotarefas.core.model.constants.StatusTarefa;
import com.example.gerenciamentotarefas.core.model.embeddable.DadosAtribuicao;
import com.example.gerenciamentotarefas.core.model.embeddable.DadosTarefa;
import jakarta.persistence.*;

import java.time.LocalDate;
import java.util.Objects;
import java.util.Optional;

@Entity
public class Tarefa {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "TAREFA_ID")
    private Long id;

    @Embedded
    private DadosTarefa dadosTarefa;

    @Embedded
    private DadosAtribuicao dadosAtribuicao;

    protected Tarefa() {}

    public Tarefa(String titulo) {
        this();
        this.dadosTarefa = new DadosTarefa(titulo);
    }

    public Tarefa(String titulo, String descricao) {
        this(titulo);
        this.dadosTarefa.setDescricao(descricao);
    }

    public Tarefa(DadosTarefa dadosTarefa) {
        this.dadosTarefa = dadosTarefa;
    }

    public Tarefa(DadosTarefa dadosTarefa, DadosAtribuicao dadosAtribuicao) {
        this.dadosTarefa = dadosTarefa;
        this.dadosAtribuicao = dadosAtribuicao;
    }


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public DadosTarefa getDadosTarefa() {
        return dadosTarefa;
    }

    public void setDadosTarefa(DadosTarefa dadosTarefa) {
        this.dadosTarefa = dadosTarefa;
    }

    public DadosAtribuicao getDadosAtribuicao() {
        return dadosAtribuicao;
    }

    public void setDadosAtribuicao(DadosAtribuicao dadosAtribuicao) {
        this.dadosAtribuicao = dadosAtribuicao;
    }

    public String getDescricao() {
        return Optional.ofNullable(dadosTarefa)
                .map(DadosTarefa::getDescricao)
                .orElse(null);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Tarefa tarefa = (Tarefa) o;
        return Objects.equals(id, tarefa.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    public boolean estaEmAberto() {
        return Optional.ofNullable(dadosTarefa)
                .map(DadosTarefa::getStatus)
                .map(StatusTarefa.ABERTO::equals)
                .orElse(false);
    }

    public LocalDate getDataVencimento() {
        return dadosTarefa.getDataVencimento();
    }
}
