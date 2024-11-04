package lotto;

public class LottoUtils {
    public LottoUtils() {
    }

    public static Boolean isNumber(String input) {
        try {
            Integer.parseInt(input);
        } catch (Exception e) {
            return false;
        }

        return true;
    }
}
