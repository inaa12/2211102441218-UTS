import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class plum here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Plum extends Block
{
    /**
     * Act - do whatever the plum wants to do. This method is called whenever
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
        world.grow(2);
    }
}
