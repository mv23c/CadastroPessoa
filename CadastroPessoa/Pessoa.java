package TesteComHerança;

import java.util.List;
import java.util.LinkedList;

public class Pessoa {
	String nome;
	static List<Pessoa> membros = new LinkedList<Pessoa>();

	public Pessoa() {} 

	public Pessoa(String nome) {
		this.nome = nome;
	}

	public String getNome() {
		return nome;
	}

	public boolean addMembro(Pessoa p) {
		boolean adicionado = membros.add(p);
		return adicionado;
	}

	public boolean delMembro(Pessoa p) {
		boolean excluido = membros.remove(p);
		return excluido;
	}

	public Pessoa findMembro(String nome) {
		for (Pessoa p: membros) {
			if (p.getNome().equalsIgnoreCase(nome))
				return p;
		}
		return null;
	}

	public String mostrarCadastro() {
		String resposta = "";
		for (Pessoa p: membros) {
			resposta += p.getNome() + '\n';
		}
		return resposta;
	}
}
