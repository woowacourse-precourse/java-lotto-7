package lotto;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Output {

    public static void printLotto(int count, List<Lotto> lottos) {
        System.out.println(count + "개를 구매했습니다");
        for (Lotto lotto : lottos) {
            String result = lotto.getNumbers().
                    stream()
                    .map(String::valueOf)
                    .collect(Collectors.joining(","));

            System.out.println("[" + result + "]");
        }
    }

    public static void printReulst(Map<LottoRank, Integer> rankCount, double profit) {
        System.out.println("당첨 통계");
        System.out.println("---");
        System.out.println("3개 일치 (" + LottoRank.FIFTH.getPrice() + "원)" + rankCount.get(LottoRank.FIFTH));
        System.out.println("4개 일치 (" + LottoRank.FOURTH.getPrice() + "원)" + rankCount.get(LottoRank.FIFTH));
        System.out.println("5개 일치 (" + LottoRank.THIRD.getPrice()+ "원)" + rankCount.get(LottoRank.FIFTH));
        System.out.println("5개 일치, 보너스 볼 일치 (" + LottoRank.SECOND.getPrice() + "원)" + rankCount.get(LottoRank.FIFTH));
        System.out.println("6개 일치 (" + LottoRank.FIRST.getPrice() + "원)" + rankCount.get(LottoRank.FIFTH));
        System.out.println("총 수익률은 " + profit +"입니다");
    }

}
