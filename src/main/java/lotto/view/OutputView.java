package lotto.view;

import java.util.List;

public class OutputView {

    private static final String LOTTERY_TICKETS_SUFFIX = "개를 구매했습니다.";

    public static void printLotteryTickets(List<List<Integer>> lotteryTickets) {
        int numberOfTickets = lotteryTickets.size();

        System.out.println(numberOfTickets + LOTTERY_TICKETS_SUFFIX);
        
        for (List<Integer> ticket : lotteryTickets) {
            System.out.println(ticket);
        }
    }

    public static void printNewLine() {
        System.out.println();
    }

}
