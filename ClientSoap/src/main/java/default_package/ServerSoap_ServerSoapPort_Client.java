
package default_package;

/**
 * Please modify this class to meet your needs
 * This class is not complete
 */

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import javax.xml.namespace.QName;
import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebResult;
import javax.jws.WebService;
import javax.xml.bind.annotation.XmlSeeAlso;
import javax.xml.ws.RequestWrapper;
import javax.xml.ws.ResponseWrapper;

/**
 * This class was generated by Apache CXF 3.4.5
 * 2021-12-27T21:28:27.834Z
 * Generated source version: 3.4.5
 *
 */
public final class ServerSoap_ServerSoapPort_Client {

    private static final QName SERVICE_NAME = new QName("http://default_package/", "ServerSoapService");

    private ServerSoap_ServerSoapPort_Client() {
    }

    public static void main(String args[]) throws java.lang.Exception {
        URL wsdlURL = ServerSoapService.WSDL_LOCATION;
        if (args.length > 0 && args[0] != null && !"".equals(args[0])) {
            File wsdlFile = new File(args[0]);
            try {
                if (wsdlFile.exists()) {
                    wsdlURL = wsdlFile.toURI().toURL();
                } else {
                    wsdlURL = new URL(args[0]);
                }
            } catch (MalformedURLException e) {
                e.printStackTrace();
            }
        }

        ServerSoapService ss = new ServerSoapService(wsdlURL, SERVICE_NAME);
        ServerSoap port = ss.getServerSoapPort();

        {
        System.out.println("Invoking reservarQuarto...");
        int _reservarQuarto_arg0 = -1990907198;
        int _reservarQuarto_arg1 = -1015004871;
        java.lang.String _reservarQuarto_arg2 = "_reservarQuarto_arg258630216";
        java.lang.String _reservarQuarto_arg3 = "_reservarQuarto_arg31357875450";
        java.lang.String _reservarQuarto_arg4 = "_reservarQuarto_arg41266222928";
        java.lang.Boolean _reservarQuarto__return = port.reservarQuarto(_reservarQuarto_arg0, _reservarQuarto_arg1, _reservarQuarto_arg2, _reservarQuarto_arg3, _reservarQuarto_arg4);
        System.out.println("reservarQuarto.result=" + _reservarQuarto__return);


        }
        {
        System.out.println("Invoking autenticarUser...");
        java.lang.String _autenticarUser_arg0 = "_autenticarUser_arg01541515377";
        java.lang.String _autenticarUser_arg1 = "_autenticarUser_arg1-84220354";
        java.lang.String _autenticarUser__return = port.autenticarUser(_autenticarUser_arg0, _autenticarUser_arg1);
        System.out.println("autenticarUser.result=" + _autenticarUser__return);


        }
        {
        System.out.println("Invoking cancelarQuarto...");
        int _cancelarQuarto_arg0 = 1398075500;
        java.lang.String _cancelarQuarto_arg1 = "_cancelarQuarto_arg11437085101";
        java.lang.String _cancelarQuarto_arg2 = "_cancelarQuarto_arg2-1076570725";
        java.lang.Boolean _cancelarQuarto__return = port.cancelarQuarto(_cancelarQuarto_arg0, _cancelarQuarto_arg1, _cancelarQuarto_arg2);
        System.out.println("cancelarQuarto.result=" + _cancelarQuarto__return);


        }
        {
        System.out.println("Invoking listarQuartos...");
        java.lang.String _listarQuartos_arg0 = "_listarQuartos_arg064821701";
        java.lang.String _listarQuartos_arg1 = "_listarQuartos_arg1-1303726580";
        java.util.List<java.lang.Integer> _listarQuartos__return = port.listarQuartos(_listarQuartos_arg0, _listarQuartos_arg1);
        System.out.println("listarQuartos.result=" + _listarQuartos__return);


        }
        {
        System.out.println("Invoking registarUser...");
        java.lang.String _registarUser_arg0 = "_registarUser_arg02144193778";
        java.lang.String _registarUser_arg1 = "_registarUser_arg1977397347";
        java.lang.String _registarUser__return = port.registarUser(_registarUser_arg0, _registarUser_arg1);
        System.out.println("registarUser.result=" + _registarUser__return);


        }

        System.exit(0);
    }

}