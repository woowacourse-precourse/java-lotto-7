package lotto.domain;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.Collections;
import java.util.List;

public class WinningLotto {
    private final List<Integer> numbers;

    private final int bonusNumber;

    public WinningLotto() {
        List<Integer> randoms = Randoms.pickUniqueNumbersInRange(1, 45, 7);
        this.numbers = randoms.subList(0, 6);
        this.bonusNumber = randoms.get(6);
    }

    public List<Integer> getNumbers() {
        return Collections.unmodifiableList(numbers);
    }

    public int getBonusNumber() {
        return bonusNumber;
    }
}
