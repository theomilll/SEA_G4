package br.gov.cesarschool.projetos.DAO;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;
import java.util.ArrayList;

import java.io.File;

import java.io.BufferedReader;
import java.io.FileReader;
import br.gov.cesarschool.projetos.doador.Doador;
import br.gov.cesarschool.projetos.doador.ItemDoacao;
import br.gov.cesarschool.projetos.endereco.Endereco;
import br.gov.cesarschool.projetos.necessidade.Necessidade;
import br.gov.cesarschool.projetos.ong.ONG;


public class DAO {
    private String diretorioBase;

    public DAO(String diretorioBase) {
        this.diretorioBase = diretorioBase;
    }

    public boolean incluirDoador(Doador doador) {
        String nomeArquivo = diretorioBase + doador.getCPF() + ".txt";
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

            return true;
        } catch (IOException e) {
            e.printStackTrace();
            return false;
        }
    }

    public boolean incluirONG(ONG ong) {
        String nomeArquivo = diretorioBase + ong.getCNPJ() + ".txt";
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
        String nomeArquivo = diretorioBase + ong.getCNPJ() + "_doacoes.txt";
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
    
    public boolean incluirDoacao(ONG ong, ItemDoacao itemDoacao, Doador doador) {
        String nomeArquivo = diretorioBase + ong.getCNPJ() + "_DOACOES.txt";
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(nomeArquivo, true))) {
            writer.write("Doação:");
            writer.newLine();
            writer.write("Item: " + itemDoacao.getItem());
            writer.newLine();
            writer.write("Quantidade: " + itemDoacao.getQuantidade());
            writer.newLine();
            writer.write("Nome do doador: " + doador.getNome());
            writer.newLine();
            writer.newLine();

            return true;
        } catch (IOException e) {
            e.printStackTrace();
            return false;
        }
    }

    
    public void incluirNecessidade(ONG ong, Necessidade necessidade) {
        String nomeArquivo = diretorioBase + ong.getCNPJ() + ".txt";
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
        String nomeArquivo = diretorioBase + ong.getCNPJ() + ".txt";
        List<String> necessidadesList = new ArrayList<>();

        try (BufferedReader reader = new BufferedReader(new FileReader(nomeArquivo))) {
            String line;

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
    
    public Integer[] lerQuantidades(ONG ong) {
        String nomeArquivo = diretorioBase + ong.getCNPJ() + ".txt";
        List<Integer> quantidadesList = new ArrayList<>();

        try (BufferedReader reader = new BufferedReader(new FileReader(nomeArquivo))) {
            String line;

            while ((line = reader.readLine()) != null) {
                if (line.startsWith("Quantidade:")) {
                    String quantidadeStr = line.substring(line.indexOf(":") + 1).trim();
                    int quantidade = Integer.parseInt(quantidadeStr);
                    quantidadesList.add(quantidade);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        return quantidadesList.toArray(new Integer[quantidadesList.size()]);
    }
    
    public void atualizarNecessidade(ONG ong, ItemDoacao doacao) {
        String nomeArquivo = diretorioBase + ong.getCNPJ() + ".txt";
        File arquivo = new File(nomeArquivo);
        List<String> linhas = new ArrayList<>();

        try (BufferedReader reader = new BufferedReader(new FileReader(arquivo))) {
            String linha;
            while ((linha = reader.readLine()) != null) {
                if (linha.equalsIgnoreCase("Categoria: " + doacao.getItem())) {
                    String proximaLinha = reader.readLine();

                    int indiceSeparador = proximaLinha.indexOf(":");
                    if (indiceSeparador != -1) {
                        String conteudo = proximaLinha.substring(indiceSeparador + 1).trim();

                        int quantidadeNecessidade = Integer.parseInt(conteudo);

                        int novaQuantidade = quantidadeNecessidade - doacao.getQuantidade();

                        if (novaQuantidade > 0) {
                          
                            linhas.add(linha);
                            linhas.add("Quantidade: " + novaQuantidade);
                        }
                        continue;
                    }
                }
                linhas.add(linha);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        try (FileWriter writer = new FileWriter(arquivo)) {
            for (String linha : linhas) {
                writer.write(linha);
                writer.write(System.lineSeparator());
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    
    public Doador buscarDoadorPorCPF(String cpf) {		
        String nomeArquivo = diretorioBase + cpf + ".txt";
        File arquivo = new File(nomeArquivo);

        if (!arquivo.exists()) {
            return null;
        }

        try (BufferedReader reader = new BufferedReader(new FileReader(arquivo))) {
            String nome = null;
            String email = null;
            String telefone = null;
            int id = 0;
            Endereco endereco = null;
            String metodoDePagamento = null;

            String linha;
            while ((linha = reader.readLine()) != null) {
                String[] partes = linha.split(":");
                if (partes.length == 2) {
                    String chave = partes[0].trim();
                    String valor = partes[1].trim();

                    switch (chave) {
                        case "Nome":
                            nome = valor;
                            break;
                        case "Email":
                            email = valor;
                            break;
                        case "Telefone":
                            telefone = valor;
                            break;
                        case "ID":
                            id = Integer.parseInt(valor);
                            break;
                        case "Endereco":
                            break;
                        case "CPF":
                            if (valor.equals(cpf)) {
                                return new Doador(nome, email, telefone, id, endereco, cpf, metodoDePagamento);
                            } else {
                            	System.out.print("CPF não corresponde");
                                return null;
                            }
                        case "Método de Pagamento":
                            metodoDePagamento = valor;
                            break;
                        default:
 
                            break;
                    }
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        return null;
    }
    
    public ONG buscarONGPorCNPJ(String cnpj) {
        String nomeArquivo = diretorioBase + cnpj + ".txt";
        File arquivo = new File(nomeArquivo);

        if (arquivo.exists()) {
            try (BufferedReader reader = new BufferedReader(new FileReader(arquivo))) {
                String nome = null;
                String email = null;
                String telefone = null;
                int id = 0;
                Endereco endereco = null;
                int numeroVoluntarios = 0;
                Necessidade necessidade = null;

                String linha;
                while ((linha = reader.readLine()) != null) {
                    if (linha.startsWith("Nome:")) {
                        nome = linha.substring(5).trim();
                    } else if (linha.startsWith("Email:")) {
                        email = linha.substring(6).trim();
                    } else if (linha.startsWith("Telefone:")) {
                        telefone = linha.substring(9).trim();
                    } else if (linha.startsWith("ID:")) {
                        id = Integer.parseInt(linha.substring(3).trim());
                    } else if (linha.startsWith("Endereco:")) {
   
                    } else if (linha.startsWith("NumeroVoluntarios:")) {
                        numeroVoluntarios = Integer.parseInt(linha.substring(18).trim());
                    } else if (linha.startsWith("Necessidade:")) {
     
                    }
                }


                ONG ong = new ONG(nome, email, telefone, id, endereco, cnpj,  numeroVoluntarios, necessidade);
                return ong;
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
 
    

        return null; 
    }

    public void exibirNecessidades(ONG ong) {
        String nomeArquivo = diretorioBase + ong.getCNPJ() + ".txt";
        try (BufferedReader reader = new BufferedReader(new FileReader(nomeArquivo))) {
            String line;


            while ((line = reader.readLine()) != null) {
                if (line.startsWith("Categoria:")) {
                    String categoria = line.substring(line.indexOf(":") + 1).trim();
                    System.out.println("\nCategoria: " + categoria);
                }
                else if (line.startsWith("Quantidade:")) {
                    String quantidade = line.substring(line.indexOf(":") + 1).trim();
                    System.out.println("Quantidade: " + quantidade);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void exibirDoacoes(ONG ong) {
        String nomeArquivo = diretorioBase + ong.getCNPJ() + "_DOACOES.txt";
        try (BufferedReader reader = new BufferedReader(new FileReader(nomeArquivo))) {
            String line;


            while ((line = reader.readLine()) != null) {
                if (line.startsWith("\nDoação:")) {
                    System.out.println("Doação:");
                } else if (line.startsWith("Item:")) {
                    String item = line.substring(line.indexOf(":") + 1).trim();
                    System.out.println("\nItem: " + item);
                } else if (line.startsWith("Quantidade:")) {
                    String quantidade = line.substring(line.indexOf(":") + 1).trim();
                    System.out.println("Quantidade: " + quantidade);
                } else if (line.startsWith("Nome do doador:")) {
                    String nomeDoador = line.substring(line.indexOf(":") + 1).trim();
                    System.out.println("Nome do doador: " + nomeDoador);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    
  }

