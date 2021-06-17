
public class Menu{
    private String[] opciones;
    public Menu(String[] op){
        opciones = op;
    }
    
    public String mostrarMenu(){
        String menu;
        menu = "    OPCIONES\n" +
               "================\n";
        for(int i = 0; i<opciones.length; i++){
            menu += opciones[i] + "\n";
        }
        menu += "================\n" +
                "ELIGE UNA OPCION";
        return menu;
    }
}
