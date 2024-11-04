package lotto;

import java.util.Objects;

public class JackpotResult {
    private int jackpotCount;
    private JackpotAmount jackpotAmount;
    public JackpotResult(int jackpotCount, boolean isBonus) {
        this.jackpotCount = jackpotCount;
        this.jackpotAmount = JackpotAmount.getMatchLottoJackpotAmount(jackpotCount, isBonus);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        JackpotResult that = (JackpotResult) o;
        return jackpotCount == that.jackpotCount && jackpotAmount == that.jackpotAmount;
    }

    @Override
    public int hashCode() {
        return Objects.hash(jackpotCount, jackpotAmount);
    }
}
