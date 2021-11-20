import greenfoot.*;  
import java.util.Stack;

public abstract class Personagens extends Actor
{
    private int contadorEsquerda = 0;
    private int contadorDireita = 0;
    private int contadorCima = 0;
    private int contadorBaixo = 0;
    private static int dist = 10;
    protected int mov = 1;
    protected String key = "";
    protected boolean ativo;
    private boolean forca;
    protected long total;
    protected long start;
    protected long finish;
    protected Bomba Bomba;
    private int timer;
    protected boolean morreu = false;
    protected String nomePersonagem = "";
    protected boolean ligado;
    protected Mapa mapa;
    protected Contador contador;    
    protected TelaPause pause;
    private int minutoAntigo;
    private int tempoAntigo;
    private int currentAntigo;
    
    public Personagens (String nomePersonagem, Mapa p, Contador contador){
        this.nomePersonagem = nomePersonagem;
        this.contador = contador;
        this.mapa = p;
    }

    public void act() 
    {

    }    

    public int getTempoAntigo(){
        return this.tempoAntigo;
    }

    public int getMinutoAntigo(){
        return this.minutoAntigo;
    }

    public int getCurrentAntigo(){
        return this.currentAntigo;
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
                 * Aqui será feita uma chegagem para saber se há qualquer outro Ator(Barreira, Bomba ou Peidin), caso não haja ele poderá se mover.
                 */
                if(getOneObjectAtOffset(0,-dist,null)==null) 
                {
                    setLocation(getX(), getY()-mov);
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
                 * Aqui será feita uma chegagem para saber se há qualquer outro Ator(Barreira, Bomba ou Peidin), caso não haja ele poderá se mover.
                 */
                if(getOneObjectAtOffset(0,+dist,null)==null)
                {
                    setLocation(getX(), getY ()+mov);
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
                 * Aqui será feita uma chegagem para saber se há qualquer outro Ator(Barreira, Bomba ou Peidin), caso não haja ele poderá se mover.
                 */
                if(getOneObjectAtOffset(+dist,0,null)==null)
                {
                    setLocation(getX()+mov, getY());
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
                 * Aqui será feita uma chegagem para saber se há qualquer outro Ator(Barreira, Bomba ou Peidin), caso não haja ele poderá se mover.
                 */
                if(getOneObjectAtOffset(-dist,0,null)==null)
                {
                    setLocation(getX()-mov, getY());
                }
                break; 

                case(5):
                pause = new TelaPause(mapa);
                minutoAntigo = mapa.getContador().getMinuto();
                tempoAntigo = mapa.getContador().getTempo();
                currentAntigo = mapa.getContador().getCurrent();
                Greenfoot.setWorld(pause);
                Greenfoot.stop();
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
     * Método que vai definir onde o boneco deve cagar e onde sua Bomba vai aparecer no mapa.
     */
    public void cagar(){ 
        Bomba = new Bomba(this.ligado, this.forca);
        getWorld().addObject(Bomba, getX(), getY());
        ativo = true; 
        start = System.currentTimeMillis();
        if(getLigado()){
            Greenfoot.playSound("peido.wav");
        }
    }

    /**
     * Determina a hora de destruir uma Bomba que está instanciada no mapa.
     * O tempo padrão para destruição de um Bomba é de 2 segundos.
     */
    protected  boolean estaNaHora(){
        if(total >= 2000 || !ativo){
            return true;
        }else{
            return false;   
        }
    }

    /**
     * Retorna a hor
    a atual do sistema do usário.
     */

    protected void currentTime(){
        finish= System.currentTimeMillis();
    }

    protected void morrer(){
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

    public void trocarImagem(){
        timer ++;  
        if(timer == 6){
            setImage(nomePersonagem+"_35.png");
        }
        if(timer == 16){
            setImage(nomePersonagem +"_36.png");
        }
        if(timer == 26){
            setImage(nomePersonagem+"_31.png");
        }
        if(timer == 46){
            setImage(nomePersonagem +"_33.png");
            timer = 0;
            getWorld().removeObject(this);
            Greenfoot.delay(3);
            morrer();
        }
    }
    
    protected void encontrouBonus(){
        Bonus bonus;
        bonus = (Bonus) getOneIntersectingObject(Bonus.class);
        if(bonus != null){
            if(bonus instanceof Velocidade){
                getWorld().removeObject(bonus);
                mov = 2;
            }

            if(bonus instanceof Forca){
                getWorld().removeObject(bonus);
                this.forca = true;
            }

            if(bonus instanceof Vida){
                if(mapa.getPeidinVidas() <= 3){  
                    if(nomePersonagem == "buffan"){
                        if(mapa.getBuffanVidas() == 4){
                            return;
                        }

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
                }

                if(nomePersonagem == "peidin"){         
                    if(mapa.getPeidinVidas() <= 3){
                        if(mapa.getPeidinVidas() == 4){
                            return;
                        }

                        if(mapa.getPeidinVidas() == 3){
                            getWorld().addObject(new PeidinVida() , 310, 430);    
                            mapa.setPeidinVidas(mapa.getPeidinVidas() + 1);
                        }else if(mapa.getPeidinVidas() == 2){
                            getWorld().addObject(new PeidinVida() , 330, 430);    
                            mapa.setPeidinVidas(mapa.getPeidinVidas() + 1); 
                        }else if(mapa.getPeidinVidas() == 1){
                            getWorld().addObject(new PeidinVida() , 350, 430);    
                            mapa.setPeidinVidas(mapa.getPeidinVidas() + 1); 
                        }
                    }
                }    
                getWorld().removeObject(bonus);
            }
        }
    }

    public void matarPersonagem(){
        this.morreu = true;
    }   

    public boolean morreu(){
        return this.morreu;
    }

}
