package lotto.view;

import lotto.domain.LottoRanking;
import lotto.domain.User;
import lotto.domain.UserLotto;

import java.util.Map;

public class OutputView {

    public static void buyLottoQuantity(User user) {
        System.out.println();
        System.out.println(user.getLottoQuantity() + "개를 구매했습니다.");
    }

    public static void buyLottoNumber(User user) {
        for (UserLotto userLotto : user.getUserLotto()) {
            System.out.println(userLotto.getLottoNumber());
        }
    }

    public static void printWinningHistory(Map<LottoRanking, Integer> map) {
        for (LottoRanking ranking : LottoRanking.values()) {
            if (ranking.isBonusMatch()) {
                System.out.println(ranking.getMatchNumber() + "개 일치, 보너스 볼 일치 (" + String.format("%,d", ranking.getPrice()) + "원) - " + map.get(ranking) +"개");
                continue;
            }
            System.out.println(ranking.getMatchNumber() + "개 일치 (" + String.format("%,d", ranking.getPrice()) + "원) - " + map.get(ranking) +"개");
        }
    }

    public static void printProfit(double profit) {
        System.out.println("총 수익률은 " +  profit + "%입니다.");
    }
}
