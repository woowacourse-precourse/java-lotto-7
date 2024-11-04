package Model;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Lotto {
    public static final Integer NUMBERS_LENGTH = 6;
    public static final Integer NUMBER_MIN = 1;
    public static final Integer NUMBER_MAX = 45;
    public static final String ERROR_MESSAGE = "[ERROR]";
    private final List<Integer> numbers;
    public enum NumberType {
        BASIC_NUMBER, BONUS_NUMBER;
    }
    public Lotto(List<Integer> numbers) {
        validateSize(numbers);
        validateDuplicate(numbers);
        validateNumbersRange(numbers);
        this.numbers = numbers;

    }

    @Override
    public String toString() {
        return numbers.toString();
    }

    public List<Integer> getNumbers() {
        return numbers;
    }

    private void validateSingleNumberRange(Integer number, NumberType numberType) {
        if((number < NUMBER_MIN) || (number > NUMBER_MAX)) {
            throw new IllegalArgumentException(ERROR_MESSAGE);
        }
    }

    private void validBonusNumberDuplicate(Integer number, NumberType numberType) {
        if(numbers.contains(number)) {
            throw new IllegalArgumentException(String.format("%s %s %d 가 중복으로 포함되었습니다.", ERROR_MESSAGE, numberType, number));
        }
    }

    public void validBonusNumber(Integer bonusNumber) {
        validateSingleNumberRange(bonusNumber, NumberType.BONUS_NUMBER);
        validBonusNumberDuplicate(bonusNumber, NumberType.BONUS_NUMBER);
    }

    private void validateSize(List<Integer> numbers) {
        if(numbers.size() != NUMBERS_LENGTH) {
            throw new IllegalArgumentException(String.format("%s %s 는 %d개 이여야 합니다.", ERROR_MESSAGE, NumberType.BASIC_NUMBER, NUMBERS_LENGTH));
        }
    }

    private void validateNumbersRange(List<Integer> numbers) {
        for(Integer n : numbers) {
            validateSingleNumberRange(n, NumberType.BASIC_NUMBER);
        }
    }

    private void validateDuplicate(List<Integer> numbers) {
        Set<Integer> uniqueNumbers = new HashSet<>();
        for (Integer n : numbers) {
            if (!uniqueNumbers.add(n)) {
                throw new IllegalArgumentException(String.format("%s %s %d가 중복으로 포함되었습니다.", ERROR_MESSAGE, NumberType.BASIC_NUMBER, n));
            }
        }
    }
}