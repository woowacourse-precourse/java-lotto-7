package lotto;

import java.util.List;
import java.util.Map;

public class Application {

    public static void main(String[] args) {

        final int numberOfLotto;
        final Lotto winNumbers;
        final int bonusNumber;

        UserInput userInput = new UserInput();

        while (true) {
            try {
                userInput.purchaseAmountInput();
                break;
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }

        numberOfLotto = userInput.getNumberOfLotto();
        LottoList lottoList = new LottoList(numberOfLotto);

        lottoList.printLottoList();

        while (true) {
            try {
                userInput.winNumbersInput();
                break;
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }

        while (true) {
            try {
                userInput.bonusNumberInput();
                break;
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }

        winNumbers = new Lotto(userInput.getWinNumbers());
        bonusNumber = userInput.getBonusNumber();


        Statistics statistics = new Statistics(lottoList.getLottoList(), winNumbers, bonusNumber);

        Map<Rank, Integer> statisticResult = statistics.statistic();
        double profitRate = statistics.calculateProfitRate();

        ResultOutput resultOutput = new ResultOutput(statisticResult, profitRate);

        resultOutput.printResult();
    }
}
