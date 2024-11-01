package lotto;

import java.util.List;

public class Winning {
    private final List<Integer> winningNumbers;
    private final int bonusNumber;
    public Winning(List<Integer> winningNumbers, int bonusNumber) {
        if(winningNumbers.size() != 6){
            throw new IllegalArgumentException("[ERROR] 당첨 번호는 6개입니다.");
        }
        for(int i = 0; i < winningNumbers.size(); i++){
            if(winningNumbers.get(i) < 1||winningNumbers.get(i) > 45||countOccurrences(winningNumbers, winningNumbers.get(i))>1){
                throw new IllegalArgumentException("[ERROR] 당첨 번호는 중복될 수 없는 1~45 사이의 숫자입니다.");
            }
        }
        if(bonusNumber<1||bonusNumber>45||winningNumbers.contains(bonusNumber)){
            throw new IllegalArgumentException("[ERROR] 보너스 번호는 당첨 번호와 중복되지 않는 1~45 사이의 숫자입니다.");
        }
        this.winningNumbers = winningNumbers;
        this.bonusNumber = bonusNumber;
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


}
