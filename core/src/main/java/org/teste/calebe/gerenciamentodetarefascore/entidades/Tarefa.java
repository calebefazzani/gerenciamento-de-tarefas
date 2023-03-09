package org.teste.calebe.gerenciamentodetarefascore.entidades;

import jakarta.persistence.*;
import org.teste.calebe.gerenciamentodetarefascore.contantes.StatusTarefa;
import org.teste.calebe.gerenciamentodetarefascore.utils.ProjetoUtils;

import java.time.LocalDate;
import java.util.Objects;
import java.util.Optional;

@Entity
@Table(name = "TAREFA")
public class Tarefa {
    public static final String DESCRICAO_PADRAO = "Nenhuma Descrição Informada";
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID_TAREFA")
    private Long idTarefa;
    @Column(name = "TITULO_TAREFA")
    private String titulo;
    @Column(name = "DESCRICAO_TAREFA")
    private String descricao;
    @Column(name = "DATA_INICIO_TAREFA")
    private LocalDate dataInicio;
    @Column(name = "DATA_CONCLUSAO_TAREFA")
    private LocalDate dataConclusao;
    @Column(name = "DATA_VENCIMENTO_TAREFA")
    private LocalDate dataVencimento;
    @Column(name = "STATUS_TAREFA")
    @Enumerated(EnumType.STRING)
    private StatusTarefa status;
    @Column(name = "USUARIO_RESPONSAVEL")
    private String usuarioResponsavel;

    protected Tarefa() {
        status = StatusTarefa.ABERTO;
        setDescricao(DESCRICAO_PADRAO);
    }

    public Tarefa(String tituloTarefa, LocalDate dataVencimento) {
        this();
        this.titulo = ProjetoUtils.requireNonNullOrEmpty(tituloTarefa, () -> new RuntimeException("Título não deve ser nulo"));
        this.dataVencimento = ProjetoUtils.requireNonNull(dataVencimento, () -> new RuntimeException("Data de vencimento não pode ser nula"));
    }

    public Long getIdTarefa() {
        return idTarefa;
    }

    public void setIdTarefa(Long idTarefa) {
        this.idTarefa = idTarefa;
    }

    public String getTitulo() {
        return titulo;
    }

    protected void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = Optional.ofNullable(descricao)
                .filter(e -> !e.isEmpty())
                .orElse(DESCRICAO_PADRAO);
    }

    public LocalDate getDataVencimento() {
        return dataVencimento;
    }

    protected void setDataVencimento(LocalDate dataVencimento) {
        this.dataVencimento = dataVencimento;
    }

    public StatusTarefa getStatus() {
        return status;
    }

    protected void setStatus(StatusTarefa status) {
        this.status = status;
    }

    public LocalDate getDataInicio() {
        return dataInicio;
    }

    protected void setDataInicio(LocalDate dataInicio) {
        this.dataInicio = ProjetoUtils.requireNonNull(dataInicio, () -> new RuntimeException("Por favor informe a data de início da tarefa"));
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Tarefa tarefa = (Tarefa) o;
        return Objects.equals(idTarefa, tarefa.idTarefa);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idTarefa);
    }

    @Override
    public String toString() {
        return "Tarefa{" +
                "idTarefa=" + idTarefa +
                '}';
    }

    public void iniciaAtividade(String usuario, LocalDate dataInicio) {
        this.status = StatusTarefa.EM_ANDAMENTO;
        setDataInicio(dataInicio);
        setUsuarioResponsavel(ProjetoUtils.requireNonNullOrEmpty(usuario, () -> new RuntimeException("Por favor informe um usuário responsável pela tarefa")));
    }

    public void concluiAtividade(LocalDate dataConclusao) {
        this.status = StatusTarefa.CONCLUIDO;
        setDataConclusao(dataConclusao);
    }

    public String getUsuarioResponsavel() {
        return this.usuarioResponsavel;
    }

    protected void setUsuarioResponsavel(String usuarioResponsavel) {
        this.usuarioResponsavel = usuarioResponsavel;
    }

    public LocalDate getDataConclusao() {
        return dataConclusao;
    }

    protected void setDataConclusao(LocalDate dataConclusao) {
        this.dataConclusao = ProjetoUtils.requireNonNull(dataConclusao, () -> new RuntimeException("Por favor informe a data de conclusão da tarefa"));
    }


}
