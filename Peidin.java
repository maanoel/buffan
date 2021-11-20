import greenfoot.*; 

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
        if(Greenfoot.isKeyDown("shift")){ 
            if(estaNaHora()){
                cagar();
            }
        }

        //Determina a hora de soltar a bomba
        if(ativo){
            total = finish - start;
        } 

        //Se total for 2000 passou 2 segundos á hora de soltar a bomba
        if(total >= 2000){
            ativo = false;
            Bomba.explodir();
            Bomba.explodir(Bomba);
            total = 0;
        }

        //Verifica se o personagem ainda está vivo
        if(morreu()){  
            trocarImagem();
        }
        currentTime();

    }  

    public String toString(){
        return this.nomePersonagem;
    }

    public void mover()
    {            

        if(Greenfoot.isKeyDown("up")) 
        {
            mover(1);
        }else if(Greenfoot.isKeyDown("down")) 
        {
            mover(2);
        }else if(Greenfoot.isKeyDown("right")) 
        {
            mover(3);        
        }else if(Greenfoot.isKeyDown("left")) 
        {
            mover(4);        
        }else if(Greenfoot.isKeyDown("p"))
        {
            mover(5);
        } else {
            mover(6);
        }

    }
}
