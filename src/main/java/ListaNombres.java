/**
 * La clase mantiene una lista de nombres
 * en orden lexicográfico
 */
import java.io.InputStream;
import java.util.Scanner;
//import java.io.File;

public class ListaNombres
{
    private String[] nombres;
    private int cuantos;

    /**
     * Constructor de la clase ListaNombres
     * n es el tamaño máximo de la lista
     */
    public ListaNombres(int n)
    {
        nombres = new String[n];
        cuantos = 0;
    }

    /**
     * Cuántos nombres hay en la lista, inicialmente 0
     * @return número de nombres en la lista
     */
    public int getCuantos() {
        return cuantos;
    }

    /**
     * @return  true si la lista está vacía
     */
    public boolean  listaVacia()
    {
        //TODO: listaVacia
        return true;
    }

    /**
     *
     * @return  true si la lista está llena
     */
    public boolean  listaLlena()
    {
        //TODO: listaLlena
        return true;
    }

    /**
     *  Busca un nomnbre en la lista
     *  Puesto que la lista está en siempre ordenada
     *  se hace una búsqueda binaria
     *  @param  nombre el nombre a buscar
     *  @return   true si ya existe el nombre en la lista
     *
     */
    public boolean estaNombre(String nombre) { // private
        //TODO: estaNombre
        return false;
    }

    /**
     * Inserta un nombre en la lista únicamente
     * si no está y la lista no está llena. La inserción se hace de tal
     * manera que el nombre queda colocado en el
     * lugar que le corresponde manteniendo el orden
     * de la lista (no se utiliza ningún algoritmo de ordenación)
     * Importan mayúsculas y minúsculas
     *
     * @param nombre el nombre a insertar
     * @return  true si la inserción se hace con éxito
     *
     */
    public boolean insertarNombre(String nombre) {
        //TODO: insertarNombre
        return false;
    }

    /**
     *  Busca y devuelve el nombre de mayor longitud
     *  en la lista. Si hay varios devuelve el
     *  primero encontrado
     *  Si la lista está vacía devuelve null
     *
     *  @return   el nombre más largo
     *
     */
    public String nombreMasLargo() {
        //TODO: nombreMasLargo
        return "masLargo";
    }

    /**
     * Borra de la lista los nombres que empiezan por
     * una letra determinada (sí importan mayúsculas y minúsculas)
     * No es lo mismo borrarLetra('A') que borrarLetra('a')
     *
     * @param letra la letra por la que han de empezar los nombres
     *
     */
    public void borrarLetra(char letra) {
        //TODO: borrarLetra
    }

    /**
     * Borra un nombre de la posición indicada
     *
     * @param  p posición del nombre a borrar
     */
    public void borrarDePosicion(int p) {//private
        //TODO: borrarDePosicion
    }

    /**
     *  Dado un nombre lo devuelve invertido.
     *  Usar StringBuilder
     */
    public static String invertir(String nombre) {
        //TODO: invertir string
        return "invertir";
    }

    /**
     *  devuelve un array con los elementos de lista pero en orden inverso
     *  el primero ahora es el último de lista, el segundo el antepenúltimo,.....
     *  y además cada nombre en el nuevo array se invierte también
     */
    public String[] invertir() {
        //TODO: invertir array
        return null;
    }

    /**
     * Lee de un fichero de texto una serie
     * de nombres con ayuda de un objeto de la
     * clase Scanner y los almacena en la lista
     */
    public void cargarDeFichero()
    {
        Scanner sc = null;
        try   {
            InputStream iStream = ListaNombres.class.getResourceAsStream("/nombres.txt");
            sc = new Scanner(iStream);
//            sc = new Scanner(new File("src/main/resources/nombres.txt"));

            while (sc.hasNextLine() && !listaLlena())     {
                insertarNombre(sc.nextLine());
            }
        }
        catch (Exception e)  {
            e.printStackTrace();
        }
        finally {
            if (sc!=null){
                sc.close();
            }
        }
    }

    /**
     * Cuenta cuántos nombres empiezan por una determinada
     * cadena sin importar si es mayúscula o minúscula
     *
     * @param  inicio la cadena de comienzo
     * @return  la cantidad de nombres calculados
     */
    public int empiezanPor(String inicio) {
        //TODO: empiezanPor
        return 0;
    }

    /**
     *
     * Devuelve un array con los nombres que empiezan por una determinada
     * letra sin importar si es mayúscula o minúscula
     *
     * @param  letra la letra de comienzo
     * @return  la cantidad de nombres encontrados con esa letra
     */
    public String[] empiezanPorLetra(char letra) {
        //TODO: empiezanPorLetra
        return null;
    }

    /**
     * Representación textual de la cadena
     *
     * @return la cadena resultante
     */
    public String toString() {
        //TODO: toString
        return "toString";
    }

}
