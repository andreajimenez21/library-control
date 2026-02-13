package pio.daw;

import java.nio.file.Path;
import java.nio.file.Files;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Library implements Controlable {

    private Map<String,User> users;

    public static Library fromFile(Path path){
        Library library = new Library();

        try {
            for (String line : Files.readAllLines(path)) {

                String[] splittedLine = line.split(";");

                if (splittedLine.length != 2) continue;

                String id = splittedLine[0].trim();
                String evento = splittedLine[1].trim();

                EventType e = null;

                if (evento.equalsIgnoreCase("ENTRADA")) {
                    e = EventType.ENTRY;
                } else if (evento.equalsIgnoreCase("SALIDA")) {
                    e = EventType.EXIT;
                } else {
                    continue;
                }

                library.registerChange(id, e);
            }

        } catch (IOException e) {
            System.err.println("Error al leer el fichero: " + e.getMessage());
        }

        return library;
    }

    private Library(){
        this.users = new HashMap<>();
    }

    //Este método actualiza el estado del usuario
    public void registerChange(String id, EventType e){
        User u = this.users.get(id);

        if(u == null){
            u = new User(id);
        }

        u.registerNewEvent(e);

        this.users.put(id, u);
    }

    //Devuelve los usuarios que están dentro ahora mismo
    @Override
    public List<User> getCurrentInside() {
        List<User> inside = new ArrayList<>();

        for(User u : users.values()){
            if(u.isInside()){
                inside.add(u);
            }
        }

        return inside;
    }

    //Devuelve los usuarios con más entradas válidas
    @Override
    public List<User> getMaxEntryUsers() {
        List<User> result = new ArrayList<>();

        int max = 0;

        for(User u : users.values()){
            if(u.getNEntries() > max){
                max = u.getNEntries();
            }
        }

        for(User u : users.values()){
            if(u.getNEntries() == max){
                result.add(u);
            }
        }

        return result;
    }

    //Devuelve la lista completa de usuarios
    @Override
    public List<User> getUserList() {
        return new ArrayList<>(users.values());
    }

    //Muestra el resumen final
    @Override
    public void printResume() {
        System.out.println("Usuarios dentro ahora:");
        for(User u : getCurrentInside()){
            System.out.println("- " + u.getId());
        }

        System.out.println("\nUsuarios con más entradas:");
        for(User u : getMaxEntryUsers()){
            System.out.println("- " + u.getId() + " (" + u.getNEntries() + ")");
        }
    }
}
