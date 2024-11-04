package lotto;

import java.util.Objects;

public class LottoResult {
    private int jackpotCount;
    private JackpotAmount jackpotAmount;
    public LottoResult(int jackpotCount, boolean isBonus) {
        this.jackpotCount = jackpotCount;
        this.jackpotAmount = JackpotAmount.getMatchLottoJackpotAmount(jackpotCount, isBonus);
    }

    public int getJackpotCount() {
        return jackpotCount;
    }

    public JackpotAmount getJackpotAmount() {
        return jackpotAmount;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        LottoResult that = (LottoResult) o;
        return jackpotCount == that.jackpotCount && jackpotAmount == that.jackpotAmount;
    }

    @Override
    public int hashCode() {
        return Objects.hash(jackpotCount, jackpotAmount);
    }
}
