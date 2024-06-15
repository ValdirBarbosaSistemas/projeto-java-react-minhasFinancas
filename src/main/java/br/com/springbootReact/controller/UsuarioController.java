package br.com.springbootReact.controller;

import br.com.springbootReact.dto.UsuarioDTO;
import br.com.springbootReact.exceptions.RegraDeNegocioException;
import br.com.springbootReact.model.Usuario;
import br.com.springbootReact.service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/usuarios")
public class UsuarioController {
    @Autowired
    private UsuarioService service;

    @PostMapping("/novoUsuario")
    public ResponseEntity salvarUsuario(@RequestBody UsuarioDTO usuarioDTO) {
        Usuario usuario = Usuario
                .builder()
                .nome(usuarioDTO.getNome())
                .email(usuarioDTO.getEmail())
                .senha(usuarioDTO.getSenha())
                .build();
        try {
            Usuario usuarioSalvo = service.salvarUsuario(usuario);
            return new ResponseEntity(usuarioSalvo, HttpStatus.CREATED);
        } catch (RegraDeNegocioException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }
}