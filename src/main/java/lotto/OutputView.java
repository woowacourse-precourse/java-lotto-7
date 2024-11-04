package lotto;

public class OutputView {

    public void printLottoTickets(LottoMachine lottoMachine) {
        System.out.printf("%s개를 구매했습니다.%n", lottoMachine.currentLottoTicketCount());
        System.out.println(lottoMachine.currentLottoTicketNumbers());
    }

    public void printWinningStatistics(StatisticalMachine statisticalMachine) {
        System.out.println("당첨 통계");
        System.out.println("---");
        System.out.println(statisticalMachine.toString());
    }
}
