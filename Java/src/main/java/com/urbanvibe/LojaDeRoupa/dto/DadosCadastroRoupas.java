package com.urbanvibe.LojaDeRoupa.dto;

import com.urbanvibe.LojaDeRoupa.model.Tamanho;

public record DadosCadastroRoupas(
        String nomeProduto,
        String marca,
        Tamanho tamanho,
        double preco,
        int quantidade
        ) {
}
