package lotto.io;

import lotto.lotto.value.Lotto;

import java.util.List;

public final class Viewer {

    private static final String ENTER_MONEY = "구입금액을 입력해주세요.";
    private static final String BUY_MESSAGE = "개를 구매했습니다.";
    private static final String ENTER_WINNING_NUMBERS = "당첨 번호를 입력해주세요.";
    private static final String ENTER_BONUS_NUMBERS = "보너스 번호를 입력해주세요.";
    private static final String RESULT = "당첨 통계 \n ---";

    private Viewer() {
    }

    public static void enterMoneyMessage() {
        System.out.println(ENTER_MONEY);
    }

    public static void showSoldTickets(List<Lotto> tickets) {
        System.out.println(tickets.size() + BUY_MESSAGE);
        for (Lotto ticket : tickets) {
            System.out.println(ticket.toString());
        }
    }

    public static void enterWinningNumbers() {
        System.out.println(ENTER_WINNING_NUMBERS);
    }

    public static void enterBonusNumbers() {
        System.out.println(ENTER_BONUS_NUMBERS);
    }

    public static void showResult(String statistics) {
        System.out.println(RESULT);
        System.out.println(statistics);
    }
}
