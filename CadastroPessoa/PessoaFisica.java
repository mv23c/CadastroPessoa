package TesteComHerança;

public class PessoaFisica extends Pessoa {
	String cpf;

	public String getCpf() {
		return cpf;
	}
	
	public PessoaFisica(String nome, String cpf) {
		this.nome = nome;
		this.cpf = cpf;
	}
}
