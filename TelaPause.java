import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class TelaPause here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class TelaPause extends World
{    
    BotaoStart botaoStart;
    
    /**
     * Constructor for objects of class TelaPause.
     * 
     */
    public TelaPause()
    {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(450, 450, 1); 
        prepare();
    }

    public void prepare()
    {
        BotaoPause pause = new BotaoPause();
        addObject(pause, 200,150);

        Voltar voltar = new Voltar(botaoStart);
        addObject(voltar, 201, 303); 
    }

}
