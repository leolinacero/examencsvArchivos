import java.io.*;
import java.util.*;


public class FiltroPeliculas {
    /**Entramos dentro de la carpeta peliculas.csv y hacemos el archivo de salida**/

    private static final String CSV_FILE = "peliculas.csv";

    public void filtrarPorGenero(String genero) {
        List<String> filtrar = new ArrayList<>();
        String archivoSalida = genero.toLowerCase() + ".csv";

        try (BufferedReader reader = new BufferedReader(new FileReader(CSV_FILE))) {
            String linea;
            while ((linea = reader.readLine()) != null) {

                String[] campos = linea.split(",");
                /**lo que hacemos es comparar el campo genero con el genero que soliciatmos nosotros y añadimos la linea o lineas que coincidan**/
                if (campos.length == 5) {

                    if (campos[4].trim().equalsIgnoreCase(genero)) {
                        filtrar.add(linea);
                    }
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        /**Escribe las películas filtradas por el genero  en el nuevo archivo csv**/
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(archivoSalida))) {
            for (String pelicula : filtrar) {
                writer.write(pelicula);
                writer.newLine(); //
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        System.out.println("Archivo generado: " + archivoSalida);
    }
    /**he comprobado que si intentas poner un genero que no esta te crea el archivo csv pero queda vacio**/

    public static void main(String[] args) {
        FiltroPeliculas filtro = new FiltroPeliculas();
        filtro.filtrarPorGenero("Acción, Drama");
    }
}