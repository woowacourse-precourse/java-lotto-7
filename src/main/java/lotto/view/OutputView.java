package lotto.view;

import lotto.Constants;
import lotto.model.Lotto;
import lotto.model.LottoResult;
import lotto.model.Money;
import lotto.model.Ranking;
import org.w3c.dom.ls.LSOutput;

import java.util.Arrays;
import java.util.List;

import static lotto.Constants.*;

public class OutputView {



    public static void printBuyLottoCount(int count){
        System.out.println(count + OUTPUT_BUY_COUNT);
    }

    public static void printLottoList(List<Lotto> lottos){
        lottos.forEach(lotto -> System.out.println(lotto.toString()));
    }

    public static void printLottResult(LottoResult result){
        System.out.println(OUTPUT_TOTAL_RESULT);

        System.out.println(String.format(OUTPUT_MATCHING_THREE, result.getCountByRank(Ranking.FIFTH)));
        System.out.println(String.format(OUTPUT_MATCHING_FOUR, result.getCountByRank(Ranking.FOURTH)));
        System.out.println(String.format(OUTPUT_MATCHING_FIVE_AND_BONUS, result.getCountByRank(Ranking.THIRD)));
        System.out.println(String.format(OUTPUT_MATCHING_FIVE, result.getCountByRank(Ranking.SECOND)));
        System.out.println(String.format(OUTPUT_MATCHING_SIX, result.getCountByRank(Ranking.FIRST)));
    }


    public void printRate(double rate){
        System.out.printf(OUTPUT_TOTAL_RATE, rate);
    }
}
