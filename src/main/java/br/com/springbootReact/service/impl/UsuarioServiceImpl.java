package br.com.springbootReact.service.impl;

import br.com.springbootReact.exceptions.ErroAutenticacaoException;
import br.com.springbootReact.exceptions.RegraDeNegocioException;
import br.com.springbootReact.model.Usuario;
import br.com.springbootReact.repository.UsuarioRepository;
import br.com.springbootReact.service.UsuarioService;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UsuarioServiceImpl implements UsuarioService {

	@Autowired
	private UsuarioRepository repository;
	
	@Override
	public Usuario autenticar(String email, String senha) {
		Optional<Usuario> usuario = repository.findByEmail(email);
		if(usuario.isEmpty()) {
			throw new ErroAutenticacaoException("Usuario nao encontrado para o email informado");
		}
		if(!usuario.get().getSenha().equals(senha)) {
			throw new ErroAutenticacaoException("Senha invalida");
		}
		return usuario.get();
	}
	@Override
	@Transactional
	public Usuario salvarUsuario(Usuario usuario) {
		validarEmail(usuario.getEmail());//antes de salvar, validar o email do usuario
		return repository.save(usuario);
	}
	@Override
	public void validarEmail(String email) {
		boolean existe = repository.existsByEmail(email);
		if(existe) {
			throw new RegraDeNegocioException("Já existe um usuário cadastrado para esse email!");
		}
	}
}
