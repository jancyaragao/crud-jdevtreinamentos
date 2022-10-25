package com.jancyaragao.jdevtreinamentos.controller;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class JdevtreinamentosController {
    
    @RequestMapping(value = "/mostranome/{nome}", method = RequestMethod.GET)
    @ResponseStatus(HttpStatus.OK)
    public String mostraNome(@PathVariable String nome) {
        return "Olá, " + nome + "!";
    }

    @RequestMapping(value = "/olamundo/{nome}", method = RequestMethod.GET)
    @ResponseStatus(HttpStatus.OK)
    public String mostraOlaMundo(@PathVariable String nome) {
        return "Olá, mundo de " + nome + "!";
    }
}
