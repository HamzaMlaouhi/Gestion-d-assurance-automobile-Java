package Courtier;

import java.util.Properties;
import javax.mail.Message;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

/**
 *
 * @author Mohamed
 */
public class MailAPI {

    public void send(String mail) {

        String myEmail = "mohammed.benabbes@esprit.tn";
        String password = "183JMT0321";
        String opponentEmail = mail;
        Properties pro = new Properties();
        pro.put("mail.smtp.host", "smtp.gmail.com");
        pro.put("mail.smtp.starttls.enable", "true");
        pro.put("mail.smtp.auth", "true");
        pro.put("mail.smtp.port", "587");
        Session ss = Session.getInstance(pro, new javax.mail.Authenticator() {
            @Override
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(myEmail, password);
            }
        });
        try {
            Message msg = new MimeMessage(ss);
            msg.setFrom(new InternetAddress(myEmail));
            msg.setRecipients(Message.RecipientType.TO, InternetAddress.parse(opponentEmail));
            msg.setSubject("Creation Police");
            msg.setText("Police creer");
            Transport trans = ss.getTransport("smtp");
            trans.send(msg);
            System.out.println("message sent !! ");
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    //Test Mailing API !! 
//      public static void main(String[] args) {
//         AdminMailer send = new AdminMailer();
//         String mail = "mahmoud.omrani@esprit.tn";
//            send.send(mail);
//    }  
}
