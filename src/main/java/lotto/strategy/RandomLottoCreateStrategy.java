package lotto.strategy;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.List;

public class RandomLottoCreateStrategy implements LottoCreateStrategy {
    @Override
    public List<Integer> createRandomLottoNumbers() {
        return Randoms.pickUniqueNumbersInRange(1, 45, 6);
    }
}
