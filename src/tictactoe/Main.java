package tictactoe;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        char[] cells = new char[9];
        int counter = 0;
        char x, y;

        for (int i = 0; i < 9; i++) {
            cells[i] = ' ';
        }

        while (true) {
            draw(cells);
            System.out.println("Enter the coordinates: ");
            x = scanner.next().charAt(0);
            y = scanner.next().charAt(0);

            if (!Character.isDigit(x) && !Character.isDigit(y)) {
                System.out.println("You should enter numbers!");
                continue;
            }
            int x1 = Character.getNumericValue(x) - 1;
            int y1 = Character.getNumericValue(y) - 1;

            if (x1 > 2 || y1 > 2) {
                System.out.println("Coordinates should be from 1 to 3!");
                continue;
            }
            if (cells[3 * x1 + y1] == ' ') {
                if (counter == 0) {
                    cells[3 * x1 + y1] = 'X';
                    counter = 1;
                }
                else {
                    cells[3 * x1 + y1] = 'O';
                    counter = 0;
                }
            }
            else {
                System.out.println("This cell is occupied! Choose another one!");
                continue;
            }
            if (isWinner(cells, 'X')) {
                draw(cells);
                System.out.println("X wins");
                break;
            }
            if (isWinner(cells, 'O')) {
                draw(cells);
                System.out.println("O wins");
                break;
            }
            if (isDraw(cells)) {
                draw(cells);
                System.out.println("Draw");
                break;
            }
        }



    }

    static void draw (char[] cells) {
        System.out.println("---------");
        for (int i = 0; i < 3; i++) {
            System.out.print("| ");
            for (int j = 0; j < 3; j++) {
                System.out.print(cells[i * 3 + j] + " ");
            }
            System.out.println("|");
        }
        System.out.println("---------");
    }

    static boolean isWinner (char[] cells, char symbol) {
        return (cells[0] == symbol && cells[1] == symbol && cells[2] == symbol ||
                cells[0] == symbol && cells[3] == symbol && cells[6] == symbol ||
                cells[0] == symbol && cells[4] == symbol && cells[8] == symbol ||
                cells[2] == symbol && cells[5] == symbol && cells[8] == symbol ||
                cells[2] == symbol && cells[4] == symbol && cells[6] == symbol ||
                cells[1] == symbol && cells[4] == symbol && cells[7] == symbol ||
                cells[3] == symbol && cells[4] == symbol && cells[5] == symbol ||
                cells[6] == symbol && cells[7] == symbol && cells[8] == symbol);
    }

    static boolean isDraw (char[] cells) {
        for (int i = 0; i < 9; i++) {
            if (cells[i] == ' ') {
                return false;
            }
        }
        return true;
    }
}