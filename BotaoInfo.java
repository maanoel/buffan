import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class botao_info here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class BotaoInfo extends Navegador
{
    BotaoStart botaoStart;
   
    public BotaoInfo(BotaoStart botaoStart){
        this.botaoStart = botaoStart;
    }
    
    public void act() 
    {    
        if (Greenfoot.mouseClicked(this))
        {
            Greenfoot.setWorld(new TelaInfo(this.botaoStart));
        }
    }   
}
