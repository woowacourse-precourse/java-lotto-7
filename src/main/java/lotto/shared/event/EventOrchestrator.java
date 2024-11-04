package lotto.shared.event;

import lotto.checker.domain.BonusNumber;
import lotto.checker.domain.Lottos;
import lotto.checker.domain.WinningNumbers;
import lotto.checker.event.BonusNumberCreatedEvent;
import lotto.checker.event.WinningNumbersCreatedEvent;
import lotto.purchase.domain.Money;
import lotto.purchase.event.MoneyCreatedEvent;
import lotto.results.dto.ResultsRequest;

public class EventOrchestrator {
    private Money money;
    private Lottos lottos;
    private WinningNumbers winningNumbers;
    private BonusNumber bonusNumber;


    public Money getMoney() {
        return money;
    }

    public Lottos getLottos() {
        return lottos;
    }

    public WinningNumbers getWinningNumbers() {
        return winningNumbers;
    }


    public void register(MoneyCreatedEvent event) {
        this.money = event.getMoney();
    }

    public void register(LottosCreatedEvent event) {
        this.lottos = event.getLottos();
    }

    public void register(WinningNumbersCreatedEvent event) {
        this.winningNumbers = event.getWinningNumbers();
    }

    public void register(BonusNumberCreatedEvent event) {
        this.bonusNumber = event.getBonusNumber();
    }

    public ResultsRequest createResultRequest() {
        return new ResultsRequest(lottos, winningNumbers, bonusNumber);
    }
}
