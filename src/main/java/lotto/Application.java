package lotto;

import java.util.Map;
import lotto.domain.Lotties;
import lotto.domain.Numbers;
import lotto.domain.Number;
import lotto.domain.WinningNumbers;
import lotto.domain.WinningRank;
import lotto.view.InputView;
import lotto.view.OutputView;

public class Application {

    public static void main(String[] args) {
        int totalPrice = InputView.inputTotalPrice();
        Lotties lotties = Lotties.from(totalPrice);

        OutputView.printLotties(lotties.getLottiesNumbers());

        Numbers numbers = Numbers.from(InputView.inputWinningNumbers());
        Number bonusNumber = new Number(InputView.inputBonusNumber());
        WinningNumbers winningNumbers = new WinningNumbers(numbers, bonusNumber);

        Map<WinningRank, Long> result = winningNumbers.findResult(lotties);
        double profit = winningNumbers.calculateProfit(lotties);
        OutputView.printResult(result, profit);
    }
}
