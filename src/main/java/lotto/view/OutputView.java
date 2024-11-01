package lotto.view;

import lotto.model.Lotto;
import lotto.model.LottoManager;

import java.util.List;
import java.util.stream.Collectors;

public class OutputView {
    public static void printLottos(List<Lotto> lottos) {
        printNumberOfLotto(lottos);
        for (Lotto lotto : lottos) {
            printNumbers(lotto.getNumbers());
        }
    }

    public static void printNumberOfLotto(List<Lotto> lottos) {
        System.out.println(lottos.size() + "개를 구매했습니다.");
    }

    public static void printNumbers(List<Integer> numbers) {
        String result = "[" + numbers.stream()
                .map(String::valueOf).
                collect(Collectors.joining(", ")) + "]";
        System.out.println(result);
    }
}
