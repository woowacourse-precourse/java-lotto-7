package lotto.domain;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.stream.Stream;

public class LottoMachine {
    private LottoMachine() {}

    public static LottoMachine createLottoMachine() {
        return new LottoMachine();
    }

    public Lottos issueLottos(int quantity) {
        return Lottos.from(Stream.generate(this::issueLotto).limit(quantity).toList());
    }

    public Lotto issueLotto() {
        return new Lotto(Randoms.pickUniqueNumbersInRange(1, 45, 6));
    }
}
