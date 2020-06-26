package soap.tienda.dao;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import soap.tienda.entidad.cliente;
import soap.tienda.entidad.producto;
import soap.tienda.entidad.vendedor;
import soap.tienda.interfaces.InterfaceWSDAO;
import soap.tienda.utils.MysqlDBConexion;

public class IntefaceDAO implements InterfaceWSDAO{

	@Override
	public int savecliente(cliente bean) {
		int estado = -1;
		Connection cn = null;
		CallableStatement cstm=null;
		try {
			cn = MysqlDBConexion.getConexion();
			String sql="Registra_cliente(?,?,?,?,?,?)";
			cstm=cn.prepareCall(sql);
			cstm.setString(1, bean.getNombre());
			cstm.setString(2, bean.getApellidom());
			cstm.setString(3, bean.getApellidop());
			cstm.setInt(4, bean.getDni());
			cstm.setInt(5,bean.getTelefono());
			cstm.setString(6, bean.getFecha());
			estado = cstm.executeUpdate();
			
		}catch(Exception e){
			e.printStackTrace();
		}finally {
			try {
				if(cn!=null)cn.close();
				if(cstm!=null)cstm.close();
			}catch (Exception e2) {
				e2.printStackTrace();
			}
		}
		return estado;
	}

	@Override
	public int updatecliente(cliente bean) {
		int estado = -1;
		Connection cn= null;
		CallableStatement csmt= null;
		try {
			cn = MysqlDBConexion.getConexion();
			String sql="actualizar_cliente(?,?,?,?,?,?,?)";
			csmt= cn.prepareCall(sql);
			csmt.setInt(1, bean.getIdcliente());
			csmt.setString(2, bean.getNombre());
			csmt.setString(3, bean.getApellidom());
			csmt.setString(4, bean.getApellidop());
			csmt.setInt(5, bean.getDni());
			csmt.setString(6, bean.getFecha());
			estado = csmt.executeUpdate();
			
		}catch (Exception e) {
		e.printStackTrace();
		}finally {
			try {
				if(cn!=null)cn.close();
				if(csmt!=null)csmt.close();
			}catch (Exception e2) {
				e2.printStackTrace();
			}
		}
		return estado;
		
	}

	@Override
	public int deletecliente(int id) {
		int estado = -1;
		Connection cn=null;
		CallableStatement cstm= null;
		try {
			cn = MysqlDBConexion.getConexion();
			String sql= "Eliminar_cliente(?)";
			cstm= cn.prepareCall(sql);
			cstm.setInt(1, id);
			estado = cstm.executeUpdate();
			System.out.println("sentencia: "+cstm);
		}catch (Exception e) {
			e.printStackTrace();
		}finally {
			try {
				if(cn!=null)cn.close();
				if(cstm!=null)cstm.close();
			}catch (Exception e2) {
				e2.printStackTrace();
			}
		}
		return estado;
	}

	@Override
	public List<cliente> findcliente(int id) {
		List<cliente> lista=new ArrayList<cliente>();
		cliente bean;
		Connection cn=null;
		CallableStatement cstm=null;
		ResultSet rs=null;
		try {
			cn= MysqlDBConexion.getConexion();
			String sql="find_cliente(?)";
			cstm = cn.prepareCall(sql);
			cstm.setInt(1, id);
			rs = cstm.executeQuery();
			while(rs.next()) {
				bean =new cliente();
				bean.setIdcliente(rs.getInt(1));
				bean.setNombre(rs.getString(2));
				bean.setApellidom(rs.getString(3));
				bean.setApellidop(rs.getString(4));
				bean.setDni(rs.getInt(5));
				bean.setTelefono(rs.getInt(6));
				bean.setFecha(rs.getString(7));
				lista.add(bean);
			}
		}catch (Exception e) {
			e.printStackTrace();
		}
		return lista;
	}

	@Override
	public List<cliente> listarcliente() {
		List<cliente> lista=new ArrayList<cliente>();
		cliente bean;
		Connection cn=null;
		CallableStatement cstm=null;
		ResultSet rs=null;
		try {
			cn= MysqlDBConexion.getConexion();
			String sql="listar_clientes()";
			cstm = cn.prepareCall(sql);
			rs = cstm.executeQuery();
			while(rs.next()) {
				bean =new cliente();
				bean.setIdcliente(rs.getInt(1));
				bean.setNombre(rs.getString(2));
				bean.setApellidom(rs.getString(3));
				bean.setApellidop(rs.getString(4));
				bean.setDni(rs.getInt(5));
				bean.setTelefono(rs.getInt(6));
				bean.setFecha(rs.getString(7));
				lista.add(bean);
			}
		}catch (Exception e) {
			e.printStackTrace();
		}
		return lista;
	}

	@Override
	public int saveproducto(producto bean) {
		int estado = -1;
		Connection cn = null;
		CallableStatement cstm = null;
		try {
			cn= MysqlDBConexion.getConexion();
			String sql="Registro_producto(?,?,?)";
			cstm = cn.prepareCall(sql);
			cstm.setString(1, bean.getNombre());
			cstm.setInt(2, bean.getCantidad());
			cstm.setDouble(3, bean.getPrecio());
			estado = cstm.executeUpdate();
		}catch (Exception e) {
			e.printStackTrace();
		}finally {
			try {
			if(cn!=null) cn.close();
			if(cstm!=null) cstm.close();
			}catch (Exception e2) {
				e2.printStackTrace();
			}
		}
		return estado;
	}

	@Override
	public int updateproducto(producto bean) {
		int estado = -1;
		Connection cn = null;
		CallableStatement cstm = null;
		try {
			cn = MysqlDBConexion.getConexion();
			String sql="actualizar_producto(?,?,?,?)";
			cstm = cn.prepareCall(sql);
			cstm.setInt(1, bean.getCodigo());
			cstm.setString(2, bean.getNombre());
			cstm.setInt(3, bean.getCantidad());
			cstm.setDouble(4, bean.getPrecio());
			estado = cstm.executeUpdate();
		}catch (Exception e) {
			e.printStackTrace();
		}finally {
			try {
			if(cn!=null) cn.close();
			if(cstm!=null) cstm.close();
			}catch (Exception e2) {
				e2.printStackTrace();
			}
		}
		return estado;
	
	}

	@Override
	public int deleteproducto(int id) {
		int estado = -1;
		Connection cn = null;
		CallableStatement cstm= null;
		try {
			cn = MysqlDBConexion.getConexion();
			String  sql="Eliminar_producto(?)";
			cstm = cn.prepareCall(sql);
			cstm.setInt(1, id);
			estado = cstm.executeUpdate();
			System.out.println("sentencia: "+cstm);
		}catch (Exception e) {
			e.printStackTrace();
		}finally {
			try {
			if(cn!=null) cn.close();
			if(cstm!=null) cstm.close();
			}catch (Exception e2) {
				e2.printStackTrace();
			}
		}
		return estado;
	}

	@Override
	public List<producto> findproducto(int id) {
		List<producto> lista = new ArrayList<producto>();
		producto bean;
		Connection cn=null;
		CallableStatement cstm = null;
		ResultSet rs = null;
		try {
			cn = MysqlDBConexion.getConexion();
			String sql="find_producto(?)";
			cstm = cn.prepareCall(sql);
			cstm.setInt(1, id);
			rs=cstm.executeQuery();
			while(rs.next()) {
				bean = new producto();
				bean.setCodigo(rs.getInt(1));
				bean.setNombre(rs.getString(2));
				bean.setCantidad(rs.getInt(3));
				bean.setPrecio(rs.getDouble(4));
				lista.add(bean);
			}
		}catch (Exception e) {
			e.printStackTrace();
		}finally {
			try {
			if(cn!=null) cn.close();
			if(cstm!=null) cstm.close();
			}catch (Exception e2) {
				e2.printStackTrace();
			}
		}
		return lista;
	}

	@Override
	public List<producto> listarproducto() {
		List<producto> lista =new ArrayList<producto>();
		producto bean;
		Connection cn =null;
		CallableStatement cstm =null;
		ResultSet rs=null;
		try {
			cn = MysqlDBConexion.getConexion();
			String sql="listar_productos()";
			cstm = cn.prepareCall(sql);
			rs = cstm.executeQuery();
			while(rs.next()) {
				bean = new producto();
				bean.setCodigo(rs.getInt(1));
				bean.setNombre(rs.getString(2));
				bean.setCantidad(rs.getInt(3));
				bean.setPrecio(rs.getDouble(4));
				lista.add(bean);
			}
		}catch (Exception e) {
			e.printStackTrace();
		}finally {
			try {
			if(cn!=null) cn.close();
			if(cstm!=null) cstm.close();
			}catch (Exception e2) {
				e2.printStackTrace();
			}
		}
		return lista;
	}

	@Override
	public int savevendedor(vendedor bean) {
		int estado = -1;
		Connection cn = null;
		CallableStatement cstm = null;
		try {
			cn= MysqlDBConexion.getConexion();
			String sql="Registra_vendedor(?,?,?,?,?)";
			cstm = cn.prepareCall(sql);
			cstm.setString(1, bean.getNombre());
			cstm.setString(2, bean.getApellidom());
			cstm.setString(3, bean.getApellidom());
			estado = cstm.executeUpdate();
		}catch (Exception e) {
			e.printStackTrace();
		}finally {
			try {
			if(cn!=null) cn.close();
			if(cstm!=null) cstm.close();
			}catch (Exception e2) {
				e2.printStackTrace();
			}
		}
		return estado;
	}

	@Override
	public int updatevendedor(vendedor bean) {
		int estado = -1;
		Connection cn = null;
		CallableStatement cstm = null;
		try {
			cn= MysqlDBConexion.getConexion();
			String sql="actualizar_vendedor(?,?,?,?,?,?)";
			cstm = cn.prepareCall(sql);
			cstm.setInt(1,bean.getCodigo());
			cstm.setString(2, bean.getNombre());
			cstm.setString(3, bean.getApellidom());
			cstm.setString(4, bean.getApellidom());
			estado = cstm.executeUpdate();
		}catch (Exception e) {
			e.printStackTrace();
		}finally {
			try {
			if(cn!=null) cn.close();
			if(cstm!=null) cstm.close();
			}catch (Exception e2) {
				e2.printStackTrace();
			}
		}
		return estado;
	}

	@Override
	public int deletevendedor(int id) {
		int estado = -1;
		Connection cn = null;
		CallableStatement cstm= null;
		try {
			cn = MysqlDBConexion.getConexion();
			String  sql="Eliminar_vendedor(?)";
			cstm = cn.prepareCall(sql);
			cstm.setInt(1, id);
			estado = cstm.executeUpdate();
			System.out.println("sentencia: "+cstm);
		}catch (Exception e) {
			e.printStackTrace();
		}finally {
			try {
			if(cn!=null) cn.close();
			if(cstm!=null) cstm.close();
			}catch (Exception e2) {
				e2.printStackTrace();
			}
		}
		return estado;
	}

	@Override
	public List<vendedor> find_vendedor(int id) {
		List<vendedor> lista =new ArrayList<vendedor>();
		vendedor bean;
		Connection cn =null;
		CallableStatement cstm =null;
		ResultSet rs=null;
		try {
			cn = MysqlDBConexion.getConexion();
			String sql="find_vendedor(?)";
			cstm = cn.prepareCall(sql);
			cstm.setInt(1, id);
			rs = cstm.executeQuery();
			while(rs.next()) {
				bean = new vendedor();
				bean.setCodigo(rs.getInt(1));
				bean.setNombre(rs.getString(2));
				bean.setApellidom(rs.getString(3));
				bean.setApellidop(rs.getString(4));
				bean.setDni(rs.getInt(5));
				bean.setTelefono(rs.getInt(6));
				lista.add(bean);
			}
		}catch (Exception e) {
			e.printStackTrace();
		}finally {
			try {
			if(cn!=null) cn.close();
			if(cstm!=null) cstm.close();
			}catch (Exception e2) {
				e2.printStackTrace();
			}
		}
		return lista;
	}

	@Override
	public List<vendedor> listarvendedor() {
		List<vendedor> lista =new ArrayList<vendedor>();
		vendedor bean;
		Connection cn =null;
		CallableStatement cstm =null;
		ResultSet rs=null;
		try {
			cn = MysqlDBConexion.getConexion();
			String sql="listar_vendedor()";
			cstm = cn.prepareCall(sql);
			rs = cstm.executeQuery();
			while(rs.next()) {
				bean = new vendedor();
				bean.setCodigo(rs.getInt(1));
				bean.setNombre(rs.getString(2));
				bean.setApellidom(rs.getString(3));
				bean.setApellidop(rs.getString(4));
				bean.setDni(rs.getInt(5));
				bean.setTelefono(rs.getInt(6));
				lista.add(bean);
			}
		}catch (Exception e) {
			e.printStackTrace();
		}finally {
			try {
			if(cn!=null) cn.close();
			if(cstm!=null) cstm.close();
			}catch (Exception e2) {
				e2.printStackTrace();
			}
		}
		return lista;
	}

}
