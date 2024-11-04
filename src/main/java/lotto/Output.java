package lotto;

import java.util.Collections;
import java.util.List;

public class Output {
    public static void printLottos(List<Lotto> lottos) {
        System.out.println( lottos.size() +"개를 구매했습니다.");
        for (Lotto lotto : lottos) {
            printLotto(lotto);
        }
        System.out.println();
    }

    public static void printStatistics(LottoStatistics lottoStatistics) {
        System.out.println("당첨 통계");
        System.out.println("---");
        System.out.println("3개 일치 (5,000원) - "+lottoStatistics.getMatch3_count()+"개");
        System.out.println("4개 일치 (50,000원) - "+lottoStatistics.getMatch4_count()+"개");
        System.out.println("5개 일치 (1,500,000원) - "+lottoStatistics.getMatch5_count()+"개");
        System.out.println("5개 일치, 보너스 볼 일치 (30,000,000원) - "+lottoStatistics.getMatch5_bonus_count()+"개");
        System.out.println("6개 일치 (2,000,000,000원) - "+lottoStatistics.getMatch6_count()+"개");
        System.out.println("총 수익률은 "+ lottoStatistics.getReturnRate()+"%입니다.");
        System.out.println();
    }

    private static void printLotto(Lotto lotto) {
        System.out.println(String.join(",",lotto.getNumbers().toString()));
    }
}
