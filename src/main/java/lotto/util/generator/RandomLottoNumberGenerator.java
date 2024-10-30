package lotto.util.generator;

import java.util.List;

import camp.nextstep.edu.missionutils.Randoms;
import lotto.model.LottoNumberRange;

public class RandomLottoNumberGenerator implements NumberGenerator<List<Integer>> {

    private static final int MIN_LOTTO_NUMBER = LottoNumberRange.MIN_LOTTO_NUMBER.getValue();
    private static final int MAX_LOTTO_NUMBER = LottoNumberRange.MAX_LOTTO_NUMBER.getValue();
    private static final int LOTTO_NUMBER_SIZE = LottoNumberRange.LOTTO_NUMBER_SIZE.getValue();

    @Override
    public List<Integer> generate() {
        return Randoms.pickUniqueNumbersInRange(MIN_LOTTO_NUMBER, MAX_LOTTO_NUMBER, LOTTO_NUMBER_SIZE);
    }
}