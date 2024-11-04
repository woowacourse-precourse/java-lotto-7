package lotto.view;

import lotto.enumMessage.Rank;
import lotto.model.UserLotto;
import lotto.model.UserLottos;
import org.junit.jupiter.params.ParameterizedTest;

import java.util.List;

public class OutputView {
    public void printUserLotto(UserLottos userLottos) {
        System.out.println("\n" + userLottos.getPurchaseCount() + "개를 구매했습니다.");
        for (UserLotto userLotto : userLottos.getUserNumbers()) {
            System.out.println(userLotto.getUserNumber());
        }
    }

    public void printResult(List<Integer> results, String rate) {
        System.out.println("\n당첨 통계\n" + "---");
        for (Rank rank : Rank.values()) {
            System.out.println(rank.getDescription() + results.get(rank.ordinal()) + "개");
        }
        System.out.println("총 수익률은 " + rate + "%입니다.");
    }
}
