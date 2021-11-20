import greenfoot.*; 
import java.awt.event.ActionEvent;  
import java.awt.event.ActionListener;  
import javax.swing.Timer;


  
public class Contador extends Actor
{
    private int tempo;
    private Timer timer;  
    private int current;  
    private int minuto = 0;
    private Mapa mapa;
    public Contador(Mapa m){
         this.setImage(new GreenfootImage("TEMPO 00:00", 30, Color.BLACK, new Color(200,200,200,150)));
         this.mapa = m;
         this.go();  
    }
    
    public int getMinuto(){
        return this.minuto;
    }

    public void act() 
    {
       mostra(); 
    }    
    
    
    public void mostra(){
       if(minuto == 3){ 
        current = 0;
        tempo = 0;
        minuto = 0;
        if(mapa.getBuffanVidas() == 1  || mapa.getPeidinVidas() == 1){
            if(mapa.getBuffanVidas() > mapa.getPeidinVidas()){
                GameOver over = new GameOver(mapa.getLigado());
                over.setBackground("buffan_wins.png");
                mapa = null;
                Greenfoot.setWorld(over);
            }else if(mapa.getBuffanVidas() < mapa.getPeidinVidas()){
                GameOver over = new GameOver(mapa.getLigado());
                over.setBackground("peidin_wins.png");
                mapa = null;
                Greenfoot.setWorld(over);
            }else{
                GameOver over = new GameOver(mapa.getLigado());
                over.setBackground("empate.png");
                mapa = null;
                Greenfoot.setWorld(over);
            }
        }else if(mapa.getLigado()){
           Mapa novoMapa = new Mapa(true, mapa.getPeidinVidas() -1 , mapa.getBuffanVidas() -1);
           mapa.getSom().stop();
           mapa = null;
           Greenfoot.setWorld(novoMapa);
        }else{
           Mapa novoMapa = new Mapa(false, mapa.getPeidinVidas() -1 , mapa.getBuffanVidas() -1);
           mapa = null;
           Greenfoot.setWorld(novoMapa);
        }
      }
       
       if(current < 10 && minuto > 0 && tempo <= 59){
         this.setImage(new GreenfootImage("TIMER 0"+minuto+":" +"0"+ tempo , 30, Color.BLACK, new Color(200,200,200,150)));
       }else if(current >= 10 && minuto > 0 && tempo <= 59){
         this.setImage(new GreenfootImage("TIMER 0"+minuto+":" + tempo , 30, Color.BLACK, new Color(200,200,200,150)));
       }else if(current < 10 && minuto == 0 && tempo <= 59){ 
         this.setImage(new GreenfootImage("TIMER 00:0" + tempo , 30, Color.BLACK, new Color(200,200,200,150)));
       }else if(current >= 10 && minuto == 0 && tempo <= 59){
         this.setImage(new GreenfootImage("TIMER 00:" + tempo , 30, Color.BLACK, new Color(200,200,200,150)));
       }
       
       if(current == 60){
         this.minuto ++;  
         current = 0;
         tempo = 0;
       }
       
    }
    
    public void go() {  
        ActionListener action = new ActionListener() {  
            public void actionPerformed(ActionEvent e) {  
                ++current;
                tempo = current;
            }  
        };  
        this.timer = new Timer(1000, action);  
        this.timer.start();  
    }  
    
    
  
}
