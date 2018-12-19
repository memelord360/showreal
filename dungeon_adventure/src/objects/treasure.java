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

//initilise varibles
public class treasure {
    
    private player theplayer;
    private vector position;
    private int spritewidth;
    private int spriteheight;
    private boolean isVisible;
    private int RandX, RandY;
    
    private BufferedImage sprite;
    // load treasure sprite
    public treasure(player _thePlayer)
    {
        theplayer = _thePlayer;
        
        try
        {
            sprite = ImageIO.read(getClass().getResourceAsStream("/sprites/treasure.png"));
        }catch(IOException ex)
        {
            System.err.println("ERROR LOADING TREASURE SPRITE");
        }
        //get dimentions of treasure sprite
        spritewidth = sprite.getWidth();
        spriteheight = sprite.getHeight();
        isVisible = true;  
        respawn();
    }

    //get treasure sprite
    public BufferedImage getSprite()
    {
        return sprite;
    }
    //get boundries of sprite collision
    public Rectangle getBounds()
    {
        Rectangle objectRect = new Rectangle(position.getX(), position.getY(), spritewidth, spriteheight);
        return objectRect; 
    }
    //set position of treasure
    public void setPosition(vector v)
    {
        position.setToVector(v);
    }
    //get position of treasure
    public vector getPosition()
    {
        return position;
    }
    //make the sprite visible
    public void setVisible(boolean visible)
    {
        isVisible = visible;
    }
    //check if the sprite is visible
    public boolean getVisible()
    {
        return isVisible;
    }
    
//draw player score
    public void draw(Graphics2D g)
    {   
      
        g.drawString("Score " + theplayer.getScore(), 5, 25);
        if (theplayer.getScore() < 100)
        {
            if(isVisible == true)
            {
                g.drawImage(sprite, position.getX(), position.getY(), null);
            }
        }
    }
    
  
    public void respawn()
    {
      //respawn treasure
        Random rand = new Random();
        RandX = rand.nextInt(game.WINDOW_WIDTH - sprite.getWidth());
        RandY = rand.nextInt(game.WINDOW_HEIGHT - sprite.getHeight() );
        //if the player has collected 5 treasure stop respawning
        if (theplayer.getScore() != 100)
        {
            position = new vector(RandX, RandY);
        } 
        else 
        {
            isVisible = false;
        }
    }
}
