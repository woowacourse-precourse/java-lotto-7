package lotto.model;

import static lotto.constant.DrawType.NO_MATCH;

import java.util.Objects;
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

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof DrawResult that)) {
            return false;
        }
        return result == that.result && hasBonusResult == that.hasBonusResult;
    }

    @Override
    public int hashCode() {
        return Objects.hash(result, hasBonusResult);
    }

}
