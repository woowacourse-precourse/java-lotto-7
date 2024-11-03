package lotto.Service;

import lotto.model.BonusNumber;
import lotto.model.Lotto;
import lotto.model.UserNumber;
import lotto.model.UserNumbers;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class LottoService {
    private UserNumbers userNumbers;
    private Lotto lotto;
    private BonusNumber bonusNumber;
    private List<Integer> results;


    public void generateUserNumbers(int purchaseAmount) {
        userNumbers = new UserNumbers(purchaseAmount);
    }

    public void generateLotto(String inputValue) {
        String[] lottoNumber = inputValue.split(",");
        List<Integer> lottoNumberList = Arrays.stream(lottoNumber)
                .map(Integer::parseInt)
                .collect(Collectors.toList());
        lotto = new Lotto(lottoNumberList);
    }

    public void generateBonusNumber(int number) {
        bonusNumber = new BonusNumber(number, lotto);
    }

    public List<Integer> calculateResult() {
        results = new ArrayList<>(Arrays.asList(0, 0, 0, 0, 0));

        for (UserNumber userNumber : userNumbers.getUserNumbers()) { //이 로직은 UserNumbers에서 실행되는 것보다 여기가 좋겠지?
            long matchingCount = userNumber.getUserNumber().stream()
                    .filter(lotto.getNumbers()::contains)
                    .count();
            setResults(matchingCount, userNumber);
        }
        return results;
    }

    private void setResults(long matchingCount, UserNumber userNumber) {
        int bonus = this.bonusNumber.getNumber(); //상수로 관리
        if (matchingCount == 3) {
            results.set(0, results.get(0) + 1);
            return;
        }
        if (matchingCount == 4) {
            results.set(1, results.get(1) + 1);
            return;
        }
        if (matchingCount == 5) {
            if (userNumber.getUserNumber().contains(bonus)) {
                results.set(3, results.get(3) + 1);
                return;
            }
            results.set(2, results.get(2) + 1);
            return;
        }
        if (matchingCount == 6) {
            results.set(4, results.get(4) + 1);
        }
    }

    public double calculateRate() {
        //System.out.println(getProfit() / (double) getInvestmentCost());
        return roundOff((getProfit() / (double) getInvestmentCost()) * 100);
    }

    private double roundOff(double number) {
        return Math.round(number * 10) / 10.0;
    }

    private long getInvestmentCost() {
        return userNumbers.getPurchaseAmount();
    }

    private long getProfit() {
        return 5000L * results.get(0) + 50000L * results.get(1) + 1500000L * results.get(2) + 30000000L * results.get(3) + 2000000000L * results.get(4);
    } //int의 범위를 고려해야 하는가?

    public UserNumbers getUserNumbers() {
        return userNumbers;
    }
}
