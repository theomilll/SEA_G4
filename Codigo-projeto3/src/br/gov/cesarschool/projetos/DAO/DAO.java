package br.gov.cesarschool.projetos.DAO;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;
import java.util.ArrayList;

import java.io.BufferedReader;
import java.io.FileReader;
import br.gov.cesarschool.projetos.doador.Doador;
import br.gov.cesarschool.projetos.doador.ItemDoacao;
import br.gov.cesarschool.projetos.necessidade.Necessidade;
import br.gov.cesarschool.projetos.ong.ONG;

public class DAO {
    private String diretorioBase;

    public DAO(String diretorioBase) {
        this.diretorioBase = diretorioBase;
    }

    public boolean incluirDoador(Doador doador) {
        String nomeArquivo = diretorioBase + doador.getNome() + ".txt";
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(nomeArquivo))) {
            writer.write("Nome: " + doador.getNome());
            writer.newLine();
            writer.write("Email: " + doador.getEmail());
            writer.newLine();
            writer.write("Telefone: " + doador.getTelefone());
            writer.newLine();
            writer.write("ID: " + doador.getId());
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
        String nomeArquivo = diretorioBase + ong.getNome() + ".txt";
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(nomeArquivo))) {
            writer.write("Nome: " + ong.getNome());
            writer.newLine();
            writer.write("Email: " + ong.getEmail());
            writer.newLine();
            writer.write("Telefone: " + ong.getTelefone());
            writer.newLine();
            writer.write("ID: " + ong.getId());
            writer.newLine();
            writer.write("CNPJ: " + ong.getCNPJ());
            writer.newLine();
            writer.write("Descrição: " + ong.getDescricao());
            writer.newLine();
            writer.write("Número de Voluntários: " + ong.getNumeroVoluntarios());
            writer.newLine();
            writer.newLine();
            writer.write("Necessidades:");

            return true;
        } catch (IOException e) {
            e.printStackTrace();
            return false;
        }
    }
    
    public boolean incluirDoacao(ONG ong, ItemDoacao itemDoacao) {
        String nomeArquivo = diretorioBase + ong.getNome() + "_doacoes.txt";
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
    }
    
    public void incluirNecessidade(ONG ong, Necessidade necessidade) {
        String nomeArquivo = diretorioBase + ong.getNome() + ".txt";
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(nomeArquivo, true))) {
        	writer.newLine();
            writer.write("Categoria: " + necessidade.getCategoria());
            writer.newLine();
            writer.write("Quantidade: " + necessidade.getQuantidade());
            writer.newLine();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    
    public String[] lerNecessidades(ONG ong) {
        String nomeArquivo = diretorioBase + ong.getNome() + ".txt";
        List<String> necessidadesList = new ArrayList<>();

        try (BufferedReader reader = new BufferedReader(new FileReader(nomeArquivo))) {
            String line;
            boolean readNecessidades = false;

            while ((line = reader.readLine()) != null) {
                if (line.startsWith("Categoria:")) {
                    String categoria = line.substring(line.indexOf(":") + 1).trim();
                    necessidadesList.add(categoria);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        String[] necessidadesArray = new String[necessidadesList.size()];
        return necessidadesList.toArray(necessidadesArray);
    }



    
  }

