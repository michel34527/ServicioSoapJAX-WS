package soap.tienda.interfaces;

import java.util.List;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebService;

import soap.tienda.entidad.cliente;
import soap.tienda.entidad.producto;
import soap.tienda.entidad.vendedor;

@WebService(name="servicio")
public interface InterfaceWSDAO {
	//metodos para cliente
@WebMethod
	public int savecliente(@WebParam(name="codigo")cliente bean);
@WebMethod
	public int updatecliente(@WebParam(name="codigo")cliente bean);
@WebMethod
	public int deletecliente(@WebParam(name="id")int id);
@WebMethod
	public List<cliente> findcliente(@WebParam(name="id")int id);
	@WebMethod
	public List<cliente> listarcliente();
	//metodos para el producto
@WebMethod
public int saveproducto(@WebParam(name="codigo")producto bean);
@WebMethod
public int updateproducto (@WebParam(name="codigo")producto bean);
@WebMethod
public int deleteproducto (@WebParam(name="id")int id);
@WebMethod
public List<producto> findproducto(@WebParam(name="listarxid")int id);
@WebMethod
public List<producto>listarproducto();
	//metodos para el vendedor
@WebMethod
	public int savevendedor(@WebParam(name="codigo")vendedor bean);
@WebMethod
	public int updatevendedor(@WebParam(name="codigo")vendedor bean);
@WebMethod
	public int deletevendedor(@WebParam(name="id")int id);
@WebMethod
	public List<vendedor>find_vendedor(@WebParam(name="listaxid")int id);
@WebMethod
	public List<vendedor>listarvendedor();
}
