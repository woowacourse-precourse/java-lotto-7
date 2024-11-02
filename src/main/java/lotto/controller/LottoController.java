package lotto.controller;

import camp.nextstep.edu.missionutils.Console;
import java.util.List;
import lotto.domain.Lotto;
import lotto.service.LottoGenerator;
import lotto.view.Input;

public class LottoController {
    private LottoGenerator generator = new LottoGenerator();

    public void run() {
        try {
            int purchaseAmount = Input.inputPurchaseAmount();
            List<Lotto> purchasedLottos = generator.generateLottos(purchaseAmount);


        } finally {
            Console.close();
        }
    }
}
