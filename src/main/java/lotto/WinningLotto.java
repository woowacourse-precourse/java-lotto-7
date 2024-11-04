package lotto;

import java.util.List;

public class WinningLotto extends Lotto{
    private final int bonusNumber;

    public WinningLotto(List<Integer> numbers, int bonusNumber) {
        super(numbers);
        validateBonusNumber(numbers,bonusNumber);
        this.bonusNumber = bonusNumber;
    }

    private void validateBonusNumber(List<Integer> numbers, int bonusNumber){
        if (numbers.contains(bonusNumber)){
            throw new IllegalArgumentException("[ERROR] 보너스 번호는 로또 번호와 중복될 수 없습니다.");
        }
        if(bonusNumber<1 || bonusNumber >45){
            throw new IllegalArgumentException(("[ERROR] 로또 번호는 1~45범위 내에 있어야 합니다."));
        }
    }

    public int getBonusNumber() {
        return bonusNumber;
    }
}
