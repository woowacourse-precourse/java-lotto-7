package lotto;

import java.util.Collections;
import java.util.List;

public class OutputPrinter {

    public static void printLotto(List<Lotto> lottos) {
        System.out.printf("%d개를 구매했습니다.\n", lottos.size());

        for (Lotto lotto : lottos) {
            List<Integer> sortedNumbers = lotto.getLottoNumbers().stream()
                    .sorted()
                    .toList();

            System.out.println(sortedNumbers);
        }
    }
}
