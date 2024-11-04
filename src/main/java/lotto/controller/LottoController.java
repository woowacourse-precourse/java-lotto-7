package lotto.controller;

import java.util.List;
import lotto.model.Lotto;
import lotto.model.LottoBudget;
import lotto.model.LottoPrizes;
import lotto.model.Lottos;
import lotto.model.WinningNumbers;
import lotto.view.InputView;
import lotto.view.OutputView;

public class LottoController {

    private final InputView inputView;
    private final OutputView outputView;

    public LottoController(InputView inputView, OutputView outputView) {
        this.inputView = inputView;
        this.outputView = outputView;
    }

    public void run() {
        String lottoBudgetInput = inputView.readLottoBudget();
        LottoBudget lottoBudget = new LottoBudget(lottoBudgetInput);

        String lottoCount = lottoBudget.getLottoCount();
        outputView.printLottoCount(lottoCount);

        int lottoCountNumber = Integer.parseInt(lottoCount);
        Lottos lottos = Lottos.fromCount(lottoCountNumber);

        List<String> lottoNumbers = lottos.getLottoNumbers();
        outputView.printLottoNumbers(lottoNumbers);

        String WinningNumbersInput = inputView.readWinningNumbers();

        Lotto mainNumbers = Lotto.of(WinningNumbersInput);

        String bonusNumber = inputView.readBonusNumber();

        WinningNumbers winningNumbers = new WinningNumbers(mainNumbers, bonusNumber);

        LottoPrizes lottoPrizes = new LottoPrizes(lottos, winningNumbers);

        String yield = lottoPrizes.calculateYield(lottoBudget.getValue());

        List<String> matchStatistics = lottoPrizes.calculateMatchStatistics();
        outputView.printMatchStatistics(matchStatistics);

        System.out.println("총 수익률은 " + yield + "%입니다.");
    }

}
