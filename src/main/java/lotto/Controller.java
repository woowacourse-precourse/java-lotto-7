package lotto;

import java.util.List;
import lotto.domain.BonusNumber;
import lotto.domain.Lotto;
import lotto.domain.Lottos;
import lotto.domain.Money;
import lotto.domain.ResultSheet;
import lotto.domain.WinningLotto;
import lotto.domain.LottoOption;
import lotto.message.ViewMessage;
import lotto.view.InputView;
import lotto.view.OutputView;

public class Controller {
    public static void run() {
        Lottos purchasedLottos = purchasedLottos();
        OutputView.printLottos(purchasedLottos);
        WinningLotto winningLotto = winningNumbers();
        ResultSheet resultSheet = winningLotto.calculateResult(purchasedLottos);
        OutputView.printResult(resultSheet);
    }

    private static Lottos purchasedLottos() {
        try {
            Money money = new Money(InputView.readInteger(ViewMessage.INPUT_PURCHASE_MONEY));
            return Lottos.purchaseLottos(money);
        } catch (IllegalArgumentException e) {
            OutputView.printException(e);
            return purchasedLottos();
        }
    }

    private static WinningLotto winningNumbers() {
        Lotto winningNumbers = initLotto();
        BonusNumber bonus = initBonus();

        return new WinningLotto(winningNumbers, bonus);
    }

    private static Lotto initLotto() {
        try {
            String lottoNumberString = InputView.readString(ViewMessage.INPUT_WINNING_NUMBERS);
            List<Integer> lottoNumbers = Utils.convertStringToIntegerList(lottoNumberString,
                LottoOption.LOTTO_NUMBER_DELIMITER);
            return new Lotto(lottoNumbers);
        } catch (IllegalArgumentException e) {
            OutputView.printException(e);
            return initLotto();
        }
    }

    private static BonusNumber initBonus() {
        try {
            int bonus = InputView.readInteger(ViewMessage.INPUT_BONUS_NUMBER);
            return new BonusNumber(bonus);
        } catch (IllegalArgumentException e) {
            OutputView.printException(e);
            return initBonus();
        }
    }
}