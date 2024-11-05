package lotto.util;

import java.util.Locale;
import java.util.ResourceBundle;

public class MessageSource {

    private static final ResourceBundle messages = ResourceBundle.getBundle("messages", Locale.KOREA);

    public static String getMessage(String code) {
        return messages.getString(code);
    }
}
