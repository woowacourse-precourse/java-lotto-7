package lotto.domain;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import lotto.dto.Lotto;

public class RandomLottoResult {
    public void printResult(List<Lotto> lottos) {
        for (Lotto lotto : lottos) {
            List<Integer> numbers = new ArrayList<>(lotto.getNumbers());
            numbers.sort(Comparator.naturalOrder());
            System.out.println(numbers);
        }
    }
}
