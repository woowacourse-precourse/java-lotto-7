package lotto.service;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;
import lotto.domain.Lotto;
import lotto.domain.UserMoney;

public class LottoMachine {
    private static final int LOTTO_PRICE = 1000;
    private static final int LOTTO_NUMBER_MIN = 1;
    private static final int LOTTO_NUMBER_MAX = 45;
    private static final int NUMBER_COUNT_PER_TICKET = 6;

    public static List<Lotto> issueLotto(UserMoney userMoney) {
        List<Lotto> issuedLottos = new ArrayList<>();
        int purchaseAmount = userMoney.getUserMoney() / LOTTO_PRICE;

        for (int i = 0; i < purchaseAmount; i++) {
            issuedLottos.add(generateLotto());
        }

        return issuedLottos;
    }

    private static Lotto generateLotto() {
        return new Lotto(Randoms.pickUniqueNumbersInRange(LOTTO_NUMBER_MIN, LOTTO_NUMBER_MAX, NUMBER_COUNT_PER_TICKET));
    }
}
