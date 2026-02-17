import javax.swing.*;

public class APP {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable()
        {
            @Override
            public void run()
            {
                //instantiate RockPaperScissorGUI obj
                RockPaperScissorGUI rockPaperScissorGUI=new RockPaperScissorGUI();

                //diasplay the GUI
                rockPaperScissorGUI.setVisible(true);
            }

        });
    }
    
}
