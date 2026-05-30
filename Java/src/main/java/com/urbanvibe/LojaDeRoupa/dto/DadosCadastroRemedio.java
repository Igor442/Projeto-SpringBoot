package com.urbanvibe.LojaDeRoupa.dto;

public record DadosCadastroRemedio(
        String nomeProduto,
        double preco,
        int quantidade,
        String tipo
        ) {
}
