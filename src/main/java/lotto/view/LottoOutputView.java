package lotto.view;

import lotto.dto.PurchaseResponse;
import lotto.dto.RateOfReturnResponse;
import lotto.dto.WinningResultResponse;
import lotto.model.WinningStandard;

import java.text.NumberFormat;
import java.util.List;
import java.util.Map;

public class LottoOutputView {
    public void printPurchaseLotto(PurchaseResponse response){
        Integer lottoCount = response.getPurchaseLottoCount();
        List<List<Integer>> purchaseLottos = response.getPurchaseLottos();

        System.out.println("");
        System.out.println(String.format("%d개를 구매했습니다.", lottoCount));
        for(List<Integer> lotto : purchaseLottos) {
            System.out.println(lotto);
        }
    }

    public void printWinningResult(WinningResultResponse response){
        Map<Integer, Integer> winningResult = response.getWinningResultStatistics();

        System.out.println("");
        System.out.println("당첨 통계");
        System.out.println("---");

        // 랭킹별 출력
        printRankResult(winningResult, 5);
        printRankResult(winningResult, 4);
        printRankResult(winningResult, 3);
        printRankResult(winningResult, 2);
        printRankResult(winningResult, 1);
    }

    public void printRateOfReturn(RateOfReturnResponse response) {
        Float rateOfReturn = response.getRateOfReturn();
        rateOfReturn = Math.round(rateOfReturn * 100) / 100.0f;

        System.out.println(String.format("총 수익률은 %.1f%%입니다.", rateOfReturn));
    }

    private void printRankResult(Map<Integer, Integer> winningResult, Integer rank){
        WinningStandard standard = WinningStandard.WINNING_STANDARDS.stream()
                        .filter(s -> s.getRank().equals(rank))
                        .findFirst()
                        .get();

        String condtion = standard.getCondition();

        Integer price = standard.getPrice();
        String formattedPrice = NumberFormat.getInstance().format(price);

        Integer count = winningResult.getOrDefault(rank, 0);

        String result = String.format("%s (%s원) - %d개", condtion, formattedPrice, count);
        System.out.println(result);
    }
}
