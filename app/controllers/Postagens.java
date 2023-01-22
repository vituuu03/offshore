package controllers;

import java.io.File;
import java.util.Collections;
import java.util.List;

import models.Postagem;
import models.Postagem;
import play.mvc.Controller;
import play.mvc.With;

@With(Seguranca.class)

public class Postagens extends Controller{

	public static void remover(Long id) {
		Postagem p = Postagem.findById(id);
		p.delete();
		
	}
	public static void editar(Long id) {
		Postagem edit = Postagem.findById(id);
		renderTemplate("Postagens/form.html" , edit);
	}


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


    public static void formPostagens() {
        render();
    }

    public static void excluir(Long id) {
        Postagem v = Postagem.findById(id);
        v.delete();
      
    }
    	
    public static void salvar(Postagem v, File foto) {
		
		if (foto != null) {
			v.nomeFoto = foto.getName();
		}else {
			v.nomeFoto = v.nomeFoto;
		}
		
		v.save();
		
		if (foto != null && v.id != null) {
		new File("./offshore/uploads/" + v.id).mkdirs();
		
		
		
		File dest = new File("./offshore/uploads/" + v.id + "/" + foto.getName());
		
		if (dest.exists()) {
			dest.delete();
		
		}
		foto.renameTo(dest);
		}
		Postagens.inicial();
		
	}


   }
    

