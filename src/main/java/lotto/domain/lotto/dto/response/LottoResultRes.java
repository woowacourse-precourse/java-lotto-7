package lotto.domain.lotto.dto.response;

import lotto.domain.lotto.domain.LottoResult;

public class LottoResultRes {
    private final int matchCount;
    private final int prize;
    private final String description;
    private final int count;

    private LottoResultRes(int matchCount, int prize, String description, int count) {
        this.matchCount = matchCount;
        this.prize = prize;
        this.description = description;
        this.count = count;
    }

    public static LottoResultRes of(LottoResult result, int count) {
        return new LottoResultRes(
                result.getMatchCount(),
                result.getPrize(),
                getDescription(result),
                count
        );
    }

    private static String getDescription(LottoResult result) {
        if (result == LottoResult.SECOND) {
            return "5개 일치, 보너스 볼 일치";
        }
        if (result == LottoResult.NONE) {
            return "미당첨";
        }
        return String.format("%d개 일치", result.getMatchCount());
    }

    public String getResultMessage() {
        return String.format("%s (%d원) - %d개", description, prize, count);
    }
}