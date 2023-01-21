package controllers;

import java.util.Collections;
import java.util.List;

import models.Postagem;
import play.mvc.Controller;

public class TelaInicial extends Controller {
    
    
    public static void index() {
		
		String termo = params.get("termo");
		List<Postagem> postagens = Collections.EMPTY_LIST;
		
		if (termo == null || termo.isEmpty()) {
			postagens = Postagem.findAll();
		} else {
			postagens = Postagem.find("lower(titulo) like ?1 OR autor like ?2" , "%" + termo.toLowerCase() + "%" , "%" + termo.toLowerCase() + "%").fetch();
		}
		
		render(postagens, termo);
	}


}
