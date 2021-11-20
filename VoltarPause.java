import greenfoot.*;  

public class VoltarPause extends Actor
{
    private Mapa m;
    public VoltarPause(Mapa m){
        this.m = m;
    }
    
    public void act() 
    {
        if(Greenfoot.mouseClicked(this)){
            m.getContador().setCurrent(m.getPeidin().getCurrentAntigo());
            m.getContador().setTempo(m.getPeidin().getTempoAntigo());
            m.getContador().setMinuto(m.getPeidin().getMinutoAntigo());
            Greenfoot.setWorld(m);
        }
    }    
}
