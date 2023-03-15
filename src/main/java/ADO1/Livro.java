package ADO1;

/**
 * por Rafael Ferreira Goulart
 */

public class Livro {
    private int id;
    private String autor;
    private String titulo;
    private double preco;
    
    public Livro() {}
    
    public Livro(String a, String t, double p) {
        this.autor = a;
        this.titulo = t;
        this.preco = p;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getAutor() {
        return autor;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public double getPreco() {
        return preco;
    }

    public void setPreco(double preco) {
        this.preco = preco;
    }
    
    @Override
    public String toString() {
        return "Id: " + id + "\n  Autor: " + autor  + "\n  Título: " + titulo  + "\n  Preço: " + preco;
    }
}