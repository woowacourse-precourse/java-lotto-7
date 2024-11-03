package lotto.view;

import java.util.List;
import lotto.domain.Lotto;
import lotto.domain.Lottos;
import lotto.service.LottoService;

public class LottosView {

    public static void displayLottoNumbers(Lottos lottos) {
        for (Lotto lotto : lottos.getLottos()) {
            List<Integer> LottoNumbers = lotto.getNumber();
            LottoService.sortAscending(LottoNumbers);
            System.out.println(lotto.toString());
        }
    }
}
