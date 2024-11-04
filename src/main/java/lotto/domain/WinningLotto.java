package lotto.domain;

import java.util.List;
import lotto.domain.model.Lotto;
import lotto.domain.model.LottoNumber;

public class WinningLotto {

    private final Lotto numbers;
    private final LottoNumber bonus;

    public WinningLotto(Lotto numbers, LottoNumber bonus) {
        this.numbers = numbers;
        this.bonus = bonus;
    }

    public List<LottoNumber> getNumbers() {
        return numbers.getNumbers();
    }

    public LottoNumber getBonus() {
        return bonus;
    }
}
