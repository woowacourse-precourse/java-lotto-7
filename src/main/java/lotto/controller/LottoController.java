package lotto.controller;

import java.util.Map;
import lotto.dto.BonusNumberRequestDTO;
import lotto.dto.PurchaseMoneyRequestDTO;
import lotto.dto.PurchaseResultDTO;
import lotto.dto.WinningNumberRequestDTO;
import lotto.model.BonusNumber;
import lotto.model.LottoRank;
import lotto.model.LottoStore;
import lotto.model.Lottos;
import lotto.model.Money;
import lotto.model.WinningNumbers;
import lotto.view.InputView;
import lotto.view.OutputView;
import lotto.view.Retryable;

public class LottoController {

    private final InputView inputView;
    private final OutputView outputView;
    private final LottoStore store;

    public LottoController(InputView inputView, OutputView outputView, LottoStore store) {
        this.inputView = inputView;
        this.outputView = outputView;
        this.store = store;
    }

    public void run() {
        Money money = retryIfHasError(this::getMoney);
        Lottos lottos = buyLottos(money);
        WinningNumbers winningNumbers = retryIfHasError(this::getWinningNumbers);
        BonusNumber bonusNumber = retryIfHasError(this::getBonusNumber);
        Map<LottoRank, Integer> ranks = lottos.getLottoResults(winningNumbers, bonusNumber);
        outputView.showLottoResults(ranks);
    }

    private Lottos buyLottos(Money money) {
        Lottos lottos = store.sellLotto(money);
        outputView.showPurchasedLottos(new PurchaseResultDTO(lottos));
        return lottos;
    }

    private Money getMoney() {
        PurchaseMoneyRequestDTO purchaseMoneyRequest = inputView.readMoneyInput();
        return new Money(purchaseMoneyRequest);
    }

    private WinningNumbers getWinningNumbers() {
        WinningNumberRequestDTO winningNumberInput = inputView.readWinningNumberInput();
        return new WinningNumbers(winningNumberInput);
    }

    private BonusNumber getBonusNumber() {
        BonusNumberRequestDTO bonusNumberInput = inputView.readBonusNumberInput();
        return new BonusNumber(bonusNumberInput);
    }

    private <T> T retryIfHasError(Retryable<T> retryable) {
        while (true) {
            try {
                return retryable.execute();
            } catch (IllegalArgumentException e) {
                outputView.showErrorMessage(e);
            }
        }
    }
}
