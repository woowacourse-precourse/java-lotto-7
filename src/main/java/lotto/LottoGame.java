package lotto;

import lotto.domain.Lotto;
import lotto.util.Container;
import lotto.view.InputView;
import lotto.view.OutputView;

import java.util.ArrayList;
import java.util.List;

public class LottoGame {

    private static final InputView inputView = Container.getInstance(InputView.class);
    private static final OutputView outputView = Container.getInstance(OutputView.class);

    private static List<Lotto> lottoes = new ArrayList<>();
    private static int amount = 0;

    public static void start() {
        getAmount();
        setLottoes();

        setNumbers();
    }

    public static void setNumbers() {
        outputView.printWinningNumbers();
        List<Integer> numbers = inputView.setWinningNumbers();
        System.out.println(numbers);
    }

    private static void getAmount() {
        outputView.printStartMessage();
        amount = inputView.setLottoPrice();
        outputView.printCountMessage(amount);
    }

    private static void setLottoes() {
        lottoes = inputView.setLottoes(amount).lottoes();
        outputView.printLottoNumbers(lottoes);
    }
}
