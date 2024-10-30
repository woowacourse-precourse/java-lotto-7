package lotto.model;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.List;
import java.util.stream.IntStream;

public class LottoMaker {

    private static final int PRICE = 1000;
    private static final int LOTTO_SIZE = 6;
    private static final int LOTTO_MIN = 1;
    private static final int LOTTO_MAX = 45;

    public List<Lotto> makeLottos(int money) {

        validateMoney(money);
        int lottoCount = money / PRICE;

        return IntStream.range(0, lottoCount)
                .mapToObj(count -> makeLotto())
                .toList();
    }

    private Lotto makeLotto() {
        return new Lotto(makeLottoNumbers());
    }

    private List<Integer> makeLottoNumbers() {
        return Randoms.pickUniqueNumbersInRange(LOTTO_MIN, LOTTO_MAX, LOTTO_SIZE).stream().sorted().toList();
    }

    private void validateMoney(int money) {
        if (money < PRICE) {
            throw new IllegalArgumentException("[ERROR] 로또 구매 금액은 1000원 이상이어야 합니다.");
        }

        if (money % PRICE != 0) {
            throw new IllegalArgumentException("[ERROR] 로또 구매 금액은 1000원 단위여야 합니다.");
        }
    }
}
