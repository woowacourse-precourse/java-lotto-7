package lotto;

import static lotto.LottoConstant.MAX_VALUE;
import static lotto.LottoConstant.MIN_VALUE;
import static lotto.LottoConstant.NUMBER_COUNT;
import static lotto.LottoConstant.PRICE;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import lotto.error.ErrorMessage;

public class Validator {

    private static final int ZERO = 0;
    private static final int ONE = 1;

    public static void validatePurchaseAmount(long input) {
        if (input % PRICE != ZERO || input / PRICE < ONE) {
            throw new IllegalArgumentException(ErrorMessage.INVALID_AMOUNT_UNIT.format(PRICE));
        }
    }

    public static void validateWinningNumbers(List<Integer> drawNumbers) {
        validateNumberCount(drawNumbers, NUMBER_COUNT);
        validateUniqueNumbers(drawNumbers);
        drawNumbers.forEach(Validator::validateLottoNumber);
    }

    public static void validateLottoNumber(int number) {
        validateNumberRange(number, MIN_VALUE, MAX_VALUE);
    }


    public static void validateBonusNumber(int drawNumber, List<Integer> winningNumbers) {
        validateNumberRange(drawNumber, MIN_VALUE, MAX_VALUE);
        if (winningNumbers.contains(drawNumber)) {
            throw new IllegalArgumentException(ErrorMessage.DUPLICATED_BONUS_NUMBER.format());
        }
    }

    public static void validateNumberRange(int drawNumber, int min, int max) {
        if (min <= drawNumber && drawNumber <= max) {
            return;
        }
        throw new IllegalArgumentException(ErrorMessage.NUMBER_RANGE_ERROR.format(min, max));
    }

    public static void validateUniqueNumbers(List<Integer> numbers) {
        Set<Integer> uniqueNumbers = new HashSet<>(numbers);
        if (uniqueNumbers.size() != numbers.size()) {
            throw new IllegalArgumentException(ErrorMessage.DUPLICATED_NUMBER_ERROR.format());
        }
    }

    public static void validateNumberCount(List<Integer> numbers, int count){
        if (numbers.size() != count) {
            throw new IllegalArgumentException(ErrorMessage.NUMBER_COUNT_ERROR.format(count));
        }
    }

    public static void validateEmptyString(String input){
        if(input == null || input.isBlank()){
            throw new IllegalArgumentException(ErrorMessage.EMPTY_STRING_ERROR.format());
        }
    }
}
