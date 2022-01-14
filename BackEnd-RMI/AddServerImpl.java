import java.rmi.*;
import java.rmi.server.*;
import java.time.LocalDate;
import java.util.*;
import java.io.File;  
import java.io.IOException; 
import java.io.FileWriter;  


import java.io.File;  
import java.io.FileNotFoundException;  
import java.util.Scanner; 

public class AddServerImpl extends UnicastRemoteObject implements AddServerIntf {

  public AddServerImpl() throws RemoteException {
  }
   public double add(double d1, double d2) throws RemoteException {
    return d1 + d2;
  }
      

  public  ArrayList<Integer> listarQuartos(String date1, String date2) { // obter lista de quartos disponiveis


    String[] date1Split = date1.split("-");
    String[] date2Split = date2.split("-");
    LocalDate initMarc = LocalDate.of(Integer.parseInt(date1Split[0]),Integer.parseInt(date1Split[1]),Integer.parseInt(date1Split[2]));
    LocalDate finitMarc = LocalDate.of(Integer.parseInt(date2Split[0]),Integer.parseInt(date2Split[1]),Integer.parseInt(date2Split[2]));

    HashMap<Integer,Room[]> hotelRooms;
    if(!createFile()){
        hotelRooms = createInitData();
    }else{
        hotelRooms = getDataFromFile();
    }

    for (Room[] ro : hotelRooms.values()){
        for(Room r : ro){
            System.out.println(r.id + " | " + r.reservas.size());

        }
    }




    ArrayList<Integer> disponiveis = new ArrayList<>();
    for(Room[] rooms : hotelRooms.values())
        for(Room room : rooms){
            boolean disponivel = true;

            for(Reserva res : room.reservas){
                if(initMarc.isAfter(res.init) && initMarc.isBefore(res.finit)){
                    disponivel = false;
                }
                if(finitMarc.isAfter(res.init) && finitMarc.isBefore(res.finit)){
                    disponivel = false;
                }if(initMarc.isBefore(res.init) && finitMarc.isAfter(res.finit)){
                    disponivel = false;
                }
                if(initMarc.equals(res.init) || initMarc.equals(res.finit)){
                    disponivel = false;
                }
                if(finitMarc.equals(res.init) || finitMarc.equals(res.finit)){
                    disponivel = false;
                }


            }
            if(disponivel){

                disponiveis.add(room.id);
            }
        }
    return disponiveis;
}

public  Boolean cancelarQuarto(int idRoom, String date1, String date2 ){

    String[] date1Split = date1.split("-");
    String[] date2Split = date2.split("-");
    LocalDate initMarc = LocalDate.of(Integer.parseInt(date1Split[0]),Integer.parseInt(date1Split[1]),Integer.parseInt(date1Split[2]));
    LocalDate finitMarc = LocalDate.of(Integer.parseInt(date2Split[0]),Integer.parseInt(date2Split[1]),Integer.parseInt(date2Split[2]));

    HashMap<Integer,Room[]> hotelRooms;
    if(!createFile()){
        hotelRooms = createInitData();
    }else{
        hotelRooms = getDataFromFile();
    }



    int resToRemove = -1;
    for (Room[] rooms : hotelRooms.values()) {
        for (Room r : rooms) {
            if (r.id == idRoom) {

                for (int i = 0; i < r.reservas.size(); i++) {
                    if (r.reservas.get(i).init.equals(initMarc) && r.reservas.get(i).finit.equals(finitMarc)) {
                        resToRemove = i;
                    }
                }
                if (resToRemove != -1) {
                    r.reservas.remove(resToRemove);
                }

            }
        }
    }

    if(resToRemove == -1){
        return false;
    }else{
        updateFile(hotelRooms);
        return true;
    }
}

public  Boolean reservarQuarto(int idRoom, int numPessoas, String date1, String date2, String donoReserva) {

    String[] date1Split = date1.split("-");
    String[] date2Split = date2.split("-");
    LocalDate initMarc = LocalDate.of(Integer.parseInt(date1Split[0]),Integer.parseInt(date1Split[1]),Integer.parseInt(date1Split[2]));
    LocalDate finitMarc = LocalDate.of(Integer.parseInt(date2Split[0]),Integer.parseInt(date2Split[1]),Integer.parseInt(date2Split[2]));

    HashMap<Integer, Room[]> hotelRooms;
    if (!createFile()) {
        hotelRooms = createInitData();
    } else {
        hotelRooms = getDataFromFile();
    }
    boolean disponivel = true;
    String andaresPossiveis = "123";
    boolean breakRes = false;
    int count = 0;
    if(numPessoas>6 || numPessoas<=0){

        disponivel = false;
    }else {

        if (numPessoas == 3) {
            andaresPossiveis = "23";
        }
        if (numPessoas > 3) {
            andaresPossiveis = "3";
        }
        for (Room[] andar : hotelRooms.values()) {
            count = 0;

            for (Room r : andar) {
                if (r.id == idRoom) {
                if ((String.valueOf(r.id).charAt(0) == '1' && andaresPossiveis.equals("123")) || (String.valueOf(r.id).charAt(0) == '2' && (andaresPossiveis.equals("23") || andaresPossiveis.equals("123"))) || (String.valueOf(r.id).charAt(0) == '3' && (andaresPossiveis.equals("23") || andaresPossiveis.equals("123") || andaresPossiveis.equals("3")))){

                    for (Reserva res : r.reservas) {
                        if (initMarc.isAfter(res.init) && initMarc.isBefore(res.finit)) {
                            disponivel = false;
                        }
                        if (finitMarc.isAfter(res.init) && finitMarc.isBefore(res.finit)) {
                            disponivel = false;
                        }
                        if(initMarc.isBefore(res.init) && finitMarc.isAfter(res.finit)){
                            disponivel = false;
                        }
                        if (initMarc.equals(res.init) || initMarc.equals(res.finit)) {
                            disponivel = false;
                        }
                        if (finitMarc.equals(res.init) || finitMarc.equals(res.finit)) {
                            disponivel = false;
                        }
                    }


                }else{
                    disponivel = false;

                }breakRes= true;
                    break;
                }else {
                    count++;
                }
            }
            if (breakRes){
                if (disponivel)
                break;
            }
        }
    }
    if(disponivel){
        char andarTemp = String.valueOf(idRoom).charAt(0);
        Reserva reserva = new Reserva(initMarc,finitMarc,donoReserva);
        hotelRooms.get(Integer.parseInt(String.valueOf(andarTemp)))[count].reservas.add(reserva);
        updateFile(hotelRooms);
        return true;
    }else{
        System.out.println("NÃO FOI POSSIVEL RESERVAR QUARTO, MAXIMO DE PESSOAS EXCEDIDO");
        return false;
    }
}


public  boolean createFile(){

    boolean fileAlreadyExist = false;
    File myObj= new File("HotelRooms.txt");;
    try {

        if (myObj.createNewFile()) {
            System.out.println("File created: " + myObj.getName());
        } else {
            fileAlreadyExist=true;
            System.out.println("File already exists.");
        }
    } catch (IOException e) {
        System.out.println("An error occurred.");
        e.printStackTrace();
    }

    return fileAlreadyExist;

}

public  HashMap<Integer,Room[]> createInitData(){ // caso não exista ficheiro criado, preenche o o hashmap com o default
    HashMap<Integer,Room[]> hotelRooms = new HashMap<>();

    User user1 = new User("diogo@gmail.com","teste123");
    LocalDate testDate1 = LocalDate.of(2001,11,02);
    LocalDate testDate2 = LocalDate.of(2001,11,16);
    Reserva resTeste = new Reserva(testDate1,testDate2,user1.email);
    ArrayList<Reserva> res = new ArrayList<>();


    ArrayList<Reserva> res1 = new ArrayList<>();
    res1.add(resTeste);
    Room r1 = new Room(101,new ArrayList<Reserva>());
    Room r2 = new Room(102,new ArrayList<Reserva>());
    Room r3 = new Room(103,new ArrayList<Reserva>());
    Room r4 = new Room(104,new ArrayList<Reserva>());
    Room r5 = new Room(105,new ArrayList<Reserva>());
    Room r6 = new Room(106,new ArrayList<Reserva>());
    Room r7 = new Room(107,new ArrayList<Reserva>());
    Room r8 = new Room(108,new ArrayList<Reserva>());
    Room r9 = new Room(109,new ArrayList<Reserva>());
    Room r10 = new Room(110,new ArrayList<Reserva>());

    Room r11 = new Room(201,new ArrayList<Reserva>());
    Room r12 = new Room(202,new ArrayList<Reserva>());
    Room r13 = new Room(203,new ArrayList<Reserva>());
    Room r14 = new Room(204,new ArrayList<Reserva>());
    Room r15 = new Room(205,new ArrayList<Reserva>());
    Room r16 = new Room(206,new ArrayList<Reserva>());
    Room r17 = new Room(207,new ArrayList<Reserva>());
    Room r18 = new Room(208,new ArrayList<Reserva>());
    Room r19 = new Room(209,new ArrayList<Reserva>());
    Room r110 = new Room(210,new ArrayList<Reserva>());

    Room r1S = new Room(301,new ArrayList<Reserva>());
    Room r2S = new Room(302,new ArrayList<Reserva>());
    Room r3S = new Room(303,new ArrayList<Reserva>());
    Room r4S = new Room(304,new ArrayList<Reserva>());
    Room[] rooms1 = new Room[]{r1,r2,r3,r4,r5,r6,r7,r8,r9,r10};
    Room[] rooms2 = new Room[]{r11,r12,r13,r14,r15,r16,r17,r18,r19,r110};
    Room[] rooms3 = new Room[]{r1S,r2S,r3S,r4S};
    hotelRooms.put(1,rooms1);
    hotelRooms.put(2,rooms2);
    hotelRooms.put(3,rooms3);

    return hotelRooms;
}

public  void updateFile(HashMap<Integer,Room[]> hotelRooms){ // Atualizar o ficheiro com novas reservas
    try {

        FileWriter myWriter = new FileWriter("HotelRooms.txt");
        int count = 0;
        for (Room[] piso : hotelRooms.values() ){

            for (Room room : piso){
                String lineToWrite = "";

                if(room.reservas.size() != 0){
                    for (Reserva res : room.reservas){
                        String date1 = res.init.getYear()+"-"+res.init.getMonthValue()+"-"+res.init.getDayOfMonth();
                        String date2 = res.finit.getYear()+"-"+res.finit.getMonthValue()+"-"+res.finit.getDayOfMonth();
                        if (count==0){
                            lineToWrite = room.id + ":" + date1 + ":" + date2 + ":" + res.donoReserva;
                        }else{
                            lineToWrite = "\n" + room.id + ":" + date1 + ":" + date2 + ":" + res.donoReserva;
                        }
                        count++;
                        myWriter.write(lineToWrite);

                    }
                }
            }
        }
        myWriter.close();
        System.out.println("Successfully wrote to the file.");
    } catch (IOException e) {
        System.out.println("An error occurred.");
        e.printStackTrace();
    }
}

public  HashMap<Integer,Room[]> getDataFromFile(){ // caso exista ficheiro, vamos ler do ficheiro e guardar no hashmap


    HashMap<Integer,Room[]> hotelRooms = createInitData();
    try {
        File myObj = new File("HotelRooms.txt");
        Scanner myReader = new Scanner(myObj);
        while (myReader.hasNextLine()) {
            String data = myReader.nextLine();
            String[] dados = data.split(":");
            int count = 0;

            switch (dados[0].charAt(0)){ // verificar primeiro numero do id do quarto {1}01
                case '1':
                    count = 0;
                    for(Room room : hotelRooms.get(1)){
                        if (room.id == Integer.parseInt(dados[0])){

                            LocalDate d1 = LocalDate.of(Integer.parseInt(dados[1].split("-")[0]),Integer.parseInt(dados[1].split("-")[1]),Integer.parseInt(dados[1].split("-")[2]));
                            LocalDate d2 = LocalDate.of(Integer.parseInt(dados[2].split("-")[0]),Integer.parseInt(dados[2].split("-")[1]),Integer.parseInt(dados[2].split("-")[2]));
                            String user = dados[3];
                            Reserva reserva = new Reserva(d1,d2,user);
                            hotelRooms.get(1)[count].reservas.add(reserva);

                            break;
                        }
                        count++;
                    }
                    break;
                case '2':
                    count = 0;
                    for(Room room : hotelRooms.get(2)){
                        if (room.id == Integer.parseInt(dados[0])){

                            LocalDate d1 = LocalDate.of(Integer.parseInt(dados[1].split("-")[0]),Integer.parseInt(dados[1].split("-")[1]),Integer.parseInt(dados[1].split("-")[2]));
                            LocalDate d2 = LocalDate.of(Integer.parseInt(dados[2].split("-")[0]),Integer.parseInt(dados[2].split("-")[1]),Integer.parseInt(dados[2].split("-")[2]));
                            String user = dados[3]; // criar classe User
                            Reserva reserva = new Reserva(d1,d2,user); // add user na reserva
                            hotelRooms.get(2)[count].reservas.add(reserva);
                            break;
                        }
                        count++;
                    }
                    break;
                case '3':
                    count = 0;
                    for(Room room : hotelRooms.get(3)){
                        if (room.id == Integer.parseInt(dados[0])){

                            LocalDate d1 = LocalDate.of(Integer.parseInt(dados[1].split("-")[0]),Integer.parseInt(dados[1].split("-")[1]),Integer.parseInt(dados[1].split("-")[2]));
                            LocalDate d2 = LocalDate.of(Integer.parseInt(dados[2].split("-")[0]),Integer.parseInt(dados[2].split("-")[1]),Integer.parseInt(dados[2].split("-")[2]));
                            String user = dados[3]; // criar classe User
                            Reserva reserva = new Reserva(d1,d2,user); // add user na reserva
                            hotelRooms.get(3)[count].reservas.add(reserva);
                            break;
                        }
                        count++;

                    }
                    break;
                default:

            }

            //  System.out.println(data);
        }
        myReader.close();
    } catch (FileNotFoundException e) {
        System.out.println("An error occurred.");
        e.printStackTrace();
    }

    return hotelRooms;

}

  }