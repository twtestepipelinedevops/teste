package br.com.tw.teste.apiGeoCidade;

import java.util.Set;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;


import io.swagger.annotations.ApiOperation;



@Controller
@RequestMapping("/cidade/v1")
public class CidadeRest {
	
	@Autowired
	private CidadeService cidadeService;
	
	private static final Logger LOG = LoggerFactory.getLogger(CidadeRest.class);
	private static final String MSG_EXCEPTION = "Exception :: ";
	
	@GetMapping(value = { "/busca/" })
	@ResponseBody
	@ApiOperation(value = "Busca a lista de cidades")
	public Set<String> getBuscaListaCidades() {
		try {
			return cidadeService.buscaCidade();
		} catch (Exception e) {
			LOG.error(MSG_EXCEPTION, e);
			throw e;
		}
	}

}
