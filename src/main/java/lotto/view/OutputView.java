package lotto.view;

import static java.lang.String.format;

import java.util.List;
import lotto.domain.Lotto;
import lotto.exception.LottoException;

public class OutputView {
    private final static String INFORM_PURCHASE_LOTTO_MESSAGE = "%d개를 구매했습니다.";
    private final static String WINNING_STATISTICS_TITLE = "당첨 통계";
    private final static String SEPARATOR = "---";

    public static void printPurchaseMessage(int lottoQuantity) {
        System.out.println(format(INFORM_PURCHASE_LOTTO_MESSAGE, lottoQuantity));
    }

    public static void printLottoExceptionMessage(LottoException e) {
        System.out.println(e.getMessage() + System.lineSeparator());
    }

    public static void printLottoGroup(List<Lotto> lottoGroup) {
        lottoGroup.forEach(lotto -> {
            System.out.println(lotto.getNumbers());
        });
    }
}
