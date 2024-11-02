package lotto.view;

import java.util.List;
import java.util.stream.Collectors;
import lotto.Lotto;

public class OutputView {

    private static final String BUYING_LOTTO_VIEW = "%d개를 구매했습니다.";

    private static final String EACH_LOTTO_NUMBERS_PREFIX = "[";
    private static final String EACH_LOTTO_NUMBERS_DELIMITER = ", ";
    private static final String EACH_LOTTO_NUMBERS_SUFFIX = "]";

    public static void showLottoNumbers(List<Lotto> myLottos) {
        System.out.println(BUYING_LOTTO_VIEW);

        for (Lotto lotto : myLottos) {
            List<Integer> numbers = lotto.getNumbers();
            numbers.stream()
                    .map(String::valueOf)
                    .collect(Collectors.joining(EACH_LOTTO_NUMBERS_DELIMITER,
                    EACH_LOTTO_NUMBERS_PREFIX,
                    EACH_LOTTO_NUMBERS_SUFFIX));
            System.out.println();
        }
    }
}
