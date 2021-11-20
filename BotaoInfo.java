import greenfoot.*; 

public class BotaoInfo extends Navegador
{
    private BotaoStart botaoStart;
   
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
