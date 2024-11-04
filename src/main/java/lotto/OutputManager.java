package lotto;


import java.util.List;

public class OutputManager {

    public static void printLottoCount(int count) {
        System.out.printf((InputMessage.LOTTO_COUNT.getInputMessage()) + "%n", count);
    }

    public static void printLottoTickets(List<List<Integer>> lottoTickets) {
        for (List<Integer> ticket : lottoTickets) {
            System.out.println(ticket);
        }
    }

}
