
public class Palabra{
    private String palabra;
    private int fila;
    private int columna;
    private int tamanio;
    private String sentido;
    public Palabra(String pal, int f, int c, String sen, int tam){
        palabra = pal;
        fila = f;
        columna = c;
        sentido = sen;
        tamanio = tam;
    }
    public String getPalabra(){
        return palabra;
    }
    public int getFila(){
        return fila;
    }
    public int getCol(){
        return columna;
    }
    public int getTamanio(){
        return tamanio;
    }
    public String getSentido(){
        String[] sent = {"horizontal","vertical","diagonal;","diagonalInvertida"};
        for(int i = 0; i<4; i++){
            if(sentido.equals(sent[i])){
                sentido = sent[i];
            }
        }
        return sentido;
    }
    
}
