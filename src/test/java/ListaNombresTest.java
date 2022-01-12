import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ListaNombresTest {
    ListaNombres listaVacia;
    ListaNombres lista;
    ListaNombres listaLlena;

    @BeforeEach
    void setUp() {
        listaVacia =  new ListaNombres(10);
        lista =  new ListaNombres(10);
        listaLlena = new ListaNombres(5);
        String[] nombres = {"Roberto", "Julio", "Juan1", "Alejandro", "Juan2"};
        for (String nombre : nombres) {
            lista.insertarNombre(nombre);
            listaLlena.insertarNombre(nombre);
        }
    }

    @Test
    @DisplayName("1. Lista vacia")
    void listaVacia() {
        assertTrue(listaVacia.listaVacia());
        assertFalse(lista.listaVacia());
        assertFalse(listaLlena.listaVacia());
    }

    @Test
    @DisplayName("2. Lista llena")
    void listaLlena() {
        assertFalse(listaVacia.listaLlena());
        assertFalse(lista.listaLlena());
        assertTrue(listaLlena.listaLlena());
    }

    @Test
    @DisplayName("3. Esta nombre")
    void estaNombre() {
        assertTrue(lista.estaNombre("Juan1"));
        assertFalse(lista.estaNombre("Juan"));
        assertFalse(listaVacia.estaNombre("Juan"));
    }

    @Test
    @DisplayName("4. Insertar nombre")
    void insertarNombre() {
        assertTrue(listaVacia.insertarNombre("Aitor"));
        assertTrue(lista.insertarNombre("Aitor"));
        assertFalse(lista.insertarNombre("Roberto"));
        assertFalse(listaLlena.insertarNombre("Aitor"));
    }

    @Test
    @DisplayName("5. Nombre más largo")
    void nombreMasLargo() {
        assertNull(listaVacia.nombreMasLargo());
        assertEquals("Alejandro",lista.nombreMasLargo());
    }

    @Test
    @DisplayName("6. Borrar letra")
    void borrarLetra() {
        lista.borrarLetra('J');
        assertEquals(2, lista.getCuantos());
        lista.borrarLetra('X');
        assertEquals(2, lista.getCuantos());
        listaVacia.borrarLetra('X');
        assertEquals(0, listaVacia.getCuantos());
    }

    @Test
    @DisplayName("7. Borrar de posición")
    void borrarDePosicion() {
        lista.borrarDePosicion(0);
        assertFalse(lista.estaNombre("Alejandro"));
        lista.borrarDePosicion(1);
        assertFalse(lista.estaNombre("Juan2"));
    }

    @Test
    @DisplayName("8. Invertir nombre")
    void invertir_nomber() {
        String inv = ListaNombres.invertir("Aitor");
        assertEquals("rotiA",inv);
        inv = ListaNombres.invertir("A");
        assertEquals("A",inv);
    }

    @Test
    @DisplayName("9. Invertir array")
    void invertir_array() {
        String[] invertidos = lista.invertir();
        assertEquals("otreboR", invertidos[0]);
        assertEquals("ordnajelA", invertidos[4]);
    }

    @Test
    @DisplayName("10. Empiezan por")
    void empiezanPor() {
        assertEquals(0,lista.empiezanPor("X"));
        assertEquals(3, lista.empiezanPor("Ju"));
    }

    @Test
    @DisplayName("11. Empiezan por letra")
    void empiezanPorLetra() {
        String[] filtrados = lista.empiezanPorLetra('J');
        assertEquals(3, filtrados.length);
        filtrados = lista.empiezanPorLetra('X');
        assertEquals(0, filtrados.length);
    }

    @Test
    @DisplayName("12. To string")
    void testToString() {
        assertEquals("\n", listaVacia.toString());
        String s1 = "Alejandro\nJuan1\nJuan2\nJulio\nRoberto\n\n";
        String s2 = "Alejandro\nJuan1\nJuan2\nJulio\nRoberto\n";
        String s = lista.toString();
        assertTrue(s1.equals(s) || s2.equals(s));
    }
}