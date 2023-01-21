package controllers;

import models.Operador;
import play.libs.Crypto;
import play.mvc.Controller;

public class Logins extends Controller {
	
	public static void form() {
		render();
	}
		public static void logar(String email, String senha, Long id) {
			Operador operador = Operador.find("email = ?1 and senha = ?2", email, senha).first();
			
			if (operador != null) {
				session.put("operador", operador.id);
				flash.success("Bem vindo ao sistema");
				Postagens.inicial();
				
			}else {
				flash.error("Senha e login não correspondidos ");
			    Logins.form();
			}
		}
		
		public static void logout() {
			session.clear();
			flash.success("Você saiu da página do administrador");
			TelaInicial.index();
		}
		public static void cadastro(String a) {
			render();
		}
	}
	

