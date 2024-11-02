package lotto.model;

import java.util.HashSet;
import java.util.List;

public class Bonus {

    private final Lotto lotto;
    private final Integer bonusNumber;

    public Bonus(Lotto lotto, Integer bonusNumber) {
        this.lotto = lotto;
        this.bonusNumber = bonusNumber;
        validateDuplicationBonus(bonusNumber);
    }

    private void validateDuplicationBonus(Integer bonusNumber){
        List<Integer> numbers = lotto.getNumbers();
        HashSet<Integer> uniqueNumbers = new HashSet<>(numbers);
        boolean isAdded = uniqueNumbers.add(bonusNumber);

        if(!isAdded){
            throw new IllegalArgumentException("[ERROR] 보너스 번호는 입력하신 로또 번호와 중복되지 않아야 합니다.");
        }
    }

}
