package lotto.model;

import camp.nextstep.edu.missionutils.Console;
import lotto.exception.ExceptionMessage;
import lotto.exception.InputException;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

import static lotto.validate.Validator.validateWinning;

public class Lotto {
    private List<Number> numbers;

    public Lotto(List<Integer> numbers) {
        this.numbers = new ArrayList<>();
        for (Integer number : numbers) {
            this.numbers.add(new Number(number));
        }
        Validator.validate(this.numbers);
    }


    private static class Validator{
        static void validate(List<Number> numbers) {
            isDuplicated(numbers);
            hasLengthSix(numbers);
        }

        private static void isDuplicated(List<Number> numbers) {
            HashSet<Number> set = new HashSet<>(numbers);
            if(set.size() != numbers.size()){
                throw new InputException(ExceptionMessage.DUPLICATED_NUMBER_ERROR);
            }
        }

        private static void hasLengthSix(List<Number> numbers) {
            if (numbers.size() != 6) {
                throw new InputException(ExceptionMessage.INVALID_COUNT_ERROR);
            }
        }
    }

    public List<Number> getNumbers() {
        return numbers;
    }

}
