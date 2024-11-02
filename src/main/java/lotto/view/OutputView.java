package lotto.view;

import java.util.List;
import lotto.model.Lotto;

public class OutputView {

    private static final String PRINT_PURCHASED_LOTTO_COUNT_MESSAGE = "개를 구매했습니다.";

    public static void printPurchasedLottoCountAndNumber(List<Lotto> lottos) {
        System.out.println(lottos.size() + PRINT_PURCHASED_LOTTO_COUNT_MESSAGE);
        lottos.forEach(lotto -> {
            List<Integer> numbers = lotto.getNumbers().stream().sorted(Integer::compareTo).toList();
            System.out.println(numbers);
        });
    }
}
