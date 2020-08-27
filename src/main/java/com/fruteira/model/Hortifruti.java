package com.fruteira.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;


@Entity
public class Hortifruti {
    
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    
    @NotNull
    private String nome;
    
    @NotNull
    private double quilos;
    
    @NotNull
    private double precoCompra;
    
    @NotNull
    private double precoRevenda;
    
    @NotNull
    private String tipo;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public double getQuilos() {
        return quilos;
    }

    public void setQuilos(double quilos) {
        this.quilos = quilos;
    }

    public double getPrecoCompra() {
        return precoCompra;
    }

    public void setPrecoCompra(double precoCompra) {
        this.precoCompra = precoCompra;
    }

    public double getPrecoRevenda() {
        return precoRevenda;
    }

    public void setPrecoRevenda(double precoRevenda) {
        this.precoRevenda = precoRevenda;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }
    
    
}
