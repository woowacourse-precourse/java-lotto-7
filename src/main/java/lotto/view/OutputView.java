package lotto.view;

import java.util.List;
import lotto.model.Lotto;

public class OutputView {
    private final List<Lotto> lottos;

    public OutputView(List<Lotto> lottos) {
        this.lottos = lottos;
    }

    public void printPurchasedLottos() {
        final int lottosCount = lottos.size();
        System.out.println(lottosCount + "개를 구매했습니다.");
        lottos.stream()
                .map(Object::toString)
                .forEach(System.out::println);
    }

    public static void printRequirePurchasePrice() {
        System.out.println("구입 금액을 입력해 주세요.");
    }
}
