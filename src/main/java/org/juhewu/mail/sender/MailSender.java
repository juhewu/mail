package org.juhewu.mail.sender;

import org.juhewu.mail.MailAccount;
import org.springframework.mail.MailException;
import org.springframework.mail.javamail.MimeMessagePreparator;

import javax.mail.internet.MimeMessage;

/**
 * 邮件发送器
 *
 * @author duanjw
 */
public interface MailSender {

    /**
     * 发送邮件
     *
     * @param mailAccount
     */
    void send(MailAccount mailAccount);
//
//    /**
//     * @param mailAccount
//     * @param mimeMessagePreparator
//     * @throws MailException
//     */
//    void send(MailAccount mailAccount, MimeMessagePreparator mimeMessagePreparator) throws MailException;
}
