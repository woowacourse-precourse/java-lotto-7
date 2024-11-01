package lotto.model;

import java.util.Collections;
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

    public void validateDuplicationWithBonusNumber(int bonusNumber) {
        if (numbers.contains(bonusNumber)) {
            throw new IllegalArgumentException("[ERROR] 보너스 번호는 당첨 번호와 중복되지 않는 값입니다.");
        }
    }

    public List<Integer> getNumbers() {
        return Collections.unmodifiableList(numbers);
    }

    public int drawEachLotto(Lotto lotto) {
        int matchingAmount = 0;
        for (int number : lotto.getNumbers()) {
            if (numbers.contains(number)) {
                matchingAmount++;
            }
        }
        return matchingAmount;
    }
}
