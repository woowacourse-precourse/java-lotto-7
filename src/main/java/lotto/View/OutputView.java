package lotto.View;

import lotto.domain.Lottos;

public class OutputView {
    public static void printNumberOfLotto(int lottoQuantity) {
        System.out.printf("%d개를 구매했습니다.\n", lottoQuantity);
    }

    public static void printLottos(Lottos lottos) {
        lottos.getLottos().stream()
                .forEach(lotto -> System.out.println(lotto.getNumbers().toString()));
    }

}
