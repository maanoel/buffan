import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import javax.swing.JOptionPane;

public class Pilha
{
  
    private int topo = -1;
    private static final int TAMANHO_PILHA = 13;
    private Object[] vet = new Object[TAMANHO_PILHA];
    
    public void act() 
    {
        
    }
    
    public void empilha(Bomba valor) throws Exception{
          if(topo >= TAMANHO_PILHA){ 
             throw new Exception();
          }
          this.topo ++;
          vet[topo] = valor;
    }
    
    public Object desempilha(){
        if(this.topo == -1){
           JOptionPane.showMessageDialog(null, "Pilha Vazia");   
           return null;
        }
        Object valor = vet[topo];
        this.topo --;
        return valor;
    }
    
    public boolean vazia(int valor){
        if(valor == -1){
            return true;
        }else{
            return false;
        }
    }
    
    public Object topoPilha(){
        if(this.topo == -1){
            //Se retornar null a pilha está vazia
            JOptionPane.showMessageDialog(null, "Pilha Vazia");   
            return null;
        }
        return vet[topo];
    }
}
