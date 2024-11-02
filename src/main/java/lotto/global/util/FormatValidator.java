package lotto.global.util;

public class FormatValidator {
    private static final String PRICE_FORMAT = "^[1-9]+[0-9]*000$";
    private static final String WINNING_NUMBER_FORMAT = "^[0-9,]+$";
    private static final String BONUS_NUMBER_FORMAT = "^[0-9]+$";
    private static FormatValidator instance;
    public static FormatValidator getInstance() {
        if (instance == null) {
            instance = new FormatValidator();
        }
        return instance;
    }
    public void validatePriceFormat(String price) {
        if (!price.matches(PRICE_FORMAT)) {
            throw new IllegalArgumentException("[ERROR] 구입금액이 1000의 배수가 아닙니다.");
        }
    }
    public void validateWinningNumberFormat(String numbers) {
        if (!numbers.matches(WINNING_NUMBER_FORMAT)) {
            throw new IllegalArgumentException("[ERROR] 당첨 번호 입력은 쉼표와 숫자만으로 이루어져야 합니다.");
        }
    }

    public void validateBonusNumberFormat(String number) {
        if (!number.matches(BONUS_NUMBER_FORMAT)) {
            throw new IllegalArgumentException("[ERROR] 보너스 번호 입력은 숫자만으로 이루어져야 합니다.");
        }
    }
}
