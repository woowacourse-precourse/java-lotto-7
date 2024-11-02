package lotto.dto;

public class WinningLottoResultDTO {
    private final int matchedCount;
    private final String prize;
    private final int count;

    public WinningLottoResultDTO(int matchedCount, String prize, int count) {
        this.matchedCount = matchedCount;
        this.prize = prize;
        this.count = count;
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
}
