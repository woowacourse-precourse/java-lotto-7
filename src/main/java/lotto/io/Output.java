package lotto.io;

import java.util.List;
import lotto.domain.Lotto;

public class Output {
    private final String PRINT_LOTTO_QUANTITY = "개를 구매했습니다.";

    public void printLottoQuantity(int lottoQuantity) {
        printNewLine();
        System.out.println(lottoQuantity + PRINT_LOTTO_QUANTITY);
    }

    public void printLottos(List<Lotto> lottos) {
        for (Lotto lotto : lottos) {
            System.out.println(lotto);
        }
    }

    private void printNewLine() {
        System.out.println();
    }
}
