package lotto.model;

import camp.nextstep.edu.missionutils.Randoms;
import lotto.constants.lottoType.LottoType;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Lottos {

    private final List<Integer> lottoNumbers;

    public Lottos(List<Integer> lottoNumbers) {
        this.lottoNumbers = lottoNumbers;
    }

    public static Lottos generateLottoNumbers() {
        List<Integer> lottoNumbers = new ArrayList<>(Randoms.pickUniqueNumbersInRange(LottoType.LOTTO_MIN_NUMBER.getValue(), LottoType.LOTTO_MAX_NUMBER.getValue(), LottoType.LOTTO_NUMBER_COUNT.getValue()));
        Collections.sort(lottoNumbers);
        return new Lottos(lottoNumbers);
    }

    public List<Integer> getLottoNumbers() {
        return lottoNumbers;
    }

}
