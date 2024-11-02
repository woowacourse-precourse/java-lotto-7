package lotto.enums;

import java.text.NumberFormat;
import java.util.Arrays;
import java.util.Locale;
import java.util.Map;
import java.util.stream.Collectors;

public enum LottoRank {
    FIRST(6, 2_000_000_000L),
    SECOND(5, 30_000_000L),
    THIRD(5, 1_500_000L),
    FOURTH(4, 50_000L),
    FIFTH(3, 5_000L),
    NO_REWARD(0, 0L);

    private final int matchCount;
    private final long prizeMoney;

    LottoRank(int matchCount, long prizeMoney) {
        this.matchCount = matchCount;
        this.prizeMoney = prizeMoney;
    }

    public int getMatchCount() {
        return matchCount;
    }

    public long getMoney() {
        return prizeMoney;
    }

    public static LottoRank of(int matchCount, boolean hasBonusNum) {
        if (matchCount == SECOND.matchCount && hasBonusNum) {
            return SECOND;
        }

        return Arrays.stream(values())
                .filter(lottoRank -> lottoRank.matchCount == matchCount)
                .findFirst()
                .orElse(NO_REWARD);
    }

    public static Map<LottoRank, String> getRankInfo() {
        return Arrays.stream(values())
                .filter(lottoRank -> lottoRank != NO_REWARD)
                .collect(Collectors.toMap(
                        lottoRank -> lottoRank,
                        lottoRank -> String.format("%s개 일치 (%s원)", lottoRank.getMatchCount(), formatPrizeMoney(lottoRank.getMoney()))
                ));
    }

    private static String formatPrizeMoney(long prizeMoney) {
        NumberFormat numberFormat = NumberFormat.getInstance(Locale.KOREA);
        return numberFormat.format(prizeMoney);
    }
}
