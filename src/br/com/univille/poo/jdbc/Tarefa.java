package br.com.univille.poo.jdbc;

import java.util.Date;

public class Tarefa {
	
	private int numero;
	private int estado;
	private Date data_abertura;
	private int id_responsavel;
	private String titulo;
	private String descricao;
	
	public int getNumero() {
		return numero;
	}
	public void setNumero(int numero) {
		this.numero = numero;
	}
	public int getEstado() {
		return estado;
	}
	public void setEstado(int estado) {
		this.estado = estado;
	}
	public Date getData_abertura() {
		return data_abertura;
	}
	public void setData_abertura(Date data_abertura) {
		this.data_abertura = data_abertura;
	}
	public int getId_responsavel() {
		return id_responsavel;
	}
	public void setId_responsavel(int id_responsavel) {
		this.id_responsavel = id_responsavel;
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
	
}
