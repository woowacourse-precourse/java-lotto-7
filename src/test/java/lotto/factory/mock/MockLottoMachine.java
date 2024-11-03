package lotto.factory.mock;

import java.util.List;
import lotto.factory.LottoMachine;
import lotto.model.Lotto;
import lotto.model.LottoTicket;
import lotto.model.Money;

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
