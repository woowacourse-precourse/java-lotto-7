package lotto;

import java.util.Arrays;
import java.util.List;

public class WinningLotto {

    private Lotto mainNumbers;
    private int bonusNumber;

    public WinningLotto(Lotto lotto, int bonusNumber){
        this.mainNumbers = lotto;
        this.bonusNumber = bonusNumber;
    }

}
