import java.util.*;
public class Room {
    int id;
    ArrayList<Reserva> reservas = new ArrayList<>();

    Room (int id, ArrayList<Reserva> reservas){
        this.id = id;
        this.reservas= reservas;

    }

}
