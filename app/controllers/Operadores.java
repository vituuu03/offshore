package controllers;

import java.util.List;

import models.Operador;
import play.mvc.Controller;
import play.mvc.With;
import security.Administrador;
import security.Seguranca;

@With(Seguranca.class)
public class Operadores extends Controller {
	
	@Administrador
	//criar importação
	public static void listar() {
		List<Operador> operadores = Operador.findAll();
		render(operadores);
	}

	

}
