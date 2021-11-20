import greenfoot.*; 

public class Sobre extends Abas
{
    public void act() 
    {
        if(Greenfoot.mouseClicked(this)){
         sobreInfo = new SobreInfo();
         getWorld().addObject(sobreInfo, 228, 235); 
       }
    }    
}
