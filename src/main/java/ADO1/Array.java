package ADO1;

/**
 * por Rafael Ferreira Goulart
 */

public class Array {
    private static Livro[] lista = new Livro[5];
    private static int ind = 0;
    
    /**
     * Realiza a inserção de objetos do tipo Livro no Array lista
     * @param l 
     */
    public static void inserir(Livro l) {
        if (ind == lista.length) {
            lista = alocarNovoArray();
        }
        l.setId(ind + 1);
        lista[ind++] = l;
    }
    
    /**
     * Exibe os valores armazenados no Array lista
     * @return 
     */
    public static String mostrar() {
        String txt = "";
        
        for (int i = 0; i < ind; i++) {
            System.out.println(lista[i]);
            System.out.println("");
            txt = txt + lista[i].toString() + "\n";
        }
        
        return txt;
    }
    
    /**
     * Exibe apenas o valor buscado
     * @return 
     */
    public static String mostrarUm(int id) {
        String txt = "";
        
        System.out.println(lista[id]);
        txt = txt + lista[id].toString() + "\n";
        
        return txt;
    }
    
    /**
     * Aumenta o tamanho do Array lista
     * @return 
     */
    private static Livro[] alocarNovoArray() {
        Livro[] novo = new Livro[lista.length + 3];
        
        System.arraycopy(lista, 0, novo, 0, lista.length);
        
        return novo;
    }
    
    /**
     * Realiza a busca de um valor possivelmente presente no Array lista
     * @param id
     * @return 
     */
    public static int buscar(String titulo) {
        int inicio = 0, fim = ind - 1, meio;
        
        while (inicio <= fim) {
            meio = (fim + inicio) / 2;
            if (titulo == lista[meio].getTitulo()) {
                return meio;
            } else {
                fim = meio - 1;
            }
        }
        return -1;
    }
    
    public static int buscarEx(int id) {
        int inicio = 0, fim = ind - 1, meio;
        while (inicio <= fim) {
            meio = (fim + inicio) / 2;
            if (id == lista[meio].getId()) {
                return meio;
            } else if (id > lista[meio].getId()) {
                inicio = meio + 1;
            } else {
                fim = meio - 1;
            }
        }
        return -1;
    }
    
    /**
     * Remove um objeto por id presente no Array lista
     * @param id
     * @return
     */
    public static boolean remover(int id) {
        int rem = buscarEx(id);
        
        if (rem != -1) {
            for (int i = rem; i < ind - 1; i++) {
                lista[i] = lista[i + 1];
            }
            ind--;
            return true;
        }
        return false;
    }
    
    public static void ordenarPorAutor(){
       for (int i = 1; i < ind; i++) {
            Livro temp = lista[i];
            int j = i;
            while (j > 0 && lista[j - 1].getAutor().compareTo(temp.getAutor())>0) {
                lista[j] = lista[j - 1];
                j--;
            }
            lista[j] = temp;
        }
    }
    
    public static void ordenarPorTitulo(){
       for (int i = 1; i < ind; i++) {
            Livro temp = lista[i];
            int j = i;
            while (j > 0 && lista[j - 1].getTitulo().compareTo(temp.getTitulo())>0) {
                lista[j] = lista[j - 1];
                j--;
            }
            lista[j] = temp;
        }
    }
    
    /**
    public static void ordenarPorID(){
       for (int i = 1; i < ind; i++) {
            Livro temp = lista[i];
            int j = i;
            while (j > 0 && lista[j - 1].getAutor().compareTo(temp.getAutor())>0) {
                lista[j] = lista[j - 1];
                j--;
            }
            lista[j] = temp;
        }
    }
    **/
}