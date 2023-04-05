package com.rbtxm.doc.config;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

import java.util.Map;

/**
 * @Author: guanxiangkai
 * @Description:
 * @Data: 2023年04月04日 周二 11时01分49秒
 **/
@Data
@Component
@ConfigurationProperties(prefix = "spring.doc")
public class DocProperties {

    private String url;
    private String description;
    private AuthProperty auth;
    private InfoProperty info;
    private ServersProperty servers;
    private TagsProperty tags;


    @Data
    public static class AuthProperty {
        private String loginToken;
        private String scheme;
        private String bearerFormat;
    }

    @Data
    public static class InfoProperty {
        private String title;
        private String version;
        private String description;
    }

    @Data
    public static class ServersProperty {
        private Map<String, ServerProperty> serverPropertyMap;
    }

    @Data
    public static class ServerProperty {
        private String path;
        private String group;
        private String description;
    }

    @Data
    public static class TagsProperty {
        private Map<String, TagProperty> tagPropertyMap;
    }

    @Data
    public static class TagProperty {
        private String name;
        private String description;
    }
}
