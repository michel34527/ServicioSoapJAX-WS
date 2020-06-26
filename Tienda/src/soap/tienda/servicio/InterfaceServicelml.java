package soap.tienda.servicio;

import java.util.List;

import javax.jws.WebService;

import soap.tienda.dao.IntefaceDAO;
import soap.tienda.entidad.cliente;
import soap.tienda.entidad.producto;
import soap.tienda.entidad.vendedor;
import soap.tienda.interfaces.InterfaceWSDAO;
@WebService(name="Tienda", endpointInterface="soap.tienda.interfaces.InterfaceWSDAO")  
public class InterfaceServicelml implements InterfaceWSDAO {
private IntefaceDAO dao = new IntefaceDAO();
	@Override
	public int savecliente(cliente bean) {
		// TODO Auto-generated method stub
		return dao.savecliente(bean);
	}

	@Override
	public int updatecliente(cliente bean) {
		// TODO Auto-generated method stub
		return dao.updatecliente(bean);
	}

	@Override
	public int deletecliente(int id) {
		// TODO Auto-generated method stub
		return dao.deletecliente(id);
	}

	@Override
	public List<cliente> findcliente(int id) {
		// TODO Auto-generated method stub
		return dao.findcliente(id);
	}

	@Override
	public List<cliente> listarcliente() {
		// TODO Auto-generated method stub
		return dao.listarcliente();
	}

	@Override
	public int saveproducto(producto bean) {
		// TODO Auto-generated method stub
		return dao.saveproducto(bean);
	}

	@Override
	public int updateproducto(producto bean) {
		// TODO Auto-generated method stub
		return dao.updateproducto(bean);
	}

	@Override
	public int deleteproducto(int id) {
		// TODO Auto-generated method stub
		return dao.deleteproducto(id);
	}

	@Override
	public List<producto> findproducto(int id) {
		// TODO Auto-generated method stub
		return dao.findproducto(id);
	}

	@Override
	public List<producto> listarproducto() {
		// TODO Auto-generated method stub
		return dao.listarproducto();
	}

	@Override
	public int savevendedor(vendedor bean) {
		// TODO Auto-generated method stub
		return dao.savevendedor(bean);
	}

	@Override
	public int updatevendedor(vendedor bean) {
		// TODO Auto-generated method stub
		return dao.updatevendedor(bean);
	}

	@Override
	public int deletevendedor(int id) {
		// TODO Auto-generated method stub
		return dao.deletevendedor(id);
	}

	@Override
	public List<vendedor> find_vendedor(int id) {
		// TODO Auto-generated method stub
		return dao.find_vendedor(id);
	}

	@Override
	public List<vendedor> listarvendedor() {
		// TODO Auto-generated method stub
		return dao.listarvendedor();
	}

}
