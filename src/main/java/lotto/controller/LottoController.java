package lotto.controller;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;
import lotto.model.Lotto;
import lotto.view.InputView;
import lotto.view.OutputView;

public class LottoController {
    public void run() {
        int lottosAmount = InputView.inputPurchase();
        List<Lotto> purchaseLottos = new ArrayList<>();
        for (int i = 0; i < lottosAmount; i++) {
            List<Integer> numbers = Randoms.pickUniqueNumbersInRange(1, 45, 6);
            purchaseLottos.add(new Lotto(numbers));
        }
        OutputView.printLottoTicket(purchaseLottos);
    }
}
