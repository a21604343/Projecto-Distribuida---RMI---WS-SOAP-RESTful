
import java.time.LocalDate;
import java.util.*;
public class Reserva {
    LocalDate init;
    LocalDate finit;
    String donoReserva;

    Reserva(LocalDate init,LocalDate finit, String donoReserva){
        this.init= init;
        this.finit=finit;
        this.donoReserva= donoReserva;
    }
}
