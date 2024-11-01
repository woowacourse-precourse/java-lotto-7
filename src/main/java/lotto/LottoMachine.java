package lotto;

import static lotto.LottoConstants.LOTTO_MAX_NUMBER;
import static lotto.LottoConstants.LOTTO_MIN_NUMBER;
import static lotto.LottoConstants.LOTTO_NUMBER_COUNT;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;

public class LottoMachine {
    private static final int LOTTO_PRICE = LottoMachineConstants.LOTTO_PRICE;

    private final List<Lotto> lottos = new ArrayList<>();

    public void purchaseLottos(int purchaseAmount) {
        int count = purchaseAmount / LOTTO_PRICE;
        for (int i = 0; i < count; i++) {
            lottos.add(generateLotto());
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
