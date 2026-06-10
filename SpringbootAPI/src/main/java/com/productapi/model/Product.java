package com.productapi.model;

// Marca a classe java como uma entidade persistente que será mapeada para uma tabela de banco de dados
import jakarta.persistence.Entity;

// Essas classes são usadas juntas para especificar o valor da chave primária e como ele é gerado
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;

// Usado para marcar um campo como chave primária da entidade
import jakarta.persistence.Id;

// Usado para garantir que o campo anotado não esteja vazio
import jakarta.validation.constraints.NotEmpty;

@Entity
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @NotEmpty(message = "Informe um nome.")
    private String nome;
    private int quantidade;
    private double preco;
    private String status;

    // O ID é autoincrementado pelo próprio banco de dados!
    public Product(String nome, int quantidade, double preco, String status) {
        this.nome = nome;
        this.quantidade = quantidade;
        this.preco = preco;
        this.status = status;
    }

    public Product(){
        // Construtor vazio
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }

    public double getPreco() {
        return preco;
    }

    public void setPreco(double preco) {
        this.preco = preco;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
