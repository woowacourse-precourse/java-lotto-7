package lotto.view;

import java.util.List;
import lotto.domain.Lotto;
import lotto.domain.Lottos;
import lotto.message.LottoMessage;
import lotto.service.LottoService;
import lotto.validate.LottosValidate;

public class LottosView {

    public static void displayLottoNumbers(Lottos lottos) {
        for (Lotto lotto : lottos.getLottos()) {
            List<Integer> LottoNumbers = lotto.getNumber();
            LottoService.sortAscending(LottoNumbers);

            if (!LottosValidate.isAscendingNumber(LottoNumbers)) {
                throw new IllegalStateException(LottoMessage.IS_NOT_ASCENDING_NUMBER.getMessage());
            }
            System.out.println(lotto.toString());
        }
    }
}
