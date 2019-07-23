package com.leyou.upload.config;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;

import java.util.List;

/**
 * @author SanRay
 * @date 2019-07-11 16:38
 */
@Data
@ConfigurationProperties(prefix = "ly.upload")
public class UploadProperties {
        private String baseUrl;
        private List<String> allowTypes;
}
