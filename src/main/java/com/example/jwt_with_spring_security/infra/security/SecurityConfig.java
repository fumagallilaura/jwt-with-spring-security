package com.example.jwt_with_spring_security.infra.security;


import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class SecurityConfig {

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        http
                // Configuração de autorização
                .authorizeHttpRequests(request ->
                request.requestMatchers(HttpMethod.GET, "/health").permitAll() // Permite acesso público ao endpoint de health check
                        .requestMatchers(HttpMethod.POST,"/auth").permitAll()
                        .anyRequest().authenticated() // Exige autenticação para qualquer outra requisição
        );
        // O CSRF (Cross-Site Request Forgery), ou falsificação de requisição entre sites, é um tipo de ataque em que um usuário autenticado em um site é induzido a realizar ações indesejadas em outro site onde ele também está autenticado. Esse ataque explora a confiança que um site tem em um navegador autenticado.
        //
        //Como o CSRF Funciona:
        //Imagine que você está autenticado em um site bancário. Se o site não estiver protegido contra CSRF, um atacante pode criar um site malicioso que, ao ser visitado, envia uma requisição ao site bancário em nome do usuário autenticado, sem que o usuário perceba. Como o navegador do usuário já tem um cookie de sessão válido, o site bancário pode aceitar a requisição como legítima, resultando em ações indesejadas, como transferências de dinheiro.
        //
        //Proteção Contra CSRF:
        //Para evitar esse tipo de ataque, o Spring Security, por padrão, habilita a proteção contra CSRF em aplicações web. A proteção contra CSRF funciona exigindo que cada requisição POST, PUT, DELETE ou PATCH contenha um token CSRF. Esse token é gerado pelo servidor e enviado ao cliente (geralmente como um campo oculto em formulários HTML). Quando o cliente envia uma requisição, o token deve ser incluído, e o servidor verifica se o token é válido. Se o token estiver ausente ou for inválido, a requisição é rejeitada.
        //
        //Quando Desabilitar o CSRF:
        //Em APIs REST, o CSRF geralmente não é necessário, porque as APIs REST são stateless (sem estado). Isso significa que as APIs não dependem de cookies de sessão para autenticação, mas sim de tokens como JWT (JSON Web Tokens) ou OAuth. Como o CSRF é um ataque que depende de cookies de sessão, ele não é uma ameaça em APIs que usam tokens de autenticação no cabeçalho da requisição (como o cabeçalho Authorization).
        //
        //Portanto, em APIs REST, é comum desabilitar o CSRF, pois ele não é necessário e pode complicar a implementação.
        http.csrf(AbstractHttpConfigurer::disable);
        return http.build();
    }
}