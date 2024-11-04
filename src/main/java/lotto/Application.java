package lotto;

import java.math.BigDecimal;
import java.util.List;
import lotto.common.Transaction;
import lotto.console.view.InputView;
import lotto.console.view.OutputView;
import lotto.lotto.domain.Lotto;
import lotto.lotto.domain.LottoAnswer;
import lotto.lotto.domain.LottoResult;
import lotto.user.domain.User;

public class Application {
    public static void main(String[] args) {
        InputView inputView = new InputView();
        OutputView outputView = new OutputView();

        run(inputView, outputView);
    }

    public static void run(InputView inputView, OutputView outputView) {
        Transaction transaction = new Transaction();

        User user = transaction.execute(
                () -> User.of(inputView.readMoney())
        );

        int numberOfLotto = user.calculateAvailableNumberOfLotto();
        for (int i = 0; i < numberOfLotto; i++) {
            user.buy(Lotto.issue());
        }

        outputView.printUserLottos(user);

        List<Integer> winNumbers = transaction.execute(inputView::readWinNumbers);
        int bonusNumber = transaction.execute(inputView::readBonusNumber);

        LottoAnswer answer = transaction.execute(
                () -> LottoAnswer.issue(winNumbers, bonusNumber)
        );
        List<LottoResult> results = user.match(answer);

        outputView.printResults(results);

        BigDecimal ratio = user.calculateProfitRatio(LottoResult.getTotalPrize(results));

        outputView.printProfitRation(ratio);
    }
}
