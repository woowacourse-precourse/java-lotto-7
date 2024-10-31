package lotto.View;

import lotto.Model.Lotto;

import java.util.Collections;
import java.util.List;

public class OutputView {
    public static void showLottoCount(int lottoCount){
        System.out.println(lottoCount + "개를 구매했습니다.");
    }

    public static void showAllLottos(List<Lotto> allLottos){
        for (Lotto lotto : allLottos) {
            List<Integer> numbers = lotto.getNumbers();
            Collections.sort(numbers);
            System.out.println(lotto.getNumbers());
        }
    }
}
