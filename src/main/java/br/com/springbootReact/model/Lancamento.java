package br.com.springbootReact.model;

import java.math.BigDecimal;
import java.time.LocalDate;

import org.springframework.data.jpa.convert.threeten.Jsr310JpaConverters;

import br.com.springbootReact.enums.StatusLancamento;
import br.com.springbootReact.enums.TipoLancamento;
import jakarta.persistence.Column;
import jakarta.persistence.Convert;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Builder;
import lombok.Data;

@Entity
@Table(name = "lancamento", schema = "financas")
@Data
@Builder
public class Lancamento {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column
	private Long id;
	@Column
	private String descricao;
	@Column
	private Integer mes;
	@Column
	private Integer ano;
	@ManyToOne
	@JoinColumn(name = "id_usuario")
	private Usuario usurio;
	@Column
	private BigDecimal valor;
	@Column(name = "data_cadastro")
	@Convert(converter = Jsr310JpaConverters.LocalDateConverter.class) // Convertendo a data de acordo com o do banco
	private LocalDate dataCadastro;
	@Column
	@Enumerated(EnumType.STRING) // Aqui diz que o campo é do tipo enumeracao
	private TipoLancamento tipo;
	@Column
	@Enumerated(EnumType.STRING)
	private StatusLancamento status;

	/*
	 * public Long getId() { return this.id; }
	 * 
	 * public void setId(Long id) { this.id = id; }
	 * 
	 * public String getDescricao() { return this.descricao; }
	 * 
	 * public void setDescricao(String descricao) { this.descricao = descricao; }
	 * 
	 * public Integer getMes() { return this.mes; }
	 * 
	 * public void setMes(Integer mes) { this.mes = mes; }
	 * 
	 * public Integer getAno() { return this.ano; }
	 * 
	 * public void setAno(Integer ano) { this.ano = ano; }
	 * 
	 * public Usuario getUsurio() { return this.usurio; }
	 * 
	 * public void setUsurio(Usuario usurio) { this.usurio = usurio; }
	 * 
	 * public BigDecimal getValor() { return this.valor; }
	 * 
	 * public void setValor(BigDecimal valor) { this.valor = valor; }
	 * 
	 * public LocalDate getDataCadastro() { return this.dataCadastro; }
	 * 
	 * public void setDataCadastro(LocalDate dataCadastro) { this.dataCadastro =
	 * dataCadastro; }
	 * 
	 * public TipoLancamento getTipo() { return this.tipo; }
	 * 
	 * public void setTipo(TipoLancamento tipo) { this.tipo = tipo; }
	 * 
	 * public StatusLancamento getStatus() { return this.status; }
	 * 
	 * public void setStatus(StatusLancamento status) { this.status = status; }
	 * 
	 * @Override public int hashCode() { final int prime = 31; int result = 1;
	 * result = prime * result + ((this.ano == null) ? 0 : this.ano.hashCode());
	 * result = prime * result + ((this.dataCadastro == null) ? 0 :
	 * this.dataCadastro.hashCode()); result = prime * result + ((this.descricao ==
	 * null) ? 0 : this.descricao.hashCode()); result = prime * result + ((this.id
	 * == null) ? 0 : this.id.hashCode()); result = prime * result + ((this.mes ==
	 * null) ? 0 : this.mes.hashCode()); result = prime * result + ((this.status ==
	 * null) ? 0 : this.status.hashCode()); result = prime * result + ((this.tipo ==
	 * null) ? 0 : this.tipo.hashCode()); result = prime * result + ((this.usurio ==
	 * null) ? 0 : this.usurio.hashCode()); result = prime * result + ((this.valor
	 * == null) ? 0 : this.valor.hashCode()); return result; }
	 * 
	 * @Override public boolean equals(Object obj) { if (this == obj) return true;
	 * if (obj == null) return false; if (getClass() != obj.getClass()) return
	 * false; Lancamento other = (Lancamento) obj; if (this.ano == null) { if
	 * (other.ano != null) return false; } else if (!this.ano.equals(other.ano))
	 * return false; if (this.dataCadastro == null) { if (other.dataCadastro !=
	 * null) return false; } else if (!this.dataCadastro.equals(other.dataCadastro))
	 * return false; if (this.descricao == null) { if (other.descricao != null)
	 * return false; } else if (!this.descricao.equals(other.descricao)) return
	 * false; if (this.id == null) { if (other.id != null) return false; } else if
	 * (!this.id.equals(other.id)) return false; if (this.mes == null) { if
	 * (other.mes != null) return false; } else if (!this.mes.equals(other.mes))
	 * return false; if (this.status != other.status) return false; if (this.tipo !=
	 * other.tipo) return false; if (this.usurio == null) { if (other.usurio !=
	 * null) return false; } else if (!this.usurio.equals(other.usurio)) return
	 * false; if (this.valor == null) { if (other.valor != null) return false; }
	 * else if (!this.valor.equals(other.valor)) return false; return true; }
	 * 
	 * @Override public String toString() { return "Lancamento [id=" + this.id +
	 * ", descricao=" + this.descricao + ", mes=" + this.mes + ", ano=" + this.ano +
	 * ", usurio=" + this.usurio + ", valor=" + this.valor + ", dataCadastro=" +
	 * this.dataCadastro + ", tipo=" + this.tipo + ", status=" + this.status + "]";
	 * }
	 */

}
