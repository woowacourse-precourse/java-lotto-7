package lotto.controller;

import static lotto.view.InputView.getConsoleInput;

import java.util.List;
import lotto.domain.lotto.Lotto;
import lotto.domain.lotto.LottoStore;
import lotto.domain.winning.LottoMachine;
import lotto.domain.winning.WinningNumbers;
import lotto.domain.winning.WinningStatus;
import lotto.view.InputView;

public class LottoController {

    private InputView inputView = new InputView();
    private LottoStore lottoStore = new LottoStore();
    private int lottoCount;
    private String purchaseAmount;
    private List<Lotto> lottos;
    private WinningStatus winningStatus;

    public void run() {
        purchaseAmount = inputView.requestPurchaseAmount(getConsoleInput());
        lottoCount = lottoStore.getLottoCount(purchaseAmount);
        lottos = lottoStore.buyLotto(lottoCount);

        String winningNumbers = inputView.requestWinningNumbers(getConsoleInput());
        int bonusNumber = inputView.requestBonusNumber(getConsoleInput());
        WinningNumbers winningNumbersObject = new WinningNumbers(winningNumbers, bonusNumber);
        LottoMachine lottoMachine = new LottoMachine(winningNumbersObject);
        winningStatus = lottoMachine.checkWinningStatus(lottos);
    }
}
