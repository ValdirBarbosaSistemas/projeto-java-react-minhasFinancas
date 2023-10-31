package br.com.springbootReact.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.springbootReact.model.Usuario;

public interface UsuarioRepository extends JpaRepository<Usuario, Long> {

}
