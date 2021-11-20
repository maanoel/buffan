import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.util.ArrayList;

/**
 * Write a description of class Bosta here.
 * 
 * @author (your name) 
 * @version (1.1)
 */
public class Bosta extends Actor
{
    private boolean explodir;
    private int timer;
    private Personagens personagem;
    private Rolo rolo;
    private Rolo02 rolo02;
    private boolean ligado;

    public Bosta(boolean ligado){
        this.ligado = ligado;
    }

    public Bosta( ){

    }

    public void act() {
        if(explodir){
            bombaCruz();
        } 
    }  

    /**
     * Faz a explosão de uma bomba, não recebe parâmetro e seu tipo de retorno é void.
     */
    public void explodir(){
        this.explodir = true;
        atigindo();
    }

    private void bombaCruz(){
        timer ++;
        if(timer == 6)
            setImage("bufa_efeito_1.gif");
        if(timer == 11)
            setImage("bufa_efeito_2.gif");
        if(timer == 16)
            setImage("bufa_efeito_3.gif");
        if(timer == 21)
            setImage("bufa_efeito_4.gif");
        if(timer == 26)
            setImage("bufa_efeito_5.gif");
        if(timer == 31)
            setImage("bufa_efeito_6.gif");
        if(timer == 36)
            setImage("bufa_efeito_7.gif");
        if(timer == 41)
            setImage("bufa_efeito_8.gif");
        if(timer == 46)
            setImage("bufa_efeito_9.gif");
        if(timer == 51)
            setImage("bufa_efeito_10.gif");  
        if(timer == 56)
            setImage("bufa_efeito_11.gif"); 
        if(timer == 61)
            setImage("bufa_efeito_12.gif"); 
        if(timer == 66){
            setImage("bufa_efeito_13.gif");
            timer = 0;
            explodir = false;  
            getWorld().removeObject(this);
        } 
    }

    /**
     * Faz o efeito de uma cruz no mapa.
     */
    public void explodir(Bosta b){
        int x = b.getX(); 
        int y = b.getY(); 

        if(this.ligado){
            Greenfoot.playSound("bomba.wav"); 
        }

        int contUm = 15, contDois = 30, contTres = 40;
        
        Bosta bosta2 = new Bosta();
        Bosta bosta3 = new Bosta();
        Bosta bosta4 = new Bosta();
        Bosta bosta5 = new Bosta();
        Bosta bosta6 = new Bosta();
        Bosta bosta7 = new Bosta();
        Bosta bosta8 = new Bosta();
        Bosta bosta9 = new Bosta();

        if(getOneObjectAtOffset(-contUm,0,Privada.class)==null && getOneObjectAtOffset(-contUm,0,Borda.class)==null) {
            getWorld().addObject(bosta3, x-contUm, y);
            bosta3.explodir();
        }  
        if(getOneObjectAtOffset(-contDois,0,Privada.class)==null && getOneObjectAtOffset(-contDois,0,Borda.class)==null && getOneObjectAtOffset(-contDois,0,Rolo.class)==null && getOneObjectAtOffset(-contDois,0,Rolo02.class)==null) {
            getWorld().addObject(bosta2, x-contDois, y);
            bosta2.explodir();
        }

        if(getOneObjectAtOffset(+contUm,0,Privada.class)==null && getOneObjectAtOffset(+contUm,0,Borda.class)==null) {
            getWorld().addObject(bosta4, x+contUm, y);
            bosta4.explodir();          
        }        
        if(getOneObjectAtOffset(+contDois,0,Privada.class)==null && getOneObjectAtOffset(+contDois,0,Borda.class)==null && getOneObjectAtOffset(+contDois,0,Rolo.class)==null && getOneObjectAtOffset(+contDois,0,Rolo02.class)==null) {
            getWorld().addObject(bosta5, x+contDois, y);
            bosta5.explodir();  
        }

        if(getOneObjectAtOffset(0,-contUm,Privada.class)==null && getOneObjectAtOffset(0,-contUm,Borda.class)==null) {
            getWorld().addObject(bosta7, x, y-contUm);
            bosta7.explodir();    
        }

        if(getOneObjectAtOffset(0,-contDois,Privada.class)==null && getOneObjectAtOffset(0,-contDois,Borda.class)==null && getOneObjectAtOffset(0,-contTres,Rolo.class)==null && getOneObjectAtOffset(0,-contTres,Rolo02.class)==null) {
            getWorld().addObject(bosta6, x, y-contDois);            
            bosta6.explodir();
        }

        if(getOneObjectAtOffset(0,+contUm,Privada.class)==null && getOneObjectAtOffset(0,+contUm,Borda.class)==null) {
            getWorld().addObject(bosta8, x, y+contUm);
            bosta8.explodir();       
        }

        if(getOneObjectAtOffset(0,+contDois,Privada.class)==null && getOneObjectAtOffset(0,+contDois,Borda.class)==null  && getOneObjectAtOffset(0,+contTres,Rolo.class)==null && getOneObjectAtOffset(0,+contTres,Rolo02.class)==null) {
            getWorld().addObject(bosta9, x, y+contDois);
            bosta9.explodir();
        }

    }        

    public void atigindo(){
        personagem = (Personagens) getOneIntersectingObject(Personagens.class);
        if(personagem != null){
            personagem.matarPersonagem(); 
        }

        rolo = (Rolo) getOneIntersectingObject(Rolo.class);
        if (rolo != null){
            getWorld().removeObject(rolo);
        }

        rolo02 = (Rolo02) getOneIntersectingObject(Rolo02.class);
        if (rolo02 != null){
            getWorld().removeObject(rolo02);
        }       

    }

} 
