package pio.daw;

import java.util.List;

public interface Controlable {

    /**
     Este método sirve para registrar,cada vez que el sistema detecta una ENTRADA o una SALIDA,
     llamaremos a este método para actualizar la información del usuario.
     
      @param id ID del usuario que ha generado el evento.
      @param e Tipo de evento (ENTRADA o SALIDA).
     
    public void registerChange(String id, EventType e);

    //Devuelve la lista de usuarios de aquellos que han entrado y todavía no han salido.
     
     * @return lista de usuarios que siguen dentro. */
     
    public List<User> getCurrentInside();

     /**
     * Devuelve una lista con el/los usuario(s) que más veces han entrado.
     * Puede haber empate, así que el método devuelve una lista en lugar de uno solo.
     * 
     * @return lista de usuarios con mayor número de entradas válidas.
     */
    public List<User> getMaxEntryUsers();

    /**
     * Devuelve la lista de todos los usuarios que han aparecido en el registro,
     * ordenados por su ID. Esto sirve para mostrar un resumen ordenado y fácil de leer.
     * 
     * @return lista de usuarios ordenados por ID.
     */
    public List<User> getUserList();
    /**
     * Print a resume of the current status:
     * 1. Current users
     * 2. Entries per user
     * 3. User with more entries
     */

    public void printResume();
}
