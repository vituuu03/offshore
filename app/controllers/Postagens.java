package controllers;

import java.io.File;
import java.util.Collections;
import java.util.List;

import models.Postagem;
import play.mvc.Controller;

public class Postagens extends Controller {
	
	public static void formCadastroNews() {
		render();
	}
	
	public static void inicial() {
		
		String termo = params.get("termo");
		List<Postagem> postagens = Collections.EMPTY_LIST;
		
		if (termo == null || termo.isEmpty()) {
			postagens = Postagem.findAll();
		} else {
			postagens = Postagem.find("lower(titulo) like ?1 OR autor like ?2" , "%" + termo.toLowerCase() + "%" , "%" + termo.toLowerCase() + "%").fetch();
		}
		
		render(postagens, termo);
	}
	public static void salvar(Postagem p, File foto) {
		if (foto != null) {
			p.nomeFoto = foto.getName();
		}else {
			p.nomeFoto = p.nomeFoto;
		}
		
		p.save();
		
		if (foto != null && p.id != null) {
		new File("./fotoPostagens/" + p.id).mkdirs();
		
		
		
		File dest = new File("./fotoPostagens/" + p.id + "/" + foto.getName());
		
		if (dest.exists()) {
			dest.delete();
		
		}
		foto.renameTo(dest);
		}
		formCadastroNews();
		
	}

	











	
	public static void remover(Long id) {
		Postagem p = Postagem.findById(id);
		p.delete();
		
	}
	public static void editar(Long id) {
		Postagem edit = Postagem.findById(id);
		renderTemplate("Postagens/form.html" , edit);
	}
	
	
}
