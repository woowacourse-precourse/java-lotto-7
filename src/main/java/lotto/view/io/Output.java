package lotto.view.io;

import java.math.BigDecimal;
import java.util.List;

public class Output {
    public void lottoCount(int count) {
        System.out.println();
        System.out.println(count + "개를 구매했습니다.");
    }

    public void lottoNumber(List<Integer> lottoNumber) {
        System.out.println(lottoNumber);
    }

    public void winningResult(int[] ans, double rate) {
        System.out.println();
        System.out.println("당첨 통계");
        System.out.println("---");
        System.out.println("3개 일치 (5,000원) - " + ans[0] + "개");
        System.out.println("4개 일치 (50,000원) - " + ans[1] + "개");
        System.out.println("5개 일치 (1,500,000원) - " + ans[2] + "개");
        System.out.println("5개 일치, 보너스 볼 일치 (30,000,000원) - " + ans[3] + "개");
        System.out.println("6개 일치 (2,000,000,000원) - " + ans[4] + "개");

        System.out.println("총 수익률은 " + String.format("%.1f",rate) + "%입니다.");
    }
}
