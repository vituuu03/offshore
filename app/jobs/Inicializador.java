package jobs;

import models.Operador;
import models.Operador;
import play.jobs.Job;
import play.jobs.OnApplicationStart;

@OnApplicationStart
public class Inicializador extends Job {

	@Override
	public void doJob() throws Exception {
		 if (Operador.count() == 0) {
			 Operador op = new Operador();
			 op.email = "adm@adm.com";
			 op.senha = "123456";
			 op.save();
		 }
		 
		
	}
}
