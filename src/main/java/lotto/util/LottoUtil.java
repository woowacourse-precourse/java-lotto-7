package lotto.util;

public class LottoUtil {
    public static String prettyPrint(int value) {
        String formattedPart = "";
        if ( value > 1000 ) {
            formattedPart = prettyPrint(value / 1000);
            value %= 1000;
            formattedPart += ",";
        }

        String formattingPart = Integer.toString(value);
        if (!formattedPart.isEmpty()) {
            if (formattingPart.length() < 2) formattingPart = "0" + formattingPart;
            if (formattingPart.length() < 3) formattingPart = "0" + formattingPart;
        }
        return formattedPart + formattingPart;
    }
}
