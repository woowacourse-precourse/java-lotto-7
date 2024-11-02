package lotto.validation;

import java.util.List;
import lotto.domain.Lotto;
import lotto.exception.LottosException;

public class LottosValidation {

    public static void lottosValidation(int tickets, List<Lotto> lottos) {
        if (tickets != lottos.size()) {
            LottosException.exceptionLottosSize();
        }
    }

}
