package lotto.dto;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class WinningLotto extends Lotto{
    private int bonusNumber;
    public WinningLotto(List<Integer> numbers, int bonusNumber) {
        super(numbers);
        this.bonusNumber = bonusNumber;
    }

    private void validateUniqueNumbers(List<Integer> numbers, int bonusNumber){
        Set<Integer> numSet = new HashSet<>(numbers);

        if(!numSet.add(bonusNumber)){
            throw new IllegalArgumentException("[ERROR] 보너스 번호에 중복된 값이 입력되었습니다.");
        }
    }
}
