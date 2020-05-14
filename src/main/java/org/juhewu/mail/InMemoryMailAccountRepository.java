package org.juhewu.mail;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

import static java.util.Collections.synchronizedMap;

/**
 * 内存中的邮箱账户
 *
 * @author duanjw
 */
public class InMemoryMailAccountRepository implements MailAccountRepository {
    private final Map<String, MailAccount> mailAccounts = synchronizedMap(
            new LinkedHashMap());

    /**
     * 内存中的所有邮箱账户
     * @return
     */
    @Override
    public List<MailAccount> getMailAccounts() {
        return new ArrayList<>(mailAccounts.values());
    }

    /**
     * 根据邮箱账户id获取邮箱账户
     * @param id
     * @return
     */
    @Override
    public MailAccount getMailAccount(String id) {
        return mailAccounts.get(id);
    }

    /**
     * 新增邮箱账户
     * @param mailAccount
     */
    @Override
    public void add(MailAccount mailAccount) {
        mailAccounts.put(mailAccount.getId(), mailAccount);
    }

    /**
     * 批量新增邮箱账户
     * @param mailAccounts
     */
    @Override
    public void add(List<MailAccount> mailAccounts) {
        this.mailAccounts.putAll(mailAccounts.stream().collect(Collectors.toMap(MailAccount::getId, Function.identity())));
    }

    /**
     * 根据id删除邮箱账户
     * @param id
     */
    @Override
    public void delete(String id) {
        mailAccounts.remove(id);
    }

    /**
     * 批量删除邮箱账户
     * @param ids
     */
    @Override
    public void delete(List<String> ids) {
        for (String id : ids) {
            this.delete(id);
        }
    }
}
