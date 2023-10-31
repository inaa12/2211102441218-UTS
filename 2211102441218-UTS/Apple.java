import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Apple here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Apple extends Block
{
    /**
     * Act - do whatever the Apple wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        // Add your action code here.
    }    
    public void collision(SnakeWorld world) {
        Greenfoot.playSound("slurp.mp3");
        setLocation(Greenfoot.getRandomNumber(getWorld().getWidth()-2) +1, 
            Greenfoot.getRandomNumber(getWorld().getHeight()-2)+1);
        world.grow(1);
    }
}
