package lotto.view;

import lotto.domain.Lotto;

import java.util.List;

import static java.util.stream.Collectors.joining;

public class OutputView {

    public static void printMessage(String message) {
        System.out.println(message);
    }

    public static void printLottoListPrompt(List<Lotto> lottos) {
        lottos.forEach(lotto -> printMessage(formatLottoNumbers(lotto)));
    }

    private static String formatLottoNumbers(Lotto lotto) {
        return lotto.getNumbers().stream()
                .map(String::valueOf)
                .collect(joining(", ", "[", "]"));
    }

}