package lotto;

import lotto.domain.Lottos;
import lotto.view.InputView;
import lotto.view.OutputView;

import java.util.Set;

public class Application {

    public static void main(String[] args) {

        long userPurchaseMoney = InputView.inputPurchaseMoney();

        Lottos lottos = OutputView.showPurchasedLottos(userPurchaseMoney);

        Set<Integer> winningNumbers = InputView.inputWinningNumbers();
        int bonusNumber = InputView.inputBonusWinningNumber(winningNumbers);

        OutputView.showPurchasedLottosStatus(lottos, winningNumbers, bonusNumber, userPurchaseMoney);
    }
}
