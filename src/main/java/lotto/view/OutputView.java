package lotto.view;

public class OutputView {
    public static void printResult(String result) {
        System.out.println(result);
    }

    public void printLottoTicket(int ticketCount) {
        printWhiteSpace();
        System.out.println(ticketCount + "개를 구매했습니다.");
    }

    private void printWhiteSpace() {
        System.out.println();
    }
}
