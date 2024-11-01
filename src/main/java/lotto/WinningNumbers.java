package lotto;

import lotto.store.Lotto;
import lotto.store.LottoNumber;

import java.util.List;

public class WinningNumbers extends Lotto {
    private final LottoNumber bonus;

    public WinningNumbers(List<LottoNumber> winningNumber, LottoNumber bonus) {
        super(winningNumber);
        if(winningNumber.contains(bonus))
            throw new IllegalArgumentException("당첨 번호에 bonus 번호가 이미 존재합니다.");

        this.bonus = bonus;
    }
}
