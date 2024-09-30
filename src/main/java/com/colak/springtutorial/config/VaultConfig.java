package com.colak.springtutorial.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.vault.authentication.TokenAuthentication;
import org.springframework.vault.client.VaultEndpoint;
import org.springframework.vault.core.VaultTemplate;

@Configuration
public class VaultConfig {

    @Value("spring.cloud.vault.token")
    private String rootToken;

    @Bean
    public VaultTemplate vaultTemplate() {
        VaultEndpoint endpoint = VaultEndpoint.create("localhost", 8200);
        return new VaultTemplate(endpoint, getClientAuthentication());
    }

    // See https://medium.com/@theshubhamgoel/using-kubernetes-role-based-authentication-with-spring-boot-app-fb3d1d2aadcd
    private TokenAuthentication getClientAuthentication() {
        return new TokenAuthentication(rootToken);
    }
}

