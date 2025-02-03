package lotto.domain;

import java.util.ArrayList;
import java.util.List;

public class LottoMachine {
    public static final int LOTTO_UNIT_PRICE = 1000;
    public final LottoGenerator lottoGenerator;

    public LottoMachine(LottoGenerator lottoGenerator) {
        this.lottoGenerator = lottoGenerator;
    }

    public List<Lotto> generateLottos(int amount) {
        validateAmount(amount);
        int quantity = amount / LOTTO_UNIT_PRICE;
        return generateLottosByQuantity(quantity);
    }

    private void validateAmount(int amount) {
        if (amount % LOTTO_UNIT_PRICE != 0) {
            throw new IllegalArgumentException("[ERROR] 올바른 로또 구입금액이 아닙니다.");
        }
    }

    private List<Lotto> generateLottosByQuantity(int quantity) {
        List<Lotto> lottos = new ArrayList<>();
        for (int i = 0; i < quantity; i++) {
            lottos.add(new Lotto(lottoGenerator.generate()));
        }
        return lottos;
    }
}
