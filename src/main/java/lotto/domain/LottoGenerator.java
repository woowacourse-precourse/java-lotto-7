package lotto.domain;

import static lotto.constants.LottoConstants.LOTTO_MAX_NUMBER;
import static lotto.constants.LottoConstants.LOTTO_MIN_NUMBER;
import static lotto.constants.LottoConstants.LOTTO_NUMBER_COUNT;
import static lotto.constants.LottoGeneratorConstants.LOTTO_PRICE;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;
import lotto.Lotto;
import lotto.constants.ErrorMessages;

public class LottoGenerator {
    private final List<Lotto> lottos = new ArrayList<>();

    public void purchaseLottos(int purchaseAmount) {
        validatePurchaseAmount(purchaseAmount);

        int count = purchaseAmount / LOTTO_PRICE;
        for (int i = 0; i < count; i++) {
            lottos.add(generateLotto());
        }
    }

    private void validatePurchaseAmount(int amount) {
        if (amount < LOTTO_PRICE || amount % LOTTO_PRICE != 0) {
            throw new IllegalArgumentException(ErrorMessages.INVALID_PURCHASE_AMOUNT);
        }
    }

    private Lotto generateLotto() {
        List<Integer> numbers = Randoms.pickUniqueNumbersInRange(
                LOTTO_MIN_NUMBER,
                LOTTO_MAX_NUMBER,
                LOTTO_NUMBER_COUNT
        );
        return new Lotto(numbers);
    }

    public List<Lotto> getLottos() {
        return lottos;
    }

    public void printLottos() {
        System.out.println();
        System.out.println(lottos.size() + "개를 구매했습니다.");

        for (Lotto lotto : lottos) {
            System.out.println(lotto.getNumbers());
        }
    }
}
