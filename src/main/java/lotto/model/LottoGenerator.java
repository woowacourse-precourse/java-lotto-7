package lotto.model;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.List;

public class LottoGenerator {

    // 1에서 45 사이의 중복되지 않은 정수 6개 반환
    public Lotto generateRandomLotto() {
        List<Integer> randomNumbers = Randoms.pickUniqueNumbersInRange(1, 45, 6);
        return new Lotto(randomNumbers);
    }
}
