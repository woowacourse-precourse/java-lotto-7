package lotto.model.draw;

import static lotto.util.Constants.LOTTO_MAX_RANGE;
import static lotto.util.Constants.LOTTO_MIN_RANGE;
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

    public static LottoNumbersGenerator of(List<Integer> numbers) {
        LottoNumbersGenerator generator = new LottoNumbersGenerator();
        generator.lottoNumbers.clear();
        generator.lottoNumbers.addAll(numbers);
        Collections.sort(generator.lottoNumbers);
        return generator;
    }


    private List<Integer> generateLottoNumbers() {
        List<Integer> randomNumbers = new ArrayList<>(
                Randoms.pickUniqueNumbersInRange(LOTTO_MIN_RANGE, LOTTO_MAX_RANGE, NUMBER_COUNT));
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