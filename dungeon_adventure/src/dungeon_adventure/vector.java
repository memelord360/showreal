package dungeon_adventure;
//initilise varibles
   public class vector
    {
        private int x;
        private int y;
        public vector()
    //set co-ordinates to 0            
        {
            x = 0;
            y = 0;
        }
//get new co-ordinates for sprites
    public vector(int newX, int newY)
    {
        x = newX;
        y = newY;
    }
//get co-ordinates for sprites
    public vector (vector v)
    {
        x = v.getX();
        y = v.getY();
    }
//add co-ordinates for sprites
    public void add(vector v)
    {
        x += v.getX();
        y += v.getY();
    }
//set co-ordinates for sprites
    public void setToVector(vector v)
    {
        x = v.getX();
        y = v.getY();
    }
//set x co-ordinates
    public void setX(int x)
    {
        this.x = x;
    }
//get x co-ordinates
    public int getX()
    {
        return x;
    }
//set y co-ordinates
    public void setY(int y)
    {
        this.y = y;
    }
//get y co-ordinates
    public int getY()
    {
        return y;
    }
} 
