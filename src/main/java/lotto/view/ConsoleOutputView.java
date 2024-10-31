package lotto.view;

import static lotto.constants.PrintMessage.LOTTO_PURCHASE_MESSAGE;

import java.util.List;
import lotto.model.Lotto;

public class ConsoleOutputView implements OutputView {

    @Override
    public void printErrorMessage(String message) {
        System.out.println(message);
    }

    @Override
    public void printPurchasedLottos(List<Lotto> purchasedLotto) {
        System.out.print("\n" + purchasedLotto.size());
        LOTTO_PURCHASE_MESSAGE.display();
        purchasedLotto.forEach(lotto -> System.out.println(lotto.getNumbers()));
    }

    @Override
    public void printWinningStatistics() {

    }

    @Override
    public void printTotalProfitRate() {

    }
}
