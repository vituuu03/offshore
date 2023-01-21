package models;

import java.util.Date;

import javax.persistence.Entity;

import play.data.validation.Required;
import play.db.jpa.Model;

@Entity
public class Postagem extends Model {
	
	@Required
	public String titulo;
	
	@Required
	public String autor;
	
	@Required
	public String conteudo;
	
	@Required
	public Date data = new Date(); 
}
