import greenfoot.*;
public class TelaInfo extends World
{

    private BotaoStart botaoStart;
    public TelaInfo(BotaoStart botaoStart)
    {    
        super(450,450,1); 
        this.botaoStart = botaoStart;
        prepare();
        
    }
    
    private void prepare(){
        Comandos comandos = new Comandos();
        Regras regras = new Regras();
        Sobre sobre = new Sobre();
        
        addObject(comandos, 130, 132);
        addObject(regras, 225, 132);
        addObject(sobre, 320, 132);
        
        ComandosInfo comandoInfo = new ComandosInfo();
        addObject(comandoInfo, 228, 235);
        
        Voltar voltar = new Voltar(botaoStart);
        addObject(voltar, 225, 341); 
    }
}
