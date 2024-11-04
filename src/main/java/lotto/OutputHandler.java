package lotto;

import java.text.DecimalFormat;
import java.util.List;

public class OutputHandler implements Output {
    @Override
    public void printLottoNumberList(List<Lotto> lottos) {
        int size = lottos.size();
        System.out.println(size + "개를 구매했습니다.");
        for (int i = 0; i < size; i++) {
            Lotto lotto = lottos.get(i);
            System.out.println(lotto);
        }
    }

    @Override
    public void printTotalResult(int[] result) {
        System.out.println("당첨 통계");
        System.out.println("---");
        System.out.println("3개 일치 (5,000원) - " + result[Rank.FIFTH.ordinal()] + "개");
        System.out.println("4개 일치 (50,000원) - " + result[Rank.FOURTH.ordinal()] + "개");
        System.out.println("5개 일치 (1,500,000원) - " + result[Rank.THIRD.ordinal()] + "개");
        System.out.println("5개 일치, 보너스 볼 일치 (30,000,000원) - " + result[Rank.SECOND.ordinal()] + "개");
        System.out.println("6개 일치 (2,000,000,000원) - " + result[Rank.FIRST.ordinal()] + "개");

    }

    @Override
    public void printProfit(float profit) {
        DecimalFormat df = new DecimalFormat("#.0"); // 소수점 첫째 자리까지 출력
        System.out.println("총 수익률은 " + df.format(profit) + "%입니다.");

    }
}
