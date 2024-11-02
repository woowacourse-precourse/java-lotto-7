package lotto;

import lotto.domain.Ranking;
import lotto.util.Container;
import lotto.view.InputView;
import lotto.view.OutputView;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class LottoGame {

    private static final InputView inputView = Container.getInstance(InputView.class);
    private static final OutputView outputView = Container.getInstance(OutputView.class);

    private static List<Integer> winningNumbers = new ArrayList<>();
    private static Map<Ranking, Integer> lottoResult;

    private static int amount = 0;
    private static int bonusNumber = 0;

    public static void start() {
        getAmount();
        setLottoes();
        setNumbers();
        getLottoResult();
        getEarningRate();
    }

    private static void getAmount() {
        outputView.printStartMessage();
        amount = inputView.setLottoPrice();
        outputView.printCountMessage(amount);
    }

    private static void setLottoes() {
        outputView.printLottoNumbers(inputView.setLottoes(amount));
    }

    private static void setNumbers() {
        outputView.printWinningNumbers();
        winningNumbers = inputView.setWinningNumbers();

        outputView.printBonusNumber();
        bonusNumber = inputView.setBonusNumber();
    }

    private static void getLottoResult() {
        outputView.printWinningStatistics();
        lottoResult = inputView.getLottoResult(winningNumbers, bonusNumber);
        outputView.printWinningResult(lottoResult);
    }

    private static void getEarningRate() {
        double earningRate = lottoResult.keySet().stream()
                .mapToDouble(rank -> ((double) (rank.getPrize()) / (amount * 1000) * (lottoResult.get(rank)) * (100))).sum();

        outputView.printEarningRate(earningRate);
    }
}