package screens;
//import resources 
import dungeon_adventure.game;
import javax.swing.JPanel;
import java.awt.image.BufferedImage;
import javax.imageio.ImageIO;
import java.awt.Graphics;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
//initilise varibles
public class menu extends JPanel 
{
    private game game;
    private BufferedImage backgroundImage = null;
    
    public menu (game thegame)
    {
        game = thegame;
        initScreen();
    }
    
    private void initScreen()
    {
        try
        {//set background to titlescreen
            backgroundImage = ImageIO.read(getClass().getResource("/sprites/titlescreen.png"));
        }
        catch(Exception ex)
        {//display error message if screen fails
            System.err.println("ERROR LOADING IMAGE");
        }
        
        addKeyListener(new TAdapter()); 
        setFocusable(true);
    }
    //display background
    @Override
    public void paintComponent(Graphics g)
    {
        super.paintComponent(g);
        g.drawImage(backgroundImage, 0, 0, null);
    }
    //start game when player presses enter
    private class TAdapter extends KeyAdapter
    {
        @Override
        public void keyReleased(KeyEvent e)
        {
            if(e.getKeyCode()== KeyEvent.VK_ENTER)
            {
                game.playGame();   
            }
        }
        @Override
        public void keyPressed(KeyEvent e)
        {
            
        }
    }
}

