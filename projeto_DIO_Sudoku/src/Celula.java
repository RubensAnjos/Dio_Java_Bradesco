import java.util.HashSet;
import java.util.Set;

public class Celula {
    private int valor;
    private final int linha;
    private final int coluna;
    private final boolean editavel;
    private Set<Integer> possiveisValores; // Para algoritmos de resolução

    public Celula(int linha, int coluna, int valor, boolean editavel) {
        this.linha = linha;
        this.coluna = coluna;
        this.valor = valor;
        this.editavel = editavel;
        this.possiveisValores = new HashSet<>();
    }
    public boolean isEditavel() {
        return editavel;
    }

    // Possíveis valores para solução automática, imprementar no futuro.
    public Set<Integer> getPossiveisValores() {
        return possiveisValores;
    }

    public void setPossiveisValores(Set<Integer> possiveisValores) {
        this.possiveisValores = possiveisValores;
    }

    @Override
    public String toString() {
        return valor == 0 ? "." : String.valueOf(valor);
    }
}
