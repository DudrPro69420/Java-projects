import java.util.Scanner;

class TicTacToe{
        String [] board = {"-","-","-",
                          "-","-","-",
                          "-","-","-"};
        boolean gameIsGoing = true;
        String player = "X";
        String winner = null;
        boolean gameTied = false;
        Scanner sc = new Scanner(System.in);
    
    public void displayBoard(){
        System.out.println(board[0] + "|" + board[1] + "|" + board[2]);
        System.out.println(board[3] + "|" + board[4] + "|" + board[5]);
        System.out.println(board[6] + "|" + board[7] + "|" + board[8]);
    }
    
    public void drawMark(String currentPlayer){
        try{
            System.out.print("Enter number between 1 to 9: ");
            int position = sc.nextInt();
            position = position - 1;
            
            if (board[position] == "-"){
                board[position] = currentPlayer;
            }
            
            else{
                System.out.println("That spot is already taken.");
            }
        }
        
        catch(Exception e){
            System.out.println("Enter a number only and keep it between 1 and 9.");
        }
        
    }
    
    public void flipPlayer(){
        if (player=="X"){
            player = "O";
        }
        else{
            player="X";
        }
    }
    
    public void displayWinner(String gameWinner){
        System.out.println(gameWinner+" won.");
        System.exit(1);
    }
    
    public void checkRows(){
        if (board[0] == board[1]){
            if (board[1] == board[2]){
                if (board[2] != "-"){
                    gameIsGoing = false;
                    winner = board[0];
                    displayWinner(winner);
                }
            }    
        }
        
        if (board[3] == board[4]){
            if (board[4] == board[5]){
                if (board[5] != "-"){
                    gameIsGoing = false;
                    winner = board[3];
                    displayWinner(winner);
                }
            }    
        }
        
        
        if (board[6] == board[7]){
            if (board[7] == board[8]){
                if (board[8] != "-"){
                    gameIsGoing = false;
                    winner = board[6];
                    displayWinner(winner);
                }
            }    
        }
        
    } 
    
    public void checkColumns(){
        if (board[0] == board[3]){
            if (board[3] == board[6]){
                if (board[6] != "-"){
                    gameIsGoing = false;
                    winner = board[0];
                    displayWinner(winner);
                }
            }    
        }
        
        if (board[1] == board[4]){
            if (board[4] == board[7]){
                if (board[7] != "-"){
                    gameIsGoing = false;
                    winner = board[1];
                    displayWinner(winner);
                }
            }    
        }
        
        if (board[2] == board[5]){
            if (board[5] == board[8]){
                if (board[8] != "-"){
                    gameIsGoing = false;
                    winner = board[2];
                    displayWinner(winner);
                }
            }    
        }
    }
    
    public void checkDiagonals(){
        if (board[0] == board[4]){
            if (board[4] == board[8]){
                if (board[8] != "-"){
                    gameIsGoing = false;
                    winner = board[0];
                    displayWinner(winner);
                }
            }    
        }
        
        if (board[2] == board[4]){
            if (board[4] == board[6]){
                if (board[6] != "-"){
                    gameIsGoing = false;
                    winner = board[2];
                    displayWinner(winner);
                }
            }    
        }
    }
    
    public void checkIfGameEnd(){
        checkRows();
        
        checkColumns();
        
        checkDiagonals();
    }
    
    public void checkIfTie(){
        int i = 0;
        for (String marks: board){
            if (marks=="-"){
                i = i + 1;
            }
        }
        if (i==0){
            gameIsGoing = false;
            System.out.println("This game was a tie.");
        }
    }
    
    public void playGame(){
        displayBoard();
        while (gameIsGoing){
            drawMark(player);
            displayBoard();
            checkIfGameEnd();
            flipPlayer();
            checkIfTie();
        }
    }
}
public class Main
{
	public static void main(String[] args) {
		TicTacToe ttt = new TicTacToe();
		ttt.playGame();
		
	}
}


