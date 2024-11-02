package lotto.view;

import java.util.ArrayList;
import java.util.List;
import lotto.model.Lotto;

public class OutputView {
    public void printLottos(List<Lotto> lottos) {
        System.out.printf("%d개를 구매했습니다.%n", lottos.size());
        for (Lotto lotto : lottos) {
            List<Integer> numbers = new ArrayList<>(lotto.getNumbers());
            numbers.sort(Integer::compareTo);
            System.out.println(numbers);
        }
    }

    public void printYield(double yield) {
        System.out.printf("총 수익률은 %.1f%%입니다.%n", yield);
    }

    public void printErrorMessage(String message) {
        System.out.println(message);
    }
}
