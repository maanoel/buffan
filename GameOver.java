import greenfoot.*; 

public class GameOver extends World
{
    public GameOver(boolean ligado)
    { 
        super(450, 450, 1); 
        if(ligado){
            GreenfootSound som = new GreenfootSound("game-over.mp3");
            som.playLoop();
        }
    }
}
