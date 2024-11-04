package lotto.view;

import lotto.enums.Rank;
import lotto.enums.RequestMessage;
import lotto.model.LottoStatistic;
import lotto.model.LottoTicket;

import java.util.Arrays;

public class OutputView {
    private static final String ERROR_FORMAT = "[ERROR] ";

    public static void requestLotteryPurchaseAmount() {
        System.out.println(RequestMessage.LOTTO_AMOUNT.getMessage());
    }

    public static void requestLotteryWinningNumber() {
        System.out.println(RequestMessage.WINNING_NUMBER.getMessage());
    }

    public static void requestLotteryBonusNumber() {
        System.out.println(RequestMessage.BONUS_NUMBER.getMessage());
    }

    public void printErrorMessage(IllegalArgumentException exception) {
        System.out.println(ERROR_FORMAT + exception.getMessage());
    }

    public void printLottoTickets(LottoTicket lottoTicket){
        System.out.printf("%d개를 구매했습니다.\n", lottoTicket.getQuantity());
        printLotteries(lottoTicket);
    }
    private void printLotteries(LottoTicket lottoTicket){
        StringBuilder printer = new StringBuilder();
        lottoTicket.getLotteries().stream().forEach(lotto ->
                printer.append(lotto.getNumbers()).append("\n"));
        System.out.println(printer);
    }

    public void printLottoStatistics(LottoStatistic lottoStatistic){
        System.out.println("\n당첨 통계");
        System.out.println("---");
        Arrays.stream(Rank.values())
                .filter(rank -> rank != Rank.NONE)
                .forEach(rank -> {
                    int count = lottoStatistic.getRankCount().getOrDefault(rank,0);
                    System.out.printf("%s (%,d원) - %d개\n", rank.getDescription(),rank.getPrize(),count);
                });
        System.out.printf("총 수익률은 %.1f%%입니다.\n", lottoStatistic.getReturnRate());
    }

}
