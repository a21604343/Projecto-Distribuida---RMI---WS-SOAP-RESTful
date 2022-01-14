import java.util.ArrayList;

public interface RestConsumer{
  String listarQuartos(String date1, String date2);
  String registarUser(String payload);
  String autenticarUser(String payload);
  String cancelarQuarto(String payload);
  String reservarQuarto(String payload);
  String[] spliter(String payload);
}