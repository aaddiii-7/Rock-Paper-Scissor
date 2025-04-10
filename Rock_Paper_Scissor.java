import java.util.Random;
import java.util.Scanner;

class Player {
    private String name; // private modifier

    // parameterised constructor
    public Player(String name) {
        this.name = name;
    }

    public String move(Scanner input) {
        while (true) {
            System.out.println("Choose your move {\"Rock\",\"Paper\",\"Scissor\"}");
            String userMove = input.nextLine(); // Taking user input as String

            // return usermove if it is valid
            // equalsIgnoreCase-> ignores case of string

            if (userMove.equalsIgnoreCase("Rock") || userMove.equalsIgnoreCase("Paper")
                    || userMove.equalsIgnoreCase("Scissor")) 
                    {
                        return userMove; // Method is returned (loop break)
                    } 
            else
            {
                System.out.println("Enter a valid move!! " + name);
            }
                    

        }

    }
}

class Computer {
    private String[] options = { "Rock", "Paper", "Scissor" }; // String Array

    String move() {
        System.out.println("Computer: Now it's my Turn");
        Random rand = new Random();
        int index = rand.nextInt(options.length); // Generating a random number in range array.length(3) for index.
        String move = options[index]; // Stores a random element from option array{"Rock","Paper","Scissor"}
        return move;
    }

}

class FinalResult {

    public int  result(String player, String computer) {
        
//winning moves {rock && scissor},{paper && rock},{scissor && paper}

        if (player.equalsIgnoreCase("Rock") && computer.equalsIgnoreCase("Scissor")
                || player.equalsIgnoreCase("Paper") && computer.equalsIgnoreCase("Rock")
                || player.equalsIgnoreCase("Scissor") && computer.equalsIgnoreCase("Paper")) 
                {
                    System.out.println("Congratulations!! You Won.");
                    System.out.println("Computer move :"+computer);
                    System.out.println();
                    return 1;                    // this will help in calculating  no of matches won
                } 

               // draw moves {player1 == player2}
        else if (player.equalsIgnoreCase(computer))
        {
            System.out.println("It's a Draw!");
            System.out.println("Computer move :"+computer);              // tells computer's move
            System.out.println();
            return 2;                                         // this will help in calculating  no of matches draw
        } 

              // else evey move is loose move
        else 
        {
            System.out.println("You lose!");
            System.out.println("Computer move :"+computer);
            System.out.println();
            return 3;                                         // this will help in calculating  no of matches lose
        }

    }

}

public class Rock_Paper_Scissor {
    public static void main(String[] args) {
        System.out.println("Enter Your name :");
        Scanner input=new Scanner(System.in);           // enter useer name
        String playerName = input.nextLine();
        int won=0;       
        int draw=0;
        int lose=0;
        
        Player aadii = new Player(playerName);              // parameterized constructor invoked 
        Computer opponent = new Computer();                   // computer class object is created 
        FinalResult result = new FinalResult();               // finalresult class object is created
        
        for(int i =0;i<5;i++)
        {
            String player = aadii.move(input);                         // user move stored in player variable
            String computer = opponent.move();                    // computer move stored in player variable
            int flag=result.result(player, computer); //result method is called here && int value stored in flag
            switch (flag) {
                case 1:
                {
                    won++;
                    break;
                }
            
                case 2:
                {
                    draw++;
                    break;
                }
                
                case 3:
                {
                    lose++;
                    break;
                }
            }
        
        }
        System.out.println("YOUR SCORE!");
        System.out.println("Matches Won :"+won); 
        System.out.println("Matches Draw :"+draw);
        System.out.println("Matches Lose :"+lose);
        input.close();
    }
}
