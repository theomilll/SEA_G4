import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

import br.gov.cesarschool.projetos.doador.Doador;
import br.gov.cesarschool.projetos.ong.ONG;

public class DAO {
    private String diretorioBase;

    public DAO(String diretorioBase) {
        this.diretorioBase = diretorioBase;
    }

    public boolean incluirDoador(Doador doador) {
        String nomeArquivo = diretorioBase + doador.getId() + ".txt";
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(nomeArquivo))) {
            writer.write("Nome: " + doador.getNome());
            writer.newLine();
            writer.write("Email: " + doador.getEmail());
            writer.newLine();
            writer.write("Telefone: " + doador.getTelefone());
            writer.newLine();
            writer.write("ID: " + doador.getId());
            writer.newLine();
            writer.write("Senha: " + doador.getSenha());
            writer.newLine();
            writer.write("CPF: " + doador.getCPF());
            writer.newLine();
            writer.write("Método de Pagamento: " + doador.getMetodoDePagamento());
            writer.newLine();

            return true;
        } catch (IOException e) {
            e.printStackTrace();
            return false;
        }
    }

    public boolean incluirONG(ONG ong) {
        String nomeArquivo = diretorioBase + ong.getId() + ".txt";
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(nomeArquivo))) {
            writer.write("Nome: " + ong.getNome());
            writer.newLine();
            writer.write("Email: " + ong.getEmail());
            writer.newLine();
            writer.write("Telefone: " + ong.getTelefone());
            writer.newLine();
            writer.write("ID: " + ong.getId());
            writer.newLine();
            writer.write("Senha: " + ong.getSenha());
            writer.newLine();
            writer.write("CNPJ: " + ong.getCNPJ());
            writer.newLine();
            writer.write("Descrição: " + ong.getDescricao());
            writer.newLine();
            writer.write("Número de Voluntários: " + ong.getNumeroVoluntarios());
            writer.newLine();

            return true;
        } catch (IOException e) {
            e.printStackTrace();
            return false;
        }
    }
    
    public boolean incluirDoacao(ONG ong, ItemDoacao itemDoacao) {
        String nomeArquivo = diretorioBase + ong.getId() + "_doacoes.txt";
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(nomeArquivo, true))) {
  
            writer.write("Doação:");
            writer.newLine();
            writer.write("Item: " + itemDoacao.getItem());
            writer.newLine();
            writer.write("Quantidade: " + itemDoacao.getQuantidade());
            writer.newLine();
            writer.newLine();

            return true;
        } catch (IOException e) {
            e.printStackTrace();
            return false;
        }
    }}
}
