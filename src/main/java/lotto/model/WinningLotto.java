package lotto.model;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class WinningLotto {

    private Lotto winningNumbers;
    private int bonusNumber;

    public WinningLotto(List<Integer> numbers, int bonusNumber) {
        validateNumberDuplicate(numbers, bonusNumber);
        this.winningNumbers = new Lotto(numbers);
        this.bonusNumber = bonusNumber;
    }

    private void validateNumberDuplicate(List<Integer> numbers, int bonusNumber) {
        List<Integer> totalNumbers = new ArrayList<>(numbers);
        totalNumbers.add(bonusNumber);
        Set<Integer> uniqueNumbers = new HashSet<>(numbers);

        if (uniqueNumbers.size() != totalNumbers.size()) {
            throw new IllegalArgumentException("[ERROR] 당첨 번호는 중복된 숫자가 없어야 합니다.");
        }
    }
}
