package lotto;

import lotto.domain.*;
import lotto.view.OutputView;

import java.util.List;
import java.util.Map;

import static lotto.view.InputView.*;
import static lotto.view.OutputView.*;

public class LottoGame {
    private final String PURCHASE_AMOUNT_INPUT_MESSAGE = "구입금액을 입력해 주세요.";
    private final String WINNING_NUMBER_INPUT_MESSAGE = "당첨 번호를 입력해 주세요.";
    private final String BONUS_NUMBER_INPUT_MESSAGE = "보너스 번호를 입력해 주세요.";
    private LottoMachine lottoMachine;

    public void run() {
        int purchaseAmount = requestPurchaseAmount();
        List<Lotto> lottos = buyLottos(purchaseAmount);
        println();

        OutputView.printLottos(lottos);
        println();

        List<Integer> winningNumbers = requestWinningNumbers();
        println();

        int bonusNumber = requestBonusNumber(winningNumbers);
        println();

        WinningLotto winningLotto = new WinningLotto(winningNumbers, bonusNumber);

        LottoStatistics statistics = calculateStatistics(lottos, winningLotto);
        printStatistics(statistics, purchaseAmount);
    }

    public int requestPurchaseAmount() {
        println(PURCHASE_AMOUNT_INPUT_MESSAGE);
        try {
            return inputPurchaseAmount();
        } catch (IllegalArgumentException e) {
            println(e.getMessage());
            return requestPurchaseAmount();
        }
    }

    private List<Integer> requestWinningNumbers() {
        println(WINNING_NUMBER_INPUT_MESSAGE);
        try {
            return inputWinningNumbers();
        } catch (IllegalArgumentException e) {
            println(e.getMessage());
            return requestWinningNumbers();
        }
    }

    private int requestBonusNumber(List<Integer> winningNumbers) {
        println(BONUS_NUMBER_INPUT_MESSAGE);
        try {
            return inputBonusNumber(winningNumbers);
        } catch (IllegalArgumentException e) {
            println(e.getMessage());
            return requestBonusNumber(winningNumbers);
        }
    }

    private List<Lotto> buyLottos(int purchaseAmount) {
        lottoMachine = new LottoMachine(purchaseAmount, new LottoNumberGenerator());
        return lottoMachine.buyLottos();
    }

    private LottoStatistics calculateStatistics(List<Lotto> lottos, WinningLotto winningLotto) {
        LottoStatistics statistics = new LottoStatistics();
        statistics.make(lottos, winningLotto);
        return statistics;
    }

    private void printStatistics(LottoStatistics statistics, int purchaseAmount) {
        Map<LottoRanking, Integer> rankingCount = statistics.getRankingCount();
        int totalPrize = statistics.calculateTotalPrize();
        ProfitCalculator profitCalculator = new ProfitCalculator();
        double profitRate = profitCalculator.calculateProfitRate(totalPrize, purchaseAmount);

        OutputView.printWinningStatistics(rankingCount, profitRate);
    }
}
