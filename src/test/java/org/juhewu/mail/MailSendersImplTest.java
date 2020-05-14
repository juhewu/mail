package org.juhewu.mail;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Slf4j
@DisplayName("邮件账户测试")
class MailSendersImplTest {
    @Test
    @DisplayName("测试邮件账户初始化、发送器性能")
    public void send() {
//        Scanner s = new Scanner(System.in);
//        s.nextInt();
        long time4 = System.currentTimeMillis();
        List<MailAccount> mailAccounts = new ArrayList<>();
        int size = 1000;
        for (int i = 0; i < size; i++) {
            MailAccount mailAccount = new MailAccount().setId(i + "").setHost("smtp.163.com").setUsername("18630070626").setPassword("CBTAWAUHZZXLVQLJ");
            mailAccounts.add(mailAccount);
        }
        MailAccountRepository mailAccountRepository = new InMemoryMailAccountRepository();
        mailAccountRepository.add(mailAccounts);

        // 统一入口
        MailAccountLocator mailAccountLocator = new CompositeMailAccountLocator(Arrays.asList(mailAccountRepository));
        MailSenders mailSenders = new MailSendersImpl(mailAccountLocator);

        long time5 = System.currentTimeMillis();
        log.info("初始{}个化账户用时：{}", size, time5 - time4);
        for (int i = 0; i < size; i++) {
            long time1 = System.currentTimeMillis();
            JavaMailSender javaMailSender = mailSenders.get(i + "");
            long time2 = System.currentTimeMillis();
            SimpleMailMessage message = new SimpleMailMessage();

            message.setFrom("18630070626@163.com");

            message.setTo("554343346@qq.com");

            message.setSubject("it is a test for spring boot");
            message.setText("你好，我是小黄，我正在测试发送邮件。");
            javaMailSender.createMimeMessage();
//            javaMailSender.send(message);
            long time3 = System.currentTimeMillis();

//            log.info("创建发送器{}用时：{}",javaMailSender, time2-time1);
//            log.info("发送短信用时：{}", time3-time2);
        }
        long time6 = System.currentTimeMillis();
        log.info("初始化{}个javaMailSenders用时：{}", size, time6 - time5);
//        s = new Scanner(System.in);
//        s.nextInt();
    }
}