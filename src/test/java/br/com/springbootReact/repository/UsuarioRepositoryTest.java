package br.com.springbootReact.repository;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;

import br.com.springbootReact.model.Usuario;

@SpringBootTest
@ActiveProfiles("test")
public class UsuarioRepositoryTest {
	/**
	 * Teste de integracao e um teste onde e necessario se ter todo o projeto
	 * criado, ou seja, precisa de recursos externos a aplicacao. Como estamos
	 * acessando a base de dados, precisa que exista a base de dados configurada,
	 * com as tabelas criadas. TODA classe de teste, e necessario se ter o nome
	 * "teste" no final de cada nome de arquivo. Tambem que o pacote seja o mesmo da
	 * parte real do projeto. E tambem tem que ter duas annotations acima do teste
	 * que sera realizado que e o "@RunWith" e o "@Springboottest".
	 */
	
	@Autowired
	UsuarioRepository repository;
	
	
	@Test
	public void deveVerificarExistenciaDeEmail() {
		//Em todo teste, temos que ter tres cenarios que sao: CENARIO, ACAO/EXECUCAO e VERIFICACAO
		
		//cenario
		Usuario usuario = Usuario.builder().nome("usuario").email("email@gmail.com").build();
		repository.save(usuario);
		
		//acao/execucao
		boolean result = repository.existsByEmail("email@gmail.com");
		
		//verificacao
		Assertions.assertThat(result).isTrue();//afirme que o resultado e verdadeiro
	}
	
	@Test
	public void deveRetornarFalsoQuandoNaoHouverUsuarioCadastradoComEmail() {
		//cenario
		repository.deleteAll();
		
		//acao
		boolean result = repository.existsByEmail("email@gmail.com");
		
		//verificacao
		Assertions.assertThat(result).isFalse();//afirme que o resultado e falso
	}
}
