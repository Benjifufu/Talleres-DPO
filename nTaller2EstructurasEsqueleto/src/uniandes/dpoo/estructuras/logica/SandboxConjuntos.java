package uniandes.dpoo.estructuras.logica;

import java.util.Collection;
import java.util.List;
import java.util.LinkedList;
import java.util.NavigableSet;
import java.util.TreeSet;

/**
 * Esta clase tiene un conjunto de métodos para practicar operaciones sobre conjuntos implementados usando un árbol (TreeSet).
 *
 * Todos los métodos deben operar sobre el atributo arbolCadenas que se declara como un NavigableSet.
 * 
 * El objetivo de usar el tipo NavigableSet es que sólo puedan usarse métodos de esa interfaz y no métodos adicionales provistos por la implementación concreta (TreeSet).
 * 
 * A diferencia de un Set, en un NavigableSet existe una noción de orden que en este caso corresponde al órden lexicográfico.
 * 
 * No pueden agregarse nuevos atributos.
 */
public class SandboxConjuntos {
    /**
     * Un conjunto (set) de cadenas para realizar varias de las siguientes operaciones.
     * 
     * Por defecto, los elementos del conjunto están ordenados lexicográficamente.
     */
    private NavigableSet<String> arbolCadenas;

    /**
     * Crea una nueva instancia de la clase con el conjunto inicializado pero vacío.
     */
    public SandboxConjuntos() {
        arbolCadenas = new TreeSet<>();
    }

    /**
     * Retorna una lista con las cadenas del conjunto ordenadas lexicográficamente.
     * @return Una lista con las cadenas ordenadas.
     */
    /**
     * Retorna una lista con las cadenas del conjunto ordenadas lexicográficamente.
     * @return Una lista con las cadenas ordenadas.
     */
    public List<String> getCadenasComoLista() {
        List<String> lista = new LinkedList<>();
        for (String cadena : arbolCadenas) {
            lista.add(cadena);
        }
        return lista;
    }

    /**
     * Retorna una lista con las cadenas del conjunto, ordenadas lexicográficamente de mayor a menor.
     * @return Una lista con las cadenas ordenadas de mayor a menor.
     */
    public List<String> getCadenasComoListaInvertida() {
        List<String> lista = new LinkedList<>();
        for (String cadena : arbolCadenas.descendingSet()) {
            lista.add(cadena);
        }
        return lista;
    }

    /**
     * Retorna la cadena que sea lexicográficamente menor en el conjunto de cadenas.
     * Si el conjunto está vacío, debe retornar null.
     */
    public String getPrimera() {
        return arbolCadenas.isEmpty() ? null : arbolCadenas.first();
    }

    /**
     * Retorna la cadena que sea lexicográficamente mayor en el conjunto de cadenas.
     * Si el conjunto está vacío, debe retornar null.
     */
    public String getUltima() {
        return arbolCadenas.isEmpty() ? null : arbolCadenas.last();
    }

    /**
     * Retorna una colección con las cadenas que son mayores o iguales a la cadena recibida por parámetro.
     */
    public Collection<String> getSiguientes(String cadena) {
        return arbolCadenas.tailSet(cadena, true);
    }

    /**
     * Retorna la cantidad de valores en el conjunto de cadenas.
     */
    public int getCantidadCadenas() {
        return arbolCadenas.size();
    }

    /**
     * Agrega un nuevo valor al conjunto de cadenas.
     */
    public void agregarCadena(String cadena) {
        arbolCadenas.add(cadena);
    }

    /**
     * Elimina una cadena del conjunto de cadenas.
     */
    public void eliminarCadena(String cadena) {
        arbolCadenas.remove(cadena);
    }

    /**
     * Elimina una cadena del conjunto de cadenas, sin distinguir entre mayúsculas o minúsculas.
     */
    public void eliminarCadenaSinMayusculasOMinusculas(String cadena) {
        arbolCadenas.removeIf(s -> s.equalsIgnoreCase(cadena));
    }

    /**
     * Elimina la primera cadena del conjunto.
     */
    public void eliminarPrimera() {
        if (!arbolCadenas.isEmpty()) {
            arbolCadenas.pollFirst();
        }
    }

    /**
     * Reinicia el conjunto de cadenas con las representaciones en String de los objetos contenidos en la lista.
     */
    public void reiniciarConjuntoCadenas(List<Object> objetos) {
        arbolCadenas.clear();
        for (Object obj : objetos) {
            arbolCadenas.add(obj.toString());
        }
    }

    /**
     * Modifica el conjunto de cadenas para que todas las cadenas estén en mayúsculas.
     */
    public void volverMayusculas() {
        NavigableSet<String> nuevoArbol = new TreeSet<>();
        for (String cadena : arbolCadenas) {
            nuevoArbol.add(cadena.toUpperCase());
        }
        arbolCadenas = nuevoArbol;
    }

    /**
     * Construye un árbol de cadenas organizadas de MAYOR a MENOR.
     */
    public TreeSet<String> invertirCadenas() {
        return new TreeSet<>(arbolCadenas.descendingSet());
    }

    /**
     * Verifica si todos los elementos en el arreglo de cadenas hacen parte del conjunto de cadenas.
     */
    public boolean compararElementos(String[] otroArreglo) {
        for (String elemento : otroArreglo) {
            if (!arbolCadenas.contains(elemento)) {
                return false;
            }
        }
        return true;
    }
}
