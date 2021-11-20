import greenfoot.*; 
public class TelaPause extends World
{    
    private Mapa m;
    public TelaPause(Mapa m)
    {    
        super(450, 450, 1);  
        this.m = m;
        prepare();
    }

    public void prepare()
    {
        VoltarPause voltar = new VoltarPause(m);
        addObject(voltar, 235, 278); 
    }

}
