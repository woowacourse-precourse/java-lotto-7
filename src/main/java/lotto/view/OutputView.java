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
            StringBuilder resultMessage = new StringBuilder();
            resultMessage.append(ranking.getMatchNumber()).append("개 일치");

            isBonusMatch(ranking, resultMessage);

            resultMessage.append(" (")
                .append(String.format("%,d", ranking.getPrice()))
                .append("원) - ")
                .append(map.get(ranking))
                .append("개");

            System.out.println(resultMessage);
        }
    }

    private static void isBonusMatch(LottoRanking ranking, StringBuilder resultMessage) {
        if (ranking.isBonusMatch()) {
            resultMessage.append(", 보너스 볼 일치");
        }
    }

    public static void printProfit(String profit) {
        System.out.println("총 수익률은 " +  profit + "%입니다.");
    }
}
