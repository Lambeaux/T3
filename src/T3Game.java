import java.util.Scanner;

/**
 * Created by Lambeaux on 11/3/2015.
 * This will be our primary class for the entire game. It holds our
 * main function, which is the entry point for the whole program.
 *
 */
public class T3Game
{
    /*
    In our game class, we have defined a board and a scanner. Remember
    that we use the scanner to get input. Somewhere in the Java library,
    there is a class called 'Scanner' that holds the code to make the
    scanner work. Specifically, it can be found in the package that we
    imported at the top of this file: "import java.util.Scanner;" --
    that's where the Scanner class lives!

    There is a method or function in the scanner class
    called 'nextLine()' that does something meaningful.
    See label [3] where we invoke this function.

    Currently our T3Board class only has a constructor. It doesn't have
    any invokable functions. In the next commit I make to GitHub, this
    will change.
    */
    private static T3Board MyGameBoard;
    private static Scanner MyInputReader;


    /*
    Here in main we provide some test code for constructing our own
    T3Board object. Whenever we use the keyword 'new', we are allocating
    memory for the object's variables, which are stored together, AND we
    invoke our object's constructor. That was the code in the T3Board file
    that loops through all our states and sets them to Available.

    ** We test our new method, playMove(int), at label [4] prior to printing
        the board. Run the code. You'll see that it works.

    Furthermore, we now print the board using our 'toString()' function
    we defined ourselves at label [2].
    */
    public static void main(String[] args)
    {
        // [1] Notice how the constructor for a Scanner takes an argument,
        // which is provided in parenthesis. Our constructor did not define
        // any arguments in T3Board, so we don't need to provide any.
        MyGameBoard = new T3Board();
        MyInputReader = new Scanner(System.in);

        // [4] Play some moves.
        MyGameBoard.playMove(1);
        MyGameBoard.playMove(8);
        MyGameBoard.playMove(9);
        
        // Notice that these lines will cause faults. And the
        // moves will NOT be played.
        MyGameBoard.playMove(9);
        MyGameBoard.playMove(10);

        // [2] Print the initial state of the board.
        String boardToPrint = MyGameBoard.toString();
        System.out.println(boardToPrint);

        // [3] Here we invoke the scanner's 'nextLine()' function. This
        // will keep the program from exiting until you hit ENTER.
        MyInputReader.nextLine();
    }
}
