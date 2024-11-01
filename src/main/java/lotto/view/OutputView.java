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

    public void printProfitRate(float profitRate){
        System.out.printf("총 수익률은 %.1f%%입니다.%n",profitRate);
    }

    private static void printWhiteSpace() {
        System.out.println();
    }


}
