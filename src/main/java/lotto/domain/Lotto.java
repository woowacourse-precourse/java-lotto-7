package lotto.domain;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import lotto.util.message.ErrorMessage;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        validateUniqueNumbers(numbers);
        this.numbers = new ArrayList<>(numbers);
    }

    public void displayNumbers() {
        sortNumbers();
        System.out.println(String.join(", ", Arrays.toString(numbers.toArray())));
    }

    public List<Integer> getNumbers() {
        return numbers;
    }

    private void validate(List<Integer> numbers) {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException("[ERROR] 로또 번호는 6개여야 합니다.");
        }
    }

    private void validateUniqueNumbers(List<Integer> numbers) {
        if (numbers.size() != numbers.stream().distinct().count()) {
            throw new IllegalArgumentException(ErrorMessage.DUPLICATE_NUMBER_ERROR);
        }
    }

    private void sortNumbers() {
        Collections.sort(numbers);
    }
}
