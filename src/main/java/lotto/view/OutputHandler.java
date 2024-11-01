package lotto.view;

import java.util.EnumMap;
import lotto.domain.Lotto;
import lotto.domain.Lottos;
import lotto.domain.Prize;

public class OutputHandler {

    public void printLottoStatus(Lottos lottos) {
        printNewLine();
        System.out.println(lottos.size() + "개를 구매했습니다.");
        for (Lotto lotto : lottos.getLottos()) {
            System.out.println(lotto.toString());
        }
        printNewLine();
    }

    public void printLottoResults(EnumMap<Prize, Integer> prizeResult) {
        printNewLine();
        printResultNotice();

        // 당첨 결과 출력
        for (Prize currentPrize : Prize.values()) {
            printLottoResultOf(currentPrize, prizeResult.get(currentPrize));
        }
    }

    public void printRateOfReturn(double rateOfReturn) {
        System.out.println("총 수익은 " + rateOfReturn + "%입니다.");
    }

    private void printNewLine() {
        System.out.println();
    }

    private void printResultNotice() {
        System.out.println("당첨 통계");
        System.out.println("---");
    }

    private void printLottoResultOf(Prize prize, int count) {
        System.out.println(prize.getCondition() + " (" + prize.getPrizeMoney() + ")" + " - " + count + "개");
    }
}
