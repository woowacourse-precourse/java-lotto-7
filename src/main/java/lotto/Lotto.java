package lotto;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Lotto {
    private static final int SIZE = 6;
    private static final int MIN_NUMBER = 1;
    private static final int MAX_NUM = 45;

    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = numbers;
    }

    private void validate(List<Integer> numbers) {
        if (numbers.size() != SIZE) {
            throw new IllegalArgumentException("[ERROR] 로또 번호는 6개여야 합니다.");
        }

        Set<Integer> notDuplicatedNumbers = new HashSet<>(numbers);
        if (notDuplicatedNumbers.size() != numbers.size()) {
            throw new IllegalArgumentException("[ERROR] 로또 번호는 중복되지 않아야 합니다.");
        }

        for (int value : numbers) {
            if (value < MIN_NUMBER || value > MAX_NUM) {
                throw new IllegalArgumentException("[ERROR] 로또 번호는 1과 45사이여야 합니다.");
            }
        }
    }

    public void lottoView() {
        System.out.println(numbers);
    }

    public int compareNumber(final Lotto winningLotto) {
        List<Integer> duplicatedLotto = new ArrayList<>(this.numbers);

        duplicatedLotto.retainAll(winningLotto.numbers);

        return duplicatedLotto.size();
    }

    public boolean compareBonusNumber(final int bonusNumber) {
        for (int num : this.numbers) {
            if (num == bonusNumber) {
                return true;
            }
        }
        return false;
    }
}
