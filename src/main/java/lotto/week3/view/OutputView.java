package lotto.week3.view;

import java.util.List;
import lotto.week3.domain.Lotto;
import lotto.week3.model.LottoStatistics;

public class OutputView {

    public static void lottoOutput(List<Lotto> lotto) {
        System.out.println(lotto.size() + " 개를 구매했습니다.");
        for(Lotto lottos : lotto) {
            System.out.println(lottos);
        }
    }

    public static void lottoStatisticsOutput(LottoStatistics lottoStatistics){
        System.out.println("당첨 통계\n---");
        int calculateTotalPrize = lottoStatistics.calculateTotalPrize();
        System.out.println(calculateTotalPrize);

    }

}
