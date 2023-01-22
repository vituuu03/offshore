package models;


import javax.persistence.Entity;

import play.data.validation.Required;
import play.db.jpa.Model;

@Entity
public class Postagem extends Model{
    
	
	@Required
	public String titulo;
	
	@Required
	public String descricao;

	@Required
	public String autor;
	
	public String nomeFoto;

	public String link;

	@Required
	public String ano;
}
