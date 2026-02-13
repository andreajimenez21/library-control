package pio.daw;

public class User implements Localizable {

    private String id;
    private Integer nEntries = 0;   //cuántas entradas válidas ha hecho
    private Boolean inside = false; //si está dentro o no

    public User(String id){
        this.id = id;
    }

    public String getId(){
        return this.id;
    }

    /**
     * Actualiza el estado del usuario según el evento recibido.
     * - Si entra y estaba fuera → lo marco dentro y sumo una entrada válida.
     * - Si sale y estaba dentro → lo marco fuera.
     * - Si intenta entrar dos veces seguidas → lo ignoro.
     * - Si intenta salir sin haber entrado → lo ignoro.
     */
    public void registerNewEvent(EventType e){
        if(e == EventType.ENTRY && !this.inside){
            this.inside = true;
            this.nEntries++; 
        }
        else if(e == EventType.EXIT && this.inside){
            this.inside = false;
        }
    }

    
     //Devuelve cuántas entradas válidas ha hecho el usuario.
     
    public Integer getNEntries(){
        return this.nEntries;
    }

    //Devuelve si el usuario está dentro de la biblioteca.
     
    @Override
    public Boolean isInside() {
        return this.inside;
    }

    //Para mostrar el usuario por su ID.
     
    @Override
    public String toString() {
        return this.id;
    }
}
