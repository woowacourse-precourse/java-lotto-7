package lotto.model;

import java.util.List;

public class Winning {
    List<Long> winNumbers;
    Long bonusNumber;

    public Winning(List<Long> winNumbers, Long bonusNumber) {
        this.winNumbers = winNumbers;
        this.bonusNumber = bonusNumber;
    }
}
