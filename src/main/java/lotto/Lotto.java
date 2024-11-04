package lotto;

import static lotto.LottoConstants.NUMBER_COUNT;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = numbers;
    }

    private void validate(List<Integer> numbers) {
        if (numbers.size() != NUMBER_COUNT) {
            String errorMessage = "[ERROR] 로또 번호는 " + NUMBER_COUNT + "개여야 합니다.";
            System.out.println(errorMessage); // 에러 메시지 출력
            throw new IllegalArgumentException(errorMessage);
        }

        Set<Integer> uniqueNumbers = new HashSet<>(numbers);
        if (uniqueNumbers.size() != numbers.size()) {
            String errorMessage = "[ERROR] 로또 번호에는 중복된 숫자가 있을 수 없습니다.";
            System.out.println(errorMessage); // 에러 메시지 출력
            throw new IllegalArgumentException(errorMessage);
        }
    }

    public List<Integer> getNumbers() {
        return numbers;
    }
}