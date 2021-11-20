import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Comandos here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Comandos extends Abas
{
    /**
     * Act - do whatever the Comandos wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
       if(Greenfoot.mouseClicked(this)){
         this.comandoInfo = new ComandosInfo();
         getWorld().addObject(comandoInfo, 203, 201);          
       }
    }    
}
