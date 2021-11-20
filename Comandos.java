import greenfoot.*; 

public class Comandos extends Abas
{
   
    public void act() 
    {
       if(Greenfoot.mouseClicked(this)){
         this.comandoInfo = new ComandosInfo();
         getWorld().addObject(comandoInfo, 228, 235);          
       }
    }    
}
