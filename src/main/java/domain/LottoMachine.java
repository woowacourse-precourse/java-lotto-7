package domain;

import java.util.ArrayList;
import java.util.List;

public class LottoMachine {

    private List<Integer> winningNumbers;
    private int bonusNumber;

    public LottoMachine(List<Integer> winningNumbers, int bonusNumber) {
        this.winningNumbers = winningNumbers;
        this.bonusNumber = bonusNumber;
    }
}
