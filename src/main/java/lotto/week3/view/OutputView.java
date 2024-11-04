package lotto.week3.view;

import java.util.List;
import java.util.Map;
import lotto.week3.domain.Lotto;
import lotto.week3.dto.StatisticsRequestDto;
import lotto.week3.model.LottoStatistics;

public class OutputView {

    public static void lottoOutput(List<Lotto> lotto) {
        System.out.println(lotto.size() + "개를 구매했습니다.");
        for(Lotto lottos : lotto) {
            System.out.println(lottos);
        }
    }

    public static void lottoStatisticsOutput(StatisticsRequestDto statisticsRequestDto , int totalPrize, double yield){
        System.out.println("당첨 통계\n---");
        Map<String, Integer> results = statisticsRequestDto.getStratistics();
        System.out.println("3개 일치 (5,000원) - " + results.get("3개 일치") + "개");
        System.out.println("4개 일치 (50,000원) - " + results.get("4개 일치") + "개");
        System.out.println("5개 일치 (1,500,000원) - " + results.get("5개 일치") + "개");
        System.out.println("5개 일치, 보너스 볼 일치 (30,000,000원) - " + results.get("5개 일치 + 보너스 일치") + "개");
        System.out.println("6개 일치 (2,000,000,000원) - " + results.get("6개 일치") + "개");
        System.out.printf("총 수익률은 %.1f%%입니다.%n", yield);

    }

}
