package lotto;

import java.util.Arrays;
import java.util.List;

public class WinningLotto {

    private Lotto mainNumbers;
    private int bonusNumber;

    public WinningLotto(Lotto lotto, int bonusNumber){
        if(lotto.hasValue(bonusNumber)) throw new IllegalArgumentException("보너스 번호는 당첨 번호와 중복되면 안됩니다.");
        this.mainNumbers = lotto;
        this.bonusNumber = bonusNumber;
    }

}
