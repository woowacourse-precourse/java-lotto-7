package lotto.io.output.impl;

import lotto.domain.LottoTicket;
import lotto.domain.Result;
import lotto.io.output.GameOutput;

public class OutputConsole implements GameOutput {

    @Override
    public void printPurchasedTickets(LottoTicket lottoTicket) {
        System.out.printf("%d개를 구매했습니다.%n", lottoTicket.size());
        lottoTicket.getTickets().forEach(System.out::println);
    }

    @Override
    public void printResults(Result result, double yield) {
        System.out.println("당첨 통계");
        System.out.println("---");
        result.getFormattedResults().forEach(System.out::println);
        System.out.printf("총 수익률은 %.1f%%입니다.%n", yield);
    }

    @Override
    public void printErrorMessage(String message) {
        System.out.println(message);
    }
}

