package utils;

	import java.util.Properties;
	import java.util.regex.Matcher;
	import java.util.regex.Pattern;

	import jakarta.mail.*;

	public class MailOTP {

	    public static String getOTP(String email, String appPassword) {

	        try {
	            // Gmail IMAP settings
	            Properties properties = new Properties();
	            properties.put("mail.store.protocol", "imaps");
	            properties.put("mail.imaps.host", "imap.gmail.com");
	            properties.put("mail.imaps.port", "993");
	            properties.put("mail.imaps.ssl.enable", "true");

	            // Login to Gmail
	            Session session = Session.getInstance(properties);

	            Store store = session.getStore("imaps");
	            store.connect("imap.gmail.com", email, appPassword);

	            // Open Inbox
	            Folder inbox = store.getFolder("INBOX");
	            inbox.open(Folder.READ_ONLY);

	            // Get emails
	            Message[] messages = inbox.getMessages();

	            // Start from the newest email
	            for (int i = messages.length - 1; i >= 0; i--) {

	                Message message = messages[i];

	                String content = getTextFromMessage(message);

	                // Look for a 6-digit OTP
	                Pattern pattern = Pattern.compile("\\b\\d{6}\\b");
	                Matcher matcher = pattern.matcher(content);

	                if (matcher.find()) {

	                    String otp = matcher.group();

	                    inbox.close(false);
	                    store.close();

	                    return otp;
	                }
	            }

	            inbox.close(false);
	            store.close();

	        } catch (Exception e) {
	            e.printStackTrace();
	        }

	        return null;
	    }

	    private static String getTextFromMessage(Message message) throws Exception {

	        Object content = message.getContent();

	        if (content instanceof String) {
	            return (String) content;
	        }

	        if (content instanceof Multipart) {

	            Multipart multipart = (Multipart) content;

	            for (int i = 0; i < multipart.getCount(); i++) {

	                BodyPart bodyPart = multipart.getBodyPart(i);

	                if (bodyPart.isMimeType("text/plain")) {
	                    return bodyPart.getContent().toString();
	                }
	            }
	        }

	        return "";
	    }
	
}
