package lotto.view;

import static lotto.enums.ViewMessage.OUTPUT_LOTTO_COUNT;

import java.util.Collections;
import java.util.List;
import lotto.model.Lotto;
import lotto.model.Lottos;

public class OutputView {

    public void printLottos(Lottos lottos) {
        printLottoCount(lottos);
        printLottoNumbers(lottos);
    }

    private void printLottoCount(Lottos lottos) {
        System.out.println(lottos.getLottos().size() + OUTPUT_LOTTO_COUNT.getMessage());
    }

    private void printLottoNumbers(Lottos lottos) {
        for (Lotto lotto : lottos.getLottos()) {
            printLotto(lotto);
        }
    }

    private void printLotto(Lotto lotto) {
        List<Integer> numbers = lotto.getNumbers();
        Collections.sort(numbers);
        System.out.println(numbers);
    }
}
