package lotto.view;

import lotto.constant.LottoConstant;
import lotto.model.LottoMatchResult;
import lotto.model.Lotto;
import lotto.model.LottoBundle;
import lotto.model.LottoResult;

import java.text.DecimalFormat;
import java.util.List;

public class OutputView {
    private static final String LOTTO_RESULT_STATISTICS_MESSAGE = "당첨 통계";
    private static final String LOTTO_RESULT_LINE = "---";
    private static final String DISPLAY_LOTTO_COUNT_PURCHASED = "%d개를 구매했습니다.";
    private static final String DISPLAY_LOTTO_RESULT = "총 수익률은 %.1f%%입니다.";

    public void printLottoResult(LottoResult result){
        printLine();
        System.out.println(LOTTO_RESULT_STATISTICS_MESSAGE);
        System.out.println(LOTTO_RESULT_LINE);
        printPrizeProfits(result);

    }

    public void printLottoCountPurchased(int amount) {
        printLine();
        String formattedMessage = String.format(DISPLAY_LOTTO_COUNT_PURCHASED, getLottoCount(amount));
        System.out.println(formattedMessage);
    }

    public void printLottoBundle(LottoBundle bundle){
       List<Lotto> lottos = bundle.getPurchasedLottos();
       for(Lotto lotto : lottos){
           System.out.println(lotto.toString());
       }
    }


    public void printLottoProfit(double profit){
        String formattedMessage = String.format(DISPLAY_LOTTO_RESULT, profit);
        System.out.println(formattedMessage);
    }

    public void printPrizeProfits(LottoResult result){
        for (LottoMatchResult stats : LottoMatchResult.values()) {
            printPrizeProfit(result, stats.getMatchCount());
        }
    }

    private void printPrizeProfit(LottoResult result, int number){
            int prize = result.getPrizeMoney().get(number);
            int count = result.getMatchCounts().get(number);
        LottoMatchResult resultStatistics = LottoMatchResult.getByMatchCount(number);
            String description = resultStatistics.getDescription();
        if (resultStatistics != null) {
            System.out.printf("%s (%s원) - %d개%n",
                    resultStatistics.getDescription(),
                    formattedPrize(prize),  // 천 단위 구분 기호 추가
                    count);
        }
    }


    private String formattedPrize(int prize){
        DecimalFormat formatter = new DecimalFormat("#,###");
        return formatter.format(prize);
    }
    private Integer getLottoCount(int amount){
        return amount/LottoConstant.LOTTO_PRICE;
    }
    private void printLine(){
        System.out.println();
    }
}
