import java.util.Scanner;

public class Level2_Task1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Welcome to Tic-Tac-Toe!");
        boolean playAgain = true;

        while (playAgain) {
            System.out.println("\nStarting a new game...\n");
            playGame();

            System.out.print("Do you want to play again? (yes/no): ");
            String playAgainInput = scanner.next();
            playAgain = playAgainInput.equalsIgnoreCase("yes");
        }

        System.out.println("Thank you for playing Tic-Tac-Toe!");
        scanner.close();
    }

    private static void playGame() {
        char[][] board = {
            {' ', ' ', ' '},
            {' ', ' ', ' '},
            {' ', ' ', ' '}
        };

        int currentPlayer = 1; // 1 for Player 1, 2 for Player 2
        boolean gameWon = false;
        boolean draw = false;

        while (!gameWon && !draw) {
            displayBoard(board);
            int[] move = getPlayerMove(currentPlayer);
            int row = move[0];
            int col = move[1];

            // Check if the selected cell is empty
            if (board[row][col] == ' ') {
                char playerSymbol = (currentPlayer == 1) ? 'X' : 'O';
                board[row][col] = playerSymbol;

                // Check for a win
                if (checkWin(board, playerSymbol)) {
                    displayBoard(board);
                    System.out.println("Player " + currentPlayer + " wins!");
                    gameWon = true;
                } else {
                    // Check for a draw
                    draw = checkDraw(board);

                    // Switch to the other player
                    currentPlayer = (currentPlayer == 1) ? 2 : 1;
                }
            } else {
                System.out.println("Cell already taken. Try again.");
            }
        }

        if (draw) {
            displayBoard(board);
            System.out.println("It's a draw!");
        }
    }

    private static void displayBoard(char[][] board) {
        System.out.println("-------------");
        for (int i = 0; i < 3; i++) {
            System.out.print("| ");
            for (int j = 0; j < 3; j++) {
                System.out.print(board[i][j] + " | ");
            }
            System.out.println();
            System.out.println("-------------");
        }
    }

    private static int[] getPlayerMove(int player) {
        Scanner scanner = new Scanner(System.in);
        int[] move = new int[2];

        System.out.println("Player " + player + ", it's your turn!");
        System.out.print("Enter your move (row and column, separated by space): ");

        // Adjusting to 0-based indices
        move[0] = scanner.nextInt() - 1;
        move[1] = scanner.nextInt() - 1;

        // Validate user input
        if (move[0] < 0 || move[0] >= 3 || move[1] < 0 || move[1] >= 3) {
            System.out.println("Invalid move! Please enter row and column values between 1 and 3.");
            return getPlayerMove(player);
        }

        return move;
    }

    private static boolean checkWin(char[][] board, char playerSymbol) {
        // Check rows, columns, and diagonals for a win
        for (int i = 0; i < 3; i++) {
            if ((board[i][0] == playerSymbol && board[i][1] == playerSymbol && board[i][2] == playerSymbol) ||
                (board[0][i] == playerSymbol && board[1][i] == playerSymbol && board[2][i] == playerSymbol)) {
                return true;
            }
        }

        if ((board[0][0] == playerSymbol && board[1][1] == playerSymbol && board[2][2] == playerSymbol) ||
            (board[0][2] == playerSymbol && board[1][1] == playerSymbol && board[2][0] == playerSymbol)) {
            return true;
        }

        return false;
    }

    private static boolean checkDraw(char[][] board) {
        // Check if the board is full (no empty cells)
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (board[i][j] == ' ') {
                    return false; // Board is not full, game continues
                }
            }
        }
        return true; // Board is full, it's a draw
    }
}
