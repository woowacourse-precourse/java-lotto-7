package lotto.service;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import lotto.domain.Lotto;

public class LottoService {
    private final int LOTTO_PRICE = 1000;
    private final int START_INCLUSIVE = 1;
    private final int END_INCLUSIVE = 45;
    private final int NUMBER_OF_LOTTO_NUMBERS = 6;

    public List<Lotto> createLottos(int lottoQuantity) {
        List<Lotto> lottos = new ArrayList<>();

        for (int i = 0; i < lottoQuantity; i++) {
            lottos.add(new Lotto(createLottoNumbers()));
        }

        return lottos;
    }

    private List<Integer> createLottoNumbers() {
        return Randoms.pickUniqueNumbersInRange(START_INCLUSIVE, END_INCLUSIVE, NUMBER_OF_LOTTO_NUMBERS);
    }

    public int getLottoQuantity(int amount) {
        return amount / LOTTO_PRICE;
    }
}
