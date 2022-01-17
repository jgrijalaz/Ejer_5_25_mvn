import java.util.Arrays;
/**
 *
 * Acepta como argumento del main el tamaño máximo de la lista
 * Si no se pasan argumentos se muestra un mensaje de error, se le informa al usuario
 * de la sintaxis a utilizar y se acaba el programa
 *
 * En otro caso se crea la lista y:
 *  - se llama al método cargarDeFichero()
 *  - se muestra la lista
 *  - se muestra el nombre más largo
 *  - se borran los que empiezan por 'r'
 *  - se muestra la lista
 *  - se muestra cuántos empiezan por 'aL'
 *  - se muestran los nombres que empiezan por "a"
 */
//mvn package
public class AppListaNombres
{

    /**
     *
     */
    public static void main(String[] args)
    {
        String[] empiezarPor;
        if(args.length == 0)
        {
            System.out.println("Error. Faltan argumentos. Sintaxis:");
            System.out.println("AppListaNombres [tamaño maximo de la lista]");
            return;
        }

        ListaNombres miLista = new ListaNombres(Integer.parseInt(args[0]));
        miLista.cargarDeFichero();
        System.out.println(miLista.toString());
        System.out.println("El nombre mas largo es " + miLista.nombreMasLargo());
        System.out.println("Despues de borrar los nombres que empiezan por 'r': ");
        miLista.borrarLetra('r');
        System.out.println(miLista.toString());
        System.out.println("Nombres que empiezan por 'aL': " + miLista.empiezanPor("aL"));
        empiezarPor = miLista.empiezanPorLetra('a');
        System.out.println("Nombres que empiezan por 'a': ");

        for (int i = 0; i < empiezarPor.length; i++)
        {
            System.out.print(empiezarPor[i] + "  ");
        }




    }
}
