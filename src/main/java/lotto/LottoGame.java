package lotto;

import lotto.domain.Lotto;
import lotto.domain.Ranking;
import lotto.util.Container;
import lotto.view.InputView;
import lotto.view.OutputView;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class LottoGame {

    private static final InputView inputView = Container.getInstance(InputView.class);
    private static final OutputView outputView = Container.getInstance(OutputView.class);

    private static List<Lotto> lottoes = new ArrayList<>();
    private static List<Integer> winningNumbers = new ArrayList<>();
    private static Map<Ranking, Integer> result = new LinkedHashMap<>();

    private static int amount = 0;
    private static int bonusNumber = 0;

    public static void start() {
        getAmount();
        setLottoes();

        setNumbers();

        result();
    }

    private static void getAmount() {
        outputView.printStartMessage();
        amount = inputView.setLottoPrice();
        outputView.printCountMessage(amount);
    }

    private static void setLottoes() {
        lottoes = inputView.setLottoes(amount).lottoes();
        outputView.printLottoNumbers(lottoes);
    }

    private static void setNumbers() {
        outputView.printWinningNumbers();
        winningNumbers = inputView.setWinningNumbers();

        outputView.printBonusNumber();
        bonusNumber = inputView.setBonusNumber();
    }

    private static void result() {
        outputView.printWinningStatistics();

        for (int i = 0; i < lottoes.size(); i++) {
            Lotto lotto = lottoes.get(i);

            int matchCount = lotto.matchCount(winningNumbers);
            boolean isBonusNumber = lotto.contains(bonusNumber);

            Ranking ranking = Ranking.valueOf(matchCount, isBonusNumber);
            result.put(ranking, result.getOrDefault(ranking, 0) + 1);
        }

        outputView.printResult(result);
    }
}
