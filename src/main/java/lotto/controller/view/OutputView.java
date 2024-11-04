package lotto.controller.view;

import java.text.NumberFormat;
import java.util.Collections;
import java.util.List;
import lotto.controller.dto.LotteryStatisticsResultDTO;
import lotto.domain.lottery.Lotteries;
import lotto.domain.lottery.Lottery;
import lotto.domain.statistics.Statistics;

public class OutputView {
    public static final String TOTAL_PURCHASED_LOTTO = "개를 구매했습니다.";
    public static final String STATISTICS = "당첨통계";
    public static final String STATISTICS_DELIMITER = "---";
    public OutputView() {
    }

    public void printLotteries(Lotteries lotteries){
        System.out.println(lotteries.getLottery().size()+TOTAL_PURCHASED_LOTTO);
        List<Lottery> lotteryList = lotteries.getLottery();
        for (Lottery lottery:lotteryList) {
            System.out.println(lottery.getNumbers().toString());
        }
    }

    public void printStatisticsResult(LotteryStatisticsResultDTO lotteryStatisticsResultDTO){
        System.out.println(STATISTICS);
        System.out.println(STATISTICS_DELIMITER);
        List<Statistics> statistics = lotteryStatisticsResultDTO.statistics();
        Collections.reverse(statistics);
        NumberFormat numberFormat = NumberFormat.getNumberInstance();
        for (Statistics statisticsData : statistics) {
            if(statisticsData.getTier().getNeedsBonusNumberMatch()){
                System.out.println(statisticsData.getTier().getRequiredMatchCount()+"개 일치, 보너스 볼 일치 ("
                        +numberFormat.format(statisticsData.getTier().getWinningAmount())+"원) - "+statisticsData.getWinningLottoCount()+"개");
            }
            if(!statisticsData.getTier().getNeedsBonusNumberMatch()){
                System.out.println(statisticsData.getTier().getRequiredMatchCount()+"개 일치 ("
                        +numberFormat.format(statisticsData.getTier().getWinningAmount())+"원) - "+statisticsData.getWinningLottoCount()+"개");
            }

        }
        System.out.println("총 수익률은 "+lotteryStatisticsResultDTO.returnRate()+"%입니다.");
    }

}
