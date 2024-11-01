package lotto.view;

import lotto.model.service.Lottos;
import lotto.model.service.RankResult;

public class OutputView {

    private static final String RESULT_HEADER = "당첨 통계\n---";
    private static final String RETURN_RATE_FORMAT = "총 수익률은 %.1f%%입니다.";

    public void printSellResult(Lottos lottos) {
        System.out.println();
        System.out.printf("%d개를 구매했습니다.%n", lottos.getSize());
        System.out.println(lottos.toString());
    }

    public void printResult(RankResult rankResult) {
        System.out.println();
        System.out.println(RESULT_HEADER);
        System.out.println(rankResult.toString());
    }

    public void printReturnRate(float returnRate) {
        System.out.println(String.format(RETURN_RATE_FORMAT, returnRate));
    }
}
