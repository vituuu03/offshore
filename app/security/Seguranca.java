package security;

import controllers.Logins;
import models.Papel;
import play.mvc.Before;
import play.mvc.Controller;

public class Seguranca extends Controller {
	
	@Before
	static void checkAuthentication() { 
		if(session.get("papel") == null) {
			flash.error("Autentique-se no sistema");
			Logins.form();
		}
	}
	
	@Before
	static void verificarAdministrador() {
		String papel = session.get("papel");
		Administrador adminAnnotation = getActionAnnotation(Administrador.class);
		if (adminAnnotation != null && !Papel.ADMIN.name().equals(papel)) {
			forbidden ("Apenas administradores.");
		}
	}
}
