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
        gameBoard = new T3State[gameBoardSize][gameBoardSize];

        for (int i = 0; i < gameBoardSize; i++)
        {
            for (int j = 0; j < gameBoardSize; j++)
            {
                gameBoard[i][j] = T3State.Available;
            }
        }
    }


}
