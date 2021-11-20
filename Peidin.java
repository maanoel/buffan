import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Buffan here.
 * 
 * @author (Equipe mais linda da cidade) 
 * @version (1.1)
 */
public class Peidin extends Personagens
{
    public Peidin(String nome, Mapa p, Contador contador){
        super(nome, p, contador);
    }

    //Método implementado que define como este personagem vai ficar parado
    public void parado(){
        if(key== "s"){
            setImage(nomePersonagem +"_03.png"); 
        }else if (key == "w"){
            setImage(nomePersonagem + "_18.png");
        }else{
            key="parado";
            setImage(nomePersonagem +"_03.png"); 
        }
    }

    public void act() 
    {
       mover();
       encontrouBonus();
        //Se a key for space, faz o personagem cagar.
        if(Greenfoot.isKeyDown("space")){ 
            if(estaNaHora()){
                cagar();
            }
        }

        //Determina a hora de soltar a bomba
        if(ativo){
            total = finish - start;
        } 

        //Se total for 3000 passou 3 segundos á hora de soltar a bomba
        if(total >= 3000){
            ativo = false;
            bosta.explodir();
            bosta.explodir(bosta);
            total = 0;
        }

        //Verifica se o personagem ainda está vivo
        if(morreu()){  
            morrer();
        }
        currentTime();

    }  

    public String toString(){
        return this.nomePersonagem;
    }

    public void mover()
    {            
        if(Greenfoot.isKeyDown("w")) 
        {
            mover(1);
        }else if(Greenfoot.isKeyDown("s")) 
        {
            mover(2);
        }else if(Greenfoot.isKeyDown("d")) 
        {
            mover(3);        
        }else if(Greenfoot.isKeyDown("a")) 
        {
            mover(4);        
        }else{
            mover(5);
        }

    }
}
