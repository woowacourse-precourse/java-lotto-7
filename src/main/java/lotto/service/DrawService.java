package lotto.service;

import java.util.List;
import lotto.domain.Bonus;
import lotto.domain.Lotto;

public class DrawService {
    public Lotto getLotto(List<Integer> lottoNumbers) {
        return new Lotto(lottoNumbers);
    }

    public Bonus getBonus(int bonusNumber, List<Integer> lottoNumbers) {
        return new Bonus(bonusNumber, lottoNumbers);
    }
}
