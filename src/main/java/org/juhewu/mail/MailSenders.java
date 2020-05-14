package org.juhewu.mail;

import org.springframework.mail.javamail.JavaMailSender;

/**
 * 邮件发送器
 *
 * @author duanjw
 */
public interface MailSenders {
    JavaMailSender get(String key);
}
