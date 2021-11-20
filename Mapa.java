import greenfoot.*; 
import java.util.*;
/**
 * Write a description of class Mapa here.
 * 
 * @author (Equipe Trovão) 
 * @version (18/05/2012)
 */
public class Mapa extends World
{
    private int x, y;
    private static final int altura = 450; 
    private static final int largura = 450;
    private GreenfootSound som;
    private boolean ligado;
    private Contador contador = new Contador(this);
    private Personagens buffan = new Buffan("buffan", this, contador); 
    private Personagens peidin = new Peidin("peidin", this, contador);
    private List <BuffanVida> buffanVidas;
    private List <PeidinVida> peidinVidas;
    private int valorBuffan = 3;
    private int valorPeidin = 3;
    private Bonus vida = new Vida();
    
    public Mapa(boolean ligado){    
        super(largura,altura,1); 
        this.ligado = ligado;
        ligarSom();
        prepare();
    }

    public Mapa(boolean ligado, int numPeidinVidas, int numBuffanVidas){
        super(largura,altura,1);
        this.ligado = ligado;
        valorPeidin = numPeidinVidas;
        valorBuffan = numBuffanVidas;
        ligarSom();
        prepare(); 
    }
    
    public Mapa(boolean ligado, int contadorVida, String nome, int numPeidinVidas, int numBuffanVidas){
        super(largura,altura,1);
        this.ligado = ligado;
        if(nome == "buffan"){
            valorBuffan = contadorVida;
            valorPeidin = numPeidinVidas;
        }else{
            valorPeidin = contadorVida;
            valorBuffan = numBuffanVidas;
        }
        ligarSom();
        prepare();
    }
    
    //Setters
    public void setBuffanVidas(int valor){
        this.valorBuffan = valor;
    }

    public void setPeidinVidas(int valor){
        this.valorPeidin = valor;
    }

    //Getters
    public boolean getLigado(){
        return this.ligado;
    }

    public GreenfootSound getSom(){
        return this.som;
    }

    public Personagens getBuffa(){
        return this.buffan;
    }

    public Personagens getPeidin(){
        return this.peidin;
    }
    
    public int getBuffanVidas(){
        return this.valorBuffan;
    }

    public int getPeidinVidas(){
        return this.valorPeidin;
    }
    
    public Contador getContador(){
        return this.contador;
    }

    public void ligarSom(){
        if(this.ligado){
            buffan.setLigado(this.ligado);
            peidin.setLigado(this.ligado);
            buffan.setContador(this.contador);
            peidin.setContador(this.contador);
            this.som = new GreenfootSound("musicamapa.mp3");
            this.som.setVolume(70);
            this.som.play();
        } 
    }
    
   private Bonus sortearBonus(int valor){
        if(valor == 1){
            return vida;
        }else if(valor == 2){
            return new Velocidade();
        }
        return new Forca();
    }


    private void criarVidasDeBuffan(){
        buffanVidas = new ArrayList<BuffanVida>();
        for(int i=0;i<4;i++){
            buffanVidas.add(new BuffanVida());
        }
    }
    
    private void criarVidasPeidin(){
        peidinVidas = new ArrayList<PeidinVida>();
        for(int i=0;i<4;i++){
            peidinVidas.add(new PeidinVida());
        }
    }
    
    private void criarBonus(){
        //Cria os bonus aleatoriamente no mapa.
        for(int i = 0; i < 6; i++){
            //Vai sortear o bonus.
            int bonusDaVez = Greenfoot.getRandomNumber(6); 

            //Pega todos os RoloDireitas do mapa.
            List listaDeRoloDireitas = getObjects(RoloDireita.class);
            List listaDeRoloDireitas02 =  getObjects(RoloEsquerda.class);

            //Gera numeros aleatórios, de acordo com o numero de RoloDireitas no mapa.
            int numeroRandomRoloDireita = Greenfoot.getRandomNumber(listaDeRoloDireitas.size());
            int numeroRandomRoloEsquerda = Greenfoot.getRandomNumber(listaDeRoloDireitas02.size());

            //Procura os RoloDireitas randomicamente.
            RoloDireita RoloDireita = (RoloDireita) listaDeRoloDireitas.get(numeroRandomRoloDireita);
            RoloEsquerda RoloEsquerda = (RoloEsquerda) listaDeRoloDireitas02.get(numeroRandomRoloEsquerda);

            addObject(sortearBonus(bonusDaVez), RoloDireita.getX()-1 , RoloDireita.getY());                        
            addObject(sortearBonus(bonusDaVez), RoloEsquerda.getX()-1 , RoloEsquerda.getY());
        }
    }
    
    private void alocarPrivda(){
        for (x=50; x<450; x+=50)
        {
            for (y = 50; y<380; y+=50){
                addObject(new Privada(), x, y);        
            }
        }  
    }
    
    private void alocarBorda(){
          // Parede SUPERIOR
        for (x=0; x<450; x+=18)
        {
            y = 0;
            addObject(new Borda(), x, y);
        }

        // PAREDE INFERIOR
        for (x=0; x<450; x+=18)
        {
            y = 400;
            addObject(new Borda(), x, y);
        }

        // Parede LADO DIREIO
        for (x=0; x<450; x+=18)
        {
            y = 450;
            addObject(new Borda(), y, x);
        }         

        // Parede LADO ESQUERDO
        for (x=0; x<450; x+=18)
        {
            y = 0;
            addObject(new Borda(), y, x);
        }  
    }
    
    private void alocarRolos(){
        for (x=75; x<425; x+=50)
        {
            for (y = 50; y<375; y+=50){
                addObject(new RoloDireita(), x, y); 
            }
        }

        for (x=75; x<450; x+=100)
        {
            for (y = 25; y<400; y+=100){
                addObject(new RoloEsquerda(), x, y); 
            }
        }
        for (x=75; x<450; x+=100){
            y = 375;
            addObject(new RoloDireita(), x, y);
        }

        for (x=25; x<450; x+=100)
        {
            for (y = 75; y<300; y+=100){
                addObject(new RoloEsquerda(), x, y); 
            }
        } 

        for (x=25; x<450; x+=100){
            for (y = 125; y<400; y+=200){
                addObject(new RoloDireita(), x, y); 
            }
        }
    }
    
    private void alocarVidaBuffan(){
        criarVidasDeBuffan();
        if(valorBuffan == 4){
            addObject(buffanVidas.get(0), 70, 430);
            addObject(buffanVidas.get(1), 90, 430);
            addObject(buffanVidas.get(2), 110, 430);
            addObject(buffanVidas.get(3), 130, 430);
        }

        if(valorBuffan == 3){
            addObject(buffanVidas.get(0), 70, 430);
            addObject(buffanVidas.get(1), 90, 430);
            addObject(buffanVidas.get(2), 110, 430);
        }

        if(valorBuffan == 2) {
            addObject(buffanVidas.get(0), 70, 430);
            addObject(buffanVidas.get(1), 90, 430);
            buffanVidas.get(2).setImage("morto.png");
            addObject(buffanVidas.get(2), 110, 430);
        } 

        if(valorBuffan == 1){
            addObject(buffanVidas.get(0), 70, 430);
            buffanVidas.get(1).setImage("morto.png");
            buffanVidas.get(2).setImage("morto.png");
            addObject(buffanVidas.get(1), 110, 430);
            addObject(buffanVidas.get(2), 90, 430);
        }

        if(valorBuffan == 0){
            buffanVidas.get(0).setImage("morto.png");
            buffanVidas.get(1).setImage("morto.png");
            buffanVidas.get(2).setImage("morto.png");
            addObject(buffanVidas.get(0), 70, 430);
            addObject(buffanVidas.get(1), 90, 430);
            addObject(buffanVidas.get(2), 110, 430);
        }
    }
    
    private void alocarVidaPeidin(){
        criarVidasPeidin();
        if( valorPeidin == 4){
            addObject(peidinVidas.get(0), 310, 430);
            addObject(peidinVidas.get(1), 330, 430);
            addObject(peidinVidas.get(2), 350, 430);
            addObject(peidinVidas.get(3), 370, 430);
        }

        if( valorPeidin == 3){
            addObject(peidinVidas.get(0), 330, 430);
            addObject(peidinVidas.get(1), 350, 430);
            addObject(peidinVidas.get(2), 370, 430);
        }

        if(valorPeidin == 2) {
            peidinVidas.get(0).setImage("morto.png");
            addObject(peidinVidas.get(0), 330, 430);
            addObject(peidinVidas.get(1), 350, 430);
            addObject(peidinVidas.get(2), 370, 430);
        } 

        if(valorPeidin == 1){
            peidinVidas.get(0).setImage("morto.png");
            addObject(peidinVidas.get(0), 330, 430);
            peidinVidas.get(1).setImage("morto.png");
            addObject(peidinVidas.get(1), 350, 430);
            addObject(peidinVidas.get(2), 370, 430);
        }

        if(valorPeidin == 0){
            peidinVidas.get(0).setImage("morto.png");
            addObject(peidinVidas.get(0), 330, 430);
            peidinVidas.get(1).setImage("morto.png");
            addObject(peidinVidas.get(1), 350, 430);
            peidinVidas.get(2).setImage("morto.png");
            addObject(peidinVidas.get(2), 370, 430);
        }
    }
    
    private void alocarPersonagens(){
       addObject(buffan, 30, 30);
       addObject(peidin, largura-30, altura-80);
       addObject(contador, 218, 427);
       setPaintOrder(Borda.class, Privada.class, Bomba.class, RoloDireita.class, RoloEsquerda.class, Bonus.class);
    }
    
    private void prepare()
    {              
       alocarPersonagens();
       alocarVidaBuffan();
       alocarVidaPeidin();
       alocarBorda(); 
       alocarPrivda();
       alocarRolos();     
       criarBonus();
    }   
}

