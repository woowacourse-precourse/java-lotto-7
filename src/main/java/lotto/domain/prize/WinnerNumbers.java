package lotto.domain.prize;

import java.util.List;
import lotto.domain.ticket.Lotto;

public class WinnerNumbers {
    private final Lotto lotto;

    private WinnerNumbers(Lotto lotto) {
        this.lotto = lotto;
    }

    public static WinnerNumbers of(Lotto lotto) {
        return new WinnerNumbers(lotto);
    }

    public List<Integer> getLottoNumbers() {
        return lotto.getNumbers();
    }

}
