import java.rmi.Naming;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;


@Consumes("application/json")
@Produces("application/json")
public class RestConsumerImpl implements RestConsumer{
	
	HashMap<String,String> users = new HashMap<String,String>();
		
	public String[] spliter(String payload){
		payload = payload.replace("{","");
		payload = payload.replace("}","");
		payload = payload.replace("\"","");
		
		String[] payloadSplit = payload.split(",");
		return payloadSplit;
	}
	
	@POST
	@Path("/registar")
	public String registarUser(String payload) {

		String[] payloadSplit = spliter(payload);
		
		String email = payloadSplit[0].split(":")[1];
		String password = payloadSplit[1].split(":")[1];
		
        if(users.containsKey(email)) {
        	
            return "Email ja registado";
        }else {
            users.put(email, password);
            return "Registado com Sucesso";
        }
    }
    
	@POST
	@Path("/autenticar")
    public String autenticarUser(String payload) {
        
    	String[] payloadSplit = spliter(payload);
		
		String email = payloadSplit[0].split(":")[1];
		String password = payloadSplit[1].split(":")[1];
    	
        if(!users.containsKey(email)) {
            return "Email invalido";
        }
        
        if(users.get(email).compareTo(password) == 0) {
            return "Autenticado com Sucesso";
        }else {
            return "Password incorreta";
        }
        
    }
    
  @GET
  @Path("/listarQuartos")
   public String listarQuartos(@QueryParam(value="date1") String date1,
		   @QueryParam(value="date2") String date2) {
	  
	  ArrayList<Integer> quartos = new ArrayList<>();
	  String listaQuartos = "";
	  
	  try {System.out.println("ENTREI LISTAR");
     
	  	String addServerURL = "rmi://" + "192.168.56.102" + "/AddServer";
	  	AddServerIntf addServerIntf =
	  			(AddServerIntf)Naming.lookup(addServerURL);
       
	  	quartos = addServerIntf.listarQuartos(date1, date2);
	  	
	  	for(int i = 0; i < quartos.size(); i++) {
	  		listaQuartos += quartos.get(i) + " | ";
	  	}
	  	
	  }catch(Exception e) {
	  		System.out.println("Exception: " + e);
	  }
	  return listaQuartos;
  } 
  
  
  @POST
  @Path("/cancelarQuarto")
  public String cancelarQuarto(String payload) {
      try {
          System.out.println("ENTREI CANCELAR");
       
          String[] payloadSplit = spliter(payload);
          int idRoom = Integer.parseInt(payloadSplit[0].split(":")[1]);
          String date1 = payloadSplit[1].split(":")[1];
          String date2 = payloadSplit[2].split(":")[1];
          String addServerURL = "rmi://" + "192.168.56.102" + "/AddServer";
          AddServerIntf addServerIntf =
                        (AddServerIntf)Naming.lookup(addServerURL);
          if(addServerIntf.cancelarQuarto(idRoom, date1, date2)) {
        	  return "true";
          }
      }catch(Exception e) {
            System.out.println("Exception: " + e);
      }
      return "false";
  }
  
  
  @POST
  @Path("/reservarQuarto")
  public String reservarQuarto(String payload) {
	  try {
          System.out.println("ENTREI RESERVAR");
       
          String[] payloadSplit = spliter(payload);
          int idRoom = Integer.parseInt(payloadSplit[0].split(":")[1]);
          System.out.println(payloadSplit[1].split(":")[1]);
          int numPessoas = Integer.parseInt(payloadSplit[1].split(":")[1]);
          String date1 = payloadSplit[2].split(":")[1];
          String date2 = payloadSplit[3].split(":")[1];
          String donoReserva = payloadSplit[4].split(":")[1];
          
          String addServerURL = "rmi://" + "192.168.56.102" + "/AddServer";
          AddServerIntf addServerIntf =
                        (AddServerIntf)Naming.lookup(addServerURL);
          
          if(addServerIntf.reservarQuarto(idRoom,numPessoas, date1, date2,donoReserva)) {
        	  return "true";
          }
      }catch(Exception e) {
            System.out.println("Exception: " + e);
      }
      return "false";
  }
  
}