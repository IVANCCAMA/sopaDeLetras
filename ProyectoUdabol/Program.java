import java.util.Scanner;

public class Program{
    public static void main(String[] arg){
        Menu menu;
        int opcion;
        String palabra;
        Palabra palabraIngresada;
        Juego juego1;
        Scanner entrada = new Scanner(System.in);
        
        Palabra pal1 = new Palabra("AVION",2,0, "horizontal",5); 
        Palabra pal2 = new Palabra("MICROBUS",0,10, "vertical",8); 
        Palabra pal3 = new Palabra("CARRO",10,1, "diagonal",5); 
        Palabra pal4 = new Palabra("BARCO",5,5, "diagonalInvertida",5); 
        Palabra[] palabras = {pal1,pal2,pal3,pal4};
        
        //System.out.println("ingrese el tamanio de su sopa");
        SopaDeLetras sopa = new SopaDeLetras(13,13);
        sopa.agregarLetrasAleatorias();
        sopa.agregarPalabra(pal1);
        sopa.agregarPalabra(pal2);
        sopa.agregarPalabra(pal3);
        sopa.agregarPalabra(pal4);
        //System.out.println(sopa.mostrar());
        juego1 = new Juego("TRANSPORTES",sopa);
        //Palabra de usuario
        String pal;
        
        int fila;
        int columna;
        String sentido;
        int tamanio;
        
        menu = new Menu(new String[]{"1. Inicializar",
                                     "2. Ingresar palabra",
                                     "3. salir"});
        
        do{
            System.out.println(menu.mostrarMenu());
            opcion = Integer.parseInt(entrada.nextLine());
            switch(opcion){
                case 1: System.out.println(juego1.inicializar());break;
                case 2:
                //System.out.println(juego1.inicializar());
                System.out.println("Igrese Palabra,fila, comluma,sentido,tamanio de Palabra:");
                palabraIngresada = new Palabra(pal = entrada.nextLine(),
                                    fila = Integer.parseInt(entrada.nextLine()),
                                    columna = Integer.parseInt(entrada.nextLine()),
                                    sentido = entrada.nextLine(),
                                    tamanio = Integer.parseInt(entrada.nextLine()));
                System.out.println(juego1.encontrarPalabra(palabraIngresada));break;
            }
        }while(opcion != 3);
    }
}
