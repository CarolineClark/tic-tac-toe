import junitparams.JUnitParamsRunner;
import junitparams.Parameters;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;

import static org.junit.Assert.assertEquals;

@RunWith(JUnitParamsRunner.class)
public class TicTacToeTest {

    private TicTacToe tictactoe;

    @Before
    public void setup() {
        tictactoe = new TicTacToe();
        tictactoe.setUpBoard();
    }

    @Test
    public void checkStartBoardIsEmpty() {

        for (char[] i : tictactoe.board) {
            for (char j: i) {
                assertEquals(TicTacToe.EMPTY, j);
            }
        }
    }

    @Test
    public void checkBoardIsCorrectSize() {
        for (char[] i: tictactoe.board) {
            assertEquals(TicTacToe.BOARD_SIZE, i.length);
        }
    }

    @Test
    @Parameters({"0, 0",
                 "1, 1",
                 "2, 0"})
    public void playingMoveReplacesEmptyCharacter(int i, int j) throws TicTacToeCharInvalidException, TicTacToeMoveOffBoardException {

        tictactoe.play(i, j, TicTacToe.X);
        assertEquals(TicTacToe.X, tictactoe.board[i][j]);
    }

    @Test(expected=TicTacToeMoveOffBoardException.class)
    public void playingMoveOutsideOfBoard_resultsInException() throws TicTacToeMoveOffBoardException, TicTacToeCharInvalidException {
        tictactoe.play(3, 3, TicTacToe.X);
    }

    @Test(expected=TicTacToeCharInvalidException.class)
    public void playingInvalidChar_resultsInException() throws TicTacToeCharInvalidException, TicTacToeMoveOffBoardException {
        tictactoe.play(2, 1, 'C');
    }
}
