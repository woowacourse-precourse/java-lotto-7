package lotto.view;

import lotto.controller.dto.LottoPurchaseResponse;
import lotto.controller.dto.PrizeResultDto;
import lotto.controller.dto.PrizeResultResponse;
import lotto.domain.Lotto;
import lotto.domain.value.Standard;

import java.text.NumberFormat;
import java.util.Collections;
import java.util.List;

public class Output {

    public static final String NUMBER_OF_LOTTO_PURCHASES = "\n%d개를 구매했습니다.\n";
    public static final String WINNING_STATISTICS_OUTPUT_MESSAGE = "\n당첨 통계\n---";

    private static final NumberFormat numberFormat = NumberFormat.getNumberInstance();

    public void printPurchaseLotto(LottoPurchaseResponse response) {
        System.out.printf(NUMBER_OF_LOTTO_PURCHASES, response.amount());
        List<Lotto> lottoList = response.lottoList();

        for (int i = 0; i < response.amount(); i++) {
            System.out.println(lottoList.get(i).getNumbers());
        }

        System.out.println();
    }

    public void printStatistics(PrizeResultResponse response) {
        System.out.println(WINNING_STATISTICS_OUTPUT_MESSAGE);

        List<PrizeResultDto> statistics = response.statistics();

        Collections.sort(statistics);

        String result = null;
        for (PrizeResultDto statistic : statistics) {

            Standard standard = statistic.getStandard();
            if (!standard.isBonusNumberRequired()) {
                System.out.printf("%d개 일치 (%s원) - %d개\n", standard.getCount(), numberFormat.format(standard.getPrizeMoney()), statistic.getCount());
                continue;
            }

            System.out.printf("%d개 일치, 보너스 볼 일치 (%s원) - %d개\n", standard.getCount(), numberFormat.format(standard.getPrizeMoney()), statistic.getCount());
        }

        System.out.println(getStatisticsRateFormat(response));
    }

    public static String getStatisticsRateFormat(PrizeResultResponse response) {
        return String.format("총 수익률은 %.1f%%입니다.", response.rate());
    }

}
