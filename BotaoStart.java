import greenfoot.*; 

/**
 * Write a description of class botao_start here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class BotaoStart extends Navegador
{
    private GreenfootSound som; 
    private boolean ligada = true;
    private boolean off = true;
    private boolean somOn;
    
    public BotaoStart(){
        this.som = new GreenfootSound("tela-inicial.mp3");        
        this.som.setVolume(100);
        this.somOn= true;
    }
    
    public void setSomOn(boolean somOn){
        this.somOn = somOn;
    }
    
    public void act() 
    {
        if(!this.som.isPlaying() && off && somOn){
           som.play();
        }
      
        if (Greenfoot.mouseClicked(this))
        {
            this.som.stop();    
            Greenfoot.setWorld(new Mapa(getLigada()));
        }     
    }
    
    public void setSom(GreenfootSound som){
         this.som = som;
    }
    
    public GreenfootSound getSom(){
        return this.som;
    }
    
    public void setLigada(boolean ligada){
       this.ligada = ligada;
    }
    
    public boolean getLigada(){
        return this.ligada;
    }
    
    public void setOff(boolean off){
        this.off = off;
    }
    
    public boolean getOff(){
        return this.off;
    }
    
    public String toString(){
        return "Botao Start";
    }
}
