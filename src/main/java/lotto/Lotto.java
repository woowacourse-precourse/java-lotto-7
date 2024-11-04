package lotto;

import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validateSize(numbers);
        validateRange(numbers);
        validateUnique(numbers);
        this.numbers = numbers;
    }

    public List<Integer> getNumbers() {
        return Collections.unmodifiableList(numbers);
    }

    public boolean isUniqueWithBonus(int bonus) {
        for (int number : numbers) {
            if (number == bonus) {
                return false;
            }
        }
        return true;
    }

    public int countDuplicates(Lotto winningLotto) {
        int duplicateCount = 0;
        for (int number : this.numbers) {
            if (winningLotto.isNumberInLotto(number)) {
                duplicateCount++;
            }
        }
        return duplicateCount;
    }

    public boolean isBonusInLotto(int bonusNumber) {
        boolean isIn = false;
        for (int number : this.numbers) {
            if (number == bonusNumber) {
                isIn = true;
            }
        }
        return isIn;
    }
    

    private void validateSize(List<Integer> numbers) {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException("[ERROR] 로또 번호는 6개여야 합니다.");
        }
    }

    private void validateRange(List<Integer> numbers) {
        for (Integer number : numbers) {
            if (number > 45 || number < 1) {
                throw new IllegalArgumentException("[ERROR] 로또 번호는 1에서 45 사이의 정수여야 합니다.");
            }
        }
    }

    private void validateUnique(List<Integer> numbers) {
        Set<Integer> checkUnique = new HashSet<>();

        for (Integer number : numbers) {
            if (!checkUnique.add(number)) {
                throw new IllegalArgumentException("[ERROR] 로또 번호는 중복될 수 없습니다.");
            }
        }
    }

    private boolean isNumberInLotto(int winningLottoNumbers) {
        boolean isIn = false;
        for (int number : this.numbers) {
            if (number == winningLottoNumbers) {
                isIn = true;
            }
        }
        return isIn;
    }
}
