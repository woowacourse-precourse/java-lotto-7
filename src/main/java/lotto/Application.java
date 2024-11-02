package lotto;

import lotto.domain.LottoWinningNumbers;
import lotto.domain.Lottos;
import lotto.view.InputView;
import lotto.view.OutputView;

public class Application {

    public static void main(String[] args) {

        long userPurchaseMoney = InputView.inputPurchaseMoney();

        Lottos lottos = OutputView.showPurchasedLottos(userPurchaseMoney);

        LottoWinningNumbers lottoWinningNumbers = InputView.inputWinningNumbers();
        int bonusNumber = InputView.inputBonusWinningNumber();
        lottoWinningNumbers.addBonusWinningNumber(bonusNumber);

        OutputView.showPurchasedLottosStatus(lottoWinningNumbers, lottos, userPurchaseMoney);
    }
}
