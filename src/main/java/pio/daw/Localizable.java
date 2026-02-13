package pio.daw;

public interface Localizable {
    
    /**
     * Devuelve true si el objeto está dentro.
     * En el caso de un usuario, significa que ha entrado
     * y todavía no ha registrado una salida válida.
     */
    public Boolean isInside();
}
