package lotto;

import java.util.List;

public class Winning {
    private final List<Integer> winningNumbers;
    private final int bonusNumber;

    public Winning(List<Integer> winningNumbers, int bonusNumber) {
        validateWinningNumber(winningNumbers);
        validateBonus(winningNumbers, bonusNumber);
        this.winningNumbers = winningNumbers;
        this.bonusNumber = bonusNumber;
    }
    private void validateWinningNumber(List<Integer> numbers) {
        for(int i = 0; i < winningNumbers.size(); i++){
            if(winningNumbers.get(i) < 1||winningNumbers.get(i) > 45||countOccurrences(winningNumbers, winningNumbers.get(i))>1){
                throw new IllegalArgumentException("[ERROR] 당첨 번호는 중복될 수 없는 1~45 사이의 숫자입니다.");
            }
        }
    }
    private void validateBonus(List<Integer> winningNumbers, int bonusNumber){
        if(bonusNumber<1||bonusNumber>45||winningNumbers.contains(bonusNumber)){
            throw new IllegalArgumentException("[ERROR] 보너스 번호는 당첨 번호와 중복되지 않는 1~45 사이의 숫자입니다.");
        }
    }
    private int countOccurrences(List<Integer> numbers, int target) {
        int count = 0;
        for(int number : numbers) {
            if(number == target) {
                count++;
            }
        }
        return count;
    }

    public int checkLotto(Lotto lotto){
        int matchCount = countMatches(lotto.getNumbers(), winningNumbers);
        boolean hasBonus = lotto.getNumbers().contains(bonusNumber);

        if(matchCount == 6) return 1;
        if(matchCount == 5 && hasBonus) return 2;
        if(matchCount == 4 && hasBonus) return 3;
        if(matchCount == 3 && hasBonus) return 4;
        if(matchCount == 2 && hasBonus) return 5;
        return 0;
    }

    private int countMatches(List<Integer> userNumbers, List<Integer> winningNumbers) {
        int count = 0;
        for(int number : userNumbers) {
            if(winningNumbers.contains(number)) {
                count++;
            }
        }
        return count;
    }


}
