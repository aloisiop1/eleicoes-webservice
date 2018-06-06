package br.com.etecmam.eleicoes_webservice.servicos;

import javax.ws.rs.Path;
import javax.ws.rs.PathParam;

import java.awt.image.BufferedImage;
import java.awt.image.DataBufferByte;
import java.awt.image.WritableRaster;
import java.io.File;
import java.io.IOException;
import java.time.LocalTime;
import java.util.List;

import javax.imageio.ImageIO;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.InternalServerErrorException;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import br.com.etecmam.eleicoes_webservice.dmp.Candidato;
import br.com.etecmam.eleicoes_webservice.dmp.CandidatoDAO;
import br.com.etecmam.eleicoes_webservice.servicos.json.CandidatoJSON;
import br.com.etecmam.eleicoes_webservice.servicos.json.ErroJSON;
import br.com.etecmam.eleicoes_webservice.servicos.json.ListaDeCandidatosJSON;

@Path("/candidato")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)

public class ServicoCandidato {
	
	@GET
	@Path("imagem/{img-candidato}")
	@Produces("image/png")
	public Response getImagem( @PathParam("img-candidato") String foto) {
		
		Response response = null;
		
		try {

			BufferedImage img = ImageIO.read(new File(System.getProperty("user.dir") + "\\resources\\" + foto ) );
			
			response = Response.ok()					
					.type("image/png")
					.entity(img)
					.build();

		} catch (Exception e) {
			throw new InternalServerErrorException();
		}
				
		return response;
	}
	
	
	public byte[] getByteArray(String imagem){
		
		byte[] data = null;
		
		try {
			
			BufferedImage img = null;
			
			try {
								
			    img = ImageIO.read(new File(System.getProperty("user.dir") + "\\resources\\" + imagem ) );
			    
			} catch (IOException e) {
				e.printStackTrace();				
			}
		
			WritableRaster raster = (WritableRaster) img.getData();
			DataBufferByte dataBuffer = (DataBufferByte) raster.getDataBuffer();
			data = dataBuffer.getData();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return data;
				
	}
	@GET
	@Path("lista")
	public Response getCandidatos() {

		Response response = null;
		
		List<Candidato> listaDeCandidatos = new CandidatoDAO().listarCandidatos();
		
		ListaDeCandidatosJSON lista = new ListaDeCandidatosJSON();
		
		for (Candidato c : listaDeCandidatos) {		
			lista.getCandidatos().add( 
					new CandidatoJSON(c.getNumero(),
									  c.getNome(),
									  c.getSigla(), 
									  c.getVotos(), 
									  c.getFoto() ) );
		}


		System.out.println("\nLISTA DE CANDIDATOS SOLICITADA "  + LocalTime.now() );
		System.out.println( lista.gerarJSON() );		
		
		response = Response
					.status(Response.Status.OK)
					.entity( lista.gerarJSON() )
					.type(MediaType.APPLICATION_JSON)
					.build();

		return response;

	}

	
	@GET
	@Path("{numero-do-candidato}")
	public Response getCandidato(@PathParam("numero-do-candidato") int numero) {

		Response response = null;
		
		
		Candidato c = new CandidatoDAO().pesquisar(numero);

		
		if (c != null) {
			
			CandidatoJSON candidato = new CandidatoJSON(
											c.getNumero(),
											c.getNome(),
											c.getSigla(),
											c.getVotos(),
											c.getFoto() );

			response = Response
					    .status(Response.Status.OK)
						.entity(candidato.gerarJSON())
						.type(MediaType.APPLICATION_JSON)
						.build();

		} else {

			ErroJSON erro = new ErroJSON("CANDIDATO " + numero + " NÃO EXISTE");

			response = Response
						.status(Response.Status.NOT_FOUND)
						.entity(erro.gerarJSON())
						.type(MediaType.APPLICATION_JSON)
						.build();

		}

		return response;

	}

}


