import greenfoot.*; 

public class Buffan extends Personagens
{
    public Buffan(String nome, Mapa p, Contador contador){
        super(nome, p, contador);
    }

    public void parado(){
        if(key== "down"){
            setImage(nomePersonagem +"_03.png"); 
        }else if (key == "up"){
            setImage(nomePersonagem + "_18.png");
        }else{
            key = "parado";
            setImage(nomePersonagem +"_03.png"); 
        }
    }

    public void act() 
    {
        mover();
        encontrouBonus();
        if(Greenfoot.isKeyDown("space") ){ 
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
        }else if(Greenfoot.isKeyDown("p"))
        {
            mover(5);
        } else {
            mover(6);
        }

    }
}
