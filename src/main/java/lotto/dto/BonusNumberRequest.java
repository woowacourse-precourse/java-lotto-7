package lotto.dto;

import lotto.domain.vo.Number;
import lotto.util.NumberParser;

public class BonusNumberRequest {
    private final Number bonusNumber;

    private BonusNumberRequest(Number bonusNumber) {
        this.bonusNumber = bonusNumber;
    }

    public static BonusNumberRequest from(String bonusNumber) {
        int parsedBonusNumber = NumberParser.parseIntegerFromString(bonusNumber);
        Number number = Number.newInstance(parsedBonusNumber);
        return new BonusNumberRequest(number);
    }

    public Number getBonusNumber() {
        return bonusNumber;
    }
}
