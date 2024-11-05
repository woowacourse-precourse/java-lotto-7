package lotto.view;

import lotto.enums.Rank;
import lotto.enums.OutputMessage;
import lotto.model.LottoStatistic;
import lotto.model.LottoTicket;

import java.util.Arrays;

public class OutputView {

    public static void requestLotteryPurchaseAmount() {
        System.out.println(OutputMessage.LOTTO_AMOUNT.getMessage());
    }

    public static void requestLotteryWinningNumber() {
        System.out.println(OutputMessage.WINNING_NUMBER.getMessage());
    }

    public static void requestLotteryBonusNumber() {
        System.out.println(OutputMessage.BONUS_NUMBER.getMessage());
    }

    public void printErrorMessage(IllegalArgumentException exception) {
        System.out.println(OutputMessage.ERROR_PREFIX.getMessage() + exception.getMessage());
    }

    public void printLottoTickets(LottoTicket lottoTicket) {
        System.out.printf(OutputMessage.PURCHASE_RESULT.getMessage(), lottoTicket.getQuantity());
        printLotteries(lottoTicket);
    }

    private void printLotteries(LottoTicket lottoTicket) {
        StringBuilder printer = new StringBuilder();
        lottoTicket.getLotteries().stream().forEach(lotto ->
            printer.append(lotto.getNumbers()).append(OutputMessage.NEW_LINE.getMessage()));
        System.out.println(printer);
    }

    public void printLottoStatistics(LottoStatistic lottoStatistic) {
        printHeader();
        printRankResults(lottoStatistic);
        printRateOfReturn(lottoStatistic);
    }

    private void printHeader() {
        System.out.println(OutputMessage.STATISTICS_HEADER.getMessage());
        System.out.println(OutputMessage.STATISTICS_DIVIDER.getMessage());
    }

    private void printRankResults(LottoStatistic lottoStatistic) {
        Arrays.stream(Rank.values()).filter(rank -> rank != Rank.NONE)
            .forEach(rank -> {
                printRankResult(lottoStatistic, rank);
            });
    }

    private static void printRankResult(LottoStatistic lottoStatistic, Rank rank) {
        int count = lottoStatistic.getRankCount().getOrDefault(rank, 0);
        System.out.printf(OutputMessage.RANK_RESULT.getMessage(), rank.getDescription(), rank.getPrize(), count);
    }

    private static void printRateOfReturn(LottoStatistic lottoStatistic) {
        System.out.printf(OutputMessage.RETURN_RATE.getMessage(),
            lottoStatistic.getReturnRate());
    }

}
