package br.com.tw.teste.apiGeoCidade;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger.web.SecurityConfiguration;
import springfox.documentation.swagger.web.SecurityConfigurationBuilder;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Configuration
@EnableConfigurationProperties(SwaggerConfigProperties.class)
@EnableSwagger2
public class SwaggerConfig {
	
	private final SwaggerConfigProperties configProperties;

	SwaggerConfig(SwaggerConfigProperties configProperties){
		this.configProperties = configProperties;
	}

    @Bean
    public Docket api() {
        return new Docket(DocumentationType.SWAGGER_2)
				.apiInfo(apiInfo())
                .select()
                .apis(RequestHandlerSelectors.basePackage("br.com.tw.teste.apiGeoCidade"))
                .paths(PathSelectors.any())
                .build();
    }

    @Bean
    public SecurityConfiguration security(){
        return SecurityConfigurationBuilder.builder()
                .clientId(null).clientSecret(null).realm(null).appName(null).scopeSeparator("").build();
    }


    private ApiInfo apiInfo(){
		return new ApiInfoBuilder()
				.title(this.configProperties.getName())
				.description(this.configProperties.getDescription())
				.version(this.configProperties.getVersion())
				.build();
	}

}
