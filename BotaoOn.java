import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class BotaoOn here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class BotaoOn extends Navegador
{
    BotaoOff btOff;
    BotaoStart botaoStart;
    
    public BotaoOn (BotaoStart botaoStart){
        this.botaoStart = botaoStart;
    }
    
    public void act() 
    {
       if(Greenfoot.mouseClicked(this)){
         botaoStart.setLigada(true);
         this.setImage("btt_on.png");
         botaoStart.getSom().setVolume(50);
         botaoStart.getSom().stop();
         botaoStart.getSom().play();
         btOff.setImage("btt_off_des.png");
       }
    }    
    
    public void setBtOff(BotaoOff btOff ){
       this.btOff = btOff;
    }
    
}
