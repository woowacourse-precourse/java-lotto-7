package lotto.model.lotto;

import static lotto.util.Constants.MAX_RANGE;
import static lotto.util.Constants.MIN_RANGE;
import static lotto.util.Constants.NUMBER_COUNT;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class LottoNumbersGenerator {
    private final List<Integer> lottoNumbers;

    private LottoNumbersGenerator() {
        this.lottoNumbers = generateLottoNumbers();
    }

    public static LottoNumbersGenerator createAutoLotto() {
        return new LottoNumbersGenerator();
    }

    private List<Integer> generateLottoNumbers() {
        List<Integer> randomNumbers = new ArrayList<>(
                Randoms.pickUniqueNumbersInRange(MIN_RANGE, MAX_RANGE, NUMBER_COUNT));
        Collections.sort(randomNumbers);
        return randomNumbers;
    }

    @Override
    public String toString() {
        return lottoNumbers.toString();
    }

    public List<Integer> getLottoNumbers() {
        return lottoNumbers;
    }
}