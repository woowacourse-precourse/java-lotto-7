package lotto.view;

public class OutputView {
    public static void printResult(String result) {
        System.out.println(result);
    }

    public void printLottoTicket(int ticketCount) {
        printWhiteSpace();
        System.out.println(ticketCount + "개를 구매했습니다.");
    }

    public void printWinningStatistics(){
        printWhiteSpace();
        System.out.println("당첨 통계");
        System.out.println("---");
    }
    private static void printWhiteSpace() {
        System.out.println();
    }


}
