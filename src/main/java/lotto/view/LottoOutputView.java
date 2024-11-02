package lotto.view;

import java.util.List;
import java.util.Map;
import lotto.enums.LottoRank;

public class LottoOutputView {

    public void printLottoCount(int lottoCount) {
        System.out.println(lottoCount + "개를 구매했습니다.");
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
        System.out.println("총 수익률은 " + totalEarnings + "%입니다.");
    }

    private void printRankResult(Map<LottoRank, Integer> rankResults) {
        for (LottoRank rank : LottoRank.values()) {
            StringBuilder result = new StringBuilder();
            result.append(rank.getMatchCount()).append("개 일치");
            if (rank == LottoRank.SECOND) {
                result.append(", 보너스 볼 일치");
            }
            System.out.printf(result.toString());
            System.out.printf(" (%,d원) - %d개\n", rank.getPrize(), rankResults.get(rank));
        }
    }

    private void printResultMessage() {
        System.out.println("당첨 통계");
        System.out.println("-----------------");
    }

    public void printExceptionMessage(IllegalArgumentException exception) {
        System.out.println("[ERROR] " + exception.getMessage());
    }
}
