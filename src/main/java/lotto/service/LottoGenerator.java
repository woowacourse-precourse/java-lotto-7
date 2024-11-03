package lotto.service;

import static lotto.domain.LottoInfo.PRICE_FOR_ONE;
import static lotto.utils.Utils.makeErrorMessage;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import lotto.domain.Lotto;
import lotto.domain.LottoInfo;

public class LottoGenerator {
    public Lotto generateOne() {
        List<Integer> immutableRandomNums = Randoms.pickUniqueNumbersInRange(LottoInfo.MIN_NUM_RANGE,
                LottoInfo.MAX_NUM_RANGE,
                LottoInfo.NUM_SIZE);
        ArrayList<Integer> randomNumbs = new ArrayList<>(immutableRandomNums);
        Collections.sort(randomNumbs);
        return new Lotto(randomNumbs);
    }

    public List<Lotto> generateMany(int money) {
        List<Lotto> lottos = new ArrayList<>();

        int purchaseAmount = calculateAmount(money);

        for (int i = 0; i < purchaseAmount; i++) {
            Lotto lotto = generateOne();
            lottos.add(lotto);
        }
        return lottos;
    }

    private int calculateAmount(int money) {
        if (money % PRICE_FOR_ONE != 0) {
            throw new IllegalArgumentException(makeErrorMessage("1000단위로 입력해주세요."));
        }
        return money / PRICE_FOR_ONE;
    }
}
