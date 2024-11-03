package lotto.dto;

public class LottoResultDto {
    private final String matchDescription;
    private final long prize;
    private final int count;

    public LottoResultDto(String matchDescription, long prize, int count) {
        this.matchDescription = matchDescription;
        this.prize = prize;
        this.count = count;
    }

    public String getMatchDescription() {
        return matchDescription;
    }

    public long getPrize() {
        return prize;
    }

    public int getCount() {
        return count;
    }
}