package dungeon_adventure;
//import resources 
import javax.swing.JFrame;
import screens.menu;
import java.awt.CardLayout;
import java.awt.Dimension;
import screens.level;
import screens.menu;


public class game 
{//set dimentions of screens
    public static final int WINDOW_WIDTH = 600;
    public static final int WINDOW_HEIGHT = 600;
    
    JFrame gameWindow; 
    
    menu startScreen;
    level lvl1;
    //initialise game 
    public game()
    {
        initWindow();
        initScreen();
    }
    //create game window
    private void initWindow()
    {
        gameWindow = new JFrame();
        gameWindow.setSize(WINDOW_WIDTH, WINDOW_HEIGHT);
        gameWindow.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        gameWindow.getContentPane().setLayout(new CardLayout());
        gameWindow.setResizable(false);
        gameWindow.setLocationRelativeTo(null);
        gameWindow.setTitle("dungeon escape");     
    }
    //create game screen
    private void initScreen()
    {
        startScreen = new menu(this);
        startScreen.setPreferredSize(new Dimension(WINDOW_WIDTH, WINDOW_HEIGHT));
        gameWindow.getContentPane().add(startScreen, "StartScreen");   
        lvl1 = new level(this);
        lvl1.setPreferredSize(new Dimension(WINDOW_WIDTH, WINDOW_HEIGHT));
        gameWindow.getContentPane().add(startScreen, "start");
        gameWindow.getContentPane().add(lvl1, "level1");
        
    }
    //open game
    public static void main(String[] args) 
    {
        game window = new game();
        window.showStartScreen();
    }    
    //show titlescreen
    public void showStartScreen()
    {
        gameWindow.setVisible(true);
        startScreen.requestFocus();
    }
    //start game
    public void playGame()
    {
        CardLayout c1 = (CardLayout)gameWindow.getContentPane().getLayout();
        c1.next(gameWindow.getContentPane());
        lvl1.requestFocus();
        lvl1.startTimer();
    }
}


