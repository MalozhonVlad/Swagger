package com.example.demo;

import com.example.demo.domain.Language;
import com.example.demo.repo.LanguageRepo;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@SpringBootApplication
@EnableSwagger2
public class SwaggerApplication {

    public static void main(String[] args) {
        SpringApplication.run(SwaggerApplication.class, args);
    }

    @Bean
    public ApplicationRunner applicationRunner(LanguageRepo languageRepo){
        return args -> {
            languageRepo.save(new Language().setName("scala").setAuthor("odersky"));
            languageRepo.save(new Language().setName("java").setAuthor("vlad"));
            languageRepo.save(new Language().setName("python").setAuthor("roma"));
            languageRepo.save(new Language().setName("javascript").setAuthor("nikita"));
        };
    }


//    http://localhost:8080/swagger-ui.html - чтоби попасть на документацию

    /**
     * к чему нужно создавать документацию
     * @return
     */
    @Bean
    public Docket api(){
        return new Docket(DocumentationType.SWAGGER_2)
                .select()
                .apis(RequestHandlerSelectors.any())
                .paths(PathSelectors.any())
                .build();
    }

}
