package lotto.model;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import static lotto.enums.Constants.*;
import static lotto.enums.ExceptionMessage.*;

public class WinningNumber {

    private final List<Integer> winningNumber;
    private final BonusNumber bonusNumber;

    public WinningNumber(Lotto lotto, BonusNumber bonusNumber) {
        this.winningNumber = lotto.getNumbers();
        this.bonusNumber = bonusNumber;
    }


    public int getBonusNumber() {
        return bonusNumber.getBonusNumber();
    }

    public List<Integer> getWinningNumber() {
        return winningNumber;
    }
}
