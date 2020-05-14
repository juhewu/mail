package org.juhewu.mail.sender;

import lombok.extern.slf4j.Slf4j;
import org.juhewu.mail.MailAccount;

/**
 * @author duanjw
 */
@Slf4j
public class MailSenderImpl implements MailSender {
    @Override
    public void send(MailAccount mailAccount) {
        if (log.isDebugEnabled()) {
            log.debug("邮件账户：{}发送邮件", mailAccount);
        }
    }
}
