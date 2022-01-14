
package default_package;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the default_package package. 
 * <p>An ObjectFactory allows you to programatically 
 * construct new instances of the Java representation 
 * for XML content. The Java representation of XML 
 * content can consist of schema derived interfaces 
 * and classes representing the binding of schema 
 * type definitions, element declarations and model 
 * groups.  Factory methods for each of these are 
 * provided in this class.
 * 
 */
@XmlRegistry
public class ObjectFactory {

    private final static QName _AutenticarUser_QNAME = new QName("http://default_package/", "autenticarUser");
    private final static QName _AutenticarUserResponse_QNAME = new QName("http://default_package/", "autenticarUserResponse");
    private final static QName _CancelarQuarto_QNAME = new QName("http://default_package/", "cancelarQuarto");
    private final static QName _CancelarQuartoResponse_QNAME = new QName("http://default_package/", "cancelarQuartoResponse");
    private final static QName _ListarQuartos_QNAME = new QName("http://default_package/", "listarQuartos");
    private final static QName _ListarQuartosResponse_QNAME = new QName("http://default_package/", "listarQuartosResponse");
    private final static QName _RegistarUser_QNAME = new QName("http://default_package/", "registarUser");
    private final static QName _RegistarUserResponse_QNAME = new QName("http://default_package/", "registarUserResponse");
    private final static QName _ReservarQuarto_QNAME = new QName("http://default_package/", "reservarQuarto");
    private final static QName _ReservarQuartoResponse_QNAME = new QName("http://default_package/", "reservarQuartoResponse");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: default_package
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link AutenticarUser }
     * 
     */
    public AutenticarUser createAutenticarUser() {
        return new AutenticarUser();
    }

    /**
     * Create an instance of {@link AutenticarUserResponse }
     * 
     */
    public AutenticarUserResponse createAutenticarUserResponse() {
        return new AutenticarUserResponse();
    }

    /**
     * Create an instance of {@link CancelarQuarto }
     * 
     */
    public CancelarQuarto createCancelarQuarto() {
        return new CancelarQuarto();
    }

    /**
     * Create an instance of {@link CancelarQuartoResponse }
     * 
     */
    public CancelarQuartoResponse createCancelarQuartoResponse() {
        return new CancelarQuartoResponse();
    }

    /**
     * Create an instance of {@link ListarQuartos }
     * 
     */
    public ListarQuartos createListarQuartos() {
        return new ListarQuartos();
    }

    /**
     * Create an instance of {@link ListarQuartosResponse }
     * 
     */
    public ListarQuartosResponse createListarQuartosResponse() {
        return new ListarQuartosResponse();
    }

    /**
     * Create an instance of {@link RegistarUser }
     * 
     */
    public RegistarUser createRegistarUser() {
        return new RegistarUser();
    }

    /**
     * Create an instance of {@link RegistarUserResponse }
     * 
     */
    public RegistarUserResponse createRegistarUserResponse() {
        return new RegistarUserResponse();
    }

    /**
     * Create an instance of {@link ReservarQuarto }
     * 
     */
    public ReservarQuarto createReservarQuarto() {
        return new ReservarQuarto();
    }

    /**
     * Create an instance of {@link ReservarQuartoResponse }
     * 
     */
    public ReservarQuartoResponse createReservarQuartoResponse() {
        return new ReservarQuartoResponse();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link AutenticarUser }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link AutenticarUser }{@code >}
     */
    @XmlElementDecl(namespace = "http://default_package/", name = "autenticarUser")
    public JAXBElement<AutenticarUser> createAutenticarUser(AutenticarUser value) {
        return new JAXBElement<AutenticarUser>(_AutenticarUser_QNAME, AutenticarUser.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link AutenticarUserResponse }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link AutenticarUserResponse }{@code >}
     */
    @XmlElementDecl(namespace = "http://default_package/", name = "autenticarUserResponse")
    public JAXBElement<AutenticarUserResponse> createAutenticarUserResponse(AutenticarUserResponse value) {
        return new JAXBElement<AutenticarUserResponse>(_AutenticarUserResponse_QNAME, AutenticarUserResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link CancelarQuarto }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link CancelarQuarto }{@code >}
     */
    @XmlElementDecl(namespace = "http://default_package/", name = "cancelarQuarto")
    public JAXBElement<CancelarQuarto> createCancelarQuarto(CancelarQuarto value) {
        return new JAXBElement<CancelarQuarto>(_CancelarQuarto_QNAME, CancelarQuarto.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link CancelarQuartoResponse }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link CancelarQuartoResponse }{@code >}
     */
    @XmlElementDecl(namespace = "http://default_package/", name = "cancelarQuartoResponse")
    public JAXBElement<CancelarQuartoResponse> createCancelarQuartoResponse(CancelarQuartoResponse value) {
        return new JAXBElement<CancelarQuartoResponse>(_CancelarQuartoResponse_QNAME, CancelarQuartoResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ListarQuartos }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link ListarQuartos }{@code >}
     */
    @XmlElementDecl(namespace = "http://default_package/", name = "listarQuartos")
    public JAXBElement<ListarQuartos> createListarQuartos(ListarQuartos value) {
        return new JAXBElement<ListarQuartos>(_ListarQuartos_QNAME, ListarQuartos.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ListarQuartosResponse }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link ListarQuartosResponse }{@code >}
     */
    @XmlElementDecl(namespace = "http://default_package/", name = "listarQuartosResponse")
    public JAXBElement<ListarQuartosResponse> createListarQuartosResponse(ListarQuartosResponse value) {
        return new JAXBElement<ListarQuartosResponse>(_ListarQuartosResponse_QNAME, ListarQuartosResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link RegistarUser }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link RegistarUser }{@code >}
     */
    @XmlElementDecl(namespace = "http://default_package/", name = "registarUser")
    public JAXBElement<RegistarUser> createRegistarUser(RegistarUser value) {
        return new JAXBElement<RegistarUser>(_RegistarUser_QNAME, RegistarUser.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link RegistarUserResponse }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link RegistarUserResponse }{@code >}
     */
    @XmlElementDecl(namespace = "http://default_package/", name = "registarUserResponse")
    public JAXBElement<RegistarUserResponse> createRegistarUserResponse(RegistarUserResponse value) {
        return new JAXBElement<RegistarUserResponse>(_RegistarUserResponse_QNAME, RegistarUserResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ReservarQuarto }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link ReservarQuarto }{@code >}
     */
    @XmlElementDecl(namespace = "http://default_package/", name = "reservarQuarto")
    public JAXBElement<ReservarQuarto> createReservarQuarto(ReservarQuarto value) {
        return new JAXBElement<ReservarQuarto>(_ReservarQuarto_QNAME, ReservarQuarto.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ReservarQuartoResponse }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link ReservarQuartoResponse }{@code >}
     */
    @XmlElementDecl(namespace = "http://default_package/", name = "reservarQuartoResponse")
    public JAXBElement<ReservarQuartoResponse> createReservarQuartoResponse(ReservarQuartoResponse value) {
        return new JAXBElement<ReservarQuartoResponse>(_ReservarQuartoResponse_QNAME, ReservarQuartoResponse.class, null, value);
    }

}
