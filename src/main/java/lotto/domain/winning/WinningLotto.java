package lotto.domain.winning;

import java.util.List;
import lotto.domain.lotto.Lotto;

public class WinningLotto extends Lotto {

    private WinningLotto(List<Integer> winningNumbers) {
        super(winningNumbers);
    }

    public static WinningLotto of(List<Integer> winningNumbers) {
        return new WinningLotto(winningNumbers);
    }

    public boolean contains(int value) {
        return getNumbers().stream()
                .anyMatch(number -> number.hashCode() == value);
    }
}
