package lotto.view;

import java.util.Map;
import lotto.model.LottoRank;
import lotto.model.Lottos;

public class OutputView {

    private static final String NEXT_LINE = System.lineSeparator();

    public void printPurchaseAmountMessage() {
        System.out.println("구입금액을 입력해 주세요.");
    }

    public void printQuantity(int quantity) {
        System.out.println(NEXT_LINE + quantity + "개를 구매했습니다.");
    }

    public void printLottos(Lottos lottos) {
        System.out.println(lottos.toString());
    }

    public void printWinningNumbersMessage() {
        System.out.println(NEXT_LINE + "당첨 번호를 입력해 주세요.");
    }

    public void printBonusNumberMessage() {
        System.out.println(NEXT_LINE + "보너스 번호를 입력해 주세요.");
    }

    public void printLottoWinningResult(Map<LottoRank, Integer> winningResult) {
        printWinningResultMessage();
        String formatWinningResult = OutputFormatter.formatingWinningResult(winningResult);
        System.out.println(formatWinningResult);
    }

    public void printRateOrReturn(double rateOfReturn) {
        String formatRateOfReturn = OutputFormatter.formatingRateOfReturn(rateOfReturn);
        System.out.println("총 수익률은 " + formatRateOfReturn + "%입니다.");
    }

    public void printErrorMessage(String exceptionMessage) {
        System.out.println(exceptionMessage);
    }

    private void printWinningResultMessage() {
        System.out.println(NEXT_LINE + "당첨 통계");
        System.out.println("---");
    }
}
