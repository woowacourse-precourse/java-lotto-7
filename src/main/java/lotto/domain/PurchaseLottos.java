package lotto.domain;

import java.util.List;
import java.util.stream.Stream;

import static camp.nextstep.edu.missionutils.Randoms.pickUniqueNumbersInRange;

public class PurchaseLottos {
    private final List<Lotto> lottos;

    protected PurchaseLottos(Integer money) {
        this.lottos = purchaseLottos(money);
    }

    public static PurchaseLottos of(Integer money) {
        return new PurchaseLottos(money);
    }

    public List<Lotto> getLottos() {
        return lottos.stream().toList();
    }

    private List<Lotto> purchaseLottos(Integer money){
        return Stream.generate(this::purchaseLotto)
                .limit(money / 1_000)
                .toList();
    }

    private Lotto purchaseLotto() {
        List<Integer> lotto = pickUniqueNumbersInRange(1, 45, 6);
        return new Lotto(lotto);
    }
}
