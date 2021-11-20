import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class GameOver here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */

public class GameOver extends World
{

    public GameOver(boolean ligado)
    {    
    
        super(450, 450, 1); 
        
        if(ligado){
            GreenfootSound som = new GreenfootSound("game-over.mp3");
            som.playLoop();
        }
    }
}
