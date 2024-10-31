package lotto.service;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.List;

public class LottoNumberGenerator {
    private List<Integer> lottoNumbers;
    private List<Integer> bonusNumber;

    public List<Integer> generateNumbers() {
        this.lottoNumbers = Randoms.pickUniqueNumbersInRange(1, 45, 6);
        return lottoNumbers;
    }

    public List<Integer> generateBonusNumbers() {
        this.bonusNumber = Randoms.pickUniqueNumbersInRange(1, 45, 1);
        return bonusNumber;
    }

    public List<Integer> getLottoNumbers() {
        return lottoNumbers;
    }

    public List<Integer> getBonusNumbers() {
        return bonusNumber;
    }
}
