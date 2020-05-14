package org.juhewu.mail;

import java.util.List;

/**
 * 邮箱账户修改
 *
 * @author duanjw
 */
public interface MailAccountWriter {
    /**
     * 新增邮箱账户
     * @param mailAccount
     */
    void add(MailAccount mailAccount);
    /**
     * 批量新增邮箱账户
     * @param mailAccounts
     */
    void add(List<MailAccount> mailAccounts);

    /**
     * 根据id删除邮箱账户
     * @param id
     */
    void delete(String id);

    /**
     * 批量删除邮箱账户
     * @param ids
     */
    void delete(List<String> ids);
}
