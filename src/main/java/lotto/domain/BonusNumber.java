package lotto.domain;

import java.util.ArrayList;
import java.util.List;

public class BonusNumber {

    private final int bonusNumber;

    public BonusNumber(String inputBonusNumber) {
        this.bonusNumber = validateInteger(inputBonusNumber);

    }

    private int validateInteger(String inputBonusNumber) {
        int number;
        try {
            number = Integer.parseInt(inputBonusNumber);
        } catch (NumberFormatException e) {
            throw new NumberFormatException();
        }

        return number;
    }

    public int getBonusNumber() {
        return bonusNumber;
    }
}
