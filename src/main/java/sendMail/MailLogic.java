package sendMail;

import java.util.*;
import javax.mail.*;
import javax.mail.internet.*;

public class MailLogic {


     private static String USER_NAME;
     private static String PASSWORD;
     private static String RECIPIENT;
     private static String SUBJECT;
     private static String MESSAGE;

    public static String getSUBJECT() {
        return SUBJECT;
    }

    public static void setSUBJECT(String SUBJECT) {
        MailLogic.SUBJECT = SUBJECT;
    }

    public static String getMESSAGE() {
        return MESSAGE;
    }

    public static void setMESSAGE(String MESSAGE) {
        MailLogic.MESSAGE = MESSAGE;
    }

    public static String getUSER_NAME() {
        return USER_NAME;
    }

    public static void setUSER_NAME(String USER_NAME) {
        MailLogic.USER_NAME = USER_NAME;
    }

    public static String getPASSWORD() {
        return PASSWORD;
    }

    public static void setPASSWORD(String PASSWORD) {
        MailLogic.PASSWORD = PASSWORD;
    }

    public static String getRECIPIENT() {
        return RECIPIENT;
    }

    public static void setRECIPIENT(String RECIPIENT) {
        MailLogic.RECIPIENT = RECIPIENT;
    }


    static void sendFromGMail(String from, String pass, String[] to, String subject, String body) {
        Properties props = System.getProperties();
        String host = "smtp.gmail.com";
        props.put("mail.smtp.starttls.enable", "true");
        props.put("mail.smtp.ssl.trust", "smtp.gmail.com"); // Zbog ovog nije htjelo raditi
        props.put("mail.smtp.host", host);
        props.put("mail.smtp.user", from);
        props.put("mail.smtp.password", pass);
        props.put("mail.smtp.port", "587");
        props.put("mail.smtp.auth", "true");

        Session session = Session.getDefaultInstance(props);
        MimeMessage message = new MimeMessage(session);

        try {
            message.setFrom(new InternetAddress(from));
            InternetAddress[] toAddress = new InternetAddress[to.length];

            // To get the array of addresses
            for( int i = 0; i < to.length; i++ ) {
                toAddress[i] = new InternetAddress(to[i]);
            }

            for( int i = 0; i < toAddress.length; i++) {
                message.addRecipient(Message.RecipientType.TO, toAddress[i]);
            }

            message.setSubject(subject);
            message.setText(body);
            Transport transport = session.getTransport("smtp");
            transport.connect(host, from, pass);
            transport.sendMessage(message, message.getAllRecipients());
            transport.close();
        }
        catch (AddressException ae) {
            ae.printStackTrace();
        }
        catch (MessagingException me) {
            me.printStackTrace();
        }
    }
}