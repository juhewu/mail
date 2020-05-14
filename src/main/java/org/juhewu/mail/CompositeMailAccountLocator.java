package org.juhewu.mail;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

/**
 * 聚合邮箱账户，获取邮箱账户从此获取
 *
 * @author duanjw
 */
public class CompositeMailAccountLocator implements MailAccountLocator {
    private final List<MailAccountLocator> mailAccountLocators;

    public CompositeMailAccountLocator(List<MailAccountLocator> mailAccountLocators) {
        this.mailAccountLocators = mailAccountLocators;
    }

    /**
     * 所有邮箱账户
     *
     * @return^
     */
    @Override
    public List<MailAccount> getMailAccounts() {
        return mailAccountLocators.stream().flatMap(item -> item.getMailAccounts().stream()).collect(Collectors.toList());
    }

    /**
     * 根据邮箱账户id获取邮箱账户
     *
     * @param id
     * @return
     */
    @Override
    public MailAccount getMailAccount(String id) {
        return mailAccountLocators.stream().map(item -> item.getMailAccount(id)).filter(Objects::nonNull).findFirst().orElseThrow(NullPointerException::new);
    }
}
