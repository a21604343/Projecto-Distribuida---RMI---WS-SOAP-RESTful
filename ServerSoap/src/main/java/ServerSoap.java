import java.rmi.*;

import java.util.*;

import javax.jws.WebService;


@WebService(targetNamespace = "http://default_package/", portName = "ServerSoapPort", serviceName = "ServerSoapService")
public class ServerSoap {
HashMap<String,String> users = new HashMap<String,String>();

    
    public String registarUser(String email, String password) {
        
        if(users.containsKey(email)) {
            return "Email já registado";
        }else {
            users.put(email, password);
            return "Registado com Sucesso";
        }
        
    }
    
    public String autenticarUser(String email, String password) {
        
        if(!users.containsKey(email)) {
            return "Email inválido";
        }
        
        if(users.get(email).compareTo(password) == 0) {
            return "Autenticado com Sucesso";
        }else {
            return "Password incorreta";
        }
        
    }
    
    
    public Boolean reservarQuarto(int idRoom,int numPessoas,String date1,String date2,String donoReserva) {
        try {
            System.out.println("ENTREI RESERVAR");
            
              String addServerURL = "rmi://" + "192.168.56.102" + "/AddServer";
              AddServerIntf addServerIntf =
                            (AddServerIntf)Naming.lookup(addServerURL);
           
        return addServerIntf.reservarQuarto(idRoom,numPessoas, date1, date2,donoReserva);
        }catch(Exception e) {
              System.out.println("Exception: " + e);
        }
        return false;
    }
    public Boolean cancelarQuarto(int idRoom,String date1,String date2) {
        try {
            System.out.println("ENTREI CANCELAR");
            
              String addServerURL = "rmi://" + "192.168.56.102" + "/AddServer";
              AddServerIntf addServerIntf =
                            (AddServerIntf)Naming.lookup(addServerURL);
              
        return addServerIntf.cancelarQuarto(idRoom, date1, date2);
        }catch(Exception e) {
              System.out.println("Exception: " + e);
        }
        return false;
    }
    public ArrayList<Integer> listarQuartos(String initMarc,String finitMarc) {
        try {System.out.println("ENTREI LISTAR");
        
            String addServerURL = "rmi://" + "192.168.56.102" + "/AddServer";
            AddServerIntf addServerIntf =
                          (AddServerIntf)Naming.lookup(addServerURL);
         
      return addServerIntf.listarQuartos(initMarc, finitMarc);
      }catch(Exception e) {
            System.out.println("Exception: " + e);
      }
        return null;
  } 
    
}
