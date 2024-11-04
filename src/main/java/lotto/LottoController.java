package lotto;

import java.util.List;
import lotto.model.Lotto;
import lotto.model.Lottos;
import lotto.model.WinningLotto;
import lotto.view.InputView;
import lotto.view.OutputView;

public class LottoController {

    private static final int PRICE_PER_TICKET = 1000;

    public void start() {
        Lottos autoLottos = makeAutoLottos();
        OutputView.printPurchases(autoLottos.getNumber(), autoLottos.getLottos());
        WinningLotto winningLotto = makeWinningLotto();
        autoLottos.calculateWinningStatistics(winningLotto);
        autoLottos.calculateWinningAmount();
        OutputView.printResult(autoLottos);
    }

    private Lottos makeAutoLottos() {
        while (true) {
            try {
                InputView.printPurchaseAmountInputMessage();
                int money = InputView.getPurchaseAmount();
                validateMoney1000Multiple(money);
                return new Lottos(money / PRICE_PER_TICKET);
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    private WinningLotto makeWinningLotto() {
        while (true) {
            try {
                InputView.printWinningNumbersInputMessage();
                List<Integer> winningNumbers = InputView.getWinningNumbers();
                InputView.printBonusNumberInputMessage();
                int bonusNumber = InputView.getBonusNumber();
                return new WinningLotto(new Lotto(winningNumbers), bonusNumber);
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    private void validateMoney1000Multiple(int money) {
        if (money % PRICE_PER_TICKET != 0) {
            throw new IllegalArgumentException("[ERROR] 금액은 1000의 배수여야 합니다.");
        }
    }
}
