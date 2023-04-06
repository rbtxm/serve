package com.rbtxm.doc.config;

import io.swagger.v3.oas.models.Components;
import io.swagger.v3.oas.models.ExternalDocumentation;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.security.SecurityRequirement;
import io.swagger.v3.oas.models.security.SecurityScheme;
import io.swagger.v3.oas.models.servers.Server;
import io.swagger.v3.oas.models.tags.Tag;
import jakarta.annotation.Resource;
import org.springdoc.core.GroupedOpenApi;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;


@Configuration
public class SpringDocConfiguration {

    @Resource
    private DocProperties docProperties;

    @Bean
    public OpenAPI openAPI() {
        return new OpenAPI()
                .info(info())
                .servers(servers())
                .tags(tags())
                .externalDocs(externalDocumentation())
                .components(components())
                .addSecurityItem(securityRequirement());
    }

    private Info info(){
        DocProperties.InfoProperty info = docProperties.getInfo();
        return new Info()
                .title(info.getTitle())
                .version(info.getVersion())
                .description(info.getDescription());
    };

    private List<Server> servers(){
        List<Server> servers = new LinkedList<>();
        Map<String, DocProperties.ServerProperty> serverPropertyMap = docProperties.getServers().getServerPropertyMap();
        serverPropertyMap.forEach((k,v)-> servers.add(new Server()
                .url(v.getPath())
                .description(v.getDescription())
        ));
        return servers;
    };

    private List<Tag> tags(){
        List<Tag> tags = new LinkedList<>();
        Map<String, DocProperties.TagProperty> tagPropertyMap = docProperties.getTags().getTagPropertyMap();
        tagPropertyMap.forEach((k,v)-> tags.add(new Tag()
                .name(v.getName())
                .description(v.getDescription())
        ));
        return tags;
    };

    private ExternalDocumentation externalDocumentation(){
        return new ExternalDocumentation()
                .url(docProperties.getUrl())
                .description(docProperties.getDescription());
    };

    private Components components(){
        return new Components()
                .addSecuritySchemes(docProperties.getAuth().getLoginToken(), securityScheme());
    };

    private SecurityRequirement securityRequirement(){
        return new SecurityRequirement()
                .addList(docProperties.getAuth().getLoginToken());
    };

    private SecurityScheme securityScheme(){
        return new SecurityScheme()
                .type(SecurityScheme.Type.HTTP)
                .scheme(docProperties.getAuth().getScheme())
                .bearerFormat(docProperties.getAuth().getBearerFormat())
                .in(SecurityScheme.In.HEADER)
                .name(docProperties.getAuth().getLoginToken());
    };
}
