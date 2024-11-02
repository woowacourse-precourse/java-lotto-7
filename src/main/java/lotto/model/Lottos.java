package lotto.model;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.Collections;
import java.util.List;

public class Lottos {

    private final List<Integer> lottoNumbers;

    public Lottos(List<Integer> lottoNumbers) {
        this.lottoNumbers = lottoNumbers;
    }

    public static Lottos generateLottoNumbers() {
        List<Integer> numbers = Randoms.pickUniqueNumbersInRange(1,45,6);
        Collections.sort(numbers);
        return new Lottos(numbers);
    }

    public List<Integer> getLottoNumbers() {
        return lottoNumbers;
    }
}
