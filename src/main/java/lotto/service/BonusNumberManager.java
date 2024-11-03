package lotto.service;

import lotto.domain.Bonus;
import lotto.repository.LottoRepository;
import lotto.valuate.Valuate;

public class BonusNumberManager {
    public void createBonusNumber(String s, LottoRepository lottoRepository) {
        Valuate.isNum(s);
        int num = Integer.parseInt(s);
        Bonus bonus = new Bonus(num, lottoRepository.getWinningNumbers());
        lottoRepository.saveBonusNumbers(bonus);
    }
}
