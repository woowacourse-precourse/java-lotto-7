package lotto.view;

import lotto.domain.Rank;
import lotto.service.LottoService;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class LottoStaticsOutputHandler {
    private LottoService lottoService;

    public LottoStaticsOutputHandler(LottoService lottoService) {
        this.lottoService = lottoService;
    }

    public void displayLottoStatics(List<Rank> ranks) {
        System.out.println("당첨 통계");
        System.out.println("---");
        Map<Rank, Integer> rankCounts = lottoService.matchingWinningNumbers(ranks);
        List<Rank> rankOrder = new ArrayList<>(List.of(Rank.FIFTH, Rank.FOURTH, Rank.THIRD, Rank.SECOND, Rank.FIRST));
        for (Rank rank : rankOrder) {
            String text = displayLottoStaticsText(rank, rankCounts.get(rank));
            System.out.println(text);
        }
    }

    public String displayLottoStaticsText(Rank rank, int rankCount) {
        if (rank.isRequiresBonus()) {
            return String.format("%d개 일치, 보너스 볼 일치 (%,d원) - %d개", rank.getMatchCount(), rank.getPrize(), rankCount);
        }
        return String.format("%d개 일치 (%,d원) - %d개", rank.getMatchCount(), rank.getPrize(), rankCount);
    }

    public void printReturn(List<Rank> ranks, int purchaseAmount) {
        double returnRate = lottoService.calculateReturn(ranks, purchaseAmount);
        String text = String.format("총 수익률은 %.1f%%입니다.", returnRate);
        System.out.println(text);
    }
}
