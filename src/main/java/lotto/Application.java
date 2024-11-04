package lotto;

import java.math.BigDecimal;
import java.util.List;
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
        User user = User.of(inputView.readMoney());

        int numberOfLotto = user.calculateAvailableNumberOfLotto();
        for (int i = 0; i < numberOfLotto; i++) {
            user.buy(Lotto.issue());
        }

        outputView.printUserLottos(user);

        LottoAnswer answer = LottoAnswer.issue(
                inputView.readWinNumbers(),
                inputView.readBonusNumber()
        );
        List<LottoResult> results = user.match(answer);

        outputView.printResults(results);

        BigDecimal ratio = user.calculateProfitRatio(LottoResult.getTotalPrize(results));

        outputView.printProfitRation(ratio);
    }
}
