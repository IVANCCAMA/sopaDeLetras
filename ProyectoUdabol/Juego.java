
public class Juego{
    private String NombreDeJuego;
    private Palabra palabra;
    private SopaDeLetras sopa;
    private boolean palabraEncontrada;
    private String[] palEncontrada;
    private boolean termino;
    private int NumPalEncontradas;
    private int numPalabras;
    
    //int errores;
    public Juego(String nom, SopaDeLetras sopaNueva){
        NombreDeJuego = nom;
        sopa = sopaNueva;
        palabraEncontrada = false;
        palEncontrada = new String[4];
        NumPalEncontradas = 0;
        numPalabras = 4;
        termino = false;
    }
    public String inicializar(){
        NumPalEncontradas = getNumPalEncontradas();
        //palabraEncontrada = false;
        //termino = false;
        String reporte = "juego inicializado, las palabras a encontrar tratan de: \n"
                        + NombreDeJuego + "\nLas palabras a encontrar son: " + numPalabras
                        + "\n" + sopa.mostrar() + "Palabras a encontrar:\n" 
                        +  sopa.mostrarPalabras() +  "\nJuega!!!";
        return reporte;
    }
    public String encontrarPalabra(Palabra palabraNueva){
        String reporte;
        if(termino){
            reporte = "terminaste!!! \n inicializa para jugar...";
        }else{
            if(palabraNueva.getPalabra().equals(sopa.obtenerPalabra(palabraNueva))){
                palEncontrada[getNumPalEncontradas()] = palabraNueva.getPalabra();
                NumPalEncontradas++;
                reporte = sopa.mostrar()
                        + "-------Palabra encontrada!-------\n"
                        + "Palabras encontradas:\n"
                        +  mostrarPalabrasEncontradas()
                        + "\nPalabras a encontrar:\n"
                        + sopa.mostrarPalabras();//**
                if(getNumPalEncontradas() == numPalabras){
                    termino = true;
                    reporte = reporte + "\nTerminaste!!!\n inicializa para jugar...";
                }
            }else{
                reporte = "Palabra no encontrada";
            }
            reporte = reporte;
        }
        return reporte;
    }
    public String mostrarPalabrasEncontradas(){
        String mostrar = "";
        for(int i = 0; i < getNumPalEncontradas(); i++){
            mostrar += palEncontrada[i] + "\n";
        }
        return mostrar;
    }
    public int getNumPalEncontradas(){
        return NumPalEncontradas;
    }
    
}
