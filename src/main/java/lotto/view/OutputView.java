package lotto.view;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.List;
import lotto.model.Ticket;
import lotto.util.MessageParser;
import lotto.util.Ranks;

public class OutputView {

    public void print(String message) {
        System.out.println(message);
    }

    public void printMoneyRequest() {
        System.out.println(Outputs.MONEY_REQUEST.getMessage());
    }

    public void printTicketNumbers(List<Ticket> tickets) {
        System.out.println();
        System.out.println(MessageParser.getComma(tickets.size()) + Outputs.TICKETS_BOUGHT.getMessage());

        for (Ticket ticket : tickets) {
            System.out.println(ticket.getNumbers());
        }
    }

    public void printLottoRequest() {
        System.out.println(Outputs.LOTTO_REQUEST.getMessage());
    }

    public void printBonusRequest() {
        System.out.println(Outputs.BONUS_REQUEST.getMessage());
    }

    public void printStatHeader() {
        System.out.println(Outputs.STATISTICS.getMessage());
    }

    public void printRanks(List<Long> rankCount) {
        Ranks[] ranks = Ranks.values();
        Arrays.sort(ranks, (a, b) -> b.getNumber() - a.getNumber());

        for (Ranks rank : ranks) {
            if (rank == Ranks.NO_WIN) {
                continue;
            }
            printRank(rank, rankCount);
        }
    }

    private void printRank(Ranks rank, List<Long> rankCount) {
        String matchCountMessage = Outputs.MATCH_COUNT.getMessage();
        if (rank == Ranks.SECOND) {
            matchCountMessage = Outputs.MATCH_COUNT_WITH_BONUS.getMessage();
        }

        System.out.println(MessageParser.getComma(rank.getMatchCount()) +
                matchCountMessage +
                MessageParser.getComma(rank.getPrize()) +
                Outputs.WON.getMessage() +
                Outputs.PARENTHESIS_HYPHEN.getMessage() +
                rankCount.get(rank.getNumber()) +
                Outputs.NUMBER.getMessage());
    }

    public void printRevenuePercent(BigDecimal revenuePercent) {
        System.out.println(Outputs.TOTAL_REVENUE_PERCENT.getMessage() +
                revenuePercent +
                Outputs.PERCENT.getMessage() +
                Outputs.DESU.getMessage());
    }
}
