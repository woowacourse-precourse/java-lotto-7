package lotto;

import java.util.List;

public class CompareNumbers {
    List<List<Integer>> allLotteryNumbers = LottoInfo.AllLotteryNumbers;
    List<Integer> jackpotNumbers = JackpotNumbers.jackpotNumbers;
    int bonusNumber = BonusNumber.bonusNumber;
    int sameNumberCount;
    boolean bonusNumberExistence = false;
    LottoResult lottoResult = new LottoResult();

    public CompareNumbers() {
        lottoResult.initMatchCount();
        getTheNumberOfJackpot();
        lottoResult.printResult();
    }

    public void getTheNumberOfJackpot() {
        for (List<Integer> lotteryNumbers : allLotteryNumbers) {
            countMatches(lotteryNumbers);
            lottoResult.calculateResults(sameNumberCount, bonusNumberExistence);
            sameNumberCount = 0;
            bonusNumberExistence = false;
        }
    }

    private void countMatches(List<Integer> lotteryNumbers) {
        for (int number : lotteryNumbers) {
            isMatches(number);
        }
    }

    public void isMatches(int number) {
        if (jackpotNumbers.contains(number)) {
            sameNumberCount = sameNumberCount + 1;
        }
        if (bonusNumber == number) {
            bonusNumberExistence = true;
        }
    }
}
