package lotto.model;

public class LottoNumberValidator {
    private static final String OUT_OF_RANGE_ERROR_MESSAGE = "[ERROR] 1부터 45 사이의 숫자만 입력해 주세요";
    private static final Integer MIN_NUMBER = 1;
    private static final Integer MAX_NUMBER = 45;

    public static void validateNumberRange(Integer number) {
        if (number < MIN_NUMBER || number > MAX_NUMBER) {
            throw new IllegalArgumentException(OUT_OF_RANGE_ERROR_MESSAGE);
        }
    }
}
