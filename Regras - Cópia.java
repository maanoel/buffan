import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Regras here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Regras extends Abas
{
    /**
     * Act - do whatever the Regras wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        if(Greenfoot.mouseClicked(this)){
         regraInfo = new RegrasInfo();
         getWorld().addObject(regraInfo, 203, 201);     
       }
    }    
}
