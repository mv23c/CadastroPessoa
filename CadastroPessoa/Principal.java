package TesteComHerança;

import javax.swing.JOptionPane;

public class Principal {
	private static Pessoa p;

	public static void main(String[] args) {
		p = new Pessoa();
		int opcao = 0, opcao1 = 0;

		do {
			opcao = apresentarMenu();
			switch (opcao) {
			case 1: {
				do {
					opcao1 = menuAddMembros();
					switch (opcao1) {
					case 1: {
						cadastrarPessoaFisica();
						System.out.println("Mostrar membros do cadastro: ");
						System.out.println(p.mostrarCadastro());
						break;
					}
					case 2: {
						cadastrarPessoaJuridica();
						System.out.println("Mostrar membros do cadastro: ");
						System.out.println(p.mostrarCadastro());
						break;
					}
					case 0: {
						break;
					}
					default:
						System.out.println("Opcão inválida!");
					}
				} while (opcao1 != 0);
				break;
			} 
			
			case 2: {
				removerMembroCadastro();
				System.out.println("Mostrar membros do cadastro: ");
				System.out.println(p.mostrarCadastro());
				break;
			}
			case 3: {
				pesquisarMembroComissao();
				break;
			}
			case 0: {
				break;
			}
			default:
				System.out.println("Opcão inválida!");
			}

		} while (opcao != 0);
	}

	public static void addMembroCadastro(Pessoa p) {
		boolean cadastrou = p.addMembro(p);
		if (cadastrou)
			JOptionPane.showMessageDialog(null, "Membro cadastrado com sucesso!");
	}
	
//	public static void cadastrarPessoaFisica() {
//		String nome = JOptionPane.showInputDialog("Informe o nome: ");
//		String cpf = JOptionPane.showInputDialog("Informe o cpf: ");
//		Pessoa p = new PessoaFisica(nome, cpf);
//		addMembroCadastro(p);	
//	}

//	public static void cadastrarPessoaFisica() {
//		String nome = JOptionPane.showInputDialog("informe o nome: ");
//		if (nome.equals("")) {
//			throw new CampoEmBrancoException("Campo em Branco");
//		}
//		String cpf = JOptionPane.showInputDialog("Informe o cpf: ");
//		if (cpf.equals("")) {
//			throw new CampoEmBrancoException("Campo em Branco");
//		}
//		Pessoa p = new PessoaFisica(nome, cpf);
//		addMembroCadastro(p);	
//	}


	public static void cadastrarPessoaFisica() {
		boolean repetir = false;
		String nome = null, cpf = null;
		do {
			repetir = false;
			try {
				String n = JOptionPane.showInputDialog("Informe o nome: ");
				if (n.equals("") | n.equals(null)) {
					throw new CampoEmBrancoException ("Campo em Branco");
				}
				nome = n;

				String c = JOptionPane.showInputDialog("Informe o cpf: ");
				if (c.equals("") | c.equals(null)) {
					throw new CampoEmBrancoException ("Campo em Branco"); 
				}
				cpf = c;
				
			} catch (NullPointerException | CampoEmBrancoException ex) {
				String msg = ex.getMessage();
				System.out.println("Exception " + msg);
				repetir = true;
			}
		} while (repetir);
		Pessoa p = new PessoaFisica(nome, cpf);
		addMembroCadastro(p);	
	}
	
	public static void cadastrarPessoaJuridica() {
		String nome = JOptionPane.showInputDialog("Informe o nome: ");
		String cnpj = JOptionPane.showInputDialog("Informe o cnpj: ");
		Pessoa p = new PessoaJuridica(nome, cnpj);
		addMembroCadastro(p);
	}

	public static void removerMembroCadastro() {
		String nome = JOptionPane.showInputDialog("Informe o nome do membro do cadastro que deseja excluir: ");
		Pessoa pessoa = p.findMembro(nome);
		if (p != null)
			p.delMembro(pessoa);
	}

	private static void pesquisarMembroComissao() {
		String nome = JOptionPane.showInputDialog("Informe o nome do membro que deseja pesquisar: ");
		Pessoa pessoa = p.findMembro(nome);
		if (pessoa != null) {
			JOptionPane.showMessageDialog(null, pessoa.getNome() + " está presente no cadastro");
		} else {
			JOptionPane.showMessageDialog(null, "não está cadastrado!");
		}	
	}

	private static int apresentarMenu() {
		int opcao = -1;
		boolean repetir = false;
		do {
			String strOpcao = JOptionPane.showInputDialog("Informe a opção desejada: \n"
					+ "1 - Adicionar membro ao cadastro \n"
					+ "2 - Remover membro do cadastro \n"
					+ "3 - Procurar membro no cadastro \n"
					+ "0 - Sair");

			try {
				opcao = Integer.parseInt(strOpcao);
				repetir = false;
			} catch (NumberFormatException ex) {
				System.out.println("Exceção do tipo " 
						+ ex.getClass().getName()
						+ " foi lançada!");
				//ex.printStackTrace();
				repetir = true;
			}
		} while (repetir);
		return opcao;
	}
	
	private static int menuAddMembros() {
		int opcao = -1;
		boolean repetir = false;
		do {
			String strOpcao = JOptionPane.showInputDialog("Informe a opção desejada: \n"
					+ "1 - Cadastrar Pessoa Física \n"
					+ "2 - Cadastrar Pessoa Jurídica \n"
					+ "0 - Sair");
			try {
				opcao = Integer.parseInt(strOpcao);
				repetir = false;
			} catch (NumberFormatException ex) {
				System.out.println("Exceção do tipo " 
						+ ex.getClass().getName()
						+ " foi lançada!");
				//ex.printStackTrace();
				repetir = true;
			}
		} while (repetir);
		return opcao;
	}
}
