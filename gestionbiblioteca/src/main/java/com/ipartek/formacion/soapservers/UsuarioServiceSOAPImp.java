package com.ipartek.formacion.soapservers;

import java.util.List;

import javax.jws.WebService;

import org.springframework.beans.factory.annotation.Autowired;

import com.ipartek.formacion.dao.persistence.Usuario;
import com.ipartek.formacion.service.interfaces.UsuarioService;

@WebService(name = "CursoService",endpointInterface ="com.ipartek.formacion.soapservers.UsuarioServiceSOAP")
public class UsuarioServiceSOAPImp implements UsuarioServiceSOAP {
	@Autowired
	UsuarioService usuService;

	public List<Usuario> getAllUsers() {

		return usuService.getAll();
	}

	public Usuario getByIdUser(int id) {
		// TODO Auto-generated method stub
		return null;
	}


}
