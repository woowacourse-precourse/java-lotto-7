package lotto;

public class LottoParser {

    private static final int MIN_LOTTO_NUMBER = 1;
    private static final int MAX_LOTTO_NUMBER = 45;
    private static final String NUMBER_ERROR_MESSAGE = "[ERROR] 1~45 사이의 수를 입력해주세요.";

    public static int parseNumber(String inputNumber) {
        try {
            int number = Integer.parseInt(inputNumber.trim());
            validateNumberRange(number);
            return number;
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(NUMBER_ERROR_MESSAGE);
        }
    }

    private static void validateNumberRange(int number) {
        if(number < MIN_LOTTO_NUMBER || number > MAX_LOTTO_NUMBER) {
            throw new IllegalArgumentException(NUMBER_ERROR_MESSAGE);
        }
    }
}
