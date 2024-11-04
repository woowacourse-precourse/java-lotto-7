package lotto;

public class LottoUtils {
    public LottoUtils() {
    }

    public static Integer convertInputToCash(String input) {
        if (!isNumber(input)) {
            System.out.println(ErrorMessage.INVALID_INPUT_MESSAGE.getMessage());
            throw new IllegalArgumentException();
        }

        Integer cash = Integer.parseInt(input);

        if (cash % 1000 != 0) {
            System.out.println(ErrorMessage.INVALID_CASH_MESSAGE.getMessage());
            throw new IllegalArgumentException();
        }

        if (cash <= 0) {
            System.out.println(ErrorMessage.NO_CASH_MESSAGE.getMessage());
            throw new IllegalArgumentException();
        }

        Integer lottoAmount = cash / 1000;

        return lottoAmount;
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
