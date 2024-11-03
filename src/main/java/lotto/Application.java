package lotto;

import java.util.Map;
import java.util.function.Function;
import java.util.function.Supplier;
import lotto.domain.Lotties;
import lotto.domain.Number;
import lotto.domain.Numbers;
import lotto.domain.WinningNumbers;
import lotto.domain.WinningRank;
import lotto.view.InputView;
import lotto.view.OutputView;

public class Application {

    public static void main(String[] args) {
        Lotties lotties = retryWhenThrowException(Application::inputLotties);
        OutputView.printLotties(lotties.getLottiesNumbers());

        Numbers numbers = retryWhenThrowException(Application::inputWinningNumbers);
        WinningNumbers winningNumbers = retryWhenThrowException(Application::inputBonusNumber, numbers);

        printTotalResult(winningNumbers, lotties);
    }

    private static Lotties inputLotties() {
        int totalPrice = InputView.inputTotalPrice();
        return Lotties.from(totalPrice);
    }

    private static Numbers inputWinningNumbers() {
        return Numbers.from(InputView.inputWinningNumbers());
    }

    private static WinningNumbers inputBonusNumber(Numbers winningNumbers) {
        Number bonusNumber = new Number(InputView.inputBonusNumber());
        return new WinningNumbers(winningNumbers, bonusNumber);
    }

    private static void printTotalResult(WinningNumbers winningNumbers, Lotties lotties) {
        Map<WinningRank, Long> result = winningNumbers.findResult(lotties);
        double profit = winningNumbers.calculateProfit(lotties);
        OutputView.printResult(result, profit);
    }

    private static <T> T retryWhenThrowException(Supplier<T> supplier) {
        while (true) {
            try {
                return supplier.get();
            } catch (IllegalArgumentException exception) {
                OutputView.printExceptionMessage(exception);
            }
        }
    }

    private static <T, R> R retryWhenThrowException(Function<T, R> function, T argument) {
        while (true) {
            try {
                return function.apply(argument);
            } catch (IllegalArgumentException exception) {
                OutputView.printExceptionMessage(exception);
            }
        }
    }
}
