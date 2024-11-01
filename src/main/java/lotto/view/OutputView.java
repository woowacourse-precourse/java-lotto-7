package lotto.view;

import java.util.List;
import java.util.stream.Collectors;

public class OutputView {
    private final String PRINT_BOUGHT_AMOUNT = "%d개를 구매했습니다.\n";
    private final String PRINT_LOTTO_NUMBERS_DELIMITER = ", ";
    private final String PRINT_LOTTO_NUMBERS_FORMAT = "[%s]\n";

    public void printBoughtLottoNumbers(List<List<Integer>> lottos) {
        StringBuilder sb = new StringBuilder();
        sb.append(String.format(PRINT_BOUGHT_AMOUNT, lottos.size()));
        for (List<Integer> lotto : lottos) {
            String joined = lotto.stream().map(String::valueOf).collect(Collectors.joining(PRINT_LOTTO_NUMBERS_DELIMITER));
            sb.append(String.format(PRINT_LOTTO_NUMBERS_FORMAT, joined));
        }
        System.out.print(sb);
    }
}
