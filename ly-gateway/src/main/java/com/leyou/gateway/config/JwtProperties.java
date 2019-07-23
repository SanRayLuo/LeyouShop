package com.leyou.gateway.config;

import com.leyou.auth.utils.RsaUtils;
import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;

import javax.annotation.PostConstruct;
import java.io.File;
import java.security.PrivateKey;
import java.security.PublicKey;

/**
 * @author SanRay
 * @date 2019-07-22 14:52
 */
@Data
@ConfigurationProperties(prefix = "ly.jwt")
public class JwtProperties {
    private String cookieName;

    private String pubKeyPath;

    private PublicKey publicKey; // 公钥

    // 对象实例化读取公钥和私钥
    @PostConstruct
    public void init() throws Exception {
            // 公钥私钥不存在,先生成
        File pubPath = new File(pubKeyPath);
        // 读取公钥私钥
        this.publicKey= RsaUtils.getPublicKey(pubKeyPath);
    }
}
