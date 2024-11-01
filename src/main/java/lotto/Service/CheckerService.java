package lotto.Service;

import java.util.List;

public class CheckerService {
    private int firstPrizeCount = 0;
    private int secondPrizeCount = 0;
    private int thirdPrizeCount = 0;
    private int fourthPrizeCount = 0;
    private int fifthPrizeCount = 0;
    private boolean hasBonus;

    public int countMatches(List<Integer> lottoNumbers, List<Integer> winningNumbers) {
        int count = 0;
        for (int number : lottoNumbers) {
            if (winningNumbers.contains(number)) {
                count++;
            }
        }
        return count;
    }

    public void matchBonus(List<Integer> lotto, int bonusNumber) {
        hasBonus = lotto.contains(bonusNumber);
    }

    public void isDetermine(int matchCount) {
        if (matchCount == 6) {
            firstPrizeCount++;
        }
        if (matchCount == 5 && hasBonus) {
            secondPrizeCount++;
        }
        if (matchCount == 5 && !hasBonus) {
            thirdPrizeCount++;
        }
        if (matchCount == 4) {
            fourthPrizeCount++;
        }
        if (matchCount == 3) {
            fifthPrizeCount++;
        }
        hasBonus = false;
    }

    public void result() {
        System.out.println(
                "1등 : " + firstPrizeCount + "\n2등 : " + secondPrizeCount + "\n3등 : " + thirdPrizeCount + "\n4등 : "
                        + fourthPrizeCount + "\n5등 : " + fifthPrizeCount);
    }
}
