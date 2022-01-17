/**
 * La clase mantiene una lista de nombres
 * en orden lexicográfico
 */
import java.io.InputStream;
import java.util.Arrays;
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
    public int getCuantos()
    {
        return cuantos;
    }

    /**
     * @return  true si la lista está vacía
     */
    public boolean  listaVacia()
    {
        return getCuantos() == 0;
    }

    /**
     *
     * @return  true si la lista está llena
     */
    public boolean  listaLlena()
    {
        return cuantos == nombres.length;
    }

    /**
     *  Busca un nomnbre en la lista
     *  Puesto que la lista está en siempre ordenada
     *  se hace una búsqueda binaria
     *  @param  nombre el nombre a buscar
     *  @return   true si ya existe el nombre en la lista
     *
     */
    public boolean estaNombre(String nombre)
    {
        //TODO: hacer private
        return Arrays.binarySearch(nombres,0,getCuantos(), nombre) >= 0;
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
    public boolean insertarNombre(String nombre)
    {
        int pos = 0;

        // implementacion especial para pruebas
        /*
        if(nombre == "" || listaLlena() || estaNombre(nombre))
        {
            return false;
        }
        else
        {
            nombres[getCuantos()] = nombre;
            cuantos++;
            Arrays.sort(nombres,0,getCuantos());
        }
        */


        // error dificil de ver !!
        /*
        if(nombre == "" || listaLlena() || estaNombre(nombre))
        {
            return false;
        }
        */

        // condiciones guardia
        if(nombre == "")
            return false;

        if(listaLlena())
            return false;

        if(estaNombre(nombre))
            return false;

        // busco la posicion  i en 'nombres' en que i + 1
        // es mayor que 'nombre'
        for (int i = 0; i < getCuantos(); i++)
        {
            if(nombre.compareTo(nombres[i]) < 0)
            {
                pos = i;
                // para salir del bucle
                i = getCuantos();
            }
        }

        // desplazo los elementos a la derecha
        // desde el ultimo (getCuantos())
        // hasta pos + 1
        for (int i = getCuantos(); i > pos ; i--)
        {
            nombres[i] = nombres [i - 1];
        }

        // añado 'nombre' y actualizo 'cuantos'
        nombres[pos] = nombre;
        cuantos++;

        return true;
    }

    /**
     *  Busca y devuelve el nombre de mayor longitud
     *  en la lista. Si hay varios devuelve el
     *  primero encontrado
     *  Si la lista está vacía devuelve null
     *
     *  @return   el nombre más largo
     */
    public String nombreMasLargo()
    {
        String masLargo = "";

        if(listaVacia())
            return null;

        for (int i = 0; i < getCuantos(); i++)
        {
            if(nombres[i].length() > masLargo.length())
            {
                masLargo = nombres[i];
            }
        }

        return masLargo;
    }

    /**
     * Borra de la lista los nombres que empiezan por
     * una letra determinada (sí importan mayúsculas y minúsculas)
     * No es lo mismo borrarLetra('A') que borrarLetra('a')
     *
     * @param letra la letra por la que han de empezar los nombres
     */
    public void borrarLetra(char letra)
    {
        for (int i = 0; i < getCuantos(); i++)
        {
            if(nombres[i].charAt(0) == letra)
            {
                borrarDePosicion(i);
                i--;
            }
        }
    }

    /**
     * Borra un nombre de la posición indicada
     *
     * @param  p posición del nombre a borrar
     */
    public void borrarDePosicion(int p)
    {
        //TODO:  hacer private

        // condiciones guardia
        if(listaVacia())
            return;

        if(p < 0)
            return;
        
        if(p >= getCuantos())
            return;

        // desplazo todos a la izquierda
        for (int i = p; i < getCuantos(); i++)
        {
            nombres[i] = nombres[i + 1];
        }

        // limpio el ultimo elemento
        nombres[getCuantos()] = null;
        cuantos--;
    }

    /**
     *  Dado un nombre lo devuelve invertido.
     *  Usar StringBuilder
     */
    public static String invertir(String nombre)
    {
        StringBuilder sb = new StringBuilder(nombre);
        return sb.reverse().toString();

        // soy imbecil, por no leer
        /*
        StringBuilder inversa = new StringBuilder("");

        for (int i = nombre.length() - 1; i >= 0; i--)
        {
            inversa.append(nombre.charAt(i));
        }

        return inversa.toString();
        */
    }

    /**
     *  devuelve un array con los elementos de lista pero en orden inverso
     *  el primero ahora es el último de lista, el segundo el antepenúltimo,.....
     *  y además cada nombre en el nuevo array se invierte también
     */
    public String[] invertir()
    {
        String[] inverso = new String[getCuantos()];
        int j = getCuantos() - 1;
        String aux = "";

        for (int i = 0; i < inverso.length; i++, j--)
        {
            aux = nombres[j];
            aux = ListaNombres.invertir(aux);
            inverso[i] = aux;
        }

        return inverso;
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
    public int empiezanPor(String inicio)
    {
        int cuantos = 0;
        String subCadena = "";

        for (int i = 0; i < getCuantos(); i++)
        {
            // Opcion 1. FUNCIONA
            // nombres[i].regionMatches(true,0,inicio,0,inicio.length())
            // Opcion 2. NO FUNCIONA: distingue mayusc.
            // nombres[i].startsWith(inicio)
            // Opcion 3. FUNCIONA
            // subCadena = nombres[i].substring(0,inicio.length());
            // subCadena.equalsIgnoreCase(inicio)
            subCadena = nombres[i].substring(0,inicio.length());
            if(subCadena.equalsIgnoreCase(inicio))
            {
                cuantos++;
            }
        }

        return cuantos;
    }

    /**
     * Devuelve un array con los nombres que empiezan por una determinada
     * letra sin importar si es mayúscula o minúscula
     *
     * @param  letra la letra de comienzo
     * @return  la cantidad de nombres encontrados con esa letra
     */
    public String[] empiezanPorLetra(char letra)
    {
        //TODO: empiezanPorLetra
        int size = empiezanPor(Character.toString(letra));
        String[] salida = new String[size];
        int posEnSalida = 0;
        String subCadena = "";
        String letraString = "";



        for (int i = 0; i < getCuantos(); i++)
        {

            subCadena = nombres[i].substring(0,1);
            letraString = Character.toString(letra);
            if(subCadena.equalsIgnoreCase(letraString))
            {
                salida[posEnSalida] = nombres[i];
                posEnSalida++;
            }
        }

        return salida;
    }

    /**
     * Representación textual de la cadena
     *
     * @return la cadena resultante
     */
    public String toString()
    {
        StringBuilder salida = new StringBuilder();

        for (int i = 0; i < getCuantos(); i++)
        {
            salida.append(nombres[i]);
            salida.append("\n");
        }
        salida.append("\n");

        return salida.toString();
    }

}
