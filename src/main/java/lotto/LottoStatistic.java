package lotto;

import java.util.List;

public class LottoStatistic {
    private static final int LOTTO_PRICE = 1000;
    private Integer count3Match;
    private Integer count4Match;
    private Integer count5Match;
    private Integer count5MatchWithBonus;
    private Integer count6Match;
    private double returnRate;
    private Integer lottoCount;


    public LottoStatistic(List<LottoResult> lottoResults) {
        countMatchedNumber(lottoResults);
        this.lottoCount = lottoResults.size();
        this.returnRate = calculateReturnRate();
    }

    private void countMatchedNumber(List<LottoResult> lottoResults) {
        this.count3Match = (int) lottoResults.stream()
                .filter(lottoResult -> lottoResult.getRank() == 5).count();

        this.count4Match = (int) lottoResults.stream()
                .filter(lottoResult -> lottoResult.getRank() == 4).count();

        this.count5Match = (int) lottoResults.stream()
                .filter(lottoResult -> lottoResult.getRank() == 2).count();

        this.count5MatchWithBonus = (int) lottoResults.stream()
                .filter(lottoResult -> lottoResult.getRank() == 3).count();

        this.count6Match = (int) lottoResults.stream()
                .filter(lottoResult -> lottoResult.getRank() == 1).count();
    }

    private double calculateReturnRate() {
        long lottoExpense = lottoCount * LOTTO_PRICE;
        long totalPrize = calculateTotalPrize();
        return (double) totalPrize / lottoExpense * 100;
    }

    private long calculateTotalPrize() {
        long totalPrize = 0L;
        totalPrize += (long) count3Match * LottoPrize.FIFTH_PRIZE.getPrizeAmountAsInteger();
        totalPrize += (long) count4Match * LottoPrize.FOURTH_PRIZE.getPrizeAmountAsInteger();
        totalPrize += (long) count5Match * LottoPrize.THIRD_PRIZE.getPrizeAmountAsInteger();
        totalPrize += (long) count5MatchWithBonus * LottoPrize.SECOND_PRIZE.getPrizeAmountAsInteger();
        totalPrize += (long) count6Match * LottoPrize.FIRST_PRIZE.getPrizeAmountAsInteger();
        return totalPrize;
    }

    public double getReturnRate() {
        return returnRate;
    }

    public Integer getCount3Match() {
        return count3Match;
    }

    public Integer getCount4Match() {
        return count4Match;
    }

    public Integer getCount5Match() {
        return count5Match;
    }

    public Integer getCount5MatchWithBonus() {
        return count5MatchWithBonus;
    }

    public Integer getCount6Match() {
        return count6Match;
    }
}
