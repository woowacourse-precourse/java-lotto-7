package lotto.shop.bandingmachine;

import java.util.Collections;
import java.util.List;
import lotto.MessageCenter;

public class DrawnNumbers {

    private List<Integer> mainNumbers;
    private Integer bonusNumber;

    private DrawnNumbers() {}

    static DrawnNumbers create() {
        return new DrawnNumbers();
    }

    static DrawnNumbers forTest() {
        return new DrawnNumbers();
    }

    public DrawnNumbers getDrawnNumbers() {
        validateBothNotNull();
        return this;
    }

    public List<Integer> getMainNumbers() {
        validateMainNotNull();
        return mainNumbers;
    }

    public Integer getBonusNumber() {
        validateBothNotNull();
        return bonusNumber;
    }

    void addMainNumbers(List<Integer> mainNumbers) {
        validateMainNull();
        this.mainNumbers = Collections.unmodifiableList(mainNumbers);
    }

    void addBonusNumber(Integer bonusNumber) {
        validateBonusNull();
        this.bonusNumber = bonusNumber;
    }

    private void validateMainNotNull() {
        if (mainNumbers == null) {
            throw new IllegalArgumentException(MessageCenter.ERROR_NULL.get());
        }
    }

    private void validateBothNotNull() {
        if (mainNumbers == null || bonusNumber == null) {
            throw new IllegalArgumentException(MessageCenter.ERROR_NULL.get());
        }
    }

    private void validateMainNull() {
        if (mainNumbers != null) {
            throw new IllegalArgumentException(MessageCenter.ERROR_NOTNULL.get());
        }
    }

    private void validateBonusNull() {
        if (bonusNumber != null) {
            throw new IllegalArgumentException(MessageCenter.ERROR_NOTNULL.get());
        }
    }
}
