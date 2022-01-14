
import java.rmi.*;
import java.time.LocalDate;
import java.util.*;
public interface AddServerIntf extends Remote {
  double add(double d1, double d2) throws RemoteException;
  ArrayList<Integer> listarQuartos(String initMarc, String finitMarc) throws RemoteException;
  Boolean cancelarQuarto(int idRoom,  String initMarc, String finitMarc ) throws RemoteException;
  Boolean reservarQuarto(int idRoom, int numPessoas,String initMarc, String finitMarc, String donoReserva) throws RemoteException;
}