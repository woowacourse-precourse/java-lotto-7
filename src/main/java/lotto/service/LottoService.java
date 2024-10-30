package lotto.service;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;
import lotto.model.Lotto;
import lotto.view.OutputView;

public class LottoService {

    private final static int MONEY_UNIT = 1000;
    private final static int LOTTO_NUMBER_UPPER_BOUND = 45;
    private final static int LOTTO_NUMBER_LOWER_BOUND = 1;
    private final static int NUMBER_OF_LOTTO_NUMBERS = 6;

    private List<Lotto> purchasedLotto = new ArrayList<>();

    public void purchaseLotto(int money) {
        for (int i = 0; i < money / MONEY_UNIT; i++) {
            purchasedLotto.add(purchaseOneLotto());
        }
    }

    public void printPurchasedLottoNumbers() {
        OutputView.printPurchasedLotto(purchasedLotto);
    }

    private Lotto purchaseOneLotto() {
        return new Lotto(Randoms.pickUniqueNumbersInRange(LOTTO_NUMBER_LOWER_BOUND, LOTTO_NUMBER_UPPER_BOUND,
                NUMBER_OF_LOTTO_NUMBERS));
    }
}
