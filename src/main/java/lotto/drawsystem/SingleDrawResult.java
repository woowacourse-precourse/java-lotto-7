package lotto.drawsystem;

import java.util.List;

public class SingleDrawResult {
        List<Integer> mainNumbers;
        Integer bonusNumber;

        public SingleDrawResult(List<Integer> mainNumbers, Integer bonusNumber) {
            this.mainNumbers = mainNumbers;
            this.bonusNumber = bonusNumber;
    }
}
