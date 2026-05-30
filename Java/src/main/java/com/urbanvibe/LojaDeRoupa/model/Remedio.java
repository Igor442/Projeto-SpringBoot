package com.urbanvibe.LojaDeRoupa.model;

import com.urbanvibe.LojaDeRoupa.dto.DadosCadastroRemedio;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Table(name="remedio")
@Entity(name="Remedio")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor

public class Remedio {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nomeProduto;
    private double preco;
    private int quantidade;
    private String tipo;

    public Remedio(DadosCadastroRemedio dados) {
        this.nomeProduto=dados.nomeProduto();
        this.preco=dados.preco();
        this.tipo=dados.tipo();
        this.preco=dados.preco();
        this.quantidade=dados.quantidade();
    }
}
