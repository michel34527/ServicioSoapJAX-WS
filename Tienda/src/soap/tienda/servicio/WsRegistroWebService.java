package soap.tienda.servicio;
import javax.xml.ws.Endpoint;
public class WsRegistroWebService {

	public static void main(String[] args) {
		//1 Se instancia el web service
		InterfaceServicelml ws= new InterfaceServicelml();
		//2 Ruta del ws
		String URL="http://localhost:8083/serviciotienda?wsdl";
		//3 Se registra
		Endpoint eds=Endpoint.publish(URL, ws);
		//4 Se verifica la publicación
		System.out.println(eds.isPublished());
	
	}

}

