package lotto.model;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;

public class LottosCreator {
    public Lottos createLottos(int price) {
        if (price % 1000 != 0) {
            throw new IllegalArgumentException("로또는 1000원단위 입니다.");
        }
        int lottoNumber = price / 1000;
        List<List<Integer>> lottos = new ArrayList<>();
        for (int i = 0; i < lottoNumber; i++) {
            lottos.add(getNumbers());
        }
        return Lottos.init(lottos);
    }

    private List<Integer> getNumbers() {
        return Randoms.pickUniqueNumbersInRange(1, 45, 6);
    }
}
