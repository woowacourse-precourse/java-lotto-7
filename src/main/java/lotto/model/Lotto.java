package lotto.model;

import camp.nextstep.edu.missionutils.Console;
import lotto.exception.ExceptionMessage;
import lotto.exception.InputException;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.stream.Collectors;


public class Lotto {
    private final List<Number> numbers;

    public Lotto(List<Integer> integers) {
        numbers = integers.stream()
                .map(Number::new)
                .collect(Collectors.toList());
        Validator.validate(numbers);
    }

    public boolean contains(Number o){
        return numbers.contains(o);
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
