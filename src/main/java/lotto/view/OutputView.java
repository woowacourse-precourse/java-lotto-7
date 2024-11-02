package lotto.view;

import java.util.List;
import lotto.domain.Lotto;
import lotto.enums.ViewMessages;

public class OutputView {

    public void printLottoAmount(int lottoAmount) {
        System.out.println();
        System.out.println(ViewMessages.PRINT_LOTTO_AMOUNT.getMessage(lottoAmount));
    }

    public void printErrorMessage(String error) {
        System.out.println(error);
    }

    public void printLottos(List<Lotto> lottos) {
        for (Lotto lotto : lottos) {
            System.out.println(lotto);
        }
    }
}
