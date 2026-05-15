package com.urbanvibe.LojaDeRoupa.controller;

import com.urbanvibe.LojaDeRoupa.dto.DadosCadastroRoupas;
import com.urbanvibe.LojaDeRoupa.model.Roupa;
import com.urbanvibe.LojaDeRoupa.repository.Rouparepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/roupa")

public class ControllerRoupa {

    @Autowired
    private Rouparepository rouparepository;

    @PostMapping
    public void cadastrarRoupa(@RequestBody DadosCadastroRoupas dados ){
        System.out.println(dados);
        rouparepository.save(new Roupa(dados));
    }

    @GetMapping
    public  List<Roupa> listarRoupas(){
        return rouparepository.findAll();
    }

}
