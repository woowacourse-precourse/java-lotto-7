package lotto.view;

import java.util.List;
import java.util.stream.Collectors;
import lotto.model.Lotto;

public class OutputView {
    private final List<Lotto> lottos;

    public OutputView(List<Lotto> lottos) {
        this.lottos = lottos;
    }

    public void printPurchasedLottos() {
        final int lottosCount = lottos.size();
        final String delimiter = ", ";
        final String prefix = "[";
        final String suffix = "]";
        System.out.println(lottosCount + "개를 구매했습니다.");
        String result = lottos.stream()
                .map(Lotto::getNumbers)
                .map(number -> number.stream()
                        .map(String::valueOf)
                        .collect(Collectors.joining(delimiter, prefix, suffix))
                )
                .collect(Collectors.joining("\n"));
        System.out.println(result);
    }

    public static void printRequirePurchasePrice() {
        System.out.println("구입 금액을 입력해 주세요.");
    }
}
