package lotto;

import java.util.HashSet;
import java.util.List;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = numbers;
    }

    private void validate(List<Integer> numbers) {
        validateLottoNumberSize(numbers);
        validateDuplication(numbers);
    }

    private void validateLottoNumberSize(List<Integer> numbers) {
        if (isLottoNumberSize(numbers)) {
            throw new IllegalArgumentException("[ERROR] 로또 번호는 6개여야 합니다.");
        }
    }

    private void validateDuplication(List<Integer> numbers){
        if (isDuplication(numbers)) {
            throw new IllegalArgumentException("[ERROR] 로또 번호는 중복된 숫자가 없어야 합니다.");
        }
    }

    private boolean isLottoNumberSize (List<Integer> numbers) {
        return numbers.size() != 6;
    }

    private boolean isDuplication (List<Integer> numbers) {
        return new HashSet<>(numbers).size() != numbers.size();
    }
}
