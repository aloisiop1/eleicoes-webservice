package br.com.etecmam.eleicoes_webservice.servicos.json;

import java.util.ArrayList;
import java.util.List;

import com.google.gson.Gson;
import com.google.gson.annotations.SerializedName;

public class ListaDeCandidatosJSON {
	
	@SerializedName("candidatos")
	List<CandidatoJSON> candidatos = new ArrayList<CandidatoJSON>();
	
	
	public List<CandidatoJSON> getCandidatos() {
		return candidatos;
	}

	public String gerarJSON() {		
		return new Gson().toJson(this);
	}

}


