package lotto;

import java.util.List;

public class LottoStatistics {
    private final LottoResult lottoResult;

    public LottoStatistics() {
        lottoResult = new LottoResult();
    }

    public LottoResult statistics(List<Lotto> issuedLottoTickets, Lotto winningLotto, LottoBonus lottoBonus) {
        setRankCountMap(issuedLottoTickets, winningLotto, lottoBonus);
        setRateReturn(issuedLottoTickets.size());

        return lottoResult;
    }

    private void setRankCountMap(List<Lotto> issuedLottoTickets, Lotto winningLotto, LottoBonus lottoBonus) {
        issuedLottoTickets.forEach(issuedLotto -> {
            int matchCount = LottoChecker.getMatchCount(issuedLotto, winningLotto);
            boolean isMatchBonus = LottoChecker.isMatchedBonus(issuedLotto, lottoBonus);

            LottoRank rank = LottoRank.getLottoRank(matchCount, isMatchBonus);

            if (!rank.equals(LottoRank.NONE)) {
                lottoResult.getRankCountMap().put(rank, lottoResult.getRankCountMap().get(rank) + 1);
            }
        });
    }

    private void setRateReturn(int issuedLottoCount) {
        int prize = getPrize();
        int amount = issuedLottoCount * 1000;
        double rateReturn = calculateRateReturn(amount, prize);

        lottoResult.setRateReturn(rateReturn);
    }

    private int getPrize() {
        int totalPrize = 0;
        for (LottoRank rank : lottoResult.getRankCountMap().keySet()) {
            int rankCount = lottoResult.getRankCountMap().get(rank);
            totalPrize += rank.getPrize() * rankCount;
        }
        return totalPrize;
    }

    private double calculateRateReturn(int amount, int prize) {
        return Math.round(((double) prize / amount) * 100 * 1000) / 1000.0;
    }

}
