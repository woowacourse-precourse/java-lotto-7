package lotto.model;

import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        numbers = numbers.stream()
                .sorted()
                .collect(Collectors.toList());
        this.numbers = numbers;
    }

    private void validate(List<Integer> numbers) {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException("[ERROR] 로또 번호는 6개여야 합니다.");
        }
        validateEachNumber(numbers);
    }

    private void validateEachNumber(List<Integer> numbers) {
        Set<Integer> uniqueNumbers = new HashSet<>();
        for (int number : numbers) {
            if (!uniqueNumbers.add(number)) {
                throw new IllegalArgumentException("[ERROR] 중복되지 않은 숫자를 입력해주세요.");
            }
            if (number < 1 || number > 45) {
                throw new IllegalArgumentException("[ERROR] 1 이상 45 이하의 정수를 입력해주세요.");
            }
        }
    }

    public int checkMatchingAmountWith(List<Integer> numbers) {
        int matchingAmount = 0;
        for (int number : numbers) {
            if (numbers.contains(number)) {
                matchingAmount++;
            }
        }
        return matchingAmount;
    }



    public List<Integer> getNumbers() {
        return Collections.unmodifiableList(numbers);
    }
}
