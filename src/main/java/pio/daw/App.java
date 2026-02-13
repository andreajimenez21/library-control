package pio.daw;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class App {

   
     // Si faltan argumentos, sobran o el fichero no existe,
      //muestro un mensaje de error y cierro el programa.
     
    public static Path getPathFromArgs(String[] args){

        //Si no hay un argumento, significa que el usuario
        //no ha puesto los datos bien.
        if (args.length != 1) {
            System.err.println("Uso correcto: java App <ruta_fichero>");
            System.exit(1); // Salgo del programa porque no puedo continuar sin el fichero.
        }

        //Convierto el argumento en un Path para poder trabajar.
        Path p = Paths.get(args[0]);

        //Compruebo que el fichero realmente existe.
        if (!Files.exists(p) || !Files.isRegularFile(p)) {
            System.err.println("El fichero no existe o no es válido: " + p);
            System.exit(1); // Si no existe, no puedo.
        }

        //Si todo está bien, devuelvo la ruta para que el programa continúe.
        return p;
    }

    public static void main(String[] args) {
        System.out.println("Escribe la ruta del fichero : ");

        //Primero obtengo la ruta del fichero.
        Path p = getPathFromArgs(args);

        //Aquí cargo el fichero y creo el objeto que se encargará de procesar
        //los registros.  El método fromFile lo lee.
        Controlable controler = Library.fromFile(p);

        //Finalmente, muestro el resumen con toda la información procesada.
        controler.printResume();
    }
}
