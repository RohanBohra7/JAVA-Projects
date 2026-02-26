import java.awt.Font;
import java.awt.Color;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

//frontend
public class RockPaperScissorGUI extends JFrame
{
    //player buttons
    JButton rockButton, paperButton, scissorButton;

    // will display the choice of the computer
    JLabel computerChoice;


    public  RockPaperScissorGUI(){
    //invoke jframe constructor and add title to GUI
    super("Rock Paper Scissor");

    //setting size of GUI
    setSize(450,574);

    //set layout to null to disable layout management, so we can use absolute positioning for the element
    //(i.e. setting x,y coordinates and width/height values)
    setLayout(null);

    //terminate the java virtual machine when closing the GUI
    setDefaultCloseOperation(EXIT_ON_CLOSE);

    //load GUI in the center of the screen every time we run the application
    setLocationRelativeTo(null);

    //add GUI componenets
    addGuiComponents();
    }
    private void addGuiComponents()
    {
        // create computer score label
        JLabel computerScoreLabel=new JLabel("Computer:0");

        // set x,y coordinates and width/height values
        computerScoreLabel.setBounds(0,43,450,30);

        //set the font to have a fontfamily of dialog, font weight of bold, and a font-size of 26
        computerScoreLabel.setFont(new Font("Dialog", Font.BOLD, 26));

        //place the text in the center
        computerScoreLabel.setHorizontalAlignment(SwingConstants.CENTER);

        //add to GUI
        add(computerScoreLabel);

        //ceate computer choice
         computerChoice=new JLabel("?");
        computerChoice.setBounds(175,118,98,81);
        computerChoice.setFont(new Font("Dialog", Font.PLAIN, 18));
        computerChoice.setHorizontalAlignment(SwingConstants.CENTER);

        //create a black border around
        computerChoice.setBorder(BorderFactory.createLineBorder(Color.BLACK));

        add(computerChoice);

        // create a player score label
        JLabel playerScoreLabel=new JLabel("Player: 0");
        playerScoreLabel.setBounds(0,317,450,30);
        playerScoreLabel.setFont(new Font("Dialog", Font.BOLD, 26));
        playerScoreLabel.setHorizontalAlignment(SwingConstants.CENTER);
        add(playerScoreLabel);

        //player buttons

        //rock button

        rockButton = new JButton("Rock");
        rockButton.setBounds(40,387,105, 81);
        rockButton.setFont(new Font("Dialog", Font.PLAIN, 18));
        add(rockButton);

        //paperbutton
        paperButton= new JButton("Paper");

        paperButton.setBounds(165,387,105, 81);
        paperButton.setFont(new Font("Dialog", Font.PLAIN, 18));
        add(paperButton);

        //scissorButton
        scissorButton = new JButton("Scissor");
        scissorButton.setBounds(290,387,105, 81);
        scissorButton.setFont(new Font("Dialog", Font.PLAIN, 18));
        add(scissorButton);

        showDialog("Test Message");


        }

        //display a message dialog which will show the winner and a try again button to play again
        private void showDialog(String message)
        {
            JDialog resultDialog= new JDialog(this, "Result", true);
            resultDialog.setSize(227, 124);
            resultDialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
            resultDialog.setResizable(false);

            //message label
            JLabel resultLabel=new JLabel(message);
            resultLabel.setFont(new Font("Dialog", Font.BOLD, 18));
            resultLabel.setHorizontalAlignment(SwingConstants.CENTER);
            resultDialog.add(resultLabel, BorderLayout.CENTER);

            //try again button
            JButton tryAgainButton= new JButton("Try Again?");
            tryAgainButton.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e)
                {
                    // reset computer choice
                    computerChoice.setText("?");

                    //close the dialog box
                    resultDialog.dispose();
                }
            });

            resultDialog.add(tryAgainButton, BorderLayout.SOUTH);

            resultDialog.setLocationRelativeTo(this);
            resultDialog.setVisible(true);



        }
}