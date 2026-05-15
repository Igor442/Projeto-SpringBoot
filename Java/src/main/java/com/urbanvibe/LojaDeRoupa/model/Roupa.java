package com.urbanvibe.LojaDeRoupa.model;

import com.urbanvibe.LojaDeRoupa.dto.DadosCadastroRoupas;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Table(name="roupa")
@Entity(name="Roupa")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor

public class Roupa {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nomeProduto;
    private String marca;
    @Enumerated(EnumType.STRING)
    private Tamanho tamanho;
    private double preco;
    private int quantidade;

    public Roupa(DadosCadastroRoupas dados) {
        this.nomeProduto=dados.nomeProduto();
        this.marca=dados.marca();
        this.tamanho=dados.tamanho();
        this.preco=dados.preco();
        this.quantidade=dados.quantidade();
    }
}
