package lotto.model;

import java.util.ArrayList;
import java.util.List;

import camp.nextstep.edu.missionutils.Randoms;

public class LottoFactory {
    public static LottoBundle makeLottosByWalletMoney(Wallet wallet) {
        List<Lotto> lottos = new ArrayList<>();
        int theNumberOfLottos = wallet.getAffordableLottoAmount();
        for (int i = 0; i < theNumberOfLottos; i++) {
            lottos.add(makeALotto());
        }

        return new LottoBundle(lottos);
    }

    private static Lotto makeALotto() {
        List<Integer> numbers = Randoms.pickUniqueNumbersInRange(1, 45, 6);
        return new Lotto(numbers);
    }
}
