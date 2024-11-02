package lotto;

import lotto.domain.Ranking;
import lotto.util.Container;
import lotto.view.InputView;
import lotto.view.OutputView;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class LottoGame {

    private static final InputView inputView = Container.getInstance(InputView.class);
    private static final OutputView outputView = Container.getInstance(OutputView.class);

    private static List<Integer> winningNumbers = new ArrayList<>();
    private static Map<Ranking, Integer> lottoResult;

    private static int amount = 0;
    private static int bonusNumber = 0;

    public static void startLotto() {
        getAmount();
        setLottoes();

        setWinningNumbers();
        setBonusNumber();

        getLottoResult();
        getEarningRate();
    }

    private static void getAmount() {
        while (true) {
            try {
                outputView.printStartMessage();
                amount = inputView.setLottoPrice();
                outputView.printCountMessage(amount);
                break;
            } catch (IllegalArgumentException e) {
                outputView.printErrorMessage(e.getMessage());
            }
        }
    }

    private static void setLottoes() {
        outputView.printLottoNumbers(inputView.setLottoes(amount));
    }

    private static void setWinningNumbers() {
        while (true) {
            try {
                outputView.printWinningNumbers();
                winningNumbers = inputView.setWinningNumbers();
                break;
            } catch (IllegalArgumentException e) {
                outputView.printErrorMessage(e.getMessage());
                winningNumbers.clear();
            }
        }
    }

    private static void setBonusNumber() {
        while (true) {
            try {
                outputView.printBonusNumber();
                bonusNumber = inputView.setBonusNumber(winningNumbers);
                break;
            } catch (IllegalArgumentException e) {
                outputView.printErrorMessage(e.getMessage());
            }
        }
    }

    private static void getLottoResult() {
        outputView.printWinningStatistics();
        lottoResult = inputView.getLottoResult(winningNumbers, bonusNumber);
        outputView.printWinningResult(lottoResult);
    }

    private static void getEarningRate() {
        outputView.printEarningRate(inputView.getEarningRate(lottoResult, amount));
    }
}