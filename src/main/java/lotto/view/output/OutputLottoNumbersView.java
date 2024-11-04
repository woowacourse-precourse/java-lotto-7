package lotto.view.output;

import java.util.List;
import lotto.model.Lotto;

public class OutputLottoNumbersView {
    public static void lottoNumbersOutput(Lotto lotto) {
        List<Integer> numbers = lotto.getNumbers();
        System.out.print("[");
        for (int i = 0; i < numbers.size() - 1; i++) {
            System.out.print(numbers.get(i) + ", ");
        }
        System.out.println(numbers.get(numbers.size() - 1) + "]");
    }
}
