package lotto.view;

import java.util.List;

public class LottoOutputView {

    private static final String TICKET_COUNT = "%d개를 구매했습니다.";
    private static final String GUIDE_MESSAGE = "당첨 통계\n---";
    private static final String RESULT_WITH_BONUS = "%d개 일치, 보너스 볼 일치 (%,d원) - %d개";
    private static final String RESULT_WITHOUT_BONUS = "%d개 일치 (%,d원) - %d개";
    private static final String TOTAL_RETURN = "총 수익률은 %.1f%%입니다.";
    private static final String BLANK_LINE = System.lineSeparator();

    public void printTicketGuide(int num) {
        System.out.print(BLANK_LINE);
        System.out.printf(TICKET_COUNT, num);
        System.out.print(BLANK_LINE);
    }

    public void printNumbers(List<Integer> numbers) {
        System.out.println(numbers);
    }

    public void printGuideMessage() {
        System.out.print(BLANK_LINE);
        System.out.println(GUIDE_MESSAGE);
    }

    public void printWinningResults(int matchingCount, int money, int prizeCount, boolean isMatchBonus) {
        if (isMatchBonus) {
            System.out.printf(RESULT_WITH_BONUS, matchingCount, money, prizeCount);
        }
        if (!isMatchBonus) {
            System.out.printf(RESULT_WITHOUT_BONUS, matchingCount, money, prizeCount);
        }
        System.out.print(BLANK_LINE);
    }

    public void printTotalReturn(float totalReturn) {
        System.out.printf(TOTAL_RETURN, totalReturn);
    }
}
