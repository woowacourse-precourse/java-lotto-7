package lotto.view;
import lotto.domain.LottoResult;
import lotto.domain.Lottos;

public class OutputView {

    private static final String START_SHOW_RESULT = "당첨 통계";
    private static final String DELIMITER = "---";

    public void displayBuyLottos(Lottos lottos) {
        long lottoAmount = lottos.getSize();
        System.out.println(lottoAmount + "개를 구매했습니다.");
        System.out.println(lottos.result());
    }

    public void displayWinningResult(LottoResult lottoResult) {
        StringBuilder sb = new StringBuilder();
        sb.append(START_SHOW_RESULT).append("\n");
        sb.append(DELIMITER).append("\n");
        sb = lottoResult.result(sb);
        sb.append("총 수익률은 ").append(lottoResult.computeProfitRate()).append("% 입니다.");
        System.out.println(sb);
    }
}
