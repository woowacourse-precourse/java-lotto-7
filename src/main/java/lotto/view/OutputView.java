package lotto.view;

import java.util.List;
import lotto.domain.Number;
import lotto.domain.lotto.Lotto;
import lotto.domain.lotto.Lottos;
import lotto.view.console.Writer;

public class OutputView {

    private static final String PURCHASE_LOTTO_COUNT = "%d개를 구매했습니다.";
    private static final String LOTTO_OUTPUT_FORMAT = "[%s]";
    private static final String SEPARATOR = ", ";

    public void print(String message) {
        System.out.println(message);
    }

    public void printLottos(Lottos lottos) {
        Writer.println(String.format(PURCHASE_LOTTO_COUNT, lottos.getLottos().size()));
        for (Lotto lotto : lottos.getLottos()) {
            printLottoInfo(lotto);
        }
    }

    private void printLottoInfo(Lotto lotto) {
        Writer.println(
                String.format(
                        LOTTO_OUTPUT_FORMAT,
                        String.join(
                                SEPARATOR,
                                convert(lotto.getNumbers())
                        )
                )
        );
    }

    private List<String> convert(List<Number> numbers) {
        return numbers.stream()
                .map(number -> Integer.toString(number.getValue()))
                .toList();
    }
}
