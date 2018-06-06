package br.com.etecmam.eleicoes_webservice.servicos.json;

import com.google.gson.Gson;
import com.google.gson.annotations.SerializedName;

public class CandidatoJSON {
	
	@SerializedName("numero")
	private int numero;
	
	@SerializedName("nome")
	private String nome;
	
	@SerializedName("sigla")
	private String sigla;
	
	@SerializedName("votos")
	private int votos;
	
	@SerializedName("foto")
	private String foto;
	
	
	
	public String gerarJSON() {		
		return new Gson().toJson(this);				
	}
		
	public CandidatoJSON(int numero, String nome, String sigla, int votos, String foto) {
		this.numero = numero;
		this.nome = nome;
		this.sigla = sigla;
		this.votos = votos;
		this.foto = foto;
	}

//	public CandidatoJSON(int numero, String nome, String sigla, int votos) {	
//		this.numero = numero;
//		this.nome = nome;
//		this.sigla = sigla;
//		this.votos = votos;
//	}

	public int getNumero() {
		return numero;
	}

	public void setNumero(int numero) {
		this.numero = numero;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getSigla() {
		return sigla;
	}

	public void setSigla(String sigla) {
		this.sigla = sigla;
	}

	public int getVotos() {
		return votos;
	}

	public String getFoto() {
		return foto;
	}

	public void setFoto(String foto) {
		this.foto = foto;
	}

	public void setVotos(int votos) {
		this.votos = votos;
	}		
	
	
}


