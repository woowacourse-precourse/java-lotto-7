package lotto.view;
import lotto.domain.LottoResult;
import lotto.domain.Lottos;

public class OutputView {

    private static final String START_SHOW_RESULT = "당첨 통계";
    private static final String DELIMITER = "---";
    private static final String PURCHASED_LOTTO_MESSAGE = "개를 구매했습니다.";
    private static final String NEW_LINE = "\n";

    public void displayBuyLottos(Lottos lottos) {
        long lottoAmount = lottos.getSize();
        System.out.println(lottoAmount + PURCHASED_LOTTO_MESSAGE);
        System.out.println(lottos.result());
    }

    public void displayWinningResult(LottoResult lottoResult) {
        StringBuilder sb = new StringBuilder();
        sb.append(START_SHOW_RESULT).append(NEW_LINE);
        sb.append(DELIMITER).append(NEW_LINE);
        sb = lottoResult.result(sb);
        System.out.println(sb);
    }
}
