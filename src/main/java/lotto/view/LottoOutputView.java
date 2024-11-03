package lotto.view;

import java.util.List;
import java.util.Map;
import lotto.enums.LottoRank;

public class LottoOutputView {

    private static final String ERR_MESSAGE = "[ERROR] ";

    private static final String WINNING_STATISTICS = "당첨 통계";

    private static final String LINE = "-----------------";

    private static final String BUY_COUNT_MESSAGE = "개를 구매했습니다.";

    private static final String EARNING_RATE_MESSAGE = "총 수익률은 ";

    private static final String EARNING_RATE_PERCENT_MESSAGE = "%입니다.";

    private static final String EQUAL_COUNT = "개 일치";

    private static final String BONUS_BALL_MESSAGE = ", 보너스 볼 일치";

    private static final String MATCH_NUMBER_COUNT = " (%,d원) - %d개";

    public void printLottoCount(int lottoCount) {
        System.out.println(lottoCount + BUY_COUNT_MESSAGE);
    }

    public void printLottoTicket(List<List<Integer>> lottoTicketNumbers) {
        lottoTicketNumbers.stream()
                .map(lotto -> lotto.toString()) // 각 로또 티켓 번호를 문자열로 변환
                .forEach(System.out::println); // 각 로또 티켓 번호를 한 줄씩 출력
        System.out.println();
    }

    public void printLottoResult(Map<LottoRank, Integer> rankResults, double totalEarnings) {
        printResultMessage();
        printRankResult(rankResults);
        printEarningRate(totalEarnings);
    }

    private void printEarningRate(double totalEarnings) {
        System.out.println(EARNING_RATE_MESSAGE + totalEarnings + EARNING_RATE_PERCENT_MESSAGE);
    }

    private void printRankResult(Map<LottoRank, Integer> rankResults) {
        for (LottoRank rank : LottoRank.values()) {
            StringBuilder result = new StringBuilder();
            result.append(rank.getMatchCount()).append(EQUAL_COUNT);
            if (rank == LottoRank.SECOND) {
                result.append(BONUS_BALL_MESSAGE);
            }
            System.out.printf(result.toString());
            System.out.printf(MATCH_NUMBER_COUNT, rank.getPrize(), rankResults.get(rank));
            System.out.println();
        }
    }

    private void printResultMessage() {
        System.out.println(WINNING_STATISTICS);
        System.out.println(LINE);
    }

    public void printExceptionMessage(IllegalArgumentException exception) {
        System.out.println(ERR_MESSAGE + exception.getMessage());
    }
}
