package lotto.view;

import java.util.Arrays;
import java.util.List;

public class OutputView {
    public void printEmptyLine() {
        System.out.println();
    }

    public void printErrorMessage(String message) {
        System.out.println(message);
    }

    public void printNumOfLottos(int numOfLottos) {
        System.out.printf("%d개를 구매했습니다.\n", numOfLottos);
    }

    public void printLotto(List<Integer> lotto) {
        System.out.println(Arrays.toString(lotto.toArray()));
    }

    public void printLottoStatistics(List<Integer> result, double rateOfReturn) {
        System.out.println("당첨 통계");
        System.out.println("---");
        printLottoResult(result);
        printLottoRateOfReturn(rateOfReturn);
    }

    private void printLottoResult(List<Integer> result) {
        System.out.printf("3개 일치 (5,000원) - %d개\n", result.get(4));
        System.out.printf("4개 일치 (50,000원) - %d개\n", result.get(3));
        System.out.printf("5개 일치 (1,500,000원) - %d개\n", result.get(2));
        System.out.printf("5개 일치, 보너스 볼 일치 (30,000,000원) - %d개\n", result.get(1));
        System.out.printf("6개 일치 (2,000,000,000원) - %d개\n", result.get(0));
    }

    private void printLottoRateOfReturn(double rateOfReturn) {
        System.out.printf("총 수익률은 %.1f%%입니다.\n", rateOfReturn);
    }
}
