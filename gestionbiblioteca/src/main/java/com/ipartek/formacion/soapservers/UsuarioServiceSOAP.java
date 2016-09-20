package com.ipartek.formacion.soapservers;

import java.util.List;

import com.ipartek.formacion.dao.persistence.Usuario;
import javax.jws.WebService;
import javax.jws.SOAPBinding;
import javax.jws.SOAPBinding.Style;
/**
 * Este es el SEI del servicio web
 * @author Curso
 *
 */
@WebService(name = "CursoService")
@SOAPBinding(style = Style.DOCUMENT,use=Use.LITERAL)
public interface UsuarioServiceSOAP {
	public List<Usuario> getAllUsers();
	
	public Usuario getByIdUser(int id);
}
