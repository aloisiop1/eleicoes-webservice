package br.com.etecmam.eleicoes_webservice.servicos.json;

import com.google.gson.Gson;
import com.google.gson.annotations.SerializedName;

public class ErroJSON {
	
	@SerializedName("erro")
	private String mensagem;

	public ErroJSON(String mensagem) {		
		this.mensagem = mensagem;
	}

	public String gerarJSON() {		
		return new Gson().toJson(this);
	}

}

