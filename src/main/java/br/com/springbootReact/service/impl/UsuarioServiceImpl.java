package br.com.springbootReact.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.springbootReact.exceptions.RegraDeNegocioException;
import br.com.springbootReact.model.Usuario;
import br.com.springbootReact.repository.UsuarioRepository;
import br.com.springbootReact.service.UsuarioService;

@Service
public class UsuarioServiceImpl implements UsuarioService {

	@Autowired
	private UsuarioRepository repository;
	
	@Override
	public Usuario autenticar(String email, String senha) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Usuario salvarUsuario(Usuario usuario) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void validarEmail(String email) {
		boolean existe = repository.existsByEmail(email);
		
		if(existe) {
			throw new RegraDeNegocioException("Já existe um usuário cadastrado para esse email!");
		}
		
	}


}
