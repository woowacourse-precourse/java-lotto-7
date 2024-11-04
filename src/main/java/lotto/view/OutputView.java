package lotto.view;

import lotto.model.Lotto;

import java.util.ArrayList;
import java.util.List;

public class OutputView {

    public void displayLottoCount(int count) {
        System.out.println(count + "개를 구매했습니다.");
    }

    public void displayLottos(List<Lotto> lottos) {
        for (Lotto lotto : lottos) {
            List<Integer> sortedNumbers = new ArrayList<>(lotto.getNumbers());
            sortedNumbers.sort(null);
            System.out.println(sortedNumbers);
        }
    }
}
