package br.com.springbootReact.service;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase.Replace;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.context.ActiveProfiles;

import br.com.springbootReact.exceptions.RegraDeNegocioException;
import br.com.springbootReact.model.Usuario;
import br.com.springbootReact.repository.UsuarioRepository;

//@SpringBootTest
@ActiveProfiles("test")
@DataJpaTest
@AutoConfigureTestDatabase(replace = Replace.NONE) // Aqui ele nao vai modificar nada do banco de configuracao
public class UsuarioServiceTest {

	@Autowired
	UsuarioService service;
	@Autowired
	UsuarioRepository repository;

	/**
	 * Com o dataJpaTest nao se faz a necessidade de deletar todos os usuarios e nem
	 * de utilizar o repository padrao do sistema. Pois dentro dele se tem uma
	 * transacao feita pra testes nao precisando mais deletar o usuario.
	 */

	TestEntityManager entityManager; //utilizando agora outra forma de transacao
	
	@Test()
	public void deveValidarEmail() {
		// cenario
		//repository.deleteAll();

		// acao
		service.validarEmail("email@email.com");
	}

	@Test
	public void deveLancarErroAoValidarEmailQuandoExistirEmailCadastrado() {
		// cenario
		Usuario usuario = Usuario.builder().nome("teste").email("testeemail@gmail.com").build();
		//repository.save(usuario);
		entityManager.persist(usuario);

		// acao
		Assertions.assertThrows(RegraDeNegocioException.class, () -> {
			service.validarEmail("testeemail@gmail.com");
		});
	}
	
	@Test
	public void devePersistirUmUsuarioNaBaseDeDados() {
		//cenario
		Usuario usuario = Usuario
				.builder()
				.nome("teste2")
				.email("teste@email.com")
				.senha("123")
				.build();
		
		//acao
		Usuario usuarioSalvo = repository.save(usuario);
		
		org.assertj.core.api.Assertions.assertThat(usuarioSalvo.getId()).isNotNull();
	}
}
