package lotto.validate;

public class LottosValidate {

    public static boolean isValidRangeOfList(int index, int lottosTotalAmount) {
        if (index >= 0 && index < lottosTotalAmount) {
            return true;
        }

        return false;
    }
}
