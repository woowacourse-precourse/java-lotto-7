package lotto.model;

import camp.nextstep.edu.missionutils.Randoms;
import lotto.entity.Lotto;
import lotto.entity.Price;

import java.util.ArrayList;
import java.util.List;

// 로또를 만드는 클래스
public class LottoGenerator {
    private final int START_NUMBER = 1;
    private final int END_NUMBER = 45;
    private final int COUNT_OF_LOTTO_NUMBER = 6;

    private final Price price;
    private final List<Lotto> lottos;

    public LottoGenerator(Price price) {
        this.price = price;
        lottos = new ArrayList<>();

        generateLottoList();
    }

    public List<Lotto> getLottoList() {
        return lottos;
    }

    private void generateLottoList() {
        for (int i = 0; i < calculateCountOfLotto(); i++) {
            lottos.add(generateLottoNumber());
        }
    }

    private int calculateCountOfLotto() {
        return price.getValue() / 1000;
    }

    private Lotto generateLottoNumber() {
        return new Lotto(Randoms.pickUniqueNumbersInRange(START_NUMBER, END_NUMBER, COUNT_OF_LOTTO_NUMBER));
    }
}