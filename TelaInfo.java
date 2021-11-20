import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class TelaInfo here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class TelaInfo extends World
{

    BotaoStart botaoStart;
    public TelaInfo(BotaoStart botaoStart)
    {    
        super(420,400,1); 
        this.botaoStart = botaoStart;
        prepare();
        
    }
    
    private void prepare(){
        Comandos comandos = new Comandos();
        Regras regras = new Regras();
        Sobre sobre = new Sobre();
        
        addObject(comandos, 105, 97);
        addObject(regras, 201, 97);
        addObject(sobre, 296, 97);
        
        ComandosInfo comandoInfo = new ComandosInfo();
        addObject(comandoInfo, 203, 201);
        
        Voltar voltar = new Voltar(botaoStart);
        addObject(voltar, 201, 303); 
    }
}
