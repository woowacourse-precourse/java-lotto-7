package lotto.domain;

import java.util.List;

public class WinningLotto {

    private final List<Integer> numbers;
    private final int bonusNumber;

    public WinningLotto(List<Integer> numbers, int bonusNumber) {
        if(numbers.contains(bonusNumber)){
            throw new IllegalArgumentException("[ERROR] 보너스 번호는 당첨번호와 중복될 수 없습니다.");
        }
        this.numbers = numbers;
        this.bonusNumber = bonusNumber;
    }

    public List<Integer> getNumbers(){
        return numbers;
    }

    public int getBonusNumber(){
        return bonusNumber;
    }

}
