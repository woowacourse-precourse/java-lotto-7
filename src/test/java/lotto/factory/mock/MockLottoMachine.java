package lotto.factory.mock;

import lotto.factory.LottoMachine;
import lotto.model.Lotto;
import lotto.model.LottoTicket;
import lotto.model.Money;

import java.util.List;

public class MockLottoMachine extends LottoMachine {
    private final List<Integer> fixedNumbers;

    public MockLottoMachine(List<Integer> fixedNumbers) {
        this.fixedNumbers = fixedNumbers;
    }

    @Override
    public LottoTicket generateLottoTicket() {
        return new LottoTicket(new Lotto(fixedNumbers), Money.of(PRICE_PER_ONE));
    }
}
