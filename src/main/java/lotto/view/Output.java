package lotto.view;

import lotto.model.Lotto;
import lotto.model.LottoGame;
import lotto.model.Rank;

import java.util.*;

public class Output {

    public static void lottoTotalOutput(int auto) {
        System.out.println("\n" + auto + "개를 구매했습니다.");
    }

    public static void lottoNumOutput(List<Integer> lotto) {
        System.out.print("[");
        for (int i = 0; i < lotto.size(); i++) {
            System.out.print(lotto.get(i));
            if (i != lotto.size() - 1) {
                System.out.print(", ");
            }
        }
        System.out.println("]");
    }

    public static void resultOfLotto(List<Lotto> lottoList, List<Integer> winnerLotto, int bonusNum, int moneyInput) {
        Map<Rank, Integer> resultMap = initializeResultMap();
        int resultMoney = calculateResult(lottoList, winnerLotto, bonusNum, resultMap);

        System.out.println("\n당첨 통계");
        System.out.println("---");
        System.out.println("3개 일치 (5,000원) - " + resultMap.get(Rank.THREE) + "개");
        System.out.println("4개 일치 (50,000원) - " + resultMap.get(Rank.FOUR) + "개");
        System.out.println("5개 일치 (1,500,000원) - " + resultMap.get(Rank.FIVE) + "개");
        System.out.println("5개 일치, 보너스 볼 일치 (30,000,000원) - " + resultMap.get(Rank.FIVE_BONUS) + "개");
        System.out.println("6개 일치 (2,000,000,000원) - " + resultMap.get(Rank.SIX) + "개");

        double rate = (double) resultMoney / moneyInput;
        rate *= 100;
        System.out.println("총 수익률은 " + String.format("%.1f", rate) + "%입니다.");
    }

    private static Map<Rank, Integer> initializeResultMap() {
        Map<Rank, Integer> resultMap = new HashMap<>();
        for (Rank rank : Rank.values()) {
            resultMap.put(rank, 0);
        }
        return resultMap;
    }

    private static int calculateResult(List<Lotto> lottoList, List<Integer> winnerLotto, int bonusNum, Map<Rank, Integer> resultMap) {
        int resultMoney = 0;
        for (Lotto lotto : lottoList) {
            Rank rank = LottoGame.getRank(lotto.getNumbers(), winnerLotto, bonusNum);
            resultMap.put(rank, resultMap.get(rank) + 1);
            resultMoney += rank.getPrize();
        }
        return resultMoney;
    }
}
