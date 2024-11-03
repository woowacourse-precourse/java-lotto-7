package lotto.domain;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import static lotto.constants.ErrorMessage.DUPLICATE_LOTTO_NUMBER;
import static lotto.constants.ErrorMessage.INVALID_LOTTO_NUMBER_COUNT;

public class LottoValidator {

    public static void validate(List<Integer> numbers){
        numbersSizeCheck(numbers);
        numbersDuplicateCheck(numbers);
    }

    private static void numbersDuplicateCheck(List<Integer> numbers) {
        if(validateNonDuplicate(numbers)){
            throw new IllegalArgumentException(DUPLICATE_LOTTO_NUMBER.getErrorMessage());
        }
    }
    private static void numbersSizeCheck(List<Integer> numbers) {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException(INVALID_LOTTO_NUMBER_COUNT.getErrorMessage());
        }
    }
    private static boolean validateNonDuplicate(List<Integer> numbers){
        Set<Integer> distinctNumbers = Set.copyOf(numbers);

        if(distinctNumbers.size() != numbers.size()){
            return true;
        }
        return false;
    }

    public static void isDuplicateLottoAndBonus(CustomLotto customLotto){
        List<Integer> numbers = new ArrayList<>(customLotto.getNumbers());
        numbers.add(customLotto.getBonus());
        List<Integer> numbersPlusBonus = numbers.stream().distinct().toList();

        if(numbersPlusBonus.size()!=7){
            throw new IllegalArgumentException(DUPLICATE_LOTTO_NUMBER.getErrorMessage());
        }
    }
}
