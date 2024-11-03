package lotto.view;

import static java.util.stream.Collectors.joining;

import java.util.List;

public class OutputView {

    private static final String LOTTIES_DELIMITER = "\n";
    private static final String LOTTO_DELIMITER = ", ";
    private static final String LOTTO_PREFIX = "[";
    private static final String LOTTO_SUFFIX = "]";

    private OutputView() {
    }

    public static void printLotties(List<List<Integer>> lotties) {
        System.out.println(lotties.size() + "개를 구매했습니다.");
        System.out.println(toLottiesFormat(lotties));
    }

    private static String toLottiesFormat(List<List<Integer>> lotties) {
        return lotties.stream()
                .map(OutputView::toLottoFormat)
                .collect(joining(LOTTIES_DELIMITER));
    }

    private static String toLottoFormat(List<Integer> lotto) {
        return lotto.stream()
                .map(Object::toString)
                .collect(joining(LOTTO_DELIMITER, LOTTO_PREFIX, LOTTO_SUFFIX));
    }
}
