package lotto.view;

import java.util.List;
import java.util.stream.Collectors;
import lotto.domain.Lotto;

public final class OutputView {

    public static void printLotto(List<Lotto> lottos) {
        System.out.println(lottos.size() + "개를 구매했습니다.");
        for (Lotto lotto : lottos) {
            System.out.print("[");
            List<Integer> numbers = lotto.getNumbers();
            Collections.sort(numbers);
            String result = numbers.stream().map(String::valueOf).collect(Collectors.joining(", "));
            System.out.print(result);
            System.out.println("]");
        }
        System.out.println();
    }
}
