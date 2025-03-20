import java.util.Random;

public class SudokuBoard {
    final int[][] board;
    private Celula[][] grid;
    private static final int NUM_CELULAS_INICIAIS =40;
    private final Random random = new Random();
    public SudokuBoard() {
        board = new int[9][9];
    }
    public static String RED = "\u001B[31m";
    public static String RESET = "\u001B[0m";

    public void inicializar() {
        // Inicialize o tabuleiro com um puzzle de Sudoku.
        grid = new Celula[9][9];
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                grid[i][j] = new Celula(i, j, 0, true);
            }
        }
    }

    public void preencherCelulasIniciais() {
        int preenchidas = 0;
        while (preenchidas < NUM_CELULAS_INICIAIS) {
            int linha = random.nextInt(9);
            int coluna = random.nextInt(9);
            int valor = random.nextInt(9) + 1; // Gera número de 1 a 9
            if(grid[linha][coluna].isEditavel() && validarMovimento(linha, coluna, valor)) {
            grid[linha][coluna] = new Celula(linha, coluna, valor, false); // Define como fixa
            board[linha][coluna] = valor;

                preenchidas++;
            }

        }
    }

    public void imprimirTabuleiro() {
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {

                //Celula editavel = new Celula(i, j, 0, true);
                if(j == 3 || j == 6 ){
                    System.out.print("|");
                }
                if(i == 3 && j == 0 || i == 6 && j == 0 ){
                    System.out.println("-------------------");
                }
                    if(grid[i][j].isEditavel()){
                        System.out.print(board[i][j] + " ");
                    }else{
                        System.out.print( RED +board[i][j] + RESET + " ");
                    }
            }
            System.out.println();
        }
    }

    public boolean validarMovimento(int linha, int coluna, int valor) {
        // Verifique se a linha, coluna e a quadrante 3x3 não possuem o valor.

        //verifica colunar
        if (valor > 9 || valor == 0){return false;}
        for (int i = 0; i < 9; i++) {
            if (board[linha][i] == valor) {
                return false;
            }
        }
        //verifica linha
        for (int i = 0; i < 9; i++) {
            if (board[i][coluna] == valor) {
                return false;
            }
        }

        //verificas quadrante
        int startRow = (linha / 3) * 3;
        int startCol = (coluna / 3) * 3;
       for (int i = 0 ; i < 3; i++) {
            for (int j = 0 ; j < 3; j++) {
                int num = board[startRow + i][startCol + j];
                if (num == valor) {
                    return false;
                }
            }
       }
        return true;
   }

    public void atualizarCelula(int linha, int coluna, int valor) {
       if(grid[linha][coluna].isEditavel()){
           board[linha][coluna] = valor;
       }else {System.err.println("Não é possível alterar uma célula fixa");}
    }

    public boolean estaCompleto() {
        // Verifica se não há zeros no tabuleiro e se está correto.
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                if (board[i][j] == 0) {
                    return false;
                }
            }
        }
        return true;
    }
}
