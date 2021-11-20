import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Sobre here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Sobre extends Abas
{
    /**
     * Act - do whatever the Sobre wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        if(Greenfoot.mouseClicked(this)){
         sobreInfo = new SobreInfo();
         getWorld().addObject(sobreInfo, 203, 201); 
       }
    }    
}
