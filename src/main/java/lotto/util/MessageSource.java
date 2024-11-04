package lotto.util;

import java.util.Locale;
import java.util.ResourceBundle;

public class MessageSource {

    private static final ResourceBundle messages = ResourceBundle.getBundle("messages", Locale.getDefault());

    public static String getMessage(String key) {
        return messages.getString(key);
    }
}
