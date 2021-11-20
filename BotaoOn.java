import greenfoot.*; 

public class BotaoOn extends Navegador
{
    private BotaoOff btOff;
    private BotaoStart botaoStart;
    
    public BotaoOn (BotaoStart botaoStart){
        this.botaoStart = botaoStart;
    }
    
    public void act() 
    {
       if(Greenfoot.mouseClicked(this)){
         botaoStart.setLigada(true);
         this.setImage("btt_on.png");
         botaoStart.getSom().setVolume(100);
         botaoStart.getSom().stop();
         botaoStart.getSom().play();
         btOff.setImage("btt_off_des.png");
       }
    }    
    
    public void setBtOff(BotaoOff btOff ){
       this.btOff = btOff;
    }
    
}
