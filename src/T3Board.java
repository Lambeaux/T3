/**
 * Created by Lambeaux on 11/3/2015.
 * This will be an object representing our game board. It will keep
 * track of the state of the game and permit players to make moves.
 *
 */
public class T3Board
{
    /*
    This is a 2-dimensional array that defines our game board.
    Essentially, a 2D array is like a table in Excel. We can
    query against rows and columns. A 3D array would be like a
    cube, a 4D array like an animating cube, etc.
    */
    private T3State[][] gameBoard;

    /*
    The following integer specifies how large our game board will be.
    Notice we've made this variable and the one above 'private' - which
    means it CANNOT be accessed outside of the class.
    */
    private int gameBoardSize;

    /*
    In order to address the concept of playing a move and maintaining an
    even amount of turns for each player, we will use a boolean to store
    whose turn it is to play. If true, it is X's turn to play. Once again
    we make it private so that other programmers can't modify it directly.
    We also initialize it in the constructor. Note that X always moves first.
    */
    private boolean isTurnX;

    /*
    Our object constructor. Anytime you make a new class, it is useful
    to define the constructor, which is a method with the same name as
    the class without a return type. This code is guaranteed to be called
    before the object can be used, so it's a great place for initialization.
    Here: we choose the default tic-tac-toe board size of 3 and initialize
    all spaces to 'Available'.
    */
    public T3Board()
    {
        gameBoardSize = 3;
        isTurnX = true;

        gameBoard = new T3State[gameBoardSize][gameBoardSize];

        for (int i = 0; i < gameBoardSize; i++)
        {
            for (int j = 0; j < gameBoardSize; j++)
            {
                gameBoard[i][j] = T3State.Available;
            }
        }
    }

    /*
    Our new method, the 'playMove(int)' will allow the next player to
    claim a space on the game board without messing up turn order. The
    provided integer represents the position to be played, and the boolean
    that returns tells us if the operation was successful. This is important
    just in case the player gives us a number that's out of bounds or has
    already been played.

    It is conceptually easier to deal with just one number as input, and then
    break it up into row-column components ourselves. The top left square is
    considered '1' and the count order goes from left to right, then down:

    "  1 | 2 | 3 ";
    " --- --- ---";
    "  4 | 5 | 6 ";
    " --- --- ---";
    "  7 | 8 | 9 ";

    */
    public boolean playMove(int position)
    {
        // Extract the row/column component indices:
        // i = integer division (ignores the remainder)
        // j = modulus operator (returns the remainder)
        int i = (position - 1) / gameBoardSize;
        int j = (position - 1) % gameBoardSize;

        // Make sure we're in bounds.
        if (position < 1 || position > gameBoardSize * gameBoardSize)
        {
            System.out.println(
                    "FAULT in T3Board.playMove(int) -- Position out of bounds.\r\n");
            return false;
        }

        // Make sure we can play at that spot.
        if (gameBoard[i][j] == T3State.Available)
        {
            // Make the play
            if (isTurnX)
                gameBoard[i][j] = T3State.X;
            else
                gameBoard[i][j] = T3State.O;

            // Change the turn (like flipping a switch)
            isTurnX = !isTurnX;
        }

        else
        {
            System.out.println(
                    "FAULT in T3Board.playMove(int) -- Position already played.\r\n");
            return false;
        }

        // If we don't encounter a problem, it must have worked.
        return true;
    }

    /*
    We need a convenient way to represent the board as a String so we can
    print it to the console. This method performs that computation. We loop
    through the 2D array for the board and print symbols according to its state.

    Ideal shape of the board (We make a plan before we start coding):

    "  O |   |   ";
    " --- --- ---";
    "  X |   |   ";
    " --- --- ---";
    "  O | X |   ";

    */
    public String toString()
    {
        // The 'final' keyword means "constant" -- the
        // value of these variables cannot be changed.
        // They are declared for convenience.
        final String NODE_EMPTY     =   "   ";
        final String NODE_X         =   " X ";
        final String NODE_O         =   " O ";

        // String variable we will concat elements to
        String boardString = "\r\n\r\n";

        // For: each row in the 2D array
        for (int i = 0; i < gameBoardSize; i++)
        {
            // Start with an empty space
            boardString += " ";

            // For: each column in the 2D array
            for (int j = 0; j < gameBoardSize; j++)
            {
                // Concat the appropriate unit based on our
                // game board state. This ensures we always
                // print the proper character as game play
                // continues.
                switch(gameBoard[i][j])
                {
                    case X:
                        boardString += NODE_X;
                        break;
                    case O:
                        boardString += NODE_O;
                        break;
                    default:
                        boardString += NODE_EMPTY;
                        break;
                }

                // As long as we're not on our last column, print
                // a grid-column separator. Otherwise, go to a new line.
                if (j != gameBoardSize - 1)
                    boardString += "|";
                else
                    boardString += "\r\n";
            }

            // As long as we're not on our last row, print a grid-row
            // separator and a new line. Otherwise, print two new lines
            // and finish the print job, because we are done.
            if (i != gameBoardSize - 1)
            {
                for (int k = 0; k < gameBoardSize; k++)
                {
                    boardString += " ---";
                }

                boardString += "\r\n";
            }
            else
            {
                boardString += "\r\n\r\n";
            }
        }

        // Return the string variable we've been concatenating to so
        // it may be printed in the main program.
        return boardString;
    }
}
