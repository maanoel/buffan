import greenfoot.*; 
public class Regras extends Abas
{
    public void act() 
    {
        if(Greenfoot.mouseClicked(this)){
         regraInfo = new RegrasInfo();
         getWorld().addObject(regraInfo, 228, 235);     
       }
    }    
}
