package com.example.praticaseara2;

import jakarta.persistence.*;

import java.sql.Date;

@Entity
public class Transacao {

    public Transacao(String descricao, double valor, Date data_transacao, String tipo_transacao) {
        this.descricao = descricao;
        this.valor = valor;
        this.data_transacao = data_transacao;
        this.tipo_transacao = tipo_transacao;
    }
    public Transacao() {

    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String descricao;
    private double valor;
    private java.sql.Date data_transacao;
    private String tipo_transacao;

    public void setId(long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public double getValor() {
        return valor;
    }

    public void setValor(double valor) {
        this.valor = valor;
    }



    public Date getData_transacao() {
        return data_transacao;
    }

    public void setData_transacao(Date data_transacao) {
        this.data_transacao = data_transacao;
    }

    public String getTipo_transacao() {
        return tipo_transacao;
    }

    public void setTipo_transacao(String tipo_transacao) {
        this.tipo_transacao = tipo_transacao;
    }


//    @Override
//    public String toString() {
//        return "Transacao{" +
//                "id=" + id +
//                ", descricao='" + descricao + '\'' +
//                ", valor=" + valor +
//                ", data_transacao=" + data_transacao +
//                ", tipo_transacao='" + tipo_transacao + '\'' +
//                '}';
//    }
}
