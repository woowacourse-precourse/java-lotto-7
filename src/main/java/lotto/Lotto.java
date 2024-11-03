package lotto;

import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class Lotto {
    private final List<Integer> numbers;
    private static final String REQUEST_NUMBER_MESSAGE = "당첨 번호를 입력해 주세요.";

    public Lotto(List<Integer> numbers) {
        isCountEqualsToSix(numbers);
        isDuplicationExist(numbers);
        isRangeValid(numbers);
        this.numbers = numbers;
    }

    private void isCountEqualsToSix(List<Integer> numbers) {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException("[ERROR] 로또 번호는 6개여야 합니다.");
        }
    }

    private void isDuplicationExist(List<Integer> numbers) {
        Set<Integer> duplicates = numbers.stream()
                .filter(i -> Collections.frequency(numbers, i) > 1)
                .collect(Collectors.toSet());

        if (!duplicates.isEmpty()) {
            throw new IllegalArgumentException("[ERROR] 로또 번호는 중복될 수 없습니다.");
        }
    }

    private void isRangeValid(List<Integer> numbers) {
        for (int i = 0; i < numbers.size(); i++) {
            if (numbers.get(i) < 1 || numbers.get(i) > 45) {
                throw new IllegalArgumentException("[ERROR] 로또 번호는 1에서 45 안에서 정할 수 있습니다.");
            }
        }
    }

    public List<Integer> getLottoNumbers() {
        return this.numbers;
    }

    public static String getRequestMessage() {
        return REQUEST_NUMBER_MESSAGE;
    }


}
