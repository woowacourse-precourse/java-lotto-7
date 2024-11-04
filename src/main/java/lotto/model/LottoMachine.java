package lotto.model;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;

public class LottoMachine {
    private final List<Lotto> lottos;
    private final int money;

    public LottoMachine(int money) {
        validateMoney(money);
        this.lottos = createLotto(money);
        this.money = money;
    }

    private void validateMoney(int money) {
        if (money % 1000 != 0) {
            throw new IllegalArgumentException("[ERROR] 금액은 1,000원 단위여야 합니다.");
        }
    }

    private List<Lotto> createLotto(int money) {
        List<Lotto> lottos = new ArrayList<>();
        int quantity = money / 1000;
        for (int i = 0; i < quantity; i++) {
            List<Integer> numbers = Randoms.pickUniqueNumbersInRange(1, 45, 6);
            lottos.add(new Lotto(numbers));
        }
        return lottos;
    }

    public List<Lotto> getLottos() {
        return lottos;
    }
}
