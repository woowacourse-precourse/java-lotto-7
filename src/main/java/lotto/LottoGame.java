package lotto;

import lotto.util.Container;
import lotto.view.InputView;
import lotto.view.OutputView;

import java.util.ArrayList;
import java.util.List;

public class LottoGame {

    private static final InputView inputView = Container.getInstance(InputView.class);
    private static final OutputView outputView = Container.getInstance(OutputView.class);

    private static List<Integer> winningNumbers = new ArrayList<>();

    private static int amount = 0;
    private static int bonusNumber = 0;

    public static void start() {
        getAmount();
        setLottoes();
        setNumbers();
        getLottoResult();
    }

    private static void getAmount() {
        outputView.printStartMessage();
        amount = inputView.setLottoPrice();
        outputView.printCountMessage(amount);
    }

    private static void setLottoes() {
        outputView.printLottoNumbers(inputView.setLottoes(amount));
    }

    private static void setNumbers() {
        outputView.printWinningNumbers();
        winningNumbers = inputView.setWinningNumbers();

        outputView.printBonusNumber();
        bonusNumber = inputView.setBonusNumber();
    }

    private static void getLottoResult() {
        outputView.printWinningStatistics();
        outputView.printResult(inputView.getLottoResult(winningNumbers, bonusNumber));
    }
}