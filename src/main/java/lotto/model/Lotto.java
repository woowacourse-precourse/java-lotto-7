package lotto.model;

import camp.nextstep.edu.missionutils.Console;
import lotto.exception.ExceptionMessage;
import lotto.exception.InputException;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

import static lotto.validate.Validator.validateWinning;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = numbers;
    }

    public Lotto(String line){
        validateWinning(line);
        this.numbers = lineToNumbers(line);
    }

    private void validate(List<Integer> numbers) {
        isDuplicated(numbers);
        hasLengthSix(numbers);
        isOutofRange(numbers);
    }

    private static void isDuplicated(List<Integer> numbers) {
        HashSet<Integer> set = new HashSet<>(numbers);
        if(set.size() != numbers.size()){
            throw new InputException(ExceptionMessage.DUPLICATED_NUMBER_ERROR);
        }
    }

    private static void hasLengthSix(List<Integer> numbers) {
        if (numbers.size() != 6) {
            throw new InputException(ExceptionMessage.INVALID_COUNT_ERROR);
        }
    }

    private static void isOutofRange(List<Integer> numbers){
        for (Integer number : numbers) {
            if(number < 1 || number > 45){
                throw new InputException(ExceptionMessage.NUMBER_RANGE_ERROR);
            }
        }
    }


    private static List<Integer> lineToNumbers(String line) {
        String[] splitLine = line.split(",");
        List<Integer> numbers = new ArrayList<>();
        for (String num : splitLine) {
            numbers.add(Integer.parseInt(num));
        }
        return numbers;
    }

    public List<Integer> getNumbers() {
        return numbers;
    }

}
