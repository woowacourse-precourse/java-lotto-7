package lotto;

import java.util.Locale;
import java.util.ResourceBundle;

public class MessageManager {
    private static ResourceBundle messages;

    static {
        setLocale(Locale.KOREAN);
    }

    public static void setLocale(Locale locale) {
        messages = ResourceBundle.getBundle("messages", locale);
    }

    public static String get(String key) {
        return messages.getString(key);
    }

    public static String getError(String key) {
        return messages.getString("error.prefix") + messages.getString(key);
    }

    public static String getFormatted(String key, Object... args) {
        String message = messages.getString(key);
        return java.text.MessageFormat.format(message, args);
    }

    public static String getFormattedError(String key, Object... args) {
        String message = messages.getString("error.prefix") + messages.getString(key);
        return java.text.MessageFormat.format(message, args);
    }
}
