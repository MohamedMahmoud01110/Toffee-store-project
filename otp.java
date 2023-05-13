package org.example;

import javax.mail.*;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.security.SecureRandom;
import java.util.Properties;
import java.util.Scanner;

public class otp
{
    private static final String OTP_CHARACTERS = "0123456789";
    private static final int OTP_LENGTH = 6; // length of the OTP

    // Email configuration parameters
    private static final String SMTP_HOST = "smtp.gmail.com";
    private static final int SMTP_PORT = 587;
    private static final String SMTP_USERNAME = "Maryamhmdbsam@gmail.com";
    private static final String SMTP_PASSWORD = "dazidxzddpidjscb";
    private static final String FROM_EMAIL_ADDRESS = "Maryamhmdbsam@gmail.com";

    public static String generateOTP() {
        StringBuilder s = new StringBuilder(OTP_LENGTH);
        SecureRandom random = new SecureRandom();
        for (int i = 0; i < OTP_LENGTH; i++)
        {
            int randomIndex = random.nextInt(OTP_CHARACTERS.length());
            s.append(OTP_CHARACTERS.charAt(randomIndex));
        }
        return s.toString();
    }

    public static void sendOTPByEmail(String toEmailAddress, String otp) {
        Properties properties = new Properties();
        properties.put("mail.smtp.host", SMTP_HOST);
        properties.put("mail.smtp.port", SMTP_PORT);
        properties.put("mail.smtp.auth", "true");
        properties.put("mail.smtp.starttls.enable", "true");

        Authenticator authenticator = new Authenticator() {
            @Override
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(SMTP_USERNAME, SMTP_PASSWORD);
            }
        };

        Session session = Session.getInstance(properties, authenticator);

        try {
            Message message = new MimeMessage(session);
            message.setFrom(new InternetAddress(FROM_EMAIL_ADDRESS));
            message.setRecipients(Message.RecipientType.TO, InternetAddress.parse(toEmailAddress));
            message.setSubject("Your OTP is " + otp);
            message.setText("Dear user,\n\nYour OTP is " + otp);

            Transport.send(message);
        } catch (MessagingException e) {
            e.printStackTrace();
        }
    }
    public static boolean verifyOtp( String generatedOtp)
    {
        String op ;
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the otp :\n");
        op = sc.nextLine();
        return op.equals(generatedOtp);
    }
}
