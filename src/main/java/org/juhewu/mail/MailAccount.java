package org.juhewu.mail;

import lombok.Data;
import lombok.experimental.Accessors;

import java.io.Serializable;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;

/**
 * 邮箱账户
 *
 * @author duanjw
 */
@Data
@Accessors(chain = true)
public class MailAccount implements Serializable {
    private static final Charset DEFAULT_CHARSET;
    public MailAccount() {
        this.defaultEncoding = DEFAULT_CHARSET;
        this.properties = new HashMap();
    }
    /**
     * 主键
     */
    private String id;
    /**
     * 创建时间
     */
    private LocalDateTime createTime;
    /**
     * 更新时间
     */
    private LocalDateTime updateTime;
    /**
     * 租户id
     */
    private Long tenantId;


    /**
     * SMTP服务器域名
     */
    private String host;
    /**
     * SMTP服务端口
     */
    private Integer port;
    /**
     * 用户名
     */
    private String username;
    /**
     * 密码
     */
    private String password;

    private String protocol;
    private Charset defaultEncoding;
    private Map<String, String> properties;

    static {
        DEFAULT_CHARSET = StandardCharsets.UTF_8;
    }
}
