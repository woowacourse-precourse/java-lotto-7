package lotto.domain;

import java.util.List;

public class LottoTicket {
    private final Lotto lotto;

    public LottoTicket(List<Integer> numbers) {
        this.lotto = new Lotto(numbers);
    }

    public Lotto getLotto() {
        return lotto;
    }
}
