package br.com.springbootReact.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.springbootReact.model.Lancamento;

public interface LancamentoRepository extends JpaRepository<Lancamento, Long>{

}
