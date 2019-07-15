package br.com.gabricio.models;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.Length;
import org.springframework.format.annotation.DateTimeFormat;


@Entity
@Table(name = "tarefas")
public class Tarefa {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private Long id;
	
	@Column(name = "titulo", length = 50, nullable = false)
	@NotNull(message="O título é obrigatório")
	@Length(max=50, min = 3, message = "O título deve conter entre 3 a 50 caracteres")
	private String titulo;
	
	@Column(name = "descricao", length = 100, nullable = true)
	@Length(max = 100, min = 3, message = "O descrição deve conter entre 3 a 100 caracteres")
	private String descricao;
	
	@Column(name = "data_expiracao", nullable = false)
	
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date dataExpiracao;
	
	@Column(name = "concluida", nullable = false)
	private Boolean concluida = false;

	public Tarefa() {
		super();
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public Date getDataExpiracao() {
		return dataExpiracao;
	}

	public void setDataExpiracao(Date dataExpiracao) {
		this.dataExpiracao = dataExpiracao;
	}

	public Boolean getConcluida() {
		return concluida;
	}

	public void setConcluida(Boolean concluida) {
		this.concluida = concluida;
	}

}