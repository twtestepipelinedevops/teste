package br.com.tw.teste.apiGeoCidade;

import static org.junit.Assert.assertTrue;

import java.util.Set;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@ActiveProfiles("test")
@SpringBootTest(classes = ApiGeoCidadeApplication.class)
public class CidadeServiceTests {

	@Autowired
	private CidadeService cidadeService;
	
	
    @Test
    public void BuscaCidadesTests() {
    	
    	Set<String> test = cidadeService.buscaCidade();    	
    	assertTrue("Deve ter cidades na lista", !test.isEmpty());
    }
	
}
