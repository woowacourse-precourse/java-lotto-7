package lotto.view;

import java.util.List;

public class LottoOutputView {

    private static final String TICKET_COUNT = "%d개를 구매했습니다.";
    private static final String BLANK_LINE = System.lineSeparator();

    public void printTicketGuide(int num) {
        System.out.print(BLANK_LINE);
        System.out.printf(TICKET_COUNT, num);
        System.out.print(BLANK_LINE);
    }

    public void printNumbers(List<Integer> numbers) {
        System.out.println(numbers);
    }
}
