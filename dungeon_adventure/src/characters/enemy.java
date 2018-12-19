package characters;
//import resources 
import dungeon_adventure.vector;
import dungeon_adventure.game;
import java.awt.Rectangle;
import java.awt.image.BufferedImage;
import javax.imageio.ImageIO;
import java.awt.Graphics2D;
import java.io.IOException;
import java.util.Random;
import java.awt.Graphics2D;
//initilise varibles
public class enemy {
    
    private player theplayer;
    private vector position;
    private int spritewidth;
    private int spriteheight;
    private boolean isVisible;
    private int RandX, RandY;
    private BufferedImage sprite;
    //load enemy sprite
    public enemy()
    {
      
        
        try
        {
            sprite = ImageIO.read(getClass().getResourceAsStream("/sprites/enemy.png"));
        }catch(IOException ex)
        {
            System.err.println("ERROR LOADING ENEMY SPRITE");
        }
        spritewidth = sprite.getWidth();
        spriteheight = sprite.getHeight();
        isVisible = true;  
        respawn();
    }
    //return enemy sprite
    public BufferedImage getSprite()
    {
        return sprite;
    }
    // get collision boundries 
    public Rectangle getBounds()
    {
        Rectangle objectRect = new Rectangle(position.getX(), position.getY(), spritewidth, spriteheight);
        return objectRect; 
    }
    //set enemy position
    public void setPosition(vector v)
    {
        position.setToVector(v);
    }
    //get enemy position
    public vector getPosition()
    {
        return position;
    }
    //set visible varible
    public void setVisible(boolean visible)
    {
        isVisible = visible;
    }
    //get visible varible
    public boolean getVisible()
    {
        return isVisible;
    }
    //draw enemy sprite
 public void draw(Graphics2D g)
    {   
     if(isVisible == true){   
     g.drawImage(sprite, position.getX(), position.getY(), null);
       }
    }
 
  // respawn enemy
    public void respawn()
    {
      
        Random rand = new Random();
        RandX = rand.nextInt(game.WINDOW_WIDTH - sprite.getWidth());
        RandY = rand.nextInt(game.WINDOW_HEIGHT - sprite.getHeight() );
        {
            position = new vector(RandX, RandY);
        } 
    }


}
