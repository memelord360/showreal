package objects;
//import resources 
import characters.player;
import characters.player;
import dungeon_adventure.game;
import dungeon_adventure.vector;
import dungeon_adventure.vector;
import java.awt.Rectangle;
import java.awt.image.BufferedImage;
import javax.imageio.ImageIO;
import java.awt.Graphics2D;
import java.io.IOException;
import java.util.Random;


public class door {
    //initialise varibles
    private player theplayer;
    private vector position;
    private int spritewidth;
    private int spriteheight;
    private boolean isVisible;
    private int RandX, RandY;
    private BufferedImage sprite;
    
    public door(player _thePlayer)
    {
        //initilise varibles
        theplayer = _thePlayer;
        position = new vector();
        try
        {//get sprite for door
            sprite = ImageIO.read(getClass().getResourceAsStream("/sprites/door.png"));
        }catch(IOException ex)
        {
            System.err.println("ERROR LOADING DOOR SPRITE");
        }
        //get position of sprite
        position.setX(RandX);
        position.setY(RandY);
        //get dimentions of sprite
        spritewidth = sprite.getWidth();
        spriteheight = sprite.getHeight();
        isVisible = true;  
        spawn();
    }
    //return sprite
    public BufferedImage getSprite()
    {
        return sprite;
    }
    //get collision boundries of sprite
    public Rectangle getBounds()
    {
        Rectangle objectRect = new Rectangle(position.getX(), position.getY(), spritewidth, spriteheight);
        return objectRect; 
    }
    //set position of sprite
    public void setPosition(vector v)
    {
        position.setToVector(v);
    }
    //get position of sprite
    public vector getPosition()
    {
        return position;
    }
    //set visibility of sprite
    public void setVisible(boolean visible)
    {
        isVisible = visible;
    }
    //find if sprite is visible
    public boolean getVisible()
    {
        return isVisible;
    }
    
//display door sprite
    public void draw(Graphics2D g)
    {   
      
        g.drawString("Score " + theplayer.getScore(), 5, 25);
        if (theplayer.getScore() == 100)
        {
            {
                if(isVisible == true)
            
        g.drawImage(sprite, position.getX(), position.getY(), null);
            } 
        }
    }
    //spawn sprite
  
    public void spawn()
    {
      
        Random rand = new Random();
        RandX = rand.nextInt(game.WINDOW_WIDTH - sprite.getWidth());
        RandY = rand.nextInt(game.WINDOW_HEIGHT - sprite.getHeight() );
        if (theplayer.getScore() == 0)
        {//set position of sprite
            position = new vector(RandX, RandY);
        } 
        else 
        {
            isVisible = false;
        }
    }
}
