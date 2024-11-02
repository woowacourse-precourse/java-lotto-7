package lotto.service;

import java.util.ArrayList;
import java.util.List;
import lotto.domain.Lotto;
import lotto.domain.RandomNumberGenerator;

public class LottoSalesService {

    private final RandomNumberGenerator randomNumberGenerator = new RandomNumberGenerator();

    public List<Lotto> createLottos(int quantity) {
        validateQuantity(quantity);
        List<Lotto> lottos = new ArrayList<>();

        for(int i=0;i<quantity;i++) {
            Lotto lotto = new Lotto(randomNumberGenerator.generate(1, 45, 6));
            lottos.add(lotto);
        }

        return lottos;
    }

    private void validateQuantity(int quantity) {
        if(quantity < 0) {
            throw new IllegalArgumentException("[ERROR] 수량은 0보다 작을 수 없습니다.");
        }
        else if(quantity == Integer.MAX_VALUE) {
            throw new IllegalArgumentException("[ERROR] 수량은 Integer.MAX_VALUE 보다 클 수 없습니다.");
        }
    }
}
