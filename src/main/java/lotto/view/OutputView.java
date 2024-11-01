package lotto.view;

import java.util.List;

public class OutputView {
    private static final String PURCHASE_AMOUNT_MESSAGE = "구입금액을 입력해 주세요";
    private static final String NUMBER_OF_PURCHASES_MESSAGE = "%s개를 구매했습니다.";
    private static final String WINNING_NUMBER_MESSAGE = "당첨 번호를 입력해 주세요";
    private static final String BONUS_NUMBER_MESSAGE = "보너스 번호를 입력해 주세요";
    private static final String WINNING_STATISTICS_MESSAGE = "당첨 통계";
    private static final String RATE_OF_RETURN_MESSAGE = "총 수익률은 %s% 입니다.";

    public static void purchaseAmountMessage() {
        System.out.println(PURCHASE_AMOUNT_MESSAGE);
    }

    public static void PurchasedLottoTicketsMessage(int lottoTickets) {
        System.out.println(String.format(NUMBER_OF_PURCHASES_MESSAGE, lottoTickets));
    }

    public static void printLottos(List<List<Integer>> lottos) {
        lottos.stream()
                .map(List::toString)
                .forEach(System.out::println);
    }
}
