package lotto.view;

import lotto.domain.Lottos;

import static java.util.stream.Collectors.joining;

public class OutputView {

    public static void printMessage(String message) {
        System.out.println(message);
    }

    public static void printLottoListPrompt(Lottos lottos) {
        lottos.getLottos()
                .forEach(lotto -> printMessage(formatLottoNumbers(lottos)));
    }

    private static String formatLottoNumbers(Lottos lotto) {
        return lotto.getLottos().stream()
                .map(String::valueOf)
                .collect(joining(", ", "[", "]"));
    }

}