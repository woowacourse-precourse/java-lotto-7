package lotto.domain;

import java.util.List;
import java.util.stream.Stream;

import static camp.nextstep.edu.missionutils.Randoms.pickUniqueNumbersInRange;
import static lotto.domain.Lotto.LOTTO_END_NUMBER;
import static lotto.domain.Lotto.LOTTO_SIZE;
import static lotto.domain.Lotto.LOTTO_START_NUMBER;

public class PurchaseLottos {
    public static final Integer LOTTO_UNIT = 1_000;

    private final Integer money;
    private final List<Lotto> lottos;

    protected PurchaseLottos(Integer money) {
        this.money = money;
        this.lottos = purchaseLottos(money);
    }

    protected PurchaseLottos(List<Lotto> lottos) {
        this.money = lottos.size() * LOTTO_UNIT;
        this.lottos = lottos;
    }

    public static PurchaseLottos of(Integer money) {
        return new PurchaseLottos(money);
    }

    public static PurchaseLottos of(List<Lotto> lottos) {
        return new PurchaseLottos(lottos);
    }

    public Integer getMoney() {
        return money;
    }

    public List<Lotto> getLottos() {
        return lottos.stream().toList();
    }

    private List<Lotto> purchaseLottos(Integer money){
        return Stream.generate(this::purchaseLotto)
                .limit(money / LOTTO_UNIT)
                .toList();
    }

    private Lotto purchaseLotto() {
        List<Integer> lotto = pickUniqueNumbersInRange(LOTTO_START_NUMBER, LOTTO_END_NUMBER, LOTTO_SIZE);
        return new Lotto(lotto);
    }
}
