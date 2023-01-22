package controllers;

import play.mvc.Before;
import play.mvc.Controller;

public class Seguranca extends Controller{
    
    @Before
	static void verificar() {

		// Se o usuraio não estiver logado, não é possível acessar as páginas
		if (session.contains("ope.email") == false) {
			Logins.form();
		}

	}


}
