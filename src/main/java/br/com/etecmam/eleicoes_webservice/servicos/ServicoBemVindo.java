package br.com.etecmam.eleicoes_webservice.servicos;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Path("/inicio")
@Produces(MediaType.TEXT_HTML)
public class ServicoBemVindo {
	
	@GET
	public String getPagina() {
		
		String texto = "<html> "
					 + " <head> <meta charset=\"utf-8\"> "
					 + "<title> ELEIÇÕES 2018 </title> <"
					 + "/head> "
					 + "<body>  <p> <b> ETECMAM - WEB SERVICE DAS ELEIÇÕES 2018 </b> </p>  "
					 + "<p> PC2 </p>"
					 + " PROF.ALOISIO  </body>"
					 + "</html>";
		
		return texto;
		
	}
	
	

}
