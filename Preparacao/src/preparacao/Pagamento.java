package preparacao;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.DiscriminatorColumn;
import javax.persistence.DiscriminatorType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.Table;

@Entity
@Table(name = "pagamento")
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name = "tipo", length = 1, discriminatorType = DiscriminatorType.STRING)
public abstract class Pagamento implements Serializable {
    
    @Id
    @GeneratedValue
    private int id;
    @Column (name = "valor_pagamaneto")
    private double valorPagamento;

    public Pagamento() {
    }

    public Pagamento(double valorPagamento) {
        this.valorPagamento = valorPagamento;
    }

    public double getValorPagamento() {
        return valorPagamento;
    }

    public void setValorPagamento(double valorPagamento) {
        this.valorPagamento = valorPagamento;
    }

    @Override
    public String toString() {
        return "Pagamento{" + "id=" + id + ", valorPagamento=" + valorPagamento + '}';
    }
    
}
