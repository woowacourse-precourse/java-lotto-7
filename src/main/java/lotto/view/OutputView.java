package lotto.view;

import lotto.model.Lotto;
import lotto.model.Lottos;

public class OutputView {
    private static final String MY_LOTTOS_MESSAGE = "\n%d개를 구매했습니다.";

    public void showMyLottos(Lottos lottos, int purchaseCount) {
        System.out.println(String.format(MY_LOTTOS_MESSAGE, purchaseCount));
        lottos.getLottos().stream()
                .map(Lotto::getNumbers)
                .forEach(numbers -> System.out.println(numbers));
    }
}
