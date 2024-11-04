package lotto.ui;

import lotto.store.lotto.winner.LottoRank;

import java.util.List;

public class LottoResult {
    private static final String RESULT_TITLE = "당첨 통계\n----\n";
    private static final String RANK_INFO_FORMAT = "%d개 일치%s (%s원) - %d개";
    private static final String RATE_OF_RETURN_PERCENT_FORMAT = "총 수익률은 %.1f%%입니다.";
    private static final String BONUS_BALL_MESSAGE = ", 보너스 볼 일치";
    private static final String EMPTY_MESSAGE = "";

    private final List<LottoRank> buyerLottoRanks;
    private final double rateOfReturnPercent;


    public LottoResult(List<LottoRank> lottoRanks, double rateOfReturnPercent) {
        this.buyerLottoRanks = List.copyOf(lottoRanks);
        this.rateOfReturnPercent = rateOfReturnPercent;
    }

    public List<LottoRank> getBuyerLottoRanks() {
        return buyerLottoRanks;
    }

    public double getRateOfReturnPercent() {
        return rateOfReturnPercent;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(RESULT_TITLE);
        for (LottoRank rank : LottoRank.values()) {
            if(rank == LottoRank.FAIL)
                continue;
            sb.append(createRankInfoMessage(rank)).append("\n");
        }

        sb.append(RATE_OF_RETURN_PERCENT_FORMAT.formatted(rateOfReturnPercent));
        return sb.toString();
    }

    private String createRankInfoMessage(LottoRank rank) {
        return RANK_INFO_FORMAT.formatted(
                rank.matchCountCondition(),
                getBonusMessage(rank.bonusMatchCondition()),
                rank.price(),
                count(buyerLottoRanks, rank)
        );
    }

    private String getBonusMessage(boolean hasBonusBall) {
        if(hasBonusBall)
            return BONUS_BALL_MESSAGE;
        return EMPTY_MESSAGE;
    }

    private int count(List<LottoRank> ranks, LottoRank found) {
        return (int) ranks.stream().filter(rank -> rank.equals(found)).count();
    }
}
