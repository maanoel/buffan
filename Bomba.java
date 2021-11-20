import greenfoot.*;  
import java.util.ArrayList;
import javax.swing.JOptionPane;

public class Bomba extends Actor
{
    private boolean explodir;
    private int timer;
    private Personagens personagem;
    private RoloDireita RoloDireita;
    private RoloEsquerda RoloEsquerda;
    private boolean ligado;
    private boolean forca;

    public Bomba(boolean ligado, boolean forca){
        this.ligado = ligado;
        this.forca = forca;
    }

    public Bomba( ){

    }

    public void act() {
        if(explodir){
            bombaCruz();
        } 
    }  

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

    public void explodir(Bomba b){
        int x = b.getX(); 
        int y = b.getY(); 

        if(this.ligado){
            Greenfoot.playSound("bomba.wav"); 
        }

        int contUm = 15, contDois = 30, conTres = 45;
        Pilha pilha = new Pilha();
        for(int i = 0; i < 12; i ++){
            try{
                pilha.empilha(new Bomba());
            }catch (Exception e){
                JOptionPane.showMessageDialog(null, "Estouro de pilha"); 
            }      
        }

        if(getOneObjectAtOffset(-contUm,0,Privada.class)==null && getOneObjectAtOffset(-contUm,0,Borda.class)==null) {
           getWorld().addObject((Bomba)pilha.topoPilha(), x-contUm, y);
           ((Bomba) pilha.topoPilha()).explodir();
           pilha.desempilha();
        }  
        if(getOneObjectAtOffset(-contDois,0,Privada.class)==null && getOneObjectAtOffset(-contDois,0,Borda.class)==null && getOneObjectAtOffset(-contDois,0,RoloDireita.class)==null && getOneObjectAtOffset(-contDois,0,RoloEsquerda.class)==null) {
            getWorld().addObject((Bomba) pilha.topoPilha(), x-contDois, y);
            ((Bomba) pilha.topoPilha()).explodir();
            pilha.desempilha();
        }

        if(getOneObjectAtOffset(+contUm,0,Privada.class)==null && getOneObjectAtOffset(+contUm,0,Borda.class)==null) {
            getWorld().addObject((Bomba) pilha.topoPilha(), x+contUm, y);
            ((Bomba) pilha.topoPilha()).explodir();
            pilha.desempilha();       
        }        
        if(getOneObjectAtOffset(+contDois,0,Privada.class)==null && getOneObjectAtOffset(+contDois,0,Borda.class)==null && getOneObjectAtOffset(+contDois,0,RoloDireita.class)==null && getOneObjectAtOffset(+contDois,0,RoloEsquerda.class)==null) {
           getWorld().addObject((Bomba) pilha.topoPilha(), x+contDois, y);
           ((Bomba) pilha.topoPilha()).explodir(); 
           pilha.desempilha();
        }

        if(getOneObjectAtOffset(0,-contUm,Privada.class)==null && getOneObjectAtOffset(0,-contUm,Borda.class)==null) {
            getWorld().addObject((Bomba)pilha.topoPilha(), x, y-contUm);
            ((Bomba) pilha.topoPilha()).explodir(); 
            pilha.desempilha();   
        }

        if(getOneObjectAtOffset(0,-contDois,Privada.class)==null && getOneObjectAtOffset(0,-contDois,Borda.class)==null && getOneObjectAtOffset(0,-conTres,RoloDireita.class)==null && getOneObjectAtOffset(0,-conTres,RoloEsquerda.class)==null) {
            getWorld().addObject((Bomba) pilha.topoPilha(), x, y-contDois);            
            ((Bomba) pilha.topoPilha()).explodir(); 
            pilha.desempilha();  
        }

        if(getOneObjectAtOffset(0,+contUm,Privada.class)==null && getOneObjectAtOffset(0,+contUm,Borda.class)==null) {
            getWorld().addObject((Bomba) pilha.topoPilha(), x, y+contUm);
           ((Bomba) pilha.topoPilha()).explodir(); 
            pilha.desempilha();     
        }

        if(getOneObjectAtOffset(0,+contDois,Privada.class)==null && getOneObjectAtOffset(0,+contDois,Borda.class)==null  && getOneObjectAtOffset(0,+conTres,RoloDireita.class)==null && getOneObjectAtOffset(0,+conTres,RoloEsquerda.class)==null) {
            getWorld().addObject((Bomba) pilha.topoPilha(), x, y+contDois);
            ((Bomba) pilha.topoPilha()).explodir(); 
            pilha.desempilha();
        }
        // Se personagem pegar bônus de força.
        if (forca == true) {
            if(getOneObjectAtOffset(-contDois,0,Privada.class)==null && getOneObjectAtOffset(-contDois,0,Borda.class)==null && getOneObjectAtOffset(-contDois,0,RoloDireita.class)==null && getOneObjectAtOffset(-contDois,0,RoloEsquerda.class)==null && getOneObjectAtOffset(-conTres,0,Privada.class)==null && getOneObjectAtOffset(-conTres,0,Borda.class)==null && getOneObjectAtOffset(-conTres,0,RoloDireita.class)==null && getOneObjectAtOffset(-conTres,0,RoloEsquerda.class)==null) {
                getWorld().addObject((Bomba) pilha.topoPilha(), x-conTres, y);
                ((Bomba) pilha.topoPilha()).explodir(); 
                pilha.desempilha();
            }

            if(getOneObjectAtOffset(+contDois,0,Privada.class)==null && getOneObjectAtOffset(+contDois,0,Borda.class)==null && getOneObjectAtOffset(+contDois,0,RoloDireita.class)==null && getOneObjectAtOffset(+contDois,0,RoloEsquerda.class)==null && getOneObjectAtOffset(+conTres,0,Privada.class)==null && getOneObjectAtOffset(+conTres,0,Borda.class)==null && getOneObjectAtOffset(+conTres,0,RoloDireita.class)==null && getOneObjectAtOffset(+conTres,0,RoloEsquerda.class)==null) {
                getWorld().addObject( (Bomba) pilha.topoPilha(), x+conTres, y);
               ((Bomba) pilha.topoPilha()).explodir(); 
                pilha.desempilha();
            }

            if(getOneObjectAtOffset(0,+contDois,Privada.class)==null && getOneObjectAtOffset(0,+contDois,Borda.class)==null  && getOneObjectAtOffset(0,+contDois,RoloDireita.class)==null && getOneObjectAtOffset(0,+contDois,RoloEsquerda.class)==null && getOneObjectAtOffset(0,+conTres,Privada.class)==null && getOneObjectAtOffset(0,+conTres,Borda.class)==null && getOneObjectAtOffset(0,+conTres,RoloDireita.class)==null && getOneObjectAtOffset(0,+conTres,RoloEsquerda.class)==null) {
                getWorld().addObject((Bomba) pilha.topoPilha(), x, y+conTres);
                ((Bomba) pilha.topoPilha()).explodir(); 
                pilha.desempilha();
            }
            if(getOneObjectAtOffset(0,-contDois,Privada.class)==null && getOneObjectAtOffset(0,-contDois,Borda.class)==null && getOneObjectAtOffset(0,-contDois,RoloDireita.class)==null && getOneObjectAtOffset(0,-contDois,RoloEsquerda.class)==null && getOneObjectAtOffset(0,-conTres,Privada.class)==null && getOneObjectAtOffset(0,-conTres,Borda.class)==null && getOneObjectAtOffset(0,-conTres,RoloDireita.class)==null && getOneObjectAtOffset(0,-conTres,RoloEsquerda.class)==null) {
                getWorld().addObject((Bomba) pilha.topoPilha(), x, y-conTres);
               ((Bomba) pilha.topoPilha()).explodir(); 
                pilha.desempilha();
            }
        }

    }        

    public void atigindo(){
        personagem = (Personagens) getOneIntersectingObject(Personagens.class);
        if(personagem != null){
            personagem.matarPersonagem(); 
        }

        RoloDireita = (RoloDireita) getOneIntersectingObject(RoloDireita.class);
        if (RoloDireita != null){
            getWorld().removeObject(RoloDireita);
        }

        RoloEsquerda = (RoloEsquerda) getOneIntersectingObject(RoloEsquerda.class);
        if (RoloEsquerda != null){
            getWorld().removeObject(RoloEsquerda);
        }       

    }

} 
