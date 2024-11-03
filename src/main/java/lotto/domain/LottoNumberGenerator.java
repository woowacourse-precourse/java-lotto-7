package lotto.domain;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.List;

public class LottoNumberGenerator {
    public List<Integer> createLottoNumbers(int start, int end, int count) {
        return Randoms.pickUniqueNumbersInRange(start, end, count);
    }
}
