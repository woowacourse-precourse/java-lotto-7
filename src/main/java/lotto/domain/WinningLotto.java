package lotto.domain;

import java.util.List;

public class WinningLotto extends Lotto{
    private final int bonusNumber;

    public WinningLotto(List<Integer> numbers, int bonusNumber) {
        super(numbers);

        validateBonusNumber(bonusNumber);
        this.bonusNumber = bonusNumber;
    }
    public int getBonusNumber(){
        return bonusNumber;
    }
    private void validateBonusNumber(int bonus){
        new LottoNumber(bonus);
        if(getNumbers().contains(bonus)){
            throw new IllegalArgumentException("[ERROR] 보너스 번호는 당첨 번호와 중복될 수 없습니다.");
        }
    }

}
