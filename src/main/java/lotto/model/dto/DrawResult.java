package lotto.model.dto;

import static lotto.constant.DrawType.NO_MATCH;

import lotto.constant.DrawType;

public class DrawResult {

    private final int result;
    private final boolean hasBonusResult;

    public DrawResult(int result, boolean hasBonusResult) {
        this.result = result;
        this.hasBonusResult = hasBonusResult;
    }

    public DrawType formatDrawResult() {
        for (DrawType type : DrawType.values()) {
            if (type.matches(String.valueOf(this.result), this.hasBonusResult)) {
                return type;
            }
        }
        return NO_MATCH;
    }

}
