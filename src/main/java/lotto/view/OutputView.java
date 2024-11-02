package lotto.view;

public class OutputView {

    public enum ConsoleMessage {
        TOTAL_TICKETS("%d개를 구매했습니다.");
        private final String message;

        ConsoleMessage(String message) {
            this.message = message;
        }
    }


    public void printExceptionMessage(Exception exception) {
        System.out.println(exception.getMessage());
    }


    public void printTotalTickets(int totalTickets) {
        System.out.printf(ConsoleMessage.TOTAL_TICKETS.message, totalTickets);
    }
}
