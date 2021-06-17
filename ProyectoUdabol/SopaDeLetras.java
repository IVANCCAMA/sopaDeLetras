
public class SopaDeLetras{
    //AQUI VAN LOS ATRIBUTOS
    private int filas;
    private int columnas;
    private String[][] sopa;
    private String[] sentidos;
    private String posicion;
    private Palabra palabra;
    private int palIngresadas;
    private String[] palabrasIng;
    //CONSTRUCTOR
    public SopaDeLetras(int fil, int col){
        filas = fil;
        columnas = col;
        sopa = new String[filas][columnas];
        sentidos = null;
        palIngresadas = 0;
        palabrasIng = new String[5];
    }

    // AUTO ==> A U T O  
    public void agregarPalabra(Palabra pal){
        //comparamos sentidos
        palabra = pal;
        String reporte = "";
        String[] sent = {"horizontal","vertical","diagonal","diagonalInvertida"};
        if(pal.getSentido().equals(sent[0]) &&  (tamanioTotal(pal) <= columnas)){
            for(int i = 0; i<pal.getTamanio(); i++){
                sopa[pal.getFila()][pal.getCol()+i] = reporte + pal.getPalabra().charAt(i);  
            }
        }
        if(pal.getSentido().equals(sent[1]) &&  (tamanioTotal(pal) <= filas)){
            for(int i = 0; i<pal.getTamanio(); i++){
                sopa[pal.getFila()+i][pal.getCol()] = reporte + pal.getPalabra().charAt(i);
            }
        }
        if(pal.getSentido().equals(sent[2])){
            for(int i = 0; i<pal.getTamanio(); i++){
                sopa[pal.getFila()-i][pal.getCol()+i] = reporte + pal.getPalabra().charAt(i); 
            }
        }
        if(pal.getSentido().equals(sent[3])){
            for(int i = 0; i<pal.getTamanio(); i++){
                sopa[pal.getFila()+i][pal.getCol()+i] = reporte + pal.getPalabra().charAt(i); 
            }
        }
        palabrasIng[palIngresadas] = pal.getPalabra();
        palIngresadas++;
    }
    public void agregarLetrasAleatorias(){
        // 65 = A  90 = Z ---- 35
        int numero = 0;
        char letra;
        String reporte = "";
        for(int i = 0; i<sopa.length; i++){
            for(int j = 0; j< sopa.length; j++){
                boolean buscador = true;
                while(buscador){ 
                    numero = (int)(Math.random()*90);
                    if(numero >= 65 && numero <= 90){
                        //si cumple se tiene q salir del ciclo
                        buscador = false;
                    }
                }
                letra = (char)numero;
                //si el lugar esta libre alamcena valor
                if(espacioLibre(i,j)){
                    letra = (char)numero;
                    sopa[i][j] = reporte + letra;
                }
            }
        }
    }
    public boolean espacioLibre(int filas, int columnas){
        boolean libre = true;
        if(sopa[filas][columnas] != null){
            libre = false;
        }else{
            libre = true;
        }
        return libre;
    }
    public int getFilas(){
        return filas;
    }
    public int gettCol(){
        return filas;
    }
    //AGREGAR SENTIDOS
    public String obtenerPalabra(Palabra pal){//**
        String nuevaPalabra = "";
        // hor, ver, d, dI
        String[] sentidos = {"horizontal","vertical","diagonal","diagonalInvertida"};
        
        if(pal.getSentido().equals(sentidos[0])){
            for(int i = 0; i<pal.getTamanio(); i++){
                nuevaPalabra = nuevaPalabra + sopa[pal.getFila()][pal.getCol()+i]; 
            }
        }
        if(pal.getSentido().equals(sentidos[1])){
            for(int i = 0; i<pal.getTamanio(); i++){
                nuevaPalabra = nuevaPalabra + sopa[pal.getFila()+i][pal.getCol()]; 
            }
        }
        if(pal.getSentido().equals(sentidos[2])){
            for(int i = 0; i<pal.getTamanio(); i++){
                nuevaPalabra = nuevaPalabra + sopa[pal.getFila()-i][pal.getCol()+i]; 
            }
        }
        if(pal.getSentido().equals(sentidos[3])){
            for(int i = 0; i<pal.getTamanio(); i++){
                nuevaPalabra = nuevaPalabra + sopa[pal.getFila()+i][pal.getCol()+i]; 
            }
        }
        
        return nuevaPalabra;
    }
    public int tamanioTotal(Palabra pal){
        int tamanioTotal = 0;
        String[] sent = {"horizontal","vertical","diagonal;","diagonalInvertida"};
        if(pal.getSentido().equals(sent[0])){
            tamanioTotal = pal.getTamanio() + pal.getCol();
        }
        if(pal.getSentido().equals(sent[1])){
            tamanioTotal = pal.getTamanio() + pal.getFila();
        }
        if(pal.getSentido().equals(sent[2])){
            tamanioTotal = pal.getTamanio();//**
        }
        if(pal.getSentido().equals(sent[3])){
            tamanioTotal = pal.getTamanio();
        }
        
        return tamanioTotal;
    }
    public String mostrarPalabras(){
        String mostrar = "- ";
        for(int i = 0; i < palIngresadas; i++){
            //mostrar = mostrar + palabrasIng[i] + "\n" + "- ";
            int aux = palIngresadas - 1;
            if(i == aux){
                mostrar = mostrar + palabrasIng[i] + "\n";
            }else{
                mostrar = mostrar + palabrasIng[i] + "\n" + "- ";
            }
        }
        return mostrar;
    }
    
    public String mostrar(){
        String reporte = "";
        for(int i = 0; i<sopa.length; i++){//filas
            for(int j = 0; j<sopa[0].length; j++){//columas
                reporte = reporte + sopa[i][j] + "  ";
            }
            reporte = reporte + "\n";
        }
        return reporte;
    }
    
    
}
