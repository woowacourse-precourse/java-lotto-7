package lotto.view;

public class OutputLottosView {

    private static final String MESSAGE_TICKET_COUNT = "\n%d개를 구매했습니다.";

    public static void outputTickets(int tickets) {
        System.out.println(String.format(MESSAGE_TICKET_COUNT, tickets));
    }

    public static void outputLottos(String lotto) {
        System.out.println(lotto);
    }
}
