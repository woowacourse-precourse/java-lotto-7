package lotto.view.output;

import lotto.domain.Lotto;
import lotto.domain.Lottos;
import lotto.validator.exception.LottoException;

public class OutputView {

    public void displayLottos(Lottos lottos) {
        int lottosCount = lottos.getLottoCount();
        System.out.printf(OutputMessage.PURCHASED_COUNT_MESSAGE.getOutputMessage(), lottosCount);
        for (Lotto lotto : lottos.getLottos()) {
            System.out.println(lotto.getNumbers());
        }
    }


    public void displayErrorMessage(LottoException lottoException) {
        System.out.println(lottoException.getMessage());
    }
}
