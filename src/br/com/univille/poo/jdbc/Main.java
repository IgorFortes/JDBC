package br.com.univille.poo.jdbc;

import java.util.Date;

public class Main {

	public static void main(String[] args) {
		PessoaDAO contructDaoPessoa = new PessoaDAO();
		TarefaDAO contructDaoTarefa = new TarefaDAO();
		
		//Criação
		Pessoa Igor = new Pessoa();
		Tarefa primeira = new Tarefa();
		
		//Inserção
		Igor.setId(1);
		Igor.setNome("Igor");
		Igor.setFuncao("Analista");
		contructDaoPessoa.insert(Igor);
		
		primeira.setNumero(1010);
		primeira.setData_abertura(new Date());
		primeira.setEstado(1);
		primeira.setId_responsavel(1);
		primeira.setTitulo("Primeira tarefa");
		contructDaoTarefa.insert(primeira);
		
		
		//Impressão
		System.out.println(contructDaoPessoa.getPorId(1));
		
		//Atualização
		Igor.setFuncao("Desenvolvedor");
		contructDaoPessoa.update(Igor);
		
		//Impressão
		System.out.println(contructDaoPessoa.getPorId(1));
		
		//Exclusão
		contructDaoTarefa.delete(primeira);
		contructDaoPessoa.delete(Igor);
		

	}

}
