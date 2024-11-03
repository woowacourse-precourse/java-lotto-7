package lotto.domain;

import java.util.List;
import lotto.domain.lotto.Lotto;

public class WinningLotto extends Lotto {

    private WinningLotto(List<Integer> winningNumbers) {
        super(winningNumbers);
    }

    public static WinningLotto of(List<Integer> winningNumbers) {
        return new WinningLotto(winningNumbers);
    }
}
