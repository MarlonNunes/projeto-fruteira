package com.fruteira.model;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="Clientes")
public class Cliente {
    
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    
    @Column( nullable= false)
    private String nome;
    
    @Column( nullable= false)
    private String endereco;
    
    @Column( nullable= false)
    private String numero;
    
    @OneToMany(mappedBy="cliente", cascade=CascadeType.ALL)
    private List<Compra> compras = new ArrayList<>();
    
    private BigDecimal divida;

    public Cliente(){

        this.divida = new BigDecimal("0");
    }

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

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }
    
    public List<Compra> getCompras() {
        return compras;
    }

    public void setCompras(List<Compra> compras) {
        this.compras = compras;
    }

    public BigDecimal getDivida() {
        return divida;
    }

    public void setAumentadivida(BigDecimal divida) {
        divida = divida.add(this.divida);
        this.divida = divida;
    }
    
    public void setDiminuidivida(BigDecimal divida) {
       
        this.divida = this.divida.subtract(divida);
    }
    
    
    
}
