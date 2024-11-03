package lotto.ui;

import lotto.store.lotto.LottoRank;

import java.util.List;

public class LottoResult {
    private final List<LottoRank> buyerLottoRanks;
    private final double rateOfReturn;

    public LottoResult(List<LottoRank> lottoRanks, double rateOfReturn) {
        this.buyerLottoRanks = List.copyOf(lottoRanks);
        this.rateOfReturn = rateOfReturn;
    }

    public List<LottoRank> getBuyerLottoRanks() {
        return buyerLottoRanks;
    }

    public double getRateOfReturn() {
        return rateOfReturn;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("당첨 통계\n----\n");
        sb.append("3개 일치 (5,000원) - %d개\n".formatted(count(buyerLottoRanks, LottoRank.FIFTH)));
        sb.append("4개 일치 (50,000원) - %d개\n".formatted(count(buyerLottoRanks, LottoRank.FOURTH)));
        sb.append("5개 일치 (1,500,000원) - %d개\n".formatted(count(buyerLottoRanks, LottoRank.THIRD)));
        sb.append("5개 일치, 보너스 볼 일치 (30,000,000원) - %d개\n".formatted(count(buyerLottoRanks, LottoRank.SECOND)));
        sb.append("6개 일치 (2,000,000,000원) - %d개\n".formatted(count(buyerLottoRanks, LottoRank.FIRST)));

        sb.append("총 수익률은 %.1f%%입니다".formatted(rateOfReturn));
        return sb.toString();
    }

    private int count(List<LottoRank> ranks, LottoRank found) {
        return (int) ranks.stream().filter(rank -> rank.equals(found)).count();
    }
}
