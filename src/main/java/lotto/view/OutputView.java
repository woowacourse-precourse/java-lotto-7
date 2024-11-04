package lotto.view;

import lotto.model.LottoRank;
import lotto.model.LottoResult;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Map;

public class OutputView {
    private final String PRINT_PURCHASE_NUMBER_MESSAGE = "개를 구매했습니다.";
    private static final OutputView instance = new OutputView();
    private OutputView() {}
    public static OutputView getInstance() {
        return instance;
    }
    public void printPurchaseCount(int count){
        System.out.println("\n"+count+PRINT_PURCHASE_NUMBER_MESSAGE);
    }
    public void printLottoReslt(LottoResult lottoResult){
        System.out.println("\n당첨 통계");
        System.out.println("---");
        for (LottoRank rank : Arrays.stream(LottoRank.values()).sorted(Comparator.reverseOrder()).toList()) {
            if (rank != null) {
                System.out.printf("%d개 일치%s (%s원) - %d개%n",
                        rank.getMatchCount(),
                        rank.isMatchBonus() ? ", 보너스 볼 일치" : "",
                        rank.getPrize(),
                        lottoResult.getLottoResult().get(rank)
                );
            }
        }
    }
    public void printProfitResult(LottoResult lottoResult,int purchaseAmount){
        Map<LottoRank,Integer> lottoWinningResult = lottoResult.getLottoResult();
        int totalPropit=0;
        for(LottoRank rank : lottoWinningResult.keySet()){
            int prize = Integer.parseInt(rank.getPrize().replace(",",""));
            totalPropit += lottoWinningResult.get(rank)*prize;
        }
        System.out.printf("총 수익률은 %.1f%%입니다.",((double)totalPropit/(purchaseAmount))*100);
    }
}
