package lotto;

import camp.nextstep.edu.missionutils.Randoms;
import lotto.Domain.Lotto;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Controller {
    final static Integer DIVISOR = 1000;
    InputView inputView = new InputView();
    OutputView outputView = new OutputView();
    private static final int[] PRIZE_MONEY = {0, 0, 0, 5000, 50000, 1500000, 2000000000, 30000000};

    public void run() {
        String userInputPurchasePrice = inputView.getPurchasePrice();

        int userNumber = stringToCount(userInputPurchasePrice);
        outputView.answerPurchase(userNumber);

        List<Lotto> lottos = new ArrayList<>();
        for (int i = 0; i < userNumber; i++) {
            List<Integer> numbers = new ArrayList<>(Randoms.pickUniqueNumbersInRange(1, 45, 6));
            Collections.sort(numbers);
            Lotto lotto = new Lotto(numbers);
            lottos.add(lotto);
        }

        for (Lotto lotto : lottos) {
            System.out.println(lotto.getNumbers().toString());
        }


        String userInputJackpotNumber = inputView.getJackpotNumbers();
        Lotto JackpotNumbers = new Lotto(parseJackpotNumbers(userInputJackpotNumber));

        outputView.askBonusNumber();
        String userInputBonusNumber = inputView.getBonusNumber(JackpotNumbers);
        int bonusNumber = Integer.parseInt(userInputBonusNumber);

        List<Integer> correctNumbersCount = new ArrayList<>(Arrays.asList(0, 0, 0, 0, 0, 0, 0, 0));
        for (int i = 0; i < userNumber; i++) {
            int ans = jackpotAnalysis(lottos.get(i), JackpotNumbers, bonusNumber);
            correctNumbersCount.set(ans, correctNumbersCount.get(ans) + 1);
        }

        double totalGain = jackpotTotalGain(userNumber, correctNumbersCount);
        outputView.jackpotAnalysis(correctNumbersCount.get(3), correctNumbersCount.get(4),
                correctNumbersCount.get(5), correctNumbersCount.get(7), correctNumbersCount.get(6), totalGain);

    }

    private int stringToCount(String userInput) {
        return Integer.parseInt(userInput) / DIVISOR;
    }

    private List<Integer> parseJackpotNumbers(String userInput) {
        return Stream.of(userInput.split(","))
                .map(Integer::parseInt)
                .collect(Collectors.toList());
    }

    private int jackpotAnalysis(Lotto lotto, Lotto jackpotNumbers, int bonusNumber) {
        List<Integer> commonNumbers = new ArrayList<>(lotto.getNumbers());
        commonNumbers.retainAll(jackpotNumbers.getNumbers());

        int ans = commonNumbers.size();
        if (ans == 5 && lotto.getNumbers().contains(bonusNumber)) {
            ans = 7; // 보너스 번호 포함 시 별도의 상태로 표시
        }
        return ans;
    }

    private double jackpotTotalGain(int userNumber, List<Integer> correctNumbersCount) {
        double totalGain = 0;
        for (int i = 3; i < PRIZE_MONEY.length; i++) {
            totalGain += correctNumbersCount.get(i) * PRIZE_MONEY[i];
        }
        return totalGain / (userNumber * 10);
    }
}
