package lotto.util.validator;

import lotto.util.constant.LottoConstants;

import java.util.List;

public class LottoValidator {

    private static final String ERR_MSG_WRONG_WINNER_NUMBERS = "[ERROR] 로또 당첨 번호는 1부터 45 사이의 6개의 숫자여야 합니다.";

    public static void validateLottoHasSixNumbers(List<Integer> numbers){
        if (numbers.size() != LottoConstants.LOTTO_NUM_COUNT) {
            throw new IllegalArgumentException(ERR_MSG_WRONG_WINNER_NUMBERS);
        }
    }

    public static void validateLottoNumberIsValid(List<Integer> numbers) {
        for (int number : numbers) {
            if (number < LottoConstants.LOTTO_MIN_NUMBER || number > LottoConstants.LOTTO_MAX_NUMBER) {
                throw new IllegalArgumentException(ERR_MSG_WRONG_WINNER_NUMBERS);
            }
        }
    }
}
