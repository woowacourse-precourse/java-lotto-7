package lotto.view;

import java.util.List;

public class OutputView {
    private final String NUMBER_OF_PURCHASES = "개를 구매했습니다.";

    public void count(int count) {
        System.out.println(count + NUMBER_OF_PURCHASES);
    }

    public void printLotto(List<Integer> lotto) {
        System.out.println(lotto);
    }
}
