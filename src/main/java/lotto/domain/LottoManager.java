package lotto.domain;

import static lotto.utils.Constant.MAX_LOTTO_NUMBER;
import static lotto.utils.Constant.MAX_LOTTO_NUMBER_COUNT;
import static lotto.utils.Constant.MIN_LOTTO_NUMBER;
import static lotto.utils.Constant.MIN_PURCHASE_AMOUNT;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;

public class LottoManager {
    private final List<Lotto> lottos = new ArrayList<>();

    public void generateLottoNumbers(int purchaseAmount) {
        int lottoCount = purchaseAmount / MIN_PURCHASE_AMOUNT;

        for (int count = 0; count < lottoCount; count++) {
            lottos.add(new Lotto(generateRandomNumbers()));
        }
    }

    private List<Integer> generateRandomNumbers() {
        return Randoms.pickUniqueNumbersInRange(
                MIN_LOTTO_NUMBER,
                MAX_LOTTO_NUMBER,
                MAX_LOTTO_NUMBER_COUNT
        );
    }
}
