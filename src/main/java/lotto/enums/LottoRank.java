package lotto.enums;

import lotto.dto.MatchResult;

import java.text.NumberFormat;
import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.Locale;
import java.util.Map;
import java.util.stream.Collectors;

public enum LottoRank {
    NO_REWARD(0, 0L),
    FIFTH(3, 5_000L),
    FOURTH(4, 50_000L),
    THIRD(5, 1_500_000L),
    SECOND(5, 30_000_000L),
    FIRST(6, 2_000_000_000L);

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

    public static LottoRank from(MatchResult matchResult) {
        if (matchResult.matchCount() == SECOND.matchCount && matchResult.containBonusNumber()) {
            return SECOND;
        }

        return Arrays.stream(values())
                .filter(lottoRank -> lottoRank.matchCount == matchResult.matchCount())
                .findFirst()
                .orElse(NO_REWARD);
    }

    public static Map<LottoRank, String> getRankInfo() {
        return Arrays.stream(values())
                .filter(lottoRank -> lottoRank != NO_REWARD)
                .collect(Collectors.toMap(
                        lottoRank -> lottoRank,
                        LottoRank::generateRankMessage,
                        (oldValue, newValue) -> oldValue,
                        LinkedHashMap::new
                ));
    }

    private static String formatPrizeMoney(long prizeMoney) {
        NumberFormat numberFormat = NumberFormat.getInstance(Locale.KOREA);
        return numberFormat.format(prizeMoney);
    }

    private String generateRankMessage() {
        if (this == LottoRank.SECOND) {
            return String.format("%s개 일치, 보너스 볼 일치 (%s원)", getMatchCount(), formatPrizeMoney(getMoney()));
        }
        return String.format("%s개 일치 (%s원)", getMatchCount(), formatPrizeMoney(getMoney()));
    }
}
