package org.juhewu.mail;

import java.util.List;

/**
 * 邮箱账户定位器
 *
 * @author duanjw
 */
public interface MailAccountLocator {
    /**
     * 所有邮箱账户
     *
     * @return
     */
    List<MailAccount> getMailAccounts();

    /**
     * 根据邮箱账户id获取邮箱账户
     * @param id
     * @return
     */
    MailAccount getMailAccount(String id);
}
