package lotto.domain;

public record WinningResult(int matchCount, boolean matchBonus) {
    public Prize calculatePrize() {
        if (matchCount == 6) {
            return Prize.FIRST;
        }
        if (matchCount == 5 && matchBonus) {
            return Prize.SECOND;
        }
        if (matchCount == 5) {
            return Prize.THIRD;
        }
        if (matchCount == 4) {
            return Prize.FOURTH;
        }
        if (matchCount == 3) {
            return Prize.FIFTH;
        }
        return Prize.NONE;
    }
}