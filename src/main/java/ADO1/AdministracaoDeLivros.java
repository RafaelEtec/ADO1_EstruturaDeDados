package ADO1;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardOpenOption;

/**
 * por Rafael Ferreira Goulart
 */

public class AdministracaoDeLivros {
    public static void main(String[] args) throws IOException {
        diretorios();
        arquivos();
        
        menu();
    }
    
    public static void menu() {
        String txt = 
                  " -- -- -- -- -- Menu -- -- -- -- -- \n"
                + " \n"
                + " <1> Visualizar Livros \n"
                + " <2> Inserir \n"
                + " <3> Remover \n"
                + " <4> Ordenar por Autor \n"
                + " <5> Ordenar por Título \n"
                + " <6> Ordenar por ID \n"
                + " <7> Buscar \n";
        boolean exit = false;
        
        while (exit != true) {
            System.out.println(txt);
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
        
        Files.writeString(file,
                Array.mostrar() + "\n\n",
                StandardCharsets.ISO_8859_1,
                StandardOpenOption.APPEND);
        System.out.println("Salvando...");
    }
}