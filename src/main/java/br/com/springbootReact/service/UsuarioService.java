package br.com.springbootReact.service;

import br.com.springbootReact.model.Usuario;

public interface UsuarioService {

	Usuario autenticar(String email, String senha);

	Usuario salvarUsuario(Usuario usuario);

	void validarEmail(String email);
}
