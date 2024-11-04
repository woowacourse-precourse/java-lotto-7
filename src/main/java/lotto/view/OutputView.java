package lotto.view;

import java.util.Arrays;
import java.util.List;

public class OutputView {
    public void printEmptyLine() {
        System.out.println();
    }

    public void printErrorMessage(String message) {
        System.out.println(message);
    }

    public void printNumOfLottos(int numOfLottos) {
        System.out.printf("%d개를 구매했습니다.\n", numOfLottos);
    }

    public void printLotto(List<Integer> lotto) {
        System.out.println(Arrays.toString(lotto.toArray()));
    }
}
