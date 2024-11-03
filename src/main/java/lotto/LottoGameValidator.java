package lotto;

public class LottoGameValidator {

    /**
     * 숫자로 구성된 문자열인지 확인
     *
     * @throws IllegalArgumentException 숫자가 아닌 문자가 문자열에 포함되어 있을 때
     */
    public static boolean checkIsNumeric(String str) {
        if (!Validator.isNumeric(str)) {
            throw new IllegalArgumentException(ErrorMessage.INPUT_MUST_NUMERIC.getMessage());
        }

        return true;
    }

    public static boolean checkMoneyValid(int money) {
        if (money < 0) {
            throw new IllegalArgumentException(ErrorMessage.MONEY_CAN_NOT_MINUS.getMessage());
        }
        if (!Validator.isDivided(money, Lotto.LOTTO_PRICE)) {
            throw new IllegalArgumentException(ErrorMessage.INSERT_MONEY_NOT_DIVIDED_1000.getMessage());
        }

        return true;
    }
}
