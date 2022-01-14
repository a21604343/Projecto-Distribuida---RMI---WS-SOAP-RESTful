import java.io.IOException;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;
import java.util.Scanner;

// CXF JAX-RS client Invoking GET Method

public class RestClient {
	
	public static String postConnection(String url, String payload) {
    	try {
			
			URL urlFinal = new URL(url);
			String response2 = "";
			HttpURLConnection conn = (HttpURLConnection) urlFinal.openConnection();
	      	conn.setDoOutput(true);
	      	conn.setRequestMethod("POST");
	      	conn.setRequestProperty("Content-Type", "application/json");
	      
	      	OutputStream os = conn.getOutputStream();
	      	os.write(payload.getBytes());
	      	os.flush();
	      	Scanner scanner;
	      	String response;
	      	if (conn.getResponseCode() != 200) {
	      		scanner = new Scanner(conn.getErrorStream());
	      		response = "Error From Server \n";
	      	} else {
	      		scanner = new Scanner(conn.getInputStream());
	        	response = "Response From Server \n";
	      	}
	      	scanner.useDelimiter("\\Z");	
	      	System.out.println(response);
	      	response2 = scanner.next();
	      	scanner.close();
	      	conn.disconnect();
	      	return response2;
		} catch (MalformedURLException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
    	return "Connection Failed\n";
    }

  public static void main(String[] args) {	
	  
		
		String input = "";
		Boolean userAutenticado = false;
        
		try {
			Scanner sc1 = new Scanner(System.in);
			while(!userAutenticado) {
    		System.out.println("Selecione o numero da opcao pretendida: \n"
    				+ "1 - Registar\n"
    				+ "2 - Autenticar\n");

	    		while (sc1.hasNextLine()) {
	    			String method = sc1.nextLine();
        			String payload = "";
        			String url = "";
        			String email = "";
        			String password = "";
        			
            		switch(method) {
            		
    	        		case "1":
    	        				
    	        			System.out.println("Introduza o seu email:");
    	        			email = sc1.nextLine();
    	        			System.out.println("Introduza uma palavra passe:");
    	        			password = sc1.nextLine();
    	        			
    	        			url = ("http://localhost:8080/RestfullWebService/rest/registar");
    	        			payload = "{\"email\":\""+email+"\",\"password\":\""+password+"\"}";
    	        			System.out.println(postConnection(url,payload)+"\n");
   
    	        			break;
    	        			
    	        		case "2":
    	        			
    	        			System.out.println("Introduza o seu email:");
    	        			email = sc1.nextLine();
    	        			System.out.println("Introduza a sua palavra passe:");
    	        			password = sc1.nextLine();
    	        			
    	        			url = ("http://localhost:8080/RestfullWebService/rest/autenticar");
    	        			payload = "{\"email\":\""+email+"\",\"password\":\""+password+"\"}";
    	        			String response_autenticar = postConnection(url,payload);
    	        			System.out.println(response_autenticar+"\n");
    	        		
		        			 if(response_autenticar.compareTo("Autenticado com Sucesso") == 0) {
		        				 userAutenticado = true;
		        			 } 
    	        			 break;
    	        			 
            		}
	        		break;       		
	        	}
    		
			}
	
		} catch (SecurityException e) {

            e.printStackTrace();

	      } catch (IllegalArgumentException e) {
	
	        e.printStackTrace();
	
	      } 
    	
    	
    	Scanner sc = new Scanner(System.in);
    	while(userAutenticado) {
    		
    		System.out.println("Selecione o numero da opcao pretendida: \n"
				    				+ "1 - Listar Quartos\n"
				    				+ "2 - Reservar Quarto\n"
				    				+ "3 - Cancelar Quarto\n");
        	String payload = "";
    		String url = "";
        	
    		try {
	    		while (sc.hasNextLine()) {
					
	        		String method = sc.nextLine();
	        		
	        		switch(method) {
	    	    		case "1":
	    	    			try {
	    	    				
	    	    				System.out.println("Introduza a data inicial da reserva no formato aaaa-mm-dd");
	    	    				String date1 = sc.nextLine();
	    	    				System.out.println("Introduza a data final da reserva no formato aaaa-mm-dd");
	    		    	        String date2 = sc.nextLine();
	    		    	        
	    	    				URL urlListar = new URL("http://localhost:8080/RestfullWebService/rest/listarQuartos?date1="+date1+"&date2="+date2+"");
	    	    			    HttpURLConnection conn = (HttpURLConnection) urlListar.openConnection();
	    	    		        conn.setDoOutput(true);
	    	    		        conn.setRequestMethod("GET");
	    	    		        conn.setRequestProperty("Content-Type", "application/json");
	
	    	    		        Scanner scanner;
	    	    		        String response;
	    	    		        if (conn.getResponseCode() != 200) {
	    	    		          scanner = new Scanner(conn.getErrorStream());
	    	    		          response = "Error From Server \n";
	    	    		        } else {
	    	    		          scanner = new Scanner(conn.getInputStream());
	    	    		          response = "Response From Server \n";
	    	    		        }
	    	    		        scanner.useDelimiter("\\Z");
	    	    		        System.out.println(response + scanner.next()+"\n");
	    	    		        scanner.close();
	    	    		        conn.disconnect();
	    	    		      } catch (MalformedURLException e) {
	    	    		        e.printStackTrace();
	    	    		      } catch (IOException e) {
	    	    		        e.printStackTrace();
	    	    		      }
	    	    		  
	    	    			  break;
	    	    		case "2":	
	    	    			
	    	    			System.out.println("Introduza o numero do quarto para reservar");
	    	    			int idRoomReservar = Integer.parseInt(sc.nextLine());
	    	    			System.out.println("Introduza o numero de hospedes");
	    	    	        int numPessoas = Integer.parseInt(sc.nextLine());
	    	    	        System.out.println("Introduza a data inicial da reserva no formato aaaa-mm-dd");
	    	    	        String date1Reservar = sc.nextLine();
	    	    	        System.out.println("Introduza a data final da reserva no formato aaaa-mm-dd");
	    	    	        String date2Reservar = sc.nextLine();
	    	    	        System.out.println("Introduza o seu email para identificacao da reserva");
	    	    	        String donoReserva = sc.nextLine();
	    	    	        String responseReservar;
	    	    	        
	    	    	        url = ("http://localhost:8080/RestfullWebService/rest/reservarQuarto");
	            			payload = "{\"idRoomReservar\":\""+idRoomReservar+"\",\"numPessoas\":\""+numPessoas+"\",\"date1Reservar\":\""+date1Reservar+"\","
	            					+ "\"date2Reservar\":\""+date2Reservar+"\",\"donoReserva\":\""+donoReserva+"\"}";
	            			
	            			responseReservar = postConnection(url,payload);
	    	    	        
	    	    			 if(responseReservar.equals("true")) {
	    	    				 System.out.println("A sua reserva no quarto nº " + idRoomReservar + " entre o dia " + date1Reservar + " e " + date2Reservar + " foi realizada com sucesso.\n");
	    	    			 }else {
	    	    				 System.out.println("O quarto nº " + idRoomReservar + " entre o dia " + date1Reservar + " e " + date2Reservar + " já se encontra reservado.\n");
	    	    			 }
	    	    			break;
	    	    			  
	    	    		case "3":
	    	    			
	    	    			System.out.println("Introduza o numero do quarto da reserva a cancelar");
	    	    			String idRoomCancelar = sc.nextLine();
	    	    			System.out.println("Introduza a data inicial da reserva no formato aaaa-mm-dd");
	    	    			String date1Cancelar = sc.nextLine();
	    	    			System.out.println("Introduza a data final da reserva no formato aaaa-mm-dd");
	    	    			String date2Cancelar = sc.nextLine();	    			
	    	    	        
	    	    	        String responseCancelar;
	    	    	        
	    	    	        url = ("http://localhost:8080/RestfullWebService/rest/cancelarQuarto");
	            			payload = "{\"idRoomCancelar\":\""+idRoomCancelar+"\",\"date1Cancelar\":\""+date1Cancelar+"\","
	            					+ "\"date2Cancelar\":\""+date2Cancelar+"\"}";
	            			
	            			responseCancelar = postConnection(url,payload);
	    	    	        
	    	    			 if(responseCancelar.equals("true")) {
	    	    				 System.out.println("A reserva entre a data " + date1Cancelar + " e " + date2Cancelar + " do quarto nº " + idRoomCancelar + " foi cancelada com sucesso.\n");
	    	    			 }else {
	    	    				 System.out.println("Não existe reserva no quarto nº " + idRoomCancelar + " nas datas inseridas.\n");
	    	    			 }
	    	    			 break;
	        			}
	        		break;
	    		}
    		} catch (SecurityException e) {

                e.printStackTrace();

    	      } catch (IllegalArgumentException e) {
    	
    	        e.printStackTrace();
    	
    	      }
    	}
    	sc.close();
    	
        // Call the Web Service to perform an operation
        
    	}

}