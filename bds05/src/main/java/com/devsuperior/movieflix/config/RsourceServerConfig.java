package com.devsuperior.movieflix.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableResourceServer;
import org.springframework.security.oauth2.config.annotation.web.configuration.ResourceServerConfigurerAdapter;
import org.springframework.security.oauth2.config.annotation.web.configurers.ResourceServerSecurityConfigurer;
import org.springframework.security.oauth2.provider.token.store.JwtTokenStore;

import java.util.Arrays;

@Configuration
@EnableResourceServer // Classe responsavel por receber o token e verificar se o acesso da requisicao esta ok
public class RsourceServerConfig extends ResourceServerConfigurerAdapter {

    // a partir desse objeto conseguimos acessar diversas variaveis da aplicacao
    @Autowired
    private Environment env;

    @Autowired
    private JwtTokenStore tokenStore;

    // rota que sera publica para acessar
    private static final String[] PUBLIC = {"/oauth/token", "/h2-console/**"};

    // configuracao do token store, passamos o nosso bean para ele ser decodificado e analisado, verificar a validade
    @Override
    public void configure(ResourceServerSecurityConfigurer resources) throws Exception {
        resources.tokenStore(tokenStore);
    }

    // configuracao das rotas
    @Override
    public void configure(HttpSecurity http) throws Exception {

        // configuracao para liberar o console do h2
        if (Arrays.asList(env.getActiveProfiles()).contains("test")) {
            http.headers().frameOptions().disable();
        }

        // Definimos liberado td o que e publico e o restante precisa de autenticacao
        http.authorizeRequests()
                .antMatchers(PUBLIC).permitAll()
                .anyRequest().authenticated();

    }
}
