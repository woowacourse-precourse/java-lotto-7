package lotto.view;

import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.List;
import java.util.Map;
import lotto.domain.Lotto;
import lotto.service.MatchPrize;

public class OutputView {

    public static final String PURCHASE_COUNT = "\n%d개를 구매했습니다.\n";
    public static final String DRAW_RESULT = "%d개 일치 (%s원) - %d개\n";
    public static final String FIVE_AND_BONUS_MATCH_RESULT = "5개 일치, 보너스 볼 일치 (%s원) - %d개\n";
    public static final String PRICE_PATTERN = "#,###";
    public static final String START_PRINT_DRAW_RESULT = "\n당첨 통계\n---";
    private static final String PROFIT_RATIO_MESSAGE = "총 수익률은 %s%%입니다.";

    public static void purcharsedCount(int count){
        System.out.printf(PURCHASE_COUNT, count);
    }

    public static void purchasedLottos(List<Lotto> lottos){
        for (Lotto lotto:lottos){
            System.out.println(lotto);
        }
    }

    public static void startDrawResult(){
        System.out.println(START_PRINT_DRAW_RESULT);
    }

    public static void drawResult(int matchedNumberCount,int count){
        String formattedPrice;
        if (matchedNumberCount == 7){
            int prize = MatchPrize.FIVE_MATCH_WITH_BONUS.getPrize();
            formattedPrice = NumberFormat.getInstance().format(prize);
            System.out.printf(FIVE_AND_BONUS_MATCH_RESULT,formattedPrice,count);
            return;
        }
        int prize = MatchPrize.getPrizeByMatchCount(matchedNumberCount);
        formattedPrice = NumberFormat.getInstance().format(prize);
        System.out.printf(DRAW_RESULT, matchedNumberCount,formattedPrice,count);
    }

    public static void earnRatio(BigDecimal ratio){
        String printRatio = ratio.toString();
        System.out.printf(PROFIT_RATIO_MESSAGE, printRatio);
    }

}
