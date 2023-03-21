package ADO1;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardOpenOption;
import java.util.Scanner;

/**
 * por Rafael Ferreira Goulart
 */

public class AdministracaoDeLivros {
    
    public static int opt;
    public static Scanner inp = new Scanner(System.in);
    
    public static void main(String[] args) throws IOException {
        diretorios();
        arquivos();
        
        Array.inserir(new Livro("Rafael", "Preto", 10));
        Array.inserir(new Livro("Rafael", "Branco", 20));
        Array.inserir(new Livro("Tainá", "Rosa", 30));
        Array.inserir(new Livro("Renato", "Azul", 20));
        Array.inserir(new Livro("Brenda", "Amarelo", 10));
        Array.inserir(new Livro("Amanda", "Marrom", 11));
        
        menu();
    }
    
    public static void menu() throws IOException {
        String txt = 
                  " -- -- -- -- -- Menu -- -- -- -- -- \n"
                + " <1> Visualizar Livros \n"
                + " <2> Inserir \n"
                + " <3> Remover \n"
                + " <4> Ordenar por Autor \n"
                + " <5> Ordenar por Título \n"
                + " <6> Buscar \n"
                + " <0> Sair\n"
                + " -- -- -- -- -- ---- -- -- -- -- -- \n";
        boolean exit = false;
        
        while (exit != true) {
            System.out.println(txt);
            opt = inp.nextInt();
            
            switch (opt) {
                case 0:
                    System.out.println(
                              " -- -- -- -- -- ---- -- -- -- -- -- \n"
                            + " --      Fechando Programa!      -- \n"
                            + " -- -- -- -- -- ---- -- -- -- -- -- \n");
                    exit = true;
                    salvar();
                    break;
                case 1:
                    Array.mostrar();
                    break;
                case 2:
                    System.out.println(
                              " -- -- -- -- -- ---- -- -- -- -- -- \n"
                            + " Informe o Autor do livro: \n");
                    String autor = inp.nextLine();
                    while (autor.equals("") || autor.isBlank() || autor.isBlank()) {
                        System.out.println(
                              " -- -- -- -- -- ---- -- -- -- -- -- \n"
                            + " Informe o Autor do livro: \n");
                        autor = inp.nextLine();
                    }
                    
                    System.out.println(
                              " -- -- -- -- -- ---- -- -- -- -- -- \n"
                            + " Informe o Título do livro: \n");
                    String titulo = inp.nextLine();
                    while (titulo.equals("") || titulo.isBlank() || titulo.isBlank()) {
                        System.out.println(
                              " -- -- -- -- -- ---- -- -- -- -- -- \n"
                            + " Informe o Título do livro: \n");
                        titulo = inp.nextLine();
                    }
                    
                    System.out.println(
                              " -- -- -- -- -- ---- -- -- -- -- -- \n"
                            + " Informe o Preço do livro: \n");
                    double preco = inp.nextDouble();
                    
                    Livro livro = new Livro(autor, titulo, preco);
                    
                    Array.inserir(livro);
                    salvar();
                    break;
                case 3:
                    System.out.println(
                              " -- -- -- -- -- ---- -- -- -- -- -- \n"
                            + " Informe o ID do livro: \n");
                    int id = inp.nextInt();
                    Array.remover(id);
                    salvar();
                    break;
                case 4:
                    Array.ordenarPorAutor();
                    salvar();
                    break;
                case 5:
                    Array.ordenarPorTitulo();
                    salvar();
                    break;
                case 6:
                    System.out.println(
                              " -- -- -- -- -- ---- -- -- -- -- -- \n"
                            + " Informe o Título a ser buscado: ");
                    String busca = inp.nextLine();
                    while (busca.equals("") || busca.isBlank() || busca.isEmpty()) {
                        System.out.println(
                              " -- -- -- -- -- ---- -- -- -- -- -- \n"
                            + " Informe o Título a ser buscado: ");
                        busca = inp.nextLine();
                    }
                    Array.mostrarUm(Array.buscar(busca));
                    break;
            }
        }
    }
    
    public static void diretorios() throws IOException {
        boolean existe = Files.exists(Path.of("./Data"));
        
        if (!existe) {
            Path dir = Files.createDirectory(Path.of("./Data"));
            System.out.println(dir.toAbsolutePath());
        } else {
            System.out.println("Diretório já existe.");
        }
    }
    
    public static void arquivos() throws IOException {
        boolean existe = Files.exists(Path.of("./Data/Livros.txt"));
        
        if (!existe) {
            Path file = Files.createFile(Path.of("./Data").resolve("Livros.txt"));
            System.out.println(file.toAbsolutePath());
        } else {
            System.out.println("Arquivo já existe.");
        }
    }
    
    public static void salvar() throws IOException {
        Path file = Path.of("./Data/Livros.txt");
        
        Files.delete(file);
        atualizaArquivo();
        Files.writeString(file,
                Array.mostrar() + "\n\n",
                StandardCharsets.ISO_8859_1,
                StandardOpenOption.APPEND);
        System.out.println("Salvando...");
    }
    
    public static void atualizaArquivo() throws IOException {
        boolean existe = Files.exists(Path.of("./Data/Livros.txt"));
        
        if (!existe) {
            Path file = Files.createFile(Path.of("./Data").resolve("Livros.txt"));
        }
    }
}