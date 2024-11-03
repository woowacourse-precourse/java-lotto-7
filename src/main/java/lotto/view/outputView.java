package lotto.view;

import lotto.domain.LottoResult;
import lotto.dto.Bag;
import lotto.dto.Lotto;
import lotto.util.LottoRank;

import java.util.List;

public class outputView {
    public static void printPurchasedLottoTickets(Bag bag) {
        System.out.printf("%d개를 구매했습니다.\n",bag.getNumberOfLottoTickets());
        List<Lotto> purchasedLottoTickets = bag.getPurchasedLotto();
        purchasedLottoTickets.forEach(lotto -> System.out.println(lotto.getNumbers()));
    }

    public static void printLottoResult(LottoResult lottoResult) {
        System.out.println("당첨 통계");
        System.out.println("---");
        for(LottoRank lottoRank : LottoRank.allLottoRank) {
            int sameNumberCount = lottoResult.getRankCount(lottoRank);
            if(lottoRank==LottoRank.SECOND) {

            }
            System.out.printf("%d개 일치 (%,d원) - %d개",lottoRank.getSameNumberCount(),lottoRank.getPrize(),sameNumberCount);
            System.out.println();
        }
    }

    public static void showRateOfReturn(int purchaseAmount, long totalPrize) {
        double rateOfReturn = (double) totalPrize / purchaseAmount * 100;
        System.out.printf("총 수익률은 %.1f%%입니다.",rateOfReturn);
    }
}
