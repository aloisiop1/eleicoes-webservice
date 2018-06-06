package br.com.etecmam.eleicoes_webservice.dmp;

import java.util.List;

public class Teste {

	public static void main(String[] args) {

		CandidatoDAO dao = new CandidatoDAO();
		
		List<Candidato> listarCandidatos = dao.listarCandidatos();
		
		for (Candidato candidato : listarCandidatos) {
			System.out.println(candidato.getNumero() + " "+  candidato.getNome() ) ;
			
		}
		
		

	}

}
