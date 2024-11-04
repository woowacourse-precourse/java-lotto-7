package lotto.dto;

import lotto.domain.LottoRank;

public class LottoRankDto {
    private final int matchCount;
    private final boolean isBonusMatch;
    private final int prize;
    private final long amount;

    private LottoRankDto(int matchCount, boolean isBonusMatch, int prize, long amount) {
        this.matchCount = matchCount;
        this.isBonusMatch = isBonusMatch;
        this.prize = prize;
        this.amount = amount;
    }

    public static LottoRankDto from(LottoRank lottoRank, Long amount) {
        return new LottoRankDto(lottoRank.getMatchCount(),
                lottoRank == LottoRank.SECOND, lottoRank.getPrize(), amount);
    }

    public int getMatchCount() {
        return matchCount;
    }

    public boolean isBonusMatch() {
        return isBonusMatch;
    }

    public long getAmount() {
        return amount;
    }

    public int getPrize() {
        return prize;
    }
}
