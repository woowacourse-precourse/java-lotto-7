package lotto.service;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;
import lotto.model.Lotto;
import lotto.model.PurchasedLottos;
import lotto.view.LottoMachineView;

import java.util.Collections;

public class LottoMachineService {
    PurchasedLottos purchasedLottos;
    Lotto winningLotto;

    public LottoMachineService() {
        purchasedLottos = new PurchasedLottos();
    }

    public void purchaseLotto() {
        makeLotto(readPurchaseAmount());
        LottoMachineView.printPurchaseLottos(purchasedLottos);
    }

    private void makeLotto(int purchaseAmount) {
        for ( int i = 0; i < purchaseAmount; i++ ) {
            Lotto lotto = new Lotto(Randoms.pickUniqueNumbersInRange(1, 45, 6));
            Collections.sort(lotto.getNumbers());
            purchasedLottos.add(lotto);
        }
    }

    public int readPurchaseAmount() {
        LottoMachineView.printPurchaseAmount();
        String input = Console.readLine();
        return InputHandler.purchaseAmountHandle(input);
    }

}
