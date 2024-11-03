package lotto.factory;

import lotto.model.Lotto;
import lotto.model.LottoTicket;
import lotto.model.Money;

public class LottoMachine {
    public static final int PRICE_PER_ONE = 1_000;

    private Lotto generateLotto() {
        return LottoNumberPicker.pickSortedRandomNumbers();
    }

    public LottoTicket generateLottoTicket() {
        return new LottoTicket(generateLotto(), Money.of(PRICE_PER_ONE));
    }
}
