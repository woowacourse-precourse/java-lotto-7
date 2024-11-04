package lotto.validator.model;

import lotto.entity.BonusNumber;
import lotto.entity.WinningNumber;
import lotto.validator.Validator;

import java.util.HashSet;

// 로또 결과 ( 당첨 번호, 보너스 번호 ) 검증 클래스
public class LottoResultValidator implements Validator {
    private final WinningNumber winningNumber;
    private final BonusNumber bonusNumber;

    public LottoResultValidator(WinningNumber winningNumbers, BonusNumber bonusNumber){
        this.winningNumber = winningNumbers;
        this.bonusNumber = bonusNumber;
    }

    @Override
    public void validate() {
        isDuplicated();
    }

    private void isDuplicated(){
        HashSet<Integer> set = new HashSet<>(winningNumber.getValue().getNumbers());
        set.add(bonusNumber.getValue());

        if(winningNumber.getValue().getNumbers().size() == set.size()){
            throw new IllegalArgumentException("[ERROR] 당첨 번호와 보너스 번호는 중복 될 수 없습니다.");
        }
    }
}
