package lotto.controller;

import java.util.Map;
import lotto.dto.BonusNumberRequestDTO;
import lotto.dto.PurchaseMoneyRequestDTO;
import lotto.dto.PurchaseResultDTO;
import lotto.dto.WinningNumberRequestDTO;
import lotto.model.BonusNumber;
import lotto.model.LottoDraw;
import lotto.model.constant.LottoRank;
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
        LottoDraw lottoDraw = retryIfHasError(this::getLottoDraw);
        Map<LottoRank, Integer> ranks = lottos.getLottoResults(lottoDraw);
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

    private LottoDraw getLottoDraw() {
        WinningNumbers winningNumbers = getWinningNumbers();
        BonusNumber bonusNumber = getBonusNumber();
        return new LottoDraw(winningNumbers, bonusNumber);
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
