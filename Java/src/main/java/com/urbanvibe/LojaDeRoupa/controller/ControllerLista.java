package com.urbanvibe.LojaDeRoupa.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.urbanvibe.LojaDeRoupa.dto.DadosCadastroRemedio;
import com.urbanvibe.LojaDeRoupa.model.Remedio;
import com.urbanvibe.LojaDeRoupa.repository.Remediorepository;

@CrossOrigin(origins = "http://127.0.0.1:3000")
@RestController
@RequestMapping("/lista")

public class ControllerLista {

    @Autowired
    private Remediorepository remediorepository;

    @PostMapping
    public void cadastrarRemedio(@RequestBody DadosCadastroRemedio dados ){
        System.out.println(dados);
        remediorepository.save(new Remedio(dados));
    }

    @GetMapping("/add")
    public void cadastrarRemedioViaGet(
            @RequestParam String nomeProduto,
            @RequestParam double preco,
            @RequestParam int quantidade,
            @RequestParam String tipo) {
        remediorepository.save(new Remedio(new DadosCadastroRemedio(nomeProduto, preco, quantidade, tipo)));
    }

    @DeleteMapping("/{id}")
    public void deletar(@PathVariable Long id) {
        remediorepository.deleteById(id);
        
    }

    @PutMapping("/{id}")
    public void atualizar(@PathVariable Long id, @RequestBody DadosCadastroRemedio dados) {
        Remedio remedioExistente = remediorepository.findById(id).orElse(null);
        if (remedioExistente != null) {
            remedioExistente.setNomeProduto(dados.nomeProduto());
            remedioExistente.setPreco(dados.preco());
            remedioExistente.setQuantidade(dados.quantidade());
            remedioExistente.setTipo(dados.tipo());
            remediorepository.save(remedioExistente);
        }
    }

    @GetMapping
    public  List<Remedio> listarRemedio(){
        return remediorepository.findAll();
    }

}
