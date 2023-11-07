package br.com.springbootReact.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "usuario", schema = "financas")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Usuario {

	@Id
	@Column
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@Column
	private String nome;
	@Column
	private String email;
	@Column
	private String senha;

	/*
	 * public Long getId() { return this.id; }
	 * 
	 * public void setId(Long id) { this.id = id; }
	 * 
	 * public String getNome() { return this.nome; }
	 * 
	 * public void setNome(String nome) { this.nome = nome; }
	 * 
	 * public String getEmail() { return this.email; }
	 * 
	 * public void setEmail(String email) { this.email = email; }
	 * 
	 * public String getSenha() { return this.senha; }
	 * 
	 * public void setSenha(String senha) { this.senha = senha; }
	 * 
	 * @Override public int hashCode() { final int prime = 31; int result = 1;
	 * result = prime * result + ((this.email == null) ? 0 : this.email.hashCode());
	 * result = prime * result + ((this.id == null) ? 0 : this.id.hashCode());
	 * result = prime * result + ((this.nome == null) ? 0 : this.nome.hashCode());
	 * result = prime * result + ((this.senha == null) ? 0 : this.senha.hashCode());
	 * return result; }
	 * 
	 * @Override public boolean equals(Object obj) { if (this == obj) return true;
	 * if (obj == null) return false; if (getClass() != obj.getClass()) return
	 * false; Usuario other = (Usuario) obj; if (this.email == null) { if
	 * (other.email != null) return false; } else if
	 * (!this.email.equals(other.email)) return false; if (this.id == null) { if
	 * (other.id != null) return false; } else if (!this.id.equals(other.id)) return
	 * false; if (this.nome == null) { if (other.nome != null) return false; } else
	 * if (!this.nome.equals(other.nome)) return false; if (this.senha == null) { if
	 * (other.senha != null) return false; } else if
	 * (!this.senha.equals(other.senha)) return false; return true; }
	 * 
	 * @Override public String toString() { return "Usuario [id=" + this.id +
	 * ", nome=" + this.nome + ", email=" + this.email + ", senha=" + this.senha +
	 * "]"; }
	 */

}
