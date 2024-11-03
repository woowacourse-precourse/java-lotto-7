package lotto.view;

import lotto.Lotto;

import java.util.List;
import java.util.stream.Collectors;

public class OutputView {

    public static void printLotto(List<Lotto> lotto) {
        System.out.println(lotto.size() + "개를 구매했습니다.");

        lotto.forEach(i ->
                System.out.println(i.getLotto().stream()
                        .map(String::valueOf)
                        .collect(Collectors.joining(", ", "[", "]")))
        );

        addBlankLine();
    }

    private static void addBlankLine() {
        System.out.println();
    }
}
