package lotto;

public class LottoMachine {

    public static final String AMOUNT_ERROR_MSG = "[ERROR] 구입 금액은 1000(원) 단위의 숫자입니다. 예: 14000";
    public static final int LOTTO_PRICE = 1000;

    public int parseAmount(String input) {
        int amount = 0;

        try {
            amount = Integer.parseInt(input);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(AMOUNT_ERROR_MSG);
        }

        if (amount < 0 || amount % LOTTO_PRICE != 0) {
            throw new IllegalArgumentException(AMOUNT_ERROR_MSG);
        }

        return amount;
    }
}
