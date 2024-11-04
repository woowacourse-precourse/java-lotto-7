package lotto.view;

import java.util.List;
import java.util.Set;
import lotto.domain.LottoRank;

public class OutputView {

    public void printLottoTicketCountAndNumbers(int ticketCount, Set<List<Integer>> ticketNumbers) {
        System.out.println(ticketCount + "개를 구매했습니다.");
        for (List<Integer> ticketNumber : ticketNumbers) {
            System.out.println(ticketNumber);
        }
        System.out.println();
    }

    public void printLottoResultWithoutBonusNumber(int resultMatchCount, String formattedPrize,
            int matchedCount) {
        System.out.println(
                resultMatchCount + "개 일치 (" + formattedPrize + "원)" + " - " + matchedCount + "개");
    }

    public void printLottoResultWithBonusNumber(int resultMatchCount, String formattedPrize,
            int matchedCount) {
        System.out.println(
                resultMatchCount + "개 일치, 보너스 볼 일치 (" + formattedPrize + "원)" + " - " + matchedCount
                        + "개");
    }

}
