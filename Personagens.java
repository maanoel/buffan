import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Personagens here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public abstract class Personagens extends Actor
{
    //Variaveis contador, servem para determinar quando a imagem deve ser trocada em tempo de execução. Se a variavel contador for 0 troque para imagem um se for for troque para imagem dois 
    private int contadorEsquerda = 0;
    private int contadorDireita = 0;
    private int contadorCima = 0;
    private int contadorBaixo = 0;


    //Key, guarda a ultima se digitada pelo usuário.
    protected String key = "";

    //true se entrou no método de cagar, e false se não entrou
    protected boolean ativo;

    //Conta o tempo da bomba.
    protected long total;
    protected long start;
    protected long finish;

    //Agregação, um personagem pode ter uma ou nem um bosta (0..1), mas toda bosta tem apenas um personagem (1). 0..1 <----- 1.
    protected Bosta bosta;

    //Contar tempo para mudar imagem e diz se morreu ou não
    private int timer;
    protected boolean morreu = false;

    protected String nomePersonagem = "";
    protected boolean ligado;
    
    protected Mapa mapa;
    protected Contador contador;
    
    
    public Personagens (String nomePersonagem, Mapa p, Contador contador){
        this.nomePersonagem = nomePersonagem;
        this.contador = contador;
        this.mapa = p;
    }
    
    public void act() 
    {
        
    }    

    protected void setContador(Contador contador){
        this.contador = contador;
    }
    
    
    protected boolean getLigado(){
        return this.ligado;
    }

    protected void setLigado(boolean ligado){
        this.ligado = ligado;
    }

    public void mover(int a){
        // Checa se o personagem está vivo.
        if (morreu==false){
            switch (a)
            {
                //Move-se para CIMA
                case(1):
                if(contadorCima == 0){
                    setImage(nomePersonagem + "_19.png");
                    contadorCima ++;
                }else{
                    setImage(nomePersonagem + "_20.png");
                    contadorCima = 0;
                }  
                /*
                 * Aqui será feita uma chegagem para saber se há qualquer outro Ator(Barreira, Bosta ou Peidin), caso não haja ele poderá se mover.
                 */
                if(getOneObjectAtOffset(0,-8,null)==null){
                    setLocation(getX(), getY()-1);
                }
                break;

                //Move-se para BAIXO
                case(2):
                if(contadorBaixo == 0){
                    setImage(nomePersonagem +"_05.png");
                    contadorBaixo ++;
                }else{ 
                    setImage(nomePersonagem+ "_07.png");
                    contadorBaixo = 0;           
                }                  
                /*
                 * Aqui será feita uma chegagem para saber se há qualquer outro Ator(Barreira, Bosta ou Peidin), caso não haja ele poderá se mover.
                 */
                if(getOneObjectAtOffset(0,+8,null)==null){
                    setLocation(getX(), getY ()+1);
                }
                break;
                
                //Move-se para DIREITA
                case(3):
                if(contadorEsquerda == 0){
                    setImage(nomePersonagem + "_22.png");
                    contadorEsquerda ++;
                }else{
                    setImage(nomePersonagem + "_24.png");
                    contadorEsquerda = 0;          
                }
                /*
                 * Aqui será feita uma chegagem para saber se há qualquer outro Ator(Barreira, Bosta ou Peidin), caso não haja ele poderá se mover.
                 */
                if(getOneObjectAtOffset(+8,0,null)==null) {
                    setLocation(getX()+1, getY());
                }  
                break;
                //Move-se para ESQUERDA
                case(4):
                if(contadorDireita == 0){
                    setImage(nomePersonagem +"_09.png");
                    contadorDireita ++;
                }else{
                    setImage(nomePersonagem + "_11.png");
                    contadorDireita = 0;
                }   
                /*
                 * Aqui será feita uma chegagem para saber se há qualquer outro Ator(Barreira, Bosta ou Peidin), caso não haja ele poderá se mover.
                 */
                if(getOneObjectAtOffset(-8,0,null)==null){
                    setLocation(getX()-1, getY());
                }
                break;   
                default:
                setImage(nomePersonagem + "_03.png");
            }
        }    
    }

    /**
     *  Recebe o nome do personagem que sera a  imagem alterada, o nome da imagem deve ter o inicio o mesmo nome do personagem.
     */
    public abstract void parado();

    /**
     * Método que vai definir onde o boneco deve cagar e onde sua bosta vai aparecer no mapa.
     */
    public void cagar(){ 
        bosta = new Bosta(this.ligado);
        getWorld().addObject(bosta, getX(), getY());
        ativo = true; 
        start = System.currentTimeMillis();
        if(getLigado()){
            Greenfoot.playSound("peido.wav");
        }
    }

    /**
     * Determina a hora de destruir uma bosta que está instanciada no mapa.
     * O tempo padrão para destruição de um bosta é de 3.5 segundos.
     */
    protected  boolean estaNaHora(){
        if(total >= 3500 || !ativo){
            return true;
        }else{
            return false;   
        }
    }

    /**
     * Retorna a hora atual do sistema do usário.
     */
    protected void currentTime(){
        finish= System.currentTimeMillis();
    }

    protected void morrer(){
        timer ++;        
        if(timer == 6){
            setImage(nomePersonagem+"_35.png");
        }
        if(timer == 11){
            setImage(nomePersonagem +"_36.png");
        }
        if(timer == 16){
            setImage(nomePersonagem+"_31.png");
        }
        if(timer == 21){
            setImage(nomePersonagem +"_33.png");
        }
        if(bosta != null){
            getWorld().removeObject(bosta);   
        }
        getWorld().removeObject(this);  
        
        if(nomePersonagem == "buffan"){
           //Valor antigo do som, ligado ou não.
           boolean b =  mapa.getLigado();
           //Remove o som antigo.
           if(mapa.getSom() != null){
            mapa.getSom().stop();
           }
           int numVidas =  mapa.getBuffanVidas();
           
           if(numVidas == 1){
            GameOver over = new GameOver(mapa.getLigado());
            over.setBackground("peidin_wins.png");
            Greenfoot.setWorld(over);
           }else{
            //Define o novo mundo
            Mapa novoMapa = new Mapa(b, numVidas -1, "buffan", mapa.getPeidinVidas(), mapa.getBuffanVidas());
            Greenfoot.setWorld(novoMapa);
           }
        }else if(nomePersonagem == "peidin"){
           //Valor antigo do som, ligado ou não.
           boolean b =  mapa.getLigado();
           //Remove o som antigo.
           if(mapa.getSom() != null){
            mapa.getSom().stop();
           }
           int numVidas =  mapa.getPeidinVidas();
           
           if(numVidas == 1){
            GameOver over = new GameOver(mapa.getLigado());
            over.setBackground("buffan_wins.png");
            Greenfoot.setWorld(over);
           }else{
            //Define o novo mundo
            Mapa novoMapa = new Mapa(b, numVidas -1, "peidin", mapa.getPeidinVidas(), mapa.getBuffanVidas());
            Greenfoot.setWorld(novoMapa);
           }
        }
        
    }
    
    protected void encontrouBonus(){
        Bonus bonus;
        bonus = (Bonus) getOneIntersectingObject(Bonus.class);
        if(bonus != null){
            if(bonus instanceof Velocidade){
               getWorld().removeObject(bonus);
            }
            
            if(bonus instanceof Forca){
               getWorld().removeObject(bonus);
            }
            
            if(bonus instanceof Vida){
               if(nomePersonagem == "buffan"){  
                  if(mapa.getBuffanVidas() == 3){
                    getWorld().addObject(new BuffanVida() , 130, 430);    
                    mapa.setBuffanVidas(mapa.getBuffanVidas() + 1);
                  }else if(mapa.getBuffanVidas() == 2){
                    getWorld().addObject(new BuffanVida() , 110, 430);    
                    mapa.setBuffanVidas(mapa.getBuffanVidas() + 1); 
                  }else if(mapa.getBuffanVidas() == 1){
                    getWorld().addObject(new BuffanVida() , 90, 430);    
                    mapa.setBuffanVidas(mapa.getBuffanVidas() + 1); 
                  }
               }
               
               if(nomePersonagem == "peidin"){
                   if(mapa.getPeidinVidas() == 3){
                    getWorld().addObject(new PeidinVida() , 310, 430);    
                    mapa.setPeidinVidas(mapa.getPeidinVidas() + 1);
                  }else if(mapa.getPeidinVidas() == 2){
                    getWorld().addObject(new PeidinVida() , 370, 430);    
                    mapa.setPeidinVidas(mapa.getPeidinVidas() + 1); 
                  }else if(mapa.getPeidinVidas() == 1){
                    getWorld().addObject(new PeidinVida() , 350, 430);    
                    mapa.setPeidinVidas(mapa.getPeidinVidas() + 1); 
                  }
               }
               getWorld().removeObject(bonus);
            }
        }
    }

    /**
     * Define o personagem como morto. Seta seu status para morto
     */
    public void matarPersonagem(){
        this.morreu = true;
    }

    /**
     * Retorna o valor atual do estado do personagem, se está morto retorna true se não false.
     */
    public boolean morreu(){
        return this.morreu;
    }
    

}

   