import greenfoot.*; 

public class Voltar extends Abas
{
    private BotaoStart botaoStart;
    private boolean ligado;
    
    public Voltar(BotaoStart botaoStart){
        this.botaoStart = botaoStart;
    }
    
    public void act() 
    {
       if(Greenfoot.mouseClicked(this)){
           TelaInicial ti = new TelaInicial();
           if(botaoStart.getLigada() == false){
              ti.desligar();
           }
           botaoStart.getSom().stop();
           Greenfoot.setWorld(ti);
       }
    }    
}
