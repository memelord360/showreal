
package screens;
//import resources 
import characters.enemy;
import characters.player;
import dungeon_adventure.game;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.image.BufferedImage;
import javax.imageio.ImageIO;
import javax.swing.JPanel;
import javax.swing.Timer;
import objects.door;
import objects.door;
import characters.enemy;
import characters.player;
import dungeon_adventure.game;
import objects.treasure;
import objects.treasure;



public class level extends JPanel implements ActionListener
{
    
     
    //initialise varibles
    private game game;
    private Timer gametimer;
    private int currenttimer;
    private float timesincegamestart;
    private String[] time;
    BufferedImage background;
    private player theplayer;
    private treasure thetreasure;
    private door thedoor;
    boolean collided;
    private enemy[] theenemy;
 
    public level(game thegame)
    {
        game = thegame;
        theplayer = new player();
        thetreasure = new treasure(theplayer);
        thedoor = new door(theplayer);
        init();
     }
    
  
    private void init()
    {
        addKeyListener(new TAdapter());
        setFocusable(true);
        setDoubleBuffered(true);
//load bckground
        try
        {
            background = ImageIO.read(getClass().getResource("/sprites/background.png"));
        }
        catch (Exception ex)
        {//display error message if the background can't be loaded
            System.err.println("ERROR LOADING BACKGROUND");
        }        //array for timer
        time = new String[5];
        for (int counter = 0; counter < time.length; counter ++) 
        {
            time[counter] = ""; 
        }//array for enemies
        theenemy = new enemy[3];
        for (int counter = 0; counter < 3; counter ++) 
        {
            theenemy[counter] = new enemy(); 
        }
        
        gametimer = new Timer(10, this);
        startTimer();
    }
    
   
    @Override
    public void paintComponent(Graphics g)
    {//display sprites and backgrounds
        super.paintComponent(g);
        Graphics2D g2d = (Graphics2D) g;
        g2d.drawImage(background, 0, 0, null); 
        theplayer.draw(g2d); 
        thetreasure.draw(g2d);
        thedoor.draw(g2d);
        //display all enemy sprites in array
        for(int counter = 0; counter  <3; counter++)
        {
            theenemy[counter].draw(g2d);
        }
        this.draw(g2d);
        g.dispose();
    }
    
 //if player gets 120 points 
    public void draw(Graphics2D g)
    {
        if(theplayer.getScore() == 120)
        {
            displayWinScoreboard(g);
            theplayer.stop();
        }
        else
        {
                     
        }
    }
    
  //display win message
    public void displayWinScoreboard(Graphics2D g)
    {
            g.drawString("you're winner", 200, 200);
            g.drawString("score: " + theplayer.getScore(), 200, 220);
           
          
    }
  
   //calls the treasure check collision
    public boolean collisionstreasure()
    {
       
        if(theplayer.score != 100) 
        { 
           
            collided = theplayer.checkCollision(thetreasure);
            if(collided)
            {
                
                return true;
            }
            else
            {
               
                return false;
            }
        }
        else
        {
           
            return false;
        }
    }
//call check collision between Player and Enemy methods
    public void collisions()
    {
      theplayer.checkCollision(theenemy);
      theplayer.checkCollision(thetreasure);
      theplayer.checkCollision(thedoor);
    }//call player movement method
public void movement()
    {
        theplayer.doMove();
    }
    
   //start timer
    public void startTimer()
    {
       gametimer.start();
       currenttimer = 0;
       timesincegamestart = 0;
    }
    
    //stop timer
    public void stopTimers()
    {
        gametimer.stop();
        repaint();
    }
    
    
    @Override//call collisions, movement and repaint methods
    public void actionPerformed(ActionEvent ae)
    {   

        collisions();
        movement();
        repaint();
    }


   
    private class TAdapter extends KeyAdapter
    {
        @Override//setup key presses
        public void keyPressed(KeyEvent e)
        {
            
            int move = 0;
            switch (e.getKeyCode())
            {
                case KeyEvent.VK_UP:
                    move = 1;
                    break;
                case KeyEvent.VK_DOWN:
                    move = 2;
                    break;   
                case KeyEvent.VK_LEFT:
                    move = 3;
                    break;   
                case KeyEvent.VK_RIGHT:
                    move = 4;
                    break;                    
            }
            theplayer.move(move);      
        }

        @Override//if player stops pressing a key stop movement
        public void keyReleased(KeyEvent e)
        {
            theplayer.stop();
        }
    }
}