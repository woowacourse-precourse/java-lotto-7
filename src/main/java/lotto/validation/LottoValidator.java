package lotto.validation;

import lotto.Constant;
import lotto.exception.ExceptionMessage;

import java.util.List;

public class LottoValidator {

    public static void checkValidCashAmount(int amount) {
        //음수값 체크
        if (amount < 0) {
            throw new IllegalArgumentException(ExceptionMessage.NEGATIVE_INPUT.getMessage());
        }
        //1000 단위인지 체크
        if(amount % Constant.LOTTO_PRICE != 0) {
            throw new IllegalArgumentException(ExceptionMessage.THOUSAND_UNIT_ONLY.getMessage());
        }
    }

    public static void checkNumberInRange(Integer number) {
        if(number < Constant.MINIMUM_LOTTO_NUMBER || number > Constant.MAXIMUM_LOTTO_NUMBER) {
            throw new IllegalArgumentException(ExceptionMessage.INVALID_LOTTO_NUMBER.getMessage());
        }
    }

    public static void checkLottoSize(List<?> list) {
        if(list.size() != Constant.LOTTO_SIZE) {
            throw new IllegalArgumentException(ExceptionMessage.INVALID_LOTTO_SIZE.getMessage());
        }
    }

    public static void checkUniqueNumber(List<Integer> numbers) {
        if(numbers.size() != numbers.stream().distinct().count()) {
            throw new IllegalArgumentException(ExceptionMessage.DUPLICATE_LOTTO_NUMBER.getMessage());
        }
    }
}
