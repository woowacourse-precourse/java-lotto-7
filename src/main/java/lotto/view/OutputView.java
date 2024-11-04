package lotto.view;

import java.util.List;
import java.util.stream.Collectors;
import lotto.domain.Lotto;

public class OutputView {
    public static void printPurchaseCount(int count) {
        System.out.println(count + "개를 구매했습니다.");
    }

    public static void printLottos(List<Lotto> lottos) {
        lottos.forEach(lotto -> {
            String numbers = lotto.getNumbers().stream()
                    .map(n -> String.valueOf(n.value()))
                    .collect(Collectors.joining(", ", "[", "]"));
            System.out.println(numbers);
        });
    }
}
