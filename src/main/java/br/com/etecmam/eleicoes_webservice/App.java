package br.com.etecmam.eleicoes_webservice;

import java.time.LocalDateTime;

import org.eclipse.jetty.server.Server;
import org.eclipse.jetty.servlet.ServletContextHandler;
import org.eclipse.jetty.servlet.ServletHolder;

public class App {

	public static void main(String[] args) throws Exception {

			ServletContextHandler contexto = new ServletContextHandler(ServletContextHandler.SESSIONS);
			contexto.setContextPath("/eleicoes");

			Server jettyServer = new Server(2018);
			jettyServer.setHandler(contexto);

			ServletHolder jerseyServlet = contexto.addServlet(org.glassfish.jersey.servlet.ServletContainer.class, "/*");
			jerseyServlet.setInitOrder(0);

			// INDICA AO SERVLET JERSEY QUAL SERVIÇO/CLASSE  REST DEVERÁ SER CARRREGADO
			jerseyServlet.setInitParameter("jersey.config.server.provider.packages", "br.com.etecmam.eleicoes_webservice");
			
			try {

				System.out.println(	"********************************************************************************************************");
				System.out.println("E T E C M A M  -  ELEIÇÕES 2018 " + LocalDateTime.now().toString() );
				System.out.println(	"********************************************************************************************************");

				jettyServer.start();
				jettyServer.join();
						
			} finally {
				jettyServer.destroy();
			}
				
	}

}
