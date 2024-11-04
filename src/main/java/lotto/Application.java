package lotto;

import lotto.domain.simulator.LottoGenerator;
import lotto.domain.simulator.LottoMatcher;
import lotto.domain.simulator.Statistics;
import lotto.domain.model.WinningNumbers;
import lotto.view.InputView;
import lotto.view.OutputView;

import java.util.List;

public class Application {
    public static void main(String[] args) {
        int amount = InputView.getAmount();
        OutputView.printLottoAmount(amount);

        LottoGenerator lottoGenerator = new LottoGenerator(amount);

        List<Integer> winningNumbers = InputView.getWinningNumbers();
        int bonusNumber = InputView.getBonusNumber();

        WinningNumbers winningLotto = new WinningNumbers(winningNumbers, bonusNumber);

        LottoMatcher matchLotto = new LottoMatcher(lottoGenerator.getLottos(), winningLotto);

        Statistics statistics = new Statistics(matchLotto.getRankCounts(), amount * 1000);
        OutputView.printStatistics(statistics);

    }
}
