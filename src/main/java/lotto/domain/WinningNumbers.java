package lotto.domain;

import java.util.List;
import lotto.domain.lotto.Lotto;

public class WinningNumbers extends Lotto {

    private WinningNumbers(List<Integer> winningNumbers) {
        super(winningNumbers);
    }

    public static WinningNumbers of(List<Integer> winningNumbers) {
        return new WinningNumbers(winningNumbers);
    }
}
