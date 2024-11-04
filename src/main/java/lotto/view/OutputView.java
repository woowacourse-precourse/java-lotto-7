package lotto.view;

import lotto.dto.LottoResultResponse;
import lotto.dto.LottoTicketDto;
import lotto.model.LottoRanking;

public class OutputView {

    public void printMessage(String message) {
        System.out.println(message);
    }

    public void printPurchaseCount(int count) {
        System.out.printf("%d개를 구매했습니다.%n", count);
    }

    public void printLottoNumbers(LottoTicketDto ticket) {
        System.out.println(ticket.numbers());
    }

    public void printLottoResult(LottoResultResponse result) {
        System.out.println("당첨 통계");
        System.out.println("---");

        result.rankingCount().forEach((ranking, count) -> {
            if (ranking == LottoRanking.SECOND) {
                System.out.printf("5개 일치, 보너스 볼 일치 (%d원) - %d개%n", ranking.getPrize(), count);
            }
            if (ranking != LottoRanking.SECOND) {
                System.out.printf("%d개 일치 (%d원) - %d개%n", ranking.getMatchCount(), ranking.getPrize(), count);
            }
        });

        System.out.printf("총 수익률은 %.2f%%입니다.%n", result.profitRate());
    }

    public void printErrorMessage(String message) {
        System.out.println("[ERROR] " + message);
    }
}