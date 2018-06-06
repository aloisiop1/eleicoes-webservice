package br.com.etecmam.eleicoes_webservice.util;

import java.util.HashMap;
import java.util.Map;

import br.com.etecmam.eleicoes_webservice.servicos.json.CandidatoJSON;;

public class Util {

	static Map<Integer, CandidatoJSON> candidatos;
	
	static {
		
		candidatos = new HashMap<Integer, CandidatoJSON>(); 
		
		candidatos.put(10, new CandidatoJSON(10, "SEU MADRUGA", "SIGLA 1", 172, "") );
		candidatos.put(20, new CandidatoJSON(20, "DONA FLORINDA", "SIGLA 2", 110, "") );
		candidatos.put(30, new CandidatoJSON(30, "CHAVES", "SIGLA 3", 1000, "") );
		candidatos.put(40, new CandidatoJSON(40, "KIKO", "SIGLA 4", 777, "") );
				
	}

	public static Map<Integer, CandidatoJSON> getCandidatos() {
		return candidatos;
	}
	
		
}

	