package lotto.domain;

import java.util.stream.Stream;

public class LottoMachine {
    private LottoMachine() {}

    public static LottoMachine create() {
        return new LottoMachine();
    }

    public Lottos issueLottos(int quantity) {
        return Lottos.from(Stream.generate(this::issueLotto).limit(quantity).toList());
    }

    public Lotto issueLotto() {
        return new Lotto(LottoNumberGenerator.create().generate());
    }
}
