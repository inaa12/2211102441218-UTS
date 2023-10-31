import greenfoot.*;
import java.util.*;

public class SnakeWorld extends World {
    private LinkedList<SnakeBody> snake = new LinkedList<SnakeBody>();
    private int dx=1;
    private int dy=0;
    private int tailCounter = 0;
    private boolean dead = false;
    private int score = 0;
    
    public SnakeWorld() {
        super(25, 20, 32);
        SnakeBody body = new SnakeBody();
        snake.add(body);
        addObject(body, 2, 2);

        Apple apple = new Apple();
        addObject(apple, 
            Greenfoot.getRandomNumber(getWidth()-2) +1, 
            Greenfoot.getRandomNumber(getHeight()-2)+1);

        Plum plum = new Plum();
        addObject(plum, 
            Greenfoot.getRandomNumber(getWidth()-2) +1, 
            Greenfoot.getRandomNumber(getHeight()-2)+1);
            
        for (int x = 0; x < getWidth(); x++) {
            addObject(new Border(), x, 0);
            addObject(new Border(), x, getHeight() - 1);
        }
        for (int y = 0; y < getHeight(); y++) {
            addObject(new Border(), 0, y);
            addObject(new Border(), getWidth() - 1, y);
        }

        showScore();
    }

    private void showScore() {
        showText("Score: " + score, getWidth() / 2, 1);
    }

    public void act() {
        if(dead) return;
        changeDirection();
        showScore();
        SnakeBody head = snake.getLast();
        head.setImage("yellow-draught.png");
        SnakeBody newHead  = new SnakeBody();
        int newHeadX = head.getX() + dx;
        int newHeadY = head.getY() + dy;

        List<Block> blocks = getObjectsAt(newHeadX, newHeadY, Block.class);
        for(Block block : blocks) {
            block.collision(this);

            if (block instanceof Apple) {
                score += 1;
                showScore();
            }
            
            if (block instanceof Plum) {
                score += 1;
                showScore();
            }

            addObject(newHead, newHeadX, newHeadY);
            snake.add(newHead);
            if(tailCounter ==0){
                SnakeBody tail = snake.removeFirst();
                removeObject(tail);
            } else {
                tailCounter--;
            }
        }
    }

    private void changeDirection() {
        if(Greenfoot.isKeyDown("left") && dx ==0) {
            dx = -1;
            dy = 0;
        }
        if(Greenfoot.isKeyDown("right") && dx ==0) {
            dx = 1;
            dy = 0;
        }
        if(Greenfoot.isKeyDown("down") && dy ==0) {
            dx = 0;
            dy = 1;
        }
        if(Greenfoot.isKeyDown("up") && dy ==0) {
            dx = 0;
            dy = -1;
        }
    }

    public void dead() {
        dead = true;
    }

    public void grow(int size) {
        tailCounter+=size;
    }
}
