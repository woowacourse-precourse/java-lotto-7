package lotto.Domain;

import java.util.List;

public class WinningLotto {
    private final List<Integer> winningNumbers;
    private final int bonusNumber;

    public WinningLotto(List<Integer> numbers, int bonusNumber) {
        this.winningNumbers = new Lotto(numbers).getNumbers();
        this.bonusNumber = bonusNumber;
    }

    public int countWinningNumbers(List<Integer> lotto) {
        int winningCount = 0;
        for (Integer number : winningNumbers) {
            if (matchWinningBonusNumber(lotto, number)) {
                System.out.println("당첨" + number);
                winningCount++;
            }
        }
        return winningCount;
    }

    public int countBonusNumbers(List<Integer> lotto) {
        if (matchWinningBonusNumber(lotto, bonusNumber)) {
            return 1;
        }
        return 0;
    }

    private boolean matchWinningBonusNumber(List<Integer> numbers, int targetNumber) {
        // 정렬 안해서 바이너리 서치 말고 선형 서치 선택
        return numbers.contains(targetNumber);
    }
}
