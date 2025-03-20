import java.util.InputMismatchException;
import java.util.Scanner;

public class SudokuGame {
    final SudokuBoard board;

    public SudokuGame() {
        board = new SudokuBoard();
        board.inicializar();
        board.preencherCelulasIniciais();
    }

    public void iniciarJogo() {
        Scanner scanner = new Scanner(System.in);
        while (!board.estaCompleto()) {
            board.imprimirTabuleiro();

            try {
                System.out.println("Informe linha, coluna e valor (ex: 1 3 5): ");
                int linha = scanner.nextInt();
                int coluna = scanner.nextInt();
                int valor = scanner.nextInt();

                if (board.validarMovimento(linha, coluna, valor)) {
                    board.atualizarCelula(linha, coluna, valor);
                } else {
                    System.out.println("Movimento inválido. Tente novamente.");
                }

            } catch(InputMismatchException e){
                System.out.println("Entrada invalida digite novamente");
                scanner.nextLine();
            }
        }
        System.out.println("Parabéns, você completou o Sudoku!");
        scanner.close();
    }

    public static void main(String[] args) {
        SudokuGame jogo = new SudokuGame();
        jogo.iniciarJogo();
    }
}
