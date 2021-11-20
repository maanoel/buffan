import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class BotaoOff here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class BotaoOff extends Navegador
{
    BotaoOn botaoOn;
    BotaoStart botaoStart;
    
    public BotaoOff(BotaoStart botaoStart){
        this.botaoStart = botaoStart;
    }
    
    public BotaoOff(boolean b){
    
     
    }
    
    public void act() 
    {
       if(Greenfoot.mouseClicked(this)){
        
         botaoStart.setLigada(false);   
         this.setImage("btt_off.png");
         botaoStart.getSom().setVolume(0);
         botaoOn.setImage("btt_on_des.png");
       }
    }
    
     public void setBotaoOn(BotaoOn botaoOn ){
       this.botaoOn = botaoOn;
    }
}
