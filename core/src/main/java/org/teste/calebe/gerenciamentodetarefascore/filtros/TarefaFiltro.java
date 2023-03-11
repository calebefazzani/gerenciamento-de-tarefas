package org.teste.calebe.gerenciamentodetarefascore.filtros;

import org.springframework.data.jpa.domain.Specification;
import org.teste.calebe.gerenciamentodetarefascore.contantes.StatusTarefa;
import org.teste.calebe.gerenciamentodetarefascore.entidades.Tarefa;

import java.time.LocalDate;
import java.util.Optional;

public class TarefaFiltro {
    private StatusTarefa status;
    private LocalDate dataVencimento;
    private String titulo;

    public StatusTarefa getStatus() {
        return status;
    }

    public void setStatus(StatusTarefa status) {
        this.status = status;
    }

    public LocalDate getDataVencimento() {
        return dataVencimento;
    }

    public void setDataVencimento(LocalDate dataVencimento) {
        this.dataVencimento = dataVencimento;
    }

    public String getTitulo() {
        return Optional.ofNullable(titulo).orElse("");
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public Specification<Tarefa> getTituloSpec() {
        return (root, query, criteriaBuilder) -> {
            return criteriaBuilder.like(root.get("titulo"), "%"+getTitulo()+"%");
        };
    }

    public Specification<Tarefa> getDataVencimentoSpec() {
        return (root, query, criteriaBuilder) -> {
            if(dataVencimento == null) {
                return criteriaBuilder.and();
            }
            return criteriaBuilder.greaterThanOrEqualTo(root.get("dataVencimento"), dataVencimento);
        };
    }

    public Specification<Tarefa> getStatusSpec() {
        return (root, query, criteriaBuilder) -> {
            if(status == null) {
                return criteriaBuilder.and();
            }

            return criteriaBuilder.equal(root.get("status"), status);
        };
    }
}
