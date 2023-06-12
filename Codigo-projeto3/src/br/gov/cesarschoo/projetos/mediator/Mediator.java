package br.gov.cesarschoo.projetos.mediator;


import br.gov.cesarschool.projetos.DAO.*;
import br.gov.cesarschool.projetos.doador.Doador;
import br.gov.cesarschool.projetos.doador.ItemDoacao;
import br.gov.cesarschool.projetos.endereco.Endereco;
import br.gov.cesarschool.projetos.necessidade.*;
import br.gov.cesarschool.projetos.ong.ONG;
import br.gov.cesarschool.projetos.usuario.*;
import br.gov.cesarschool.projetos.util.ValidadorCNPJ;
import br.gov.cesarschool.projetos.util.ValidadorCPF;

public class Mediator {
    private static Mediator instance;
    private DAO arquivoDAO;

    private Mediator() {
        arquivoDAO = new DAO("SEA_");
    }

    public static Mediator getInstance() {
        if (instance == null) {
            instance = new Mediator();
        }
        return instance;
    }


    public boolean incluirONG(ONG ong) {
        if (validarInformacoesONG(ong)) {
            return arquivoDAO.incluirONG(ong);
        }
        return false;
    }

    private boolean validarInformacoesDoador(Doador doador) {
    	validarInformacoesUsuario(doador);
        if (doador.getCPF() == null || doador.getCPF().isEmpty()) {
            System.out.println("CPF do doador inválido.");
            return false;
        }

        if (!ValidadorCPF.ehCpfValido(doador.getCPF())) {
            System.out.println("CPF do doador inválido.");
            return false;
        }

        if (doador.getMetodoDePagamento() == null || doador.getMetodoDePagamento().isEmpty()) {
            System.out.println("Método de pagamento do doador inválido.");
            return false;
        }


        return true;
    }
    


    private boolean validarInformacoesONG(ONG ong) {
        
    	validarInformacoesUsuario(ong);

        if (ong.getCNPJ() == null || ong.getCNPJ().isEmpty()) {
            System.out.println("CNPJ da ONG branco ou nulo.");
            return false;
        }
        if (!ValidadorCNPJ.validarCNPJ(ong.getCNPJ())) {
            System.out.println("CNPJ da ONG inválido.");
            return false;
        }

        if (ong.getDescricao() == null || ong.getDescricao().isEmpty()) {
            System.out.println("Descrição da ONG inválida.");
            return false;
        }

        if (ong.getNumeroVoluntarios() <= 0) {
            System.out.println("Número de voluntários da ONG inválido.");
            return false;
        }


        return true;
    }
    private boolean validarInformacoesUsuario(Usuario usuario) {
    	  if (usuario.getNome() == null || usuario.getNome().isEmpty()) {
              System.out.println("Nome do Usuário inválido.");
              return false;
          }

          if (usuario.getEmail() == null || usuario.getEmail().isEmpty() ) {
              System.out.println("Email do Usuário inválido.");
              return false;
          }

          if (usuario.getTelefone() == null || usuario.getTelefone().isEmpty() ) {
              System.out.println("Telefone do Usuário inválido.");
              return false;
          }

          if (usuario.getId() < 0) {
              System.out.println("Id do Usuário inválido.");
              return false;
          }
          return true;
    }
    

    private boolean validarInformacoesDoacao(ItemDoacao doacao, ONG ong) {
        if (doacao.getItem() == null) {
            System.out.println("Item da doação inválido.");
            return false;
        }
        if (doacao.getQuantidade() <= 0) {
            System.out.println("Quantidade da doação inválida.");
            return false;
        }

        // Read needs from the file
        String[] necessidadesArray = arquivoDAO.lerNecessidades(ong);
        Integer[] quantidadesArray = arquivoDAO.lerQuantidades(ong);
        
        for (int i = 0; i < necessidadesArray.length; i++) {
            if (doacao.getItem().equalsIgnoreCase(necessidadesArray[i]) && doacao.getQuantidade() <= quantidadesArray[i]) {
            	arquivoDAO.atualizarNecessidade(ong, doacao);
                return true;
            }
        }

        System.out.println("Item da doação não corresponde a nenhuma necessidade ou quantidade insuficiente.");
        return false;
    }



    
    
    

    public boolean inserirDoador(Doador doador) {
        if (validarInformacoesDoador(doador) != false) {
        	arquivoDAO.incluirDoador(doador);
        	return true;
        }
        else {
        	System.out.println("Erro ao incluir doador");
        	return false;
        }
    }
    
    public boolean inserirONG(ONG ong) {
        if (validarInformacoesONG(ong) != false) {
        	arquivoDAO.incluirONG(ong);
        	return true;
        }
        else {
        	System.out.println("Erro ao incluir ONG");
        	return false;
        }
    }
    
    
    public boolean inserirDoacao(ItemDoacao doacao,ONG ong) {
        if (validarInformacoesDoacao(doacao, ong)!= false) {
        	arquivoDAO.incluirDoacao(ong,doacao);
        	return true;
        }
        else {
        	System.out.println("Erro ao incluir Doacao");
        	return false;
        }
    }
    
    
    public void inserirNecessidade(ONG ong, Necessidade necessidade) {
        arquivoDAO.incluirNecessidade(ong, necessidade);
    }
    
    
    


}
