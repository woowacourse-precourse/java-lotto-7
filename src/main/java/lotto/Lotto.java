package lotto;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import lotto.constant.ErrorMessage;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = numbers;
    }

    private void validate(List<Integer> numbers) {
        Set<Integer> validatedNumbers = new HashSet<>(numbers);
        if (numbers.size() != 6) {
            throw new IllegalArgumentException("[ERROR] 로또 번호는 6개여야 합니다.");
        }
        if (validatedNumbers.size() < numbers.size()) {
            throw new IllegalArgumentException(ErrorMessage.DUPLICATE_NUMBER.getMessage());
        }

    }

    // TODO: 추가 기능 구현
    public String printLottos() {
        return numbers.toString();
    }

    public List<Integer> getLottoNumbers() {
        return this.numbers;
    }
}