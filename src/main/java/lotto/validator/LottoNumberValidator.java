package lotto.validator;

public class LottoNumberValidator {

    private static final String ERROR_LOTTO_NUMBER_RANGE = "로또 번호는 1~45 사이여야 합니다.";
    private static final Integer MIN_LOTTO_NUMBER_RANGE = 1;
    private static final Integer MAX_LOTTO_NUMBER_RANGE = 45;

    public static void validate(int number){
        if(number < MIN_LOTTO_NUMBER_RANGE || number > MAX_LOTTO_NUMBER_RANGE) {
            throw new IllegalArgumentException(ERROR_LOTTO_NUMBER_RANGE);
        }
    }
}
