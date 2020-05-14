package org.juhewu.mail;

import lombok.AllArgsConstructor;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.JavaMailSenderImpl;

import java.util.Map;
import java.util.Optional;
import java.util.Properties;

/**
 * 邮件发送器
 *
 * @author duanjw
 */
@AllArgsConstructor
public class MailSendersImpl implements MailSenders {
    private MailAccountLocator mailAccountLocator;

    @Override
    public JavaMailSender get(String key) {
        JavaMailSenderImpl sender = new JavaMailSenderImpl();
        MailAccount mailAccount = Optional.ofNullable(mailAccountLocator.getMailAccount(key)).orElseThrow(MailAccountNotFoundException::new);
        this.applyProperties(mailAccount, sender);
        return sender;
    }
    private void applyProperties(MailAccount mailAccount, JavaMailSenderImpl sender) {
        sender.setHost(mailAccount.getHost());
        if (mailAccount.getPort() != null) {
            sender.setPort(mailAccount.getPort());
        }

        sender.setUsername(mailAccount.getUsername());
        sender.setPassword(mailAccount.getPassword());
        sender.setProtocol(mailAccount.getProtocol());
        if (mailAccount.getDefaultEncoding() != null) {
            sender.setDefaultEncoding(mailAccount.getDefaultEncoding().name());
        }

        if (!mailAccount.getProperties().isEmpty()) {
            sender.setJavaMailProperties(this.asProperties(mailAccount.getProperties()));
        }

    }

    private Properties asProperties(Map<String, String> source) {
        Properties properties = new Properties();
        properties.putAll(source);
        return properties;
    }
}
