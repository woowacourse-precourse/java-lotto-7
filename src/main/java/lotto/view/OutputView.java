package lotto.view;

import java.util.List;

public class OutputView {
    private static final String NEW_LINE = System.lineSeparator();
    private static final String RESPONSE_LOTTO_COUNT = "개를 구매했습니다.";
    private static final String OPEN_BRACKET = "[";
    private static final String CLOSE_BRACKET = "]";

    public static void printPurchasedLotto(int lottoCount, List<String> purchasedLotto) {
        System.out.println(NEW_LINE + lottoCount + RESPONSE_LOTTO_COUNT);

        for (String lotto : purchasedLotto) {
            System.out.println(OPEN_BRACKET + lotto + CLOSE_BRACKET);
        }
    }
}
