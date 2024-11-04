package lotto;

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
        int money = inputView.readMoney();
        User user = User.of(money);

        while (user.canBuyLotto()) {
            user.buy(Lotto.issue());
        }

        outputView.printUserLottos(user);

        List<Integer> winNumbers = inputView.readWinNumbers();
        int bonusNumber = inputView.readBonusNumber();

        LottoAnswer answer = LottoAnswer.issue(winNumbers, bonusNumber);

        List<LottoResult> results = user.match(answer);
        outputView.printResults(results);

        System.out.println("LottoResult.getTotalPrize(results) = " + LottoResult.getTotalPrize(results));
    }
}
