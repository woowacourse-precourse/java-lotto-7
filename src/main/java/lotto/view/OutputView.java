package lotto.view;

import lotto.domain.Lotto;
import java.util.List;

public class OutputView {
    public static void printLottoTickets(List<Lotto> lottos) {
        System.out.println(lottos.size() + "개를 구매했습니다.");
        for (Lotto lotto : lottos) {
            System.out.println(lotto.getNumbers());
        }
    }

    public static void printStatistics(String statistics) {
        System.out.println("당첨 통계");
        System.out.println("---");
        System.out.println(statistics);
    }
}
