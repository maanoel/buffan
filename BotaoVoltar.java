import greenfoot.*;  

public class BotaoVoltar extends Navegador
{
    public void act() 
    {
        if (Greenfoot.mouseClicked(this))
        {
            Greenfoot.setWorld(new TelaInicial());            
        }
    }    
}
