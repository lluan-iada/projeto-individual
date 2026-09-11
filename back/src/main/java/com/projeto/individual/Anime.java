package com.projeto.individual;

import java.time.LocalDate;

public class Anime {
    private Integer id;
    private String titulo;
    private Integer episodios;
    private LocalDate dataConclusao;
    private Double nota;
    private String status;
    private String genero;
    // private String imagemUrl;

    // Havia pensado em colocar uma imagem com uma API externa do MyAnimeList, mas ela estava indisponivel

    public Anime() {
    }

    public Anime(Integer id, String titulo, Integer episodios, LocalDate dataConclusao, Double nota,
                 String status, String genero, String imagemUrl) {
        this.id = id;
        this.titulo = titulo;
        this.episodios = episodios;
        this.dataConclusao = dataConclusao;
        this.nota = nota;
        this.status = status;
        this.genero = genero;
       // this.imagemUrl = imagemUrl;
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

    public Integer getEpisodios() {
        return episodios;
    }

    public void setEpisodios(Integer episodios) {
        this.episodios = episodios;
    }

    public LocalDate getDataConclusao() {
        return dataConclusao;
    }

    public void setDataConclusao(LocalDate dataConclusao) {
        this.dataConclusao = dataConclusao;
    }

    public Double getNota() {
        return nota;
    }

    public void setNota(Double nota) {
        this.nota = nota;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getGenero() {
        return genero;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }

//    public String getImagemUrl() {
//        return imagemUrl;
//    }
//
//    public void setImagemUrl(String imagemUrl) {
//        this.imagemUrl = imagemUrl;
//    }
}
