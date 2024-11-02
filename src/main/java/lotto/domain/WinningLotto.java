package lotto.domain;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.Collections;
import java.util.List;

import static lotto.domain.LottoConfig.*;

public class WinningLotto {
    private final List<Integer> numbers;

    private final int bonusNumber;

    public WinningLotto() {
        List<Integer> randoms = Randoms.pickUniqueNumbersInRange(LOTTO_START.getUnit(), LOTTO_END.getUnit(), LOTTO_BONUS_NUMBER.getUnit());
        this.numbers = randoms.subList(LOTTO_START.getUnit() - 1, LOTTO_MAX_NUMBER.getUnit());
        this.bonusNumber = randoms.get(LOTTO_BONUS_NUMBER.getUnit() - 1);
    }

    public List<Integer> getNumbers() {
        return Collections.unmodifiableList(numbers);
    }

    public int getBonusNumber() {
        return bonusNumber;
    }
}
