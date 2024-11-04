package lotto.view;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import lotto.domain.Lotto;
import lotto.domain.LottoRank;
import lotto.domain.LottoTicket;
import lotto.domain.Money;
import lotto.domain.PrizeResult;

public class OutputView {
    private static final String WINNING_STATISTICS = "\n당첨 통계\n---";
    private static final String RESULT_MESSAGE = "%d개 일치 (%s원) - %d개";
    private static final String SECOND_RESULT_MESSAGE = "%d개 일치, 보너스 볼 일치 (%s원) - %d개";
    private static final String RATE_OF_RETURN = "총 수익률은 %.1f%%입니다.";

    public void renderError(String message) {
        System.out.printf("[ERROR] %s\n", message);
    }

    public void printTicketAmount(Money money) {
        System.out.println(String.format("\n%d개를 구매했습니다.", money.calculateLottoTickets()));
    }

    public void printLotto(LottoTicket lottoTicket) {
        for (Lotto lotto : lottoTicket.getLottos()) {
            List<Integer> lottoNumbers = new ArrayList<>(lotto.getNumbers());
            Collections.sort(lottoNumbers);
            System.out.println(lottoNumbers);
        }
    }

    public void winningDetails(PrizeResult prizeResult, Money money) {
        printHeader();
        printPrizeStatistics(prizeResult);
        printRateOfReturn(prizeResult, money);
    }

    private void printHeader() {
        System.out.println(WINNING_STATISTICS);
    }

    private void printPrizeStatistics(PrizeResult prizeResult) {
        Arrays.stream(LottoRank.values())
                .filter(this::isWinningRank)
                .sorted(Comparator.comparingInt(LottoRank::getMatchCount))
                .forEach(prize -> System.out.println(getPrintResultPrize(prize, prizeResult)));
    }

    private boolean isWinningRank(LottoRank prize) {
        return !prize.equals(LottoRank.NONE);
    }

    private void printRateOfReturn(PrizeResult prizeResult, Money money) {
        System.out.printf((RATE_OF_RETURN) + "\n", calculateRateOfReturn(prizeResult, money));
    }


    private String getPrintResultPrize(LottoRank lottoRank, PrizeResult prizeResult) {
        if (lottoRank == LottoRank.SECOND) {
            return String.format(SECOND_RESULT_MESSAGE,
                    lottoRank.getMatchCount(),
                    String.format("%,d", lottoRank.getPrize()),
                    prizeResult.getPrizeCount(lottoRank));
        }

        return String.format(RESULT_MESSAGE,
                lottoRank.getMatchCount(),
                String.format("%,d", lottoRank.getPrize()),
                prizeResult.getPrizeCount(lottoRank));
    }

    private double calculateRateOfReturn(PrizeResult prizeResult, Money money) {
        int totalSpent = money.getMoney();
        int totalPrize = Arrays.stream(LottoRank.values())
                .filter(rank -> rank != LottoRank.NONE)
                .mapToInt(rank -> rank.getPrize() * prizeResult.getPrizeCount(rank))
                .sum();
        return totalSpent > 0 ? (double) totalPrize / totalSpent * 100 : 0;
    }
}
