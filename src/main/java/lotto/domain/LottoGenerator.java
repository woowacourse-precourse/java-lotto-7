package lotto.domain;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class LottoGenerator {

    private final String MONEY_SOULD_BE_DIVIDED_BY_ONE_THOUSAND = "[ERROR] 1,000원 단위로만 구입할 수 있습니다.";
    private final List<Lotto> lottos = new ArrayList<>();
    private final int lottoQuantity;

    public LottoGenerator(int money) {
        validateMoney(money);
        lottoQuantity = money / 1000;
    }

    private void validateMoney(int money) {
        if (isZeroOrNegativeNumber(money) || isDividedByOneThousand(money)) {
            throw new IllegalArgumentException(MONEY_SOULD_BE_DIVIDED_BY_ONE_THOUSAND);
        }
    }

    private boolean isZeroOrNegativeNumber(int money) {
        return money <= 0;
    }

    private boolean isDividedByOneThousand(int money) {
        return money % 1000 == 0;
    }

    public List<Lotto> generateLottos() {
        for (int i = 0; i < lottoQuantity; i++) {
            Lotto lotto = generateLotto();
            lottos.add(lotto);
        }
        return lottos;
    }

    public Lotto generateLotto() {
        List<Integer> randomNumbers = new ArrayList<>(
                Randoms.pickUniqueNumbersInRange(1, 45, 6)
        );
        randomNumbers.sort(Comparator.naturalOrder());
        return new Lotto(randomNumbers);
    }

    public List<Lotto> getLottos() {
        return lottos;
    }

    public int getLottoQuantity() {
        return lottoQuantity;
    }
}
