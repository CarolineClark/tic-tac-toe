
public class TicTacToe {
    public static final int BOARD_SIZE = 3;
    public static final char EMPTY = '?';
    public static final char X = 'X';
    public static final char O = 'O';
    public char[][] board;

    public char[][] setUpBoard() {
        board = new char[BOARD_SIZE][BOARD_SIZE];
        for (int i=0; i<BOARD_SIZE; i++) {
            for (int j = 0; j < BOARD_SIZE; j++) {
                board[i][j] = EMPTY;
            }
        }
        return board;
    }

    public void play(int i, int j, char x) throws TicTacToeMoveOffBoardException, TicTacToeCharInvalidException {
        if (i >= BOARD_SIZE || j >= BOARD_SIZE) {
            throw new TicTacToeMoveOffBoardException();
        }
        if (x != X && x != O) {
            throw new TicTacToeCharInvalidException();
        }

        board[i][j] = x;
    }
}
