package lotto.view;

import lotto.domain.*;

public class OutputView {
    public void printLottoCount(int lottoCount) {
        System.out.println();
        System.out.printf("%d개를 구매했습니다.%n", lottoCount);
    }

    public void printLottoNumbers(Lottos lottos) {
        lottos.getLottos().stream()
                .map(Lotto::getNumbers)
                .forEach(System.out::println);
    }


    public static void printWinningDetails() {

    }

    public static void printYield(double yield) {
        System.out.printf("총 수익률은 %.2f%%입니다.%n", yield);
    }
}
