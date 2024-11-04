package lotto;

import java.text.DecimalFormat;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Output {

    private static final DecimalFormat MONEY_FORMAT = new DecimalFormat("#,###");


    public static void printLotto(int count, List<Lotto> lottos) {
        System.out.println(count + "개를 구매했습니다.");
        for (Lotto lotto : lottos) {
            String result = lotto.getNumbers()
                    .stream()
                    .map(String::valueOf)
                    .collect(Collectors.joining(", "));

            System.out.println("[" + result + "]");
        }
        System.out.println();
    }

    public static void printResult(Map<LottoRank, Integer> rankCount, double profit) {
        System.out.println("당첨 통계");
        System.out.println("---");
        System.out.println("3개 일치 (" + MONEY_FORMAT.format(LottoRank.FIFTH.getPrice()) + "원) - " + rankCount.getOrDefault(LottoRank.FIFTH, 0) + "개");
        System.out.println("4개 일치 (" + MONEY_FORMAT.format(LottoRank.FOURTH.getPrice()) + "원) - " + rankCount.getOrDefault(LottoRank.FOURTH, 0) + "개");
        System.out.println("5개 일치 (" + MONEY_FORMAT.format(LottoRank.THIRD.getPrice()) + "원) - " + rankCount.getOrDefault(LottoRank.THIRD, 0) + "개");
        System.out.println("5개 일치, 보너스 볼 일치 (" + MONEY_FORMAT.format(LottoRank.SECOND.getPrice()) + "원) - " + rankCount.getOrDefault(LottoRank.SECOND, 0) + "개");
        System.out.println("6개 일치 (" + MONEY_FORMAT.format(LottoRank.FIRST.getPrice()) + "원) - " + rankCount.getOrDefault(LottoRank.FIRST, 0) + "개");
        System.out.printf("총 수익률은 %.1f%%입니다.", profit);
    }

}
