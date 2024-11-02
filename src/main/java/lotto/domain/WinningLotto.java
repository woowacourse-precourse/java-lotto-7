package lotto.domain;

import java.util.List;

public class WinningLotto {
    private Lotto lotto;

    private WinningLotto(List<Integer> numbers) {
        this.lotto = new Lotto(numbers);
    }

    public static WinningLotto from(List<Integer> numbers) {
        return new WinningLotto(numbers);
    }
}
