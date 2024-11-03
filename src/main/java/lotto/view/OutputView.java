package lotto.view;

import java.util.List;

public class OutputView {
    private static final String PURCHASED_BUDGET = "구입금액을 입력해 주세요";
    private static final String NUMBER_OF_PURCHASES = "%s개를 구매했습니다.";
    private static final String WINNING_NUMBER = "당첨 번호를 입력해 주세요";
    private static final String BONUS_NUMBER = "보너스 번호를 입력해 주세요";
    private static final String WINNING_STATISTICS = "당첨 통계";
    private static final String RATE_OF_RETURN = "총 수익률은 %s% 입니다.";

    public static void purchasedBudget() {
        System.out.println(PURCHASED_BUDGET);
    }

    public static void PurchasedLottoTicketsMessage(int lottoTickets) {
        System.out.println(String.format(NUMBER_OF_PURCHASES, lottoTickets));
    }

    public static void printLottos(List<List<Integer>> lottos) {
        lottos.stream()
                .map(List::toString)
                .forEach(System.out::println);
    }
}
