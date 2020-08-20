package com.fruteira.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotBlank;


@Entity
public class Hortifruti {
    
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id_horti;
    
    @NotBlank
    private String nome;
    
    @NotBlank
    private double quilos;
    
    @NotBlank
    private double precoCompra;
    
    @NotBlank
    private double precoRevenda;
    
    @NotBlank
    private String tipo;

    public Integer getId_horti() {
        return id_horti;
    }

    public void setId_horti(Integer id_horti) {
        this.id_horti = id_horti;
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
