import greenfoot.*;  

public class BotaoOff extends Navegador
{
    private BotaoOn botaoOn;
    private BotaoStart botaoStart;
    
    public BotaoOff(BotaoStart botaoStart){
        this.botaoStart = botaoStart;
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
