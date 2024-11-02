package lotto.controller;

import camp.nextstep.edu.missionutils.Console;
import java.util.List;
import lotto.domain.Lotto;
import lotto.service.LottoGenerator;
import lotto.view.Input;
import lotto.view.Output;

public class LottoController {
    private LottoGenerator generator = new LottoGenerator();

    public void run() {
        try {
            int purchaseAmount = Input.inputPurchaseAmount();
            int numberOfLottos = purchaseAmount / 1000; // TODO
            List<Lotto> purchasedLottos = generator.generateLottos(numberOfLottos);
            Output.printLottoNumbers(purchasedLottos);
        } finally {
            Console.close();
        }
    }
}
