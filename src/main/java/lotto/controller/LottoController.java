package lotto.controller;

import java.util.List;
import lotto.domain.lotto.Lotto;
import lotto.domain.lotto.LottoStore;
import lotto.domain.winning.LottoMachine;
import lotto.domain.winning.WinningNumbers;
import lotto.domain.winning.WinningStatus;
import lotto.view.InputView;
import lotto.view.OutputView;

public class LottoController {

    private InputView inputView = new InputView();
    private OutputView outputView = new OutputView();
    private LottoStore lottoStore = new LottoStore();
    private int lottoCount;
    private String purchaseAmount;
    private List<Lotto> lottos;
    private WinningStatus winningStatus;

    public void run() {
        purchaseAmount = inputView.requestPurchaseAmount();
        lottoCount = lottoStore.getLottoCount(purchaseAmount);

        lottos = lottoStore.buyLotto(lottoCount);

        String winningNumbers = inputView.requestWinningNumbers();
        int bonusNumber = inputView.requestBonusNumber();

        WinningNumbers winningNumbersObject = new WinningNumbers(winningNumbers, bonusNumber);
        LottoMachine lottoMachine = new LottoMachine(winningNumbersObject);
        winningStatus = lottoMachine.checkWinningStatus(lottos);

        outputView.printLottoCount(lottos, lottoCount);
        outputView.printWinningStatistics(winningStatus);
        outputView.printYield(lottoMachine.calculateYield(Integer.parseInt(purchaseAmount)));
    }
}
