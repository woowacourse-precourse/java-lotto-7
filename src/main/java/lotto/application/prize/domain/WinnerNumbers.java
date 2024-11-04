package lotto.application.prize.domain;

import java.util.List;
import lotto.application.ticket.domain.ticket.Lotto;

public class WinnerNumbers {
    private final Lotto lotto;

    private WinnerNumbers(Lotto lotto) {
        this.lotto = lotto;
    }

    public static WinnerNumbers of(Lotto lotto) {
        return new WinnerNumbers(lotto);
    }

    public Lotto getLotto() {
        return lotto;
    }

    public List<Integer> getLottoNumbers() {
        return lotto.getNumbers();
    }

}
