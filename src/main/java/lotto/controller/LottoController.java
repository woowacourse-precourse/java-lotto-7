package lotto.controller;

import lotto.model.Lotto;
import lotto.model.LottoProcess;
import lotto.view.LottoView;

import java.util.ArrayList;
import java.util.List;

public class LottoController {
    private List<Lotto> lottos;
    private List<Integer> winningNumbers;

    private int bonusNumber;

    private LottoProcess lottoProcess;

    private int purchaseAmount;

    private LottoView lottoView;


    public void inputPurchaseProcess() {

        this.lottoView = new LottoView();
        this.purchaseAmount = lottoView.inputPurchaseAmountProcess();

    }


    public void buyLottosProcess() {
        this.lottoProcess = new LottoProcess();
        this.lottos = new ArrayList<>();
        lottoView.outputBuyLottoMessage(this.purchaseAmount);

        for (int i = 1; i <= this.purchaseAmount / 1000; i++) {
            Lotto lotto = new Lotto(lottoProcess.getRandomLottoNumbers());
            lottos.add(lotto);
            lottoView.outputLottoNumbers(lotto);

        }

    }

    public void inputWinningNumbersProcess() {
        lottoView.outputWinningNumbersMessage();
        this.winningNumbers = lottoView.inputWinningNumbersProcess();

    }

    public void inputBonusNumberProcess() {
        lottoView.outputBonusNumberInputMessage();
        this.bonusNumber = lottoView.inputBonusNumberProcess(this.winningNumbers);
    }


    public void winningStatisticsProcess() {
        lottoView.outputWinningStatisticsStart();
        for (Lotto lotto : lottos) {
            lottoProcess.reflectWinningCountToStatistics(lotto.getNumbers(), this.winningNumbers, this.bonusNumber);
        }
        lottoView.outputWinnerStatistics(this.lottoProcess.getWinningStatistics());
        lottoView.outputProfitRate(this.lottoProcess.calculateProfitRate(this.purchaseAmount));

    }

    public void run() {
        inputPurchaseProcess();
        buyLottosProcess();
        inputWinningNumbersProcess();
        inputBonusNumberProcess();
        winningStatisticsProcess();
    }

}
