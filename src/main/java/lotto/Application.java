package lotto;

import lotto.domain.LottoGenerator;
import lotto.domain.LottoMatcher;
import lotto.domain.Statistics;
import lotto.domain.WinningNumbers;
import lotto.exception.ExceptionHandler;
import lotto.view.InputView;
import lotto.view.OutputView;

import java.util.List;

public class Application {
    public static void main(String[] args) {
        try {
            int amount = InputView.getAmount();
            OutputView.printLottoAmount(amount);

            LottoGenerator lottoGenerator = new LottoGenerator(amount);

            List<Integer> winningNumbers = InputView.getWinningNumbers();
            int bonusNumber = InputView.getBonusNumber();

            WinningNumbers winningLotto = new WinningNumbers(winningNumbers, bonusNumber);

            LottoMatcher matchLotto = new LottoMatcher(lottoGenerator.getLottos(), winningLotto);

            Statistics statistics = new Statistics(matchLotto.getRankCounts(), amount * 1000);
            OutputView.printStatistics(statistics);
        } catch (IllegalArgumentException e) {
            ExceptionHandler.handleIllegalArgumentException(e);
            return;
        }

    }
}
