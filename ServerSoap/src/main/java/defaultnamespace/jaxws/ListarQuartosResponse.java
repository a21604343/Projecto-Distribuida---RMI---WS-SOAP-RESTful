
package defaultnamespace.jaxws;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

/**
 * This class was generated by Apache CXF 3.4.5
 * Mon Dec 27 21:22:35 GMT 2021
 * Generated source version: 3.4.5
 */

@XmlRootElement(name = "listarQuartosResponse", namespace = "http://default_package/")
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "listarQuartosResponse", namespace = "http://default_package/")

public class ListarQuartosResponse {

    @XmlElement(name = "return")
    private java.util.ArrayList<java.lang.Integer> _return;

    public java.util.ArrayList<java.lang.Integer> getReturn() {
        return this._return;
    }

    public void setReturn(java.util.ArrayList<java.lang.Integer> new_return)  {
        this._return = new_return;
    }

}
