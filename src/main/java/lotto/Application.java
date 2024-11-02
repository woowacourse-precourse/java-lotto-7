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

        numberOfLotto = userInput.getNumberOfLotto();
        winNumbers = new Lotto(userInput.getWinNumbers());
        bonusNumber = userInput.getBonusNumber();

        LottoList lottoList = new LottoList(numberOfLotto);

        Statistics statistics = new Statistics(lottoList.getLottoList(), winNumbers, bonusNumber);

        Map<Rank, Integer> statisticResult = statistics.statistic();
    }
}
