import greenfoot.*;  
public class TelaInicial extends World
{
    private BotaoOff botaooff;
    private BotaoOn botaoon;
    private boolean somOn;
    private BotaoStart bttStart;
    
    public TelaInicial()
    {    
        super(450, 450, 1);
        this.somOn = true;
        prepare();
    }
   
    public void desligar(){
        bttStart.setSomOn(false);
        botaooff.setImage("btt_off.png");
        botaoon.setImage("btt_on_des.png");
    }
   
    private void prepare()
    {
       bttStart = new BotaoStart();
       addObject(bttStart,222,125);

       BotaoInfo bttInfo = new BotaoInfo(bttStart);
       addObject(bttInfo,222,185);

       BotaoSom bttSom = new BotaoSom();
       addObject(bttSom, 222, 245);

       botaoon = new BotaoOn(bttStart);
       addObject(botaoon, 139, 304);
       botaoon.setLocation(165, 300);
        
       botaooff = new BotaoOff(bttStart);
       addObject(botaooff, 300, 300);
        
       botaooff.setBotaoOn(botaoon);
       botaoon.setBtOff(botaooff);
    }
}
