//backend 

import java.util.Random;

public class RockPaperScissor {
    private static final String[]  computerChoices={"Rock","Paper","Scissor"};

    //use to genarte a random number to randomly choose an option
    private Random random;

    //store the computer choice so that we can retreive the value and display it to frontend
    private String computerChoice;

    //store the scores so that we can retrieve the values and display it to the frontend
    private int computerScore, playerScore;

    //constructor
    public RockPaperScissor(){
        random=new Random();
    }
    //call this method to begin playing rock paper scissor
    //playerChoice - is the choice made by the player (i.e. rock paper scissor) 
    //this method will return the reult of the game(i.e. computer win, player win, draw)
    public String playRockpaperScissor(String playerChoice)
    {
        computerChoice = computerChoices[random.nextInt(computerChoices.length)];

        //will contain the returning message indicating the result of the game
        String result;

        //evaluate the winner
        if(computerChoice.equals("Rock"))
        {
            if(playerChoice.equals("Paper"))
            {
                result="Player Wins";
                playerScore++;
            }
            else if(playerChoice.equals("Scissors"))
            {
                result="Computer Wins";
                computerScore++;
            }
            else
                result="Draw";
        }
        else if(playerChoice.equals("Paper"))
            {
                if(playerChoice.equals("Scissors"))
                {
                result="Player Wins";
                playerScore++;
            }
            else if(playerChoice.equals("Rock"))
            {
                result="Computer Wins";
                computerScore++;
            }
            else
                result="Draw";

    }
    else {
        //computer chooses Scissors
         if(playerChoice.equals("Rock"))
            {
                result="Player Wins";
                playerScore++;
            }
            else if(playerChoice.equals("Paper"))
            {
                result="Computer Wins";
                computerScore++;
            }
            else
                result="Draw";
    
     }
     return result;

}
}
