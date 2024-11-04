package lotto.view;

import java.util.List;
import lotto.model.Lotto;

public class OutputView {
    public void printLottoBuyHistory(List<Lotto> lottos) {
        System.out.println(lottos.size() + "개를 구매했습니다.");
        for (Lotto lotto : lottos) {
            List<Integer> sortedNumbers = lotto.getNumbers()
                            .stream()
                            .sorted()
                            .toList();

            System.out.println(sortedNumbers);
        }
    }
}
