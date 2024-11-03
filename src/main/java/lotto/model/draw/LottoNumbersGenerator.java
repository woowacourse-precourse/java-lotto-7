package lotto.model.draw;

import static lotto.util.Constants.LOTTO_MAX_RANGE;
import static lotto.util.Constants.LOTTO_MIN_RANGE;
import static lotto.util.Constants.NUMBER_COUNT;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class LottoNumbersGenerator {
    private final List<Integer> lottoNumbers;

    private LottoNumbersGenerator() {
        this.lottoNumbers = generateLottoNumbers();
    }

    public static LottoNumbersGenerator createAutoLotto() {
        return new LottoNumbersGenerator();
    }

    private List<Integer> generateLottoNumbers() {
        return sort(Randoms.pickUniqueNumbersInRange(LOTTO_MIN_RANGE,LOTTO_MAX_RANGE,NUMBER_COUNT));
    }

    private static List<Integer> sort(List<Integer> playerNumber) {
        return playerNumber.stream()
                .sorted()
                .collect(Collectors.toList());
    }

    @Override
    public String toString() {
        return lottoNumbers.toString();
    }

    public List<Integer> getLottoNumbers() {
        return lottoNumbers;
    }
}