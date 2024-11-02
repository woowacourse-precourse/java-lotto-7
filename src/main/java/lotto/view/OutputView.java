package lotto.view;

import lotto.domain.Lottos;

import javax.xml.transform.stream.StreamSource;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class OutputView {

    public static void printPurchasedLottos(Lottos purchasedLottos) {
        String output = purchasedLottos.getLottoCount() + "개를 구매했습니다.\n" +
                purchasedLottos.getLottos().stream()
                                .map(lotto -> lotto.getNumbers().toString())
                                        .collect(Collectors.joining("\n"));

        System.out.println(output);
    }
}
