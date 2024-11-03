package lotto.util.validator;

import lotto.util.constant.LottoConstants;

import java.util.HashMap;
import java.util.List;

public class LottoValidator {

    private static final String ERR_MSG_WRONG_VALUE_WINNER_NUMBERS = "[ERROR] 로또 당첨 번호는 1부터 45 사이의 숫자로 구성되어야 합니다.";
    private static final String ERR_MSG_WRONG_NUMBER_WINNER_NUMBERS = "[ERROR] 로또 당첨 번호는 6개의 숫자로 구성되어야 합니다.";
    private static final String ERR_MSG_DUPLICATE_WINNER_NUMBERS = "[ERROR] 로또 당첨 번호는 중복될 수 없습니다.";

    public static void validateNewLottoNumber(List<Integer> numbers){
        validateLottoHasSixNumbers(numbers);
        validateLottoNumberIsValid(numbers);
        validateLottoNumberIsDuplicate(numbers);
    }

    static void validateLottoHasSixNumbers(List<Integer> numbers){
        if (numbers.size() != LottoConstants.LOTTO_NUM_COUNT) {
            throw new IllegalArgumentException(ERR_MSG_WRONG_NUMBER_WINNER_NUMBERS);
        }
    }

    static void validateLottoNumberIsValid(List<Integer> numbers) {
        for (int number : numbers) {
            if (number < LottoConstants.LOTTO_MIN_NUMBER || number > LottoConstants.LOTTO_MAX_NUMBER) {
                throw new IllegalArgumentException(ERR_MSG_WRONG_VALUE_WINNER_NUMBERS);
            }
        }
    }

    static void validateLottoNumberIsDuplicate(List<Integer> numbers){
        HashMap<Integer, Integer> hashNumber = new HashMap<>();
        for (int number : numbers) {
            if(hashNumber.containsKey(number)){
                throw new IllegalArgumentException(ERR_MSG_DUPLICATE_WINNER_NUMBERS);
            }
            hashNumber.put(number, 0);
        }
    }
}
