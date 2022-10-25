package com.jancyaragao.jdevtreinamentos.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.jancyaragao.jdevtreinamentos.model.Usuario;
import com.jancyaragao.jdevtreinamentos.repository.UsuarioRepository;

@RequestMapping("/usuario")
@RestController
public class JdevtreinamentosController {

    @Autowired /* Injeção de dependência */
    private UsuarioRepository usuarioRepository;
    
    @GetMapping(value = "listar")
    @ResponseBody /* Retorna o dado para o corpo da resposta */
    public ResponseEntity<List<Usuario>> listar() {

        List<Usuario> usuarios = usuarioRepository.findAll(); /* Executa a consulta no banco de dados */

        return new ResponseEntity<List<Usuario>>(usuarios, HttpStatus.OK);

    }

    @PostMapping(value = "salvar") /* Mapeia a URL */
    @ResponseBody /* Descrição da resposta */
    public ResponseEntity<Usuario> salvar (@RequestBody Usuario usuario) {

        Usuario novoUsuario = usuarioRepository.save(usuario);
        
        return new ResponseEntity<Usuario>(novoUsuario, HttpStatus.CREATED);
    }

    @DeleteMapping(value = "deletar")
    @ResponseBody
    public ResponseEntity<String> deletar (@RequestParam Long id) {
        
        usuarioRepository.deleteById(id);

        return new ResponseEntity<String>("Usuário removido!", HttpStatus.OK);
    }

    @GetMapping(value = "buscarPorId")
    @ResponseBody
    public ResponseEntity<Usuario> buscarPorId (@RequestParam (name = "id") Long id) {

        Usuario usuario = usuarioRepository.findById(id).get();

        return new ResponseEntity<Usuario>(usuario, HttpStatus.OK);
    }

    @PutMapping(value = "atualizar")
    @ResponseBody
    public ResponseEntity<?> atualizar (@RequestBody Usuario usuario) {

        if (usuario.getId() == null) {
            return new ResponseEntity<String>("O ID do usuário não pode ser nulo", HttpStatus.OK);
        } 
        
        Usuario usuarioAtualizado = usuarioRepository.saveAndFlush(usuario);

        return new ResponseEntity<Usuario>(usuarioAtualizado, HttpStatus.OK);

    }
}