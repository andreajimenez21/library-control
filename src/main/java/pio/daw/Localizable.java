package pio.daw;

/**
 * Esta interfaz simplemente define algo muy básico:
 * cualquier objeto que implemente Localizable debe poder decir
 * si está "dentro" o "fuera" de un sitio.
 * 
 * En nuestro caso, la usaré con los usuarios de la biblioteca,
 * para saber si un usuario está actualmente dentro del edificio.
 * 
 * Tenerlo como interfaz me permite que, si en el futuro hubiese
 * otros tipos de objetos que también tengan un estado "dentro/fuera",
 * puedan reutilizar este mismo contrato sin cambiar nada.
 */
public interface Localizable {
    
    /**
     * Devuelve true si el objeto está dentro.
     * En el caso de un usuario, significa que ha entrado
     * y todavía no ha registrado una salida válida.
     */
    public Boolean isInside();
}
