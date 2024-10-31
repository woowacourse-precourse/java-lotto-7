package lotto.io.output.impl;

import camp.nextstep.edu.missionutils.Console;
import lotto.common.ConsoleMessages;
import lotto.common.ErrorMessages;
import lotto.domain.LottoTicket;
import lotto.domain.Result;
import lotto.io.output.GameOutput;

public class OutputConsole implements GameOutput {
    @Override
    public void printPurchasedTickets(LottoTicket lottoTicket) {
        System.out.printf(ConsoleMessages.PURCHASED_TICKETS_MESSAGE, lottoTicket.size());
        lottoTicket.getTickets().forEach(System.out::println);
    }

    @Override
    public void printResults(Result result, String yield) {
        System.out.println(ConsoleMessages.WINNING_STATISTICS_HEADER);
        result.getFormattedResults().forEach(System.out::println);
        System.out.print(ConsoleMessages.YIELD_MESSAGE_PREFIX + yield + ConsoleMessages.YIELD_MESSAGE_SUFFIX);
    }

    @Override
    public void printErrorMessage(String message) {
        System.out.println(ErrorMessages.ERROR_PREFIX + message);
    }

    @Override
    public void close() {
        Console.close();  // Console 자원 정리
    }
}
