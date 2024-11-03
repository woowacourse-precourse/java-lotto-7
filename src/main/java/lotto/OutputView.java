package lotto;

import java.util.List;

public class OutputView {
    public void updateLottos(List<List<Integer>> numbersOfLottos) {
        System.out.println("\n" + numbersOfLottos.size() + "개를 구매했습니다.");
        for(int i = 0; i < numbersOfLottos.size(); i++) {
            System.out.println(numbersOfLottos.get(i));
        }
    }
}
