package com.atividades.controle;

import java.time.LocalDate;

public class Atividade {
    private Integer id;
    private String titulo;
    private String descricao;
    private Integer materiaId;
    private LocalDate dataVencimento;
    private String tipo;
    private Double notaMaxima;
    private Boolean avaliativa;
    private Boolean entrega;
    private Boolean entregue;
    private LocalDate dataEntrega;

    public Atividade() {
    }

    public Atividade(Integer id, String titulo, String descricao, Integer materiaId, LocalDate
                             dataVencimento, String tipo, Double notaMaxima, Boolean avaliativa, Boolean entrega,
                     Boolean entregue, LocalDate dataEntrega) {
        this.id = id;
        this.titulo = titulo;
        this.descricao = descricao;
        this.materiaId = materiaId;
        this.dataVencimento = dataVencimento;
        this.tipo = tipo;
        this.notaMaxima = notaMaxima;
        this.avaliativa = avaliativa;
        this.entrega = entrega;
        this.entregue = entregue;
        this.dataEntrega = dataEntrega;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public Integer getMateriaId() {
        return materiaId;
    }

    public void setMateriaId(Integer materiaId) {
        this.materiaId = materiaId;
    }

    public LocalDate getDataVencimento() {
        return dataVencimento;
    }

    public void setDataVencimento(LocalDate dataVencimento) {
        this.dataVencimento = dataVencimento;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public Double getNotaMaxima() {
        return notaMaxima;
    }

    public void setNotaMaxima(Double notaMaxima) {
        this.notaMaxima = notaMaxima;
    }

    public Boolean getAvaliativa() {
        return avaliativa;
    }

    public void setAvaliativa(Boolean avaliativa) {
        this.avaliativa = avaliativa;
    }

    public Boolean getEntrega() {
        return entrega;
    }

    public void setEntrega(Boolean entrega) {
        this.entrega = entrega;
    }

    public Boolean getEntregue() {
        return entregue;
    }

    public void setEntregue(Boolean entregue) {
        this.entregue = entregue;
    }

    public LocalDate getDataEntrega() {
        return dataEntrega;
    }

    public void setDataEntrega(LocalDate dataEntrega) {
        this.dataEntrega = dataEntrega;
    }
}
