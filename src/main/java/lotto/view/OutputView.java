package lotto.view;

import java.util.List;
import lotto.domain.DrawNumbers;

public class OutputView {
    private static String PURCHASE_NUMBER_OUTPUT = "개를 구매했습니다.";

    public static void printPurchaseLotto(List<DrawNumbers> drawSets) {
        int ticketCount = drawSets.size();

        System.out.println(ticketCount + PURCHASE_NUMBER_OUTPUT);

        for (DrawNumbers drawNumbers : drawSets) {
            System.out.println(drawNumbers.getLottoNumbers());
        }
    }
}
