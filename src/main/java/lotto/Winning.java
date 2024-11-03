package lotto;

import java.util.List;

public class Winning {
    private final int[] winningNumbers;
    private final int bonusNumber;

    public Winning(int[] winningNumbers, int bonusNumber) {
        validateWinningNumbers(winningNumbers);
        validateBonus(winningNumbers, bonusNumber);
        this.winningNumbers = winningNumbers;
        this.bonusNumber = bonusNumber;
    }

    private void validateWinningNumbers(int[] numbers) {
        if (numbers.length != 6) {
            throw new IllegalArgumentException("[ERROR] 당첨 번호는 6개여야 합니다.");
        }
        for (int number : numbers) {
            if (number < 1 || number > 45 || containsDuplicate(numbers, number)) {
                throw new IllegalArgumentException("[ERROR] 당첨 번호는 중복될 수 없는 1~45 사이의 숫자여야 합니다.");
            }
        }
    }

    private void validateBonus(int[] winningNumbers, int bonusNumber){
        if(bonusNumber<1||bonusNumber>45||containsDuplicate(winningNumbers,bonusNumber)){
            throw new IllegalArgumentException("[ERROR] 보너스 번호는 당첨 번호와 중복되지 않는 1~45 사이의 숫자입니다.");
        }
    }

    public int checkLotto(Lotto lotto) {
        int matchCount = countMatches(lotto.getNumbers(), winningNumbers);
        boolean hasBonus = lotto.getNumbers().contains(bonusNumber);
        return LottoRank.valueOf(matchCount, hasBonus).ordinal();
    }

    private int countMatches(List<Integer> userNumbers, int[] winningNumbers) {
        int count = 0;
        for(int number : userNumbers) {
            if(contains(winningNumbers, number)) {
                count++;
            }
        }
        return count;
    }

    private boolean containsDuplicate(int[] numbers, int target) {
        int count = 0;
        for (int number : numbers) {
            if (number == target) {
                count++;
                if (count > 1) {
                    return true;
                }
            }
        }
        return false;
    }

    private boolean contains(int[] numbers, int target) {
        for (int number : numbers) {
            if (number == target) return true;
        }
        return false;
    }
}
