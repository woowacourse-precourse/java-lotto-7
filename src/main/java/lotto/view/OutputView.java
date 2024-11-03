package lotto.view;

import java.util.List;

public class OutputView {

    public void showCreatedLottos(List<List<Integer>> allNumbers) {
        System.out.println(allNumbers.size() + "개를 구매했습니다.");
        for (List<Integer> numbers : allNumbers) {
            System.out.println(numbers);
        }
    }

}
