package lotto.service;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;
import lotto.domain.Lotto;
import lotto.domain.Lottos;
import lotto.domain.WinningLotto;

public class LottoCreateService {

    private static final int LOTTO_NUMBER_COUNT = 6;
    private static final int LOTTO_NUMBER_MIN = 1;
    private static final int LOTTO_NUMBER_MAX = 45;
    private static final int LOTTO_PRICE = 1000;

    public Lottos createLottosWithMoney(int money) {
        validateMoney(money);
        int lottoCount = money / LOTTO_PRICE;
        return createLottos(lottoCount);
    }

    public void validateMoney(int money) {
        validatePositive(money);
        validateUnitOfThousand(money);
    }

    private void validatePositive(int money) {
        if (money <= 0) {
            throw new IllegalArgumentException("[ERROR] 로또 구입 금액은 0원 보다 커야 합니다.");
        }
    }

    private void validateUnitOfThousand(int money) {
        if (money % LOTTO_PRICE != 0) {
            throw new IllegalArgumentException("[ERROR] 로또 구입 금액은 1000원 단위여야 합니다.");
        }
    }

    public Lottos createLottos(int lottoCount) {
        List<Lotto> lottos = new ArrayList<>();
        for (int i = 0; i < lottoCount; i++) {
            List<Integer> numbers = createRandomNumbers();
            lottos.add(new Lotto(numbers));
        }
        return new Lottos(lottos);
    }

    public List<Integer> createRandomNumbers() {
        return Randoms.pickUniqueNumbersInRange(
            LOTTO_NUMBER_MIN,
            LOTTO_NUMBER_MAX,
            LOTTO_NUMBER_COUNT
        );
    }

    public WinningLotto createWinningLotto(List<Integer> winningNumbers, int bonusNumber) {
        return new WinningLotto(new Lotto(winningNumbers), bonusNumber);
    }
}
