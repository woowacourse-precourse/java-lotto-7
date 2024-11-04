package lotto;

import java.util.List;
import java.util.HashSet;
import java.util.Set;

public class WinningNumbers {
    private final List<Integer> winningNumbers;
    private final int bonusNumber;

    public WinningNumbers(List<Integer> winningNumbers, int bonusNumber){
        validate(winningNumbers, bonusNumber);
        this.winningNumbers = winningNumbers;
        this.bonusNumber = bonusNumber;
    }
    private void validate(List<Integer> winningNumbers, int bonusNumber){
        if(winningNumbers.size() !=6 || winningNumbers.contains(bonusNumber)){
            throw new IllegalArgumentException("[ERROR]");
        }
        Set<Integer> uniqueNumbers = new HashSet<>(winningNumbers);
        if (uniqueNumbers.size() != 6) {
            throw new IllegalArgumentException("[ERROR] 당첨 번호에 중복된 숫자가 있습니다.");
        }

        for (Integer number : winningNumbers) {
            if (number < 1 || number > 45) {
                throw new IllegalArgumentException("[ERROR] 당첨 번호는 1에서 45 사이여야 합니다.");
            }
        }

        if (winningNumbers.contains(bonusNumber)) {
            throw new IllegalArgumentException("[ERROR] 보너스 번호는 당첨 번호와 중복될 수 없습니다.");
        }

        if (bonusNumber < 1 || bonusNumber > 45) {
            throw new IllegalArgumentException("[ERROR] 보너스 번호는 1에서 45 사이여야 합니다.");
        }
    }
    public int getBonusNumber(){
        return bonusNumber;
    }
    public int countMatchingNumbers(List<Integer> numbers){
        return (int) numbers.stream().filter(winningNumbers::contains).count();
    }
}
