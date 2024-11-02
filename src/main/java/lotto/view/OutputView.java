package lotto.view;

import java.util.Map;
import java.util.StringJoiner;
import lotto.model.LottoRank;
import lotto.model.Lottos;

public class OutputView {

    private static final String NEXT_LINE = System.lineSeparator();
    private static final long NO_LUCK_AMOUNT = 0L;

    public void printPurchaseAmountMessage() {
        System.out.println("구입금액을 입력해 주세요.");
    }

    public void printErrorMessage(String exceptionMessage) {
        System.out.println(exceptionMessage);
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
        StringJoiner formatResult = formatWinningResult(winningResult);
        System.out.println(formatResult);
    }

    public void printRateOrReturn(double rateOfReturn) {
        String formatRateOfReturn = String.format("%,.1f", rateOfReturn);
        System.out.println("총 수익률은 " + formatRateOfReturn + "%입니다.");
    }

    private void printWinningResultMessage() {
        System.out.println(NEXT_LINE + "당첨 통계" + NEXT_LINE + "---");
    }

    private StringJoiner formatWinningResult(Map<LottoRank, Integer> winningResult) {
        StringJoiner sj = new StringJoiner(NEXT_LINE);
        for (LottoRank lottoRank : LottoRank.values()) {
            if (isWinningAmount(lottoRank)) {
                appendWinningResult(winningResult, lottoRank, sj);
            }
        }
        return sj;
    }

    private boolean isWinningAmount(LottoRank lottoRank) {
        return lottoRank.getWinningAmount() > NO_LUCK_AMOUNT;
    }

    private void appendWinningResult(Map<LottoRank, Integer> winningResult, LottoRank lottoRank, StringJoiner sj) {
        sj.add(lottoRank.getDescription() + " - " + winningResult.getOrDefault(lottoRank, 0) + "개");
    }
}
