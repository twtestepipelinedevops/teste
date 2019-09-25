package br.com.tw.teste.apiGeoCidade;

import java.util.HashSet;
import java.util.Set;

import org.springframework.stereotype.Service;

@Service
public class CidadeService {

	public Set<String> buscaCidade() {
		Set<String> cidades = new HashSet<String>();
		
		cidades.add("Porto alegre");
		cidades.add("São Paulo");
		cidades.add("Rio de Janeiro");
		cidades.add("Recife");
		
		return cidades;
	}

}
