package lotto;

import java.util.ArrayList;
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

        Set<Integer> notDuplicatedNumbers = new HashSet<>(numbers);
        if (notDuplicatedNumbers.size() != numbers.size()) {
            throw new IllegalArgumentException("[ERROR] 로또 번호는 중복되지 않아야 합니다.");
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
