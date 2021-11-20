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
    int x, y;
    private static final int altura = 450; 
    private static final int largura = 450;
    private GreenfootSound som;
    private boolean ligado;
    
     //Contador
    Contador contador = new Contador(this);
    
    Personagens buffan = new Buffan("buffan", this, contador); 
    Personagens peidin = new Peidin("peidin", this, contador);

    BuffanVida buffanVida1 = new BuffanVida();
    BuffanVida buffanVida2 = new BuffanVida();
    BuffanVida buffanVida3 = new BuffanVida();
    BuffanVida buffanVida4 = new BuffanVida();

    PeidinVida peidinVida1 = new PeidinVida();
    PeidinVida peidinVida2 = new PeidinVida();
    PeidinVida peidinVida3 = new PeidinVida();
    PeidinVida peidinVida4 = new PeidinVida();

    //Valor das Vidas
    int valorBuffan = 3;
    int valorPeidin = 3;
    
    public Mapa(boolean ligado){    
        //Define o tamanho do mapa distância e altura em pixels. (760px  de altura, por 700 de largura) 
        super(largura,altura,1); 
        this.ligado = ligado;
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
    
    public Mapa(boolean ligado, int numPeidinVidas, int numBuffanVidas){
        super(largura,altura,1);
        this.ligado = ligado;
        valorPeidin = numPeidinVidas;
        valorBuffan = numBuffanVidas;
        ligarSom();
        prepare(); 
    }

    private Bonus sortearBonus(int valor){
        if(valor == 1){
            return new Vida();
        }else if(valor == 2){
            return new Velocidade();
        }
        return new Forca();
    }
    
    
    public void ligarSom(){
        if(this.ligado){
            buffan.setLigado(this.ligado);
            peidin.setLigado(this.ligado);
            //buffan.setContador(this.contador);
           // peidin.setContador(this.contador);
            this.som = new GreenfootSound("musicamapa.mp3");
            this.som.play();
        } 
    }
    //Vidas
    public Contador getContador(){
        return this.contador;
    }
    
    public int getBuffanVidas(){
        return this.valorBuffan;
    }

    public int getPeidinVidas(){
        return this.valorPeidin;
    }

    public void setBuffanVidas(int valor){
        this.valorBuffan = valor;
    }

    public void setPeidinVidas(int valor){
        this.valorPeidin = valor;
    }

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

    //Toda vez que o jogo for inicado, teremos um ator na posição 388 , 43 do mapa.
    private void prepare()
    {              
        this.buffanVida1 = new BuffanVida();
        this.buffanVida2 = new BuffanVida();
        this.buffanVida3 = new BuffanVida();

        this.peidinVida1 = new PeidinVida();
        this.peidinVida2 = new PeidinVida();
        this.peidinVida3 = new PeidinVida();
        
        addObject(buffan, 30, 30);
        addObject(peidin, largura-30, altura-80);
        addObject(contador, 218, 427);
        setPaintOrder(Borda.class, Privada.class, Bosta.class);
        //Vidas buffan
        if( valorBuffan == 3){
            addObject(buffanVida1, 70, 430);
            addObject(buffanVida2, 90, 430);
            addObject(buffanVida3, 110, 430);
        }

        if(valorBuffan == 2) {
            addObject(buffanVida1, 70, 430);
            addObject(buffanVida2, 90, 430);
            buffanVida3.setImage("morto.png");
            addObject(buffanVida3, 110, 430);
        } 

        if(valorBuffan == 1){
            addObject(buffanVida1, 70, 430);
            buffanVida2.setImage("morto.png");
            buffanVida3.setImage("morto.png");
            addObject(buffanVida3, 110, 430);
            addObject(buffanVida2, 90, 430);
        }

        if(valorBuffan == 0){
            buffanVida1.setImage("morto.png");
            buffanVida2.setImage("morto.png");
            buffanVida3.setImage("morto.png");
            addObject(buffanVida1, 70, 430);
            addObject(buffanVida3, 110, 430);
            addObject(buffanVida2, 90, 430);
        }

        //Vida Peidin
        if( valorPeidin == 3){
            addObject(peidinVida1, 330, 430);
            addObject(peidinVida2, 350, 430);
            addObject(peidinVida3, 370, 430);
        }

        if(valorPeidin == 2) {
            addObject(peidinVida1, 330, 430);
            addObject(peidinVida2, 350, 430);
            peidinVida3.setImage("morto.png");
            addObject(peidinVida3, 370, 430);
        } 

        if(valorPeidin == 1){
            addObject(peidinVida1, 330, 430);
            peidinVida2.setImage("morto.png");
            peidinVida3.setImage("morto.png");
            addObject(peidinVida3, 350, 430);
            addObject(peidinVida2, 370, 430);
        }

        if(valorPeidin == 0){
            peidinVida1.setImage("morto.png");
            peidinVida2.setImage("morto.png");
            peidinVida3.setImage("morto.png");
            addObject(peidinVida1, 70, 430);
            addObject(peidinVida2, 110, 430);
            addObject(peidinVida3, 90, 430);
        }


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

        // Linhas
        for (x=50; x<450; x+=50)
        {
            for (y = 50; y<380; y+=50){
                addObject(new Privada(), x, y);        
            }
        }  

        /* -----------------------------------------------------------------------------------------
         * Rolos 
        ----------------------------------------------------------------------------------------- */
        for (x=75; x<425; x+=50)
        {
            for (y = 50; y<375; y+=50){
                addObject(new Rolo(), x, y); 
            }
        }

        for (x=75; x<450; x+=100)
        {
            for (y = 25; y<400; y+=100){
                addObject(new Rolo02(), x, y); 
            }
        }
        for (x=75; x<450; x+=100){
            y = 375;
            addObject(new Rolo(), x, y);
        }

        for (x=25; x<450; x+=100)
        {
            for (y = 75; y<300; y+=100){
                addObject(new Rolo02(), x, y); 
            }
        } 

        for (x=25; x<450; x+=100){
            for (y = 125; y<400; y+=200){
                addObject(new Rolo(), x, y); 
            }
        }
        
        //Cria os bonus aleatoriamente no mapa.
        for(int i = 0; i < 10; i++){
            //Vai sortear o bonus.
            int bonusDaVez = Greenfoot.getRandomNumber(3); 
            
            //Pega todos os rolos do mapa.
            List listaDeRolos = getObjects(Rolo.class);
            List listaDeRolos02 =  getObjects(Rolo02.class);
            
            //Gera numeros aleatórios, de acordo com o numero de rolos no mapa.
            int numeroRandomRolo = Greenfoot.getRandomNumber(listaDeRolos.size());
            int numeroRandomRolo02 = Greenfoot.getRandomNumber(listaDeRolos02.size());
            
            //Procura os rolos randomicamente.
            Rolo rolo = (Rolo) listaDeRolos.get(numeroRandomRolo);
            Rolo02 rolo02 = (Rolo02) listaDeRolos02.get(numeroRandomRolo02);
            
            setPaintOrder(Rolo.class);
            addObject(sortearBonus(bonusDaVez), rolo.getX() , rolo.getY());
            
            setPaintOrder(Rolo02.class);
            addObject(sortearBonus(bonusDaVez), rolo02.getX() , rolo02.getY());
        }   
    }   
}

