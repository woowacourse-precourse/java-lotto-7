package lotto.domain;

import java.util.List;

import static lotto.Lotto.isDuplicate;

public class WinningNumber {
    private final List<Integer> numbers;
    private final int bonusNumber;

    public WinningNumber(List<Integer> numbers, int bonusNumber) {
        if(numbers.size() != 6){
            throw new IllegalArgumentException("[ERROR] 당첨 번호는 6개여야 합니다.");
        }
        if(isDuplicate(numbers)){
            throw new IllegalArgumentException("[ERROR] 로또 번호는 중복이 될 수 없습니다.");
        }
        this.numbers = numbers;
        this.bonusNumber = bonusNumber;
    }
    public int getBonusNumber(){
        return bonusNumber;
    }

    public boolean contains(int number){
        return numbers.contains(number);
    }
}
