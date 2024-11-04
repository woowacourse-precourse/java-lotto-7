package lotto.view;

import java.util.List;

public class OutputView {

    private static final String OUTPUT_LOTTOS = "개를 구매했습니다.";

    public static void printCount(int count) {
        System.out.println(count+OUTPUT_LOTTOS);
    }

    public static void printLottos(List<List<Integer>> lottos) {
        for (List<Integer> lotto : lottos) {
            System.out.println(lotto);
        }
    }
}
