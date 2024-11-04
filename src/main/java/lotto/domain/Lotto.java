package lotto.domain;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import lotto.validator.NumberValidate;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        Collections.sort(numbers);
        this.numbers = numbers;
    }

    private void validate(List<Integer> numbers) {
        NumberValidate.isduplicated(numbers);
        for(int number : numbers){
            NumberValidate.isSizeSix(numbers);
            NumberValidate.isOutOfRange(numbers);
        }
    }

    public void printNumber() {
        System.out.println(Arrays.toString(numbers.toArray()));
    }

    public List<Integer> getNumbers() {
        return numbers;
    }
}
