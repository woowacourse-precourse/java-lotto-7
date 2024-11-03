package lotto.committee.drawsystem;

import java.util.Collections;
import java.util.List;
import lotto.MessageCenter;

public class WinningNumbers {

    private List<Integer> wonMainNumbers;
    private Integer wonBonusNumber;

    private WinningNumbers() {}

    static WinningNumbers create() {
        return new WinningNumbers();
    }

    static WinningNumbers forTest() {
        return new WinningNumbers();
    }

    public WinningNumbers getWinningNumbers() {
        validateBothNotNull();
        return this;
    }

    public List<Integer> getMainNumbers() {
        validateMainNotNull();
        return wonMainNumbers;
    }

    public Integer getBonusNumber() {
        validateBothNotNull();
        return wonBonusNumber;
    }

    void addMainNumbers(List<Integer> mainNumbers) {
        validateMainNull();
        this.wonMainNumbers = Collections.unmodifiableList(mainNumbers);
    }

    void addBonusNumber(Integer bonusNumber) {
        validateBonusNull();
        this.wonBonusNumber = bonusNumber;
    }

    private void validateMainNotNull() {
        if (wonMainNumbers == null) {
            throw new IllegalArgumentException(MessageCenter.ERROR_NULL.get());
        }
    }

    private void validateBothNotNull() {
        if (wonMainNumbers == null || wonBonusNumber == null) {
            throw new IllegalArgumentException(MessageCenter.ERROR_NULL.get());
        }
    }

    private void validateMainNull() {
        if (wonMainNumbers != null) {
            throw new IllegalArgumentException(MessageCenter.ERROR_NOTNULL.get());
        }
    }

    private void validateBonusNull() {
        if (wonBonusNumber != null) {
            throw new IllegalArgumentException(MessageCenter.ERROR_NOTNULL.get());
        }
    }
}
