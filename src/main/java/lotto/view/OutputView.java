package lotto.view;

import java.util.List;

public class OutputView {
    private static final String BUY_LOTTO = "개를 구매했습니다.";

    public static void printBuyLotto(int amount) {
        System.out.println();
        System.out.println(amount + BUY_LOTTO);
    }

    public static void printLottoNumber(List<List<Integer>> numbers) {
        for (List<Integer> number : numbers) {
            System.out.println(number);
        }
    }
}
