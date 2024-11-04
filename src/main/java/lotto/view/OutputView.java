package lotto.view;

import lotto.domain.Lotto;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.List;

public class OutputView {

    private static final String[] resultString = {
            "3개 일치 (5,000원) - ",
            "4개 일치 (50,000원) - ",
            "5개 일치 (1,500,000원) - ",
            "5개 일치, 보너스 볼 일치 (30,000,000원) - ",
            "6개 일치 (2,000,000,000원) - "
    };

    public static void outputLottoBuyCount(Integer lottoSize) {
        System.out.println(lottoSize + "개를 구매했습니다.");
    }

    public static void outputLottos(List<Lotto> lottos) {
        for (Lotto lotto : lottos) {
            System.out.println(Arrays.toString(lotto.getNumbers().toArray()));
        }
    }

    public static void outputResult(List<Integer> lottoMatchResults) {
        System.out.println("당첨 통계\n---");

        for (int i = 0; i < resultString.length; i++) {
            System.out.println(resultString[i] + lottoMatchResults.get(i) + "개");
        }
    }

    public static void outputEarningRate(BigDecimal earningRate) {
        System.out.printf("총 수익률은 %.1f%%입니다.", earningRate);
    }
}
