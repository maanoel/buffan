import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class TelaInicial here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class TelaInicial extends World
{
    /**
     * Constructor for objects of class TelaInicial.
     * 
     */
    private BotaoOff botaooff;
    private BotaoOn botaoon;
    
    private boolean somOn;
    private BotaoStart bttStart;
    
    public TelaInicial()
    {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(420, 400, 1);
        this.somOn = true;
        prepare();
    }
   
    public void desligar(){
        bttStart.setSomOn(false);
        botaooff.setImage("btt_off.png");
        botaoon.setImage("btt_on_des.png");
    }
   
    
    /**
     * Prepare the world for the start of the program. That is: create the initial
     * objects and add them to the world.
     */
    private void prepare()
    {
       bttStart = new BotaoStart();
       addObject(bttStart,200,100);

       BotaoInfo bttInfo = new BotaoInfo(bttStart);
       addObject(bttInfo,200,170);

       BotaoSom bttSom = new BotaoSom();
       addObject(bttSom, 200, 230);

       botaoon = new BotaoOn(bttStart);
       addObject(botaoon, 139, 304);
       botaoon.setLocation(144, 302);
        
       botaooff = new BotaoOff(bttStart);
       addObject(botaooff, 279, 302);
        
       botaooff.setBotaoOn(botaoon);
       botaoon.setBtOff(botaooff);
        
       
    }
}
