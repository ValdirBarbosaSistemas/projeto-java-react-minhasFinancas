package br.com.springbootReact.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.springbootReact.model.Usuario;

@Repository
public interface UsuarioRepository extends JpaRepository<Usuario, Long> {

	/**
	 * Quando utilizamos o Optional, quer dizer que ele pode existir ou não, ou
	 * seja, se existir ele mostra o resultado, caso não, ele não vai mostrar nada.
	 * 
	 * Optional<Usuario> findByEmail(String email);
	 *
	 */

	
	boolean existsByEmail(String email);
}
