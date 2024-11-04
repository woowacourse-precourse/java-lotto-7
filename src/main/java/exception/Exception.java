package exception;

import static lotto.Lotto.LOTTO_PRICE;

public class Exception extends Throwable {

    public static final String ERROR_PREFIX = "[ERROR] ";
    private static final String ONLY_NUMBER = "숫자만 입력해주세요";
    private static final String NUMBER_TOO_BIG = "숫자가 너무 큽니다.";
    private static final String MINIMUM_PURCHASE_AMOUNT = LOTTO_PRICE + "원부터 구매 가능합니다.";
    public static final String INPUT_UNITS = LOTTO_PRICE + "단위로 입력해주세요(숫자로만 입력해주세요)";
    public static final String BONUS_INPUT = "보너스번호는 1~45 이내 숫자 중 1개만 입력해주세요";
    public static final String BONUS_NOT_EXIST_WINNING_NUMBER = "보너스 번호는 당첨번호에 포함이 안된 숫자여야 합니다";
    public static final String LOTTO_LENGTH_ONLY_SIX = "로또 번호는 6개여야 합니다.";
    public static final String DUPLICATE_NUMBER = "중복된 숫자를 입력할 수 없습니다.";
    public static final String ONLY_ONE_TO_FORTY_FIVE = "로또번호는 1~45만 가능합니다";
    private static final String ONLY_NUMBER_REGEX = "\\d+";

    public void throwException(String errorMessage) {
        throw new IllegalArgumentException(ERROR_PREFIX + errorMessage);
    }

    public long changeInputStrToNumber(String number) {
        if (!number.matches(ONLY_NUMBER_REGEX)) {
            throwException(ONLY_NUMBER);
        }
        long buyPrice = 0;
        try {
            buyPrice = Long.parseLong(number);
        } catch (NumberFormatException e) {
            throwException(NUMBER_TOO_BIG);
        }
        return buyPrice;
    }

    public long verifyBuyPrice(String buyPriceInput) {
        long buyPrice = changeInputStrToNumber(buyPriceInput);
        if (buyPrice == 0) {
            throwException(MINIMUM_PURCHASE_AMOUNT);
        }
        if (buyPrice % LOTTO_PRICE != 0) {
            throwException(INPUT_UNITS);
        }
        return buyPrice;
    }

    public int verifyBonusNumber(String bonusNumber) {
        long buyPrice = changeInputStrToNumber(bonusNumber);
        if (buyPrice < 1 || buyPrice > 45) {
            throwException(BONUS_INPUT);
        }
        return (int) buyPrice;
    }

}
