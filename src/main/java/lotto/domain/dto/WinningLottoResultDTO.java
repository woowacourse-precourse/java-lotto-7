package lotto.dto;

public class WinningLottoResultDTO {
    private final int matchedCount;
    private final String prize;
    private final int count;
    private final boolean hasBonus;

    public WinningLottoResultDTO(int matchedCount, String prize, int count, boolean hasBonus) {
        this.matchedCount = matchedCount;
        this.prize = prize;
        this.count = count;
        this.hasBonus = hasBonus;
    }

    public int getMatchedCount() {
        return matchedCount;
    }

    public String getPrize() {
        return prize;
    }

    public int getCount() {
        return count;
    }

    public boolean hasBonus() {
        return hasBonus;
    }
}
