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
    public static int buscar(int id) {
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
        int rem = buscar(id);
        
        if (rem != -1) {
            for (int i = rem; i < ind - 1; i++) {
                lista[i] = lista[i + 1];
            }
            ind--;
            return true;
        }
        return false;
    }
}