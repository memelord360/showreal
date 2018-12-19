package characters;
//import resources 
import dungeon_adventure.vector;
import dungeon_adventure.sound;
import objects.treasure;
import objects.door;
import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.awt.Graphics2D;
import java.awt.Rectangle;
//initilise varibles
public class player {
    vector position;
    vector displacement;
    
    
    private BufferedImage sprite;
    private int spritewidth;
    private int spriteheight;
    public int score;
    public int health;
   //set player stats
    public player()
    {
        position = new vector(100,100);
        displacement = new vector(0,0);
        score = 0;
        health = 3;
        init();
    }
    //load player sprite
    private void init()
    {
        try
        {
            sprite = ImageIO.read(getClass().getResource("/sprites/character.png"));
        }catch(Exception ex)
        {
            System.err.println("ERROR LOADING PLAYER SPRITE");
        }
        spritewidth = sprite.getWidth();
        spriteheight = sprite.getHeight();
    }
    //set player position
    public void setPosition(vector v)
    {
        position.setToVector(v);
    }
    //get player position
    public vector getPosition()
    {
        return position;
    }
    //get width of player sprite
    public int getSpriteWidth()
    {
        return spritewidth;
    }
    //get height of player sprite
    public int getSpriteHeight()
    {
        return spriteheight;
    }
    //set player score
    public void setScore(int newScore)
    {
        score = newScore;
    }
    //get player sprite
    public int getScore()
    {
        return score;
    }
    //set player health
    public void setHealth(int newHealth)
    {
        health = newHealth;
    }
    //get player health
    public int getHealth()
    {
        return health;
    }
    //return player sprite
    public BufferedImage getSprite()
    {
        return sprite;
    }
    //set player movement
    public void move(int direction)
    {
        switch(direction)
        {
            case 1:
                displacement.setY(-5);
                break;
            case 2:
                displacement.setY(5);
                break;
            case 3:
                displacement.setX(-5);
                break;                
            case 4:
                displacement.setX(5);
        }
    }
    //move player
    public void doMove()
    {           
        position.add(displacement);
    }
    //stop movement
    public void stop()
    {
        displacement.setX(0);
        displacement.setY(0);
    }
    
//get player collision boundrys 
    public Rectangle getBounds()
    {
        Rectangle objectRect = new Rectangle(position.getX(), position.getY(), spritewidth, spriteheight);
        return objectRect;
    }
    
//check player collision with treasure
    public boolean checkCollision(treasure thetreasure) {
       {
       if(thetreasure.getBounds().intersects(getBounds()))
        {
            if(thetreasure.getVisible() == true)
                {
                    thetreasure.respawn();
                    score = score+20;
                }
            return true;
        }
 
       return false;

    }
    }
    //check player collision with door
    public boolean checkCollision(door thedoor) {
       {
       if(thedoor.getBounds().intersects(getBounds()))
        {
            if(thedoor.getVisible() == true)
                {
                    thedoor.spawn();
                    score = score+20;
                }
            return true;
        }
 
       return false;

    }
    }
//check player collision with enemy
    public boolean checkCollision(enemy[] theenemy)
         {
       for(int counter = 0; counter  <3; counter++) 
       {
       if(theenemy[counter].getBounds().intersects(getBounds()))
        {
            if(theenemy[counter].getVisible() == true)
                {//make player take damage
                    theenemy[counter].respawn();
                    health = health-1;
                    //play sound effect
                    sound.play(getClass().getResourceAsStream("/soundResource/collision.wav")); 
                }
            return true;
        }
 }
       return false;

    }//draw player health
       public void draw(Graphics2D g)
    {   
      
        g.drawString("health " + getHealth(), 500, 25);
        if (getHealth() != 0)
        {
          g.drawImage(sprite, position.getX(), position.getY(), null);
         
        }
        ////draw gameover
        if (getHealth() == 0)
        {
            g.drawString("game over", 200, 200);
            stop();
        }
   
    }

}

   


