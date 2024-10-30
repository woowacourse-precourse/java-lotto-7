package lotto.view.output;

import lotto.domain.Lotto;
import lotto.domain.Lottos;
import lotto.domain.User;
import lotto.validator.exception.LottoException;

public class OutputView {

    public void displayLottos(User user) {
        int lottosCount = user.getLottos().getLottoCount();
        System.out.printf(OutputMessage.PURCHASED_COUNT_MESSAGE.getOutputMessage(), lottosCount);
        for (Lotto lotto : user.getLottos().getLottos()) {
            System.out.println(lotto.getNumbers());
        }
    }


    public void displayErrorMessage(LottoException lottoException) {
        System.out.println(lottoException.getMessage());
    }
}
