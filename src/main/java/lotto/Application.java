package lotto;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class Application {
    public static void main(String[] args) {

        Lotto.printRequestingMoneyInput();

        String moneyInput = Lotto.getUserInput();
        int lottoPurchase = Lotto.getLottoPurchaseCount(moneyInput);

        System.out.println();
        System.out.println(lottoPurchase + "개를 구매했습니다.");

        List<List<Integer>> randomLottoBundle = new ArrayList<List<Integer>>();

        for (int n=0; n<lottoPurchase; n++) {
            List<Integer> randomLotto = Lotto.getOneRandomLotto();
            randomLotto.sort(Comparator.naturalOrder());
            randomLottoBundle.add(randomLotto);

            System.out.println(randomLotto);
        }


        Lotto.printRequestingLottoWinningNumbers();

        String numbersInput = Lotto.getUserInput();
        Lotto winningNumbers = Lotto.getWinningNumbers(numbersInput);

        System.out.println();


        Lotto.printRequestingBonusNumber();

        String numberInput = Lotto.getUserInput();
        int bonusNumber = Lotto.getBonusNumber(winningNumbers, numberInput);


        List<Integer> prizeCount = new ArrayList<>(List.of(0, 0, 0, 0, 0));

        for (List<Integer> randomNumbers : randomLottoBundle) {
            int numberMatchCount = Lotto.numberMatchCount(winningNumbers, randomNumbers);
            boolean matchBonusNumber = randomNumbers.contains(bonusNumber);

            LottoPrize.getIndividualResult(numberMatchCount, matchBonusNumber, prizeCount);
        }

        LottoPrize.printResult(prizeCount);
    }
}